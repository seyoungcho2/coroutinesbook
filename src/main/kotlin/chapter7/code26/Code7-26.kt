package chapter7.code26

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
    launch(CoroutineName("Coroutine5") + Job()) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  delay(50L) // 모든 코루틴이 생성될 때까지 대기
  newRootJob.cancel() // 새로운 루트 Job 취소
  delay(1000L)
}
/*
// 결과:
[main @Coroutine5#6] 코루틴 실행
*/