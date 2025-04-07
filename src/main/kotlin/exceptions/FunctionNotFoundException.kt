package exceptions

class FunctionNotFoundException(functionName: String, fileName: String, availableFunctions: Set<String>) : RetryRequestException(
    """
    ⚠️  Function "$functionName" not found in file "$fileName".
    Available functions: ${availableFunctions.joinToString(", ")}
    """.trimIndent()
)