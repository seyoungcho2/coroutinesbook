package chapter7.code19

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(CoroutineName("Coroutine1")) {
    launch(CoroutineName("Coroutine3")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }
    launch(CoroutineName("Coroutine4")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }
    this.cancel() // Coroutine1의 CoroutineScope에 cancel 요청
  }

  launch(CoroutineName("Coroutine2")) {
    delay(100L)
    println("[${Thread.currentThread().name}] 코루틴 실행 완료")
  }
}
/*
// 결과:
[main @Coroutine2#3] 코루틴 실행 완료
*/
