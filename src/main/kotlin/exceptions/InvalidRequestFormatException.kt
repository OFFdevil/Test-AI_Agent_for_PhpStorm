package exceptions

class InvalidRequestFormatException(input: String) : RetryRequestException(
    """
    ⚠️  Invalid request format.
    You entered: "$input"
    Correct format: Analyze cyclomatic complexity for function <functionName> in file <fileName>
    Example: Analyze cyclomatic complexity for function getUserData in file UserService.php
    """.trimIndent()
)