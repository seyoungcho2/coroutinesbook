package chapter9.code2

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  delayAndPrintHelloWorld()
  delayAndPrintHelloWorld()
}

suspend fun delayAndPrintHelloWorld() {
  delay(1000L)
  println("Hello World")
}

