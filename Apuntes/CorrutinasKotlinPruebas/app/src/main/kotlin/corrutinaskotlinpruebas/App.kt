/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package corrutinaskotlinpruebas

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    doMundo()
    println("test")
}

suspend fun doMundo() = coroutineScope {
    launch {
        delay(1000L)
        println("Mundo!")
    }
    println("Hola")
}




/*
fun main() {
    CoroutineScope(Dispatchers.Default).launch { // Corrutina 1
        delay(1000L)
        println("Mundo!")
    }
    println("Hola")
    readln()
}
    OTRO AMBITO
    runBlocking { // Corrutina 1
        launch {  // Corrutina 2
            delay(1000L)
            println("Mundo!")
        }
 */