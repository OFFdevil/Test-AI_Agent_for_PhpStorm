package agent

import exceptions.FileNotFoundException
import exceptions.FunctionNotFoundException
import exceptions.InvalidRequestFormatException
import model.PhpFile
import tools.*
import java.io.File

object CodeAnalysisAgent {
    fun loadFilesFromDirectory(): Map<String, PhpFile> {
        val filesMap = mutableMapOf<String, PhpFile>()
        val dir = File(".")

        if (!dir.exists() || !dir.isDirectory) {
            Log.error("❌ Current directory is not valid.")
            return filesMap
        }

        dir.listFiles { _, name -> name.endsWith(".php") }?.forEach { file ->
            val functionMap = mutableMapOf<String, String>()
            val content = file.readText()

            val functionNames = Regex("function\\s+(\\w+)").findAll(content).map { it.groupValues[1] }
            functionNames.forEach { functionName ->
                functionMap[functionName] = content
            }

            filesMap[file.name] = PhpFile(file.name, functionMap)
        }

        return filesMap
    }

    fun processRequest(input: String, files: Map<String, PhpFile>): String {
        val request = RequestParser.parse(input) ?: throw InvalidRequestFormatException(input)
        val phpFile = files[request.fileName] ?: throw FileNotFoundException(request.fileName, files.keys)
        phpFile.functions[request.functionName] ?: throw FunctionNotFoundException(request.functionName, request.fileName, phpFile.functions.keys)

        val tools = buildTools(files)
        val analyzer = Analyzer(tools)
        Log.info("Analyzed function ${request.functionName} in ${request.fileName}")
        Log.info("Used tools: ${tools.map { it.javaClass.simpleName }}")

        val complexity = analyzer.analyze(request.functionName, request.fileName)
        return "The cyclomatic complexity of function ${request.functionName} in file ${request.fileName} is $complexity."
    }

    private fun buildTools(files: Map<String, PhpFile>): List<Tool> {
        return buildList {
            add(BasicComplexityTool())
            add(NamingConventionTool())
            add(FileLengthTool())
            add(PhpStructureTool(files))
        }
    }
}