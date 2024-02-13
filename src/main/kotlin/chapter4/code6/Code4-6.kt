package chapter4.code6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val immediateJob: Job = launch {
    println("[${getElapsedTime(startTime)}] 즉시 실행") // 지난 시간 측정
  }
}
/*
// 결과:
[지난 시간: 2ms] 즉시 실행
*/

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}ms"