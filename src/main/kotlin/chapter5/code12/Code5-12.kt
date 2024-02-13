package chapter5.code12

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val helloDeferred = async(Dispatchers.IO) {
    delay(1000L)
    return@async "Hello"
  }

  val worldDeferred = async(Dispatchers.IO) {
    delay(1000L)
    return@async "World"
  }

  val results = awaitAll(helloDeferred,worldDeferred)

  println("[${getElapsedTime(startTime)}] ${results[0]} ${results[1]}")
}
/*
// 결과:
[지난 시간: 1013ms] Hello World
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"