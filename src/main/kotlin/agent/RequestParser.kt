package agent

import model.CodeAnalysisRequest

object RequestParser {
    private val pattern = Regex("""Analyze cyclomatic complexity for function (\w+) in file (\w+\.php)""")

    fun parse(input: String): CodeAnalysisRequest? {
        val match = pattern.matchEntire(input) ?: return null
        return CodeAnalysisRequest(
            functionName = match.groupValues[1],
            fileName = match.groupValues[2]
        )
    }
}
