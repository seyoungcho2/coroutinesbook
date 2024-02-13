package chapter5.code11

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val helloString = withContext(Dispatchers.IO) {
    delay(1000L)
    return@withContext "Hello"
  }

  val worldString = withContext(Dispatchers.IO) {
    delay(1000L)
    return@withContext "World"
  }

  println("[${getElapsedTime(startTime)}] ${helloString} ${worldString}")
}
/*
// 결과:
[지난 시간: 2018ms] Hello World
*/


fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"