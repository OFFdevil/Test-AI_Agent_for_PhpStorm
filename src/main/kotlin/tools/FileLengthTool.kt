package tools

class FileLengthTool : Tool {
    override fun compute(functionName: String, fileName: String): Int {
        return if (fileName.length > 15) 1 else 0
    }
}
