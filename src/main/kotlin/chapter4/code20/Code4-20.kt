package chapter4.code20

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val whileJob: Job = launch(Dispatchers.Default) { // 취소를 확인할 수 있는 시점이 없는 코루틴 생성
    while(true) {
      // 작업 실행
    }
  }
  whileJob.cancel() // 코루틴 취소 요청
  printJobState(whileJob) // 취소가 요청됐으나 취소가 되지 않은 코루틴의 상태 출력
}
/*
// 결과:
Job State
isActive >> false
isCancelled >> true
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