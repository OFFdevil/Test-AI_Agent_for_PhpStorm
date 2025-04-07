package exceptions

class FileNotFoundException(fileName: String, availableFiles: Set<String>) : RetryRequestException(
    """
    ⚠️  File "$fileName" not found in current directory.
    Available files: ${availableFiles.joinToString(", ")}
    Ensure the file exists in the current directory.
    """.trimIndent()
)