package agent

import tools.Tool

class Analyzer(private val tools: List<Tool>) {
    fun analyze(functionName: String, fileName: String): Int {
        return tools.sumOf { it.compute(functionName, fileName) }
    }
}
