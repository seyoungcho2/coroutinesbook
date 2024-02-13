package chapter9.code5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  delayAndPrint(keyword = "Hello")
  delayAndPrint(keyword = "World")
  println(getElapsedTime(startTime))
}

suspend fun delayAndPrint(keyword: String) {
  delay(1000L)
  println(keyword)
}

/*
// 결과:
Hello
World
지난 시간: 2017ms
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"