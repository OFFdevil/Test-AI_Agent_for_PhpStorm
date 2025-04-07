package tools

import kotlin.random.Random

class BasicComplexityTool : Tool {
    override fun compute(functionName: String, fileName: String): Int {
        return when {
            functionName.startsWith("get") || functionName.startsWith("load") -> Random.nextInt(1, 4)
            functionName.startsWith("process") || functionName.startsWith("handle") -> Random.nextInt(5, 8)
            else -> Random.nextInt(3, 10)
        }
    }
}
