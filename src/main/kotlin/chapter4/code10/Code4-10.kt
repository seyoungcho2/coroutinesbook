package chapter4.code10

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val longJob: Job = launch(Dispatchers.Default) {
    repeat(10) { repeatTime ->
      delay(1000L) // 1000밀리초 대기
      println("[${getElapsedTime(startTime)}] 반복횟수 ${repeatTime}")
    }
  }
  delay(3500L) // 3500밀리초(3.5초)간 대기
  longJob.cancel() // 코루틴 취소
}
/*
// 결과:
[지난 시간: 1016ms] 반복횟수 0
[지난 시간: 2021ms] 반복횟수 1
[지난 시간: 3027ms] 반복횟수 2
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"