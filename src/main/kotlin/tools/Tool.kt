package tools

interface Tool {
    fun compute(functionName: String, fileName: String): Int
}