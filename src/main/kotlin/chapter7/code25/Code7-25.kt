package chapter7.code25

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val newRootJob = Job() // 새로운 루트 Job 생성
  launch(CoroutineName("Coroutine1") + newRootJob) {
    launch(CoroutineName("Coroutine3")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    launch(CoroutineName("Coroutine4")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  launch(CoroutineName("Coroutine2") + newRootJob) {
    launch(CoroutineName("Coroutine5")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  newRootJob.cancel() // 새로운 루트 Job 취소
  delay(1000L)
}
/*
// 결과:
Process finished with exit code 0
*/