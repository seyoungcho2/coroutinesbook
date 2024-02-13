package chapter4.code21

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val job: Job = launch {
    delay(5000L) // 5초간 대기
  }
  job.cancelAndJoin() // 코루틴 취소 요청 + 취소가 완료될 때까지 대기
  printJobState(job) // Job 상태 출력
}
/*
// 결과:
Job State
isActive >> false
isCancelled >> true
isCompleted >> true
*/

fun printJobState(job: Job) {
  println(
    "Job State\n" +
        "isActive >> ${job.isActive}\n" +
        "isCancelled >> ${job.isCancelled}\n" +
        "isCompleted >> ${job.isCompleted} "
  )
}