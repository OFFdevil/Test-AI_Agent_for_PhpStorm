import agent.CodeAnalysisAgent
import agent.Log
import exceptions.RetryRequestException
import java.util.Scanner

fun main() {
    println("🚀 Welcome to Cyclomatic Complexity CLI Agent!")
    println("💡 Enter requests like: Analyze cyclomatic complexity for function getUserData in file UserService.php")

    val files = CodeAnalysisAgent.loadFilesFromDirectory()
    if (files.isEmpty()) {
        println("❌ No PHP files found in current directory.")
        return
    }

    val scanner = Scanner(System.`in`)

    loop@ while (true) {
        print("\n> ")
        val input = scanner.nextLine()

        if (input.lowercase() in listOf("exit", "quit")) {
            println("👋 Exiting agent. Goodbye!")
            break
        }

        try {
            val response = CodeAnalysisAgent.processRequest(input, files)
            println(response)
        } catch (e: RetryRequestException) {
            e.message?.also {
                Log.error(it)
                println(it)
            }

            print("\n🔁 Would you like to try again? (yes/no): ")
            when (scanner.nextLine().lowercase()) {
                "yes", "ye", "y" -> continue@loop
                else -> {
                    println("👋 Exiting agent. Goodbye!")
                    break@loop
                }
            }
        }
    }
}