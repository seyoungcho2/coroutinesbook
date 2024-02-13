package chapter9.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  delay(1000L)
  println("Hello World")
  delay(1000L)
  println("Hello World")
  println(getElapsedTime(startTime))
}

/*
// 결과:
Hello World
Hello World
지난 시간: 2017ms
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"