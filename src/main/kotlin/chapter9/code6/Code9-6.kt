package chapter9.code6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  delay(1000L)
  println("Hello")
  delay(1000L)
  println("World")
  println(getElapsedTime(startTime))
}

/*
// 결과:
Hello
World
지난 시간: 2017ms
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"