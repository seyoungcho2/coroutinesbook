package chapter4.code7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
    println("[${chapter4.code6.getElapsedTime(startTime)}] 지연 실행")
  }
}

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}ms"

