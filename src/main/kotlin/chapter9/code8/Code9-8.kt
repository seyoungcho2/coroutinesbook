package chapter9.code8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  launch {
    delay(1000L)
    println("Hello World")
  }
  launch {
    delay(1000L)
    println("Hello World")
  }
  println(getElapsedTime(startTime))
}

/*
// 결과:
지난 시간: 3ms
Hello World
Hello World
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"