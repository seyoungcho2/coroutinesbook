package chapter4.code19

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val job: Job = launch {
    delay(1000L) // 1초간 대기
  }
  delay(2000L) // 2초간 대기
  printJobState(job)
}
/*
// 결과:
Job State
isActive >> false
isCancelled >> false
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