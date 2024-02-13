package chapter9.code7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  launch {
    delayAndPrintHelloWorld()
  }
  launch {
    delayAndPrintHelloWorld()
  }
  println(getElapsedTime(startTime))
}

suspend fun delayAndPrintHelloWorld() {
  delay(1000L)
  println("Hello World")
}


/*
// 결과:
지난 시간: 3ms
Hello World
Hello World
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"