package chapter9.code3

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  delayAndPrintHelloWorld()
  delayAndPrintHelloWorld()
  println(getElapsedTime(startTime))
}

suspend fun delayAndPrintHelloWorld() {
  delay(1000L)
  println("Hello World")
}

/*
// 결과:
Hello World
Hello World
지난 시간: 2017ms
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"