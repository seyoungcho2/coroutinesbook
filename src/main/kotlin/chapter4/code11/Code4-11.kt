package chapter4.code11

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val longJob: Job = launch(Dispatchers.Default) {
    // 작업 실행
  }
  longJob.cancel() // longJob 취소 요청
  executeAfterJobCancelled() // 코루틴 취소 후 실행돼야 하는 동작
}

fun executeAfterJobCancelled() {
  // 작업 실행
}