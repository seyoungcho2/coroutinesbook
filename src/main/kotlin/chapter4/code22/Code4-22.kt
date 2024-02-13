package chapter4.code22

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val job: Job = launch {
    delay(5000L) // 5초간 대기
  }
  job.cancelAndJoin() // 코루틴 취소 요청 + 취소가 완료될 때까지 대기
  println(job) // Job 상태 출력
}
/*
// 결과:
StandaloneCoroutine{Cancelled}@27a5f880
*/