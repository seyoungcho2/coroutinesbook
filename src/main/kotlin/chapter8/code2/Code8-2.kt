package chapter8.code2

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(CoroutineName("Parent Coroutine")) {
    launch(CoroutineName("Coroutine1") + Job()) { // 새로운 Job 객체를 만들어 Coroutine1에 연결
      launch(CoroutineName("Coroutine3")) {
        throw Exception("예외 발생")
      }
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    launch(CoroutineName("Coroutine2")) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  delay(1000L)
}
/*
// 결과:
Exception in thread "main" java.lang.Exception: 예외 발생
	at chapter8.code2.Code8_2Kt$main$1$1$1$1.invokeSuspend(Code8-2.kt:9)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	...
[main @Coroutine2#4] 코루틴 실행

Process finished with exit code 0
*/