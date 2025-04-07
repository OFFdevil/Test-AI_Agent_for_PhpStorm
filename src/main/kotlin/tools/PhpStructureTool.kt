package tools

import model.PhpFile

class PhpStructureTool(private val files: Map<String, PhpFile>) : Tool {
    override fun compute(functionName: String, fileName: String): Int {
        val phpFile = files[fileName] ?: return 0
        val functionBody = phpFile.functions[functionName] ?: return 0

        val tokens = listOf("if", "for", "while", "case", "catch")
        return tokens.sumOf { token -> Regex("\\b$token\\b").findAll(functionBody).count() }
    }
}
