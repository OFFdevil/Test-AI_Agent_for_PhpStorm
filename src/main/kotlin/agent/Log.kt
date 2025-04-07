package agent

import java.io.File
import java.io.FileWriter
import java.io.BufferedWriter
import java.time.LocalDateTime

object Log {
    private val logFile = File("logs.txt")

    fun info(message: String) {
        val logMessage = "[INFO] ${LocalDateTime.now()} - $message"
        writeToFile(logMessage)
    }

    fun error(message: String) {
        val logMessage = "[ERROR] ${LocalDateTime.now()} - $message"
        writeToFile(logMessage)
    }

    private fun writeToFile(logMessage: String) {
        try {
            BufferedWriter(FileWriter(logFile, true)).use {
                it.write("$logMessage\n")
            }
        } catch (e: Exception) {
            println("Error writing log message to file: ${e.message}")
        }
    }

    /*
     * TODO: use coroutines here
     */
}
