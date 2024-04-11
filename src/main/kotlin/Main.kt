package net.erlantz

import java.io.File
import java.io.FileInputStream
import java.util.*

fun main(args: Array<String>) {
    val from = PropertiesReader(args.firstOrNull()).getProperty("From");
    println("Hello from $from!")
}

class PropertiesReader(propsFilePath: String?) {
    private val properties = Properties()
    private val defaultConfigFile = "config.properties"

    init {
        if (propsFilePath != null) {
            val propertiesFile = File(propsFilePath)
            if (!propertiesFile.exists()) {
                println("Properties file not found.")
            }

            FileInputStream(propertiesFile).use { stream ->
                properties.load(stream)
            }
        } else {
            val file = this::class.java.classLoader.getResourceAsStream(defaultConfigFile)
            properties.load(file)
        }
    }

    fun getProperty(key: String): String = properties.getProperty(key)
}