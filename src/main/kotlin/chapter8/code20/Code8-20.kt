package chapter8.code20

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val job = launch {
    delay(1000L) // 1초간 지속
  }
  job.invokeOnCompletion { exception ->
    println(exception) // 발생한 예외 출력
  }
  job.cancel() // job 취소
}
/*
// 결과:
kotlinx.coroutines.JobCancellationException: StandaloneCoroutine was cancelled; job=StandaloneCoroutine{Cancelled}@7494e528
*/