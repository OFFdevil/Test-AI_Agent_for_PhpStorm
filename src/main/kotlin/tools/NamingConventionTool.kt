package tools

class NamingConventionTool : Tool {
    override fun compute(functionName: String, fileName: String): Int {
        return if (functionName.length <= 3 || functionName.matches(Regex("""[a-zA-Z]"""))) 2 else 0
    }
}
