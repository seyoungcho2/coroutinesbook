package chapter8.code3

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val parentJob = launch(CoroutineName("Parent Coroutine")) {
    launch(CoroutineName("Coroutine1") + Job()) {
      launch(CoroutineName("Coroutine3")) { // Coroutine3에서 예외 제거
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
      }
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    launch(CoroutineName("Coroutine2")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  delay(20L) // 코루틴들이 모두 생성될 때까지 대기
  parentJob.cancel() // Parent Coroutine에 취소 요청
  delay(1000L)
}
/*
// 결과:
[main @Coroutine1#3] 코루틴 실행
[main @Coroutine3#5] 코루틴 실행

Process finished with exit code 0
*/