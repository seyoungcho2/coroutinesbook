package chapter4.code18

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val job: Job = launch { // 실행 중 상태의 코루틴 생성
    delay(1000L)
  }
  printJobState(job) // 코루틴 상태 출력
}
/*
// 결과:
Job State
isActive >> true
isCancelled >> false
isCompleted >> false
*/

fun printJobState(job: Job) {
  println(
    "Job State\n" +
        "isActive >> ${job.isActive}\n" +
        "isCancelled >> ${job.isCancelled}\n" +
        "isCompleted >> ${job.isCompleted} "
  )
}