package chapter4.code12

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val longJob: Job = launch(Dispatchers.Default) {
// 작업 실행
  }
  longJob.cancelAndJoin() // longJob이 취소될 때까지 runBlocking 코루틴 일시 중단
  executeAfterJobCancelled()
}

fun executeAfterJobCancelled() {
  // 작업 실행
}