package chapter4.code8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] 지연 실행")
  }
  delay(1000L) // 1초간 대기
  lazyJob.start() // 코루틴 실행
}
/*
// 결과:
[main @coroutine#2][지난 시간: 1014ms] 지연 실행
*/


fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}ms"