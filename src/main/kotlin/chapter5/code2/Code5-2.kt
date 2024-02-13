package chapter5.code2

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val networkDeferred: Deferred<String> = async(Dispatchers.IO) {
    delay(1000L) // 네트워크 요청
    "Dummy Response"
  }
  networkDeferred.join() // networkDeferred가 실행 완료될 때까지 대기
  printJobState(networkDeferred) // Job이 입력되어야 할 자리에 Deferred 입력
}

fun printJobState(job: Job) {
  println(
    "Job State\n" +
        "isActive >> ${job.isActive}\n" +
        "isCancelled >> ${job.isCancelled}\n" +
        "isCompleted >> ${job.isCompleted} "
  )
}

/*
// 결과:
Job State
isActive >> false
isCancelled >> false
isCompleted >> true
*/