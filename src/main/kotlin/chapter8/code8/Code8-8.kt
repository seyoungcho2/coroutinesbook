package chapter8.code8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  supervisorScope {
    launch(CoroutineName("Coroutine1")) {
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
}
/*
// 결과:
Exception in thread "main" java.lang.Exception: 예외 발생
	at chapter8.code8.Code8_8Kt$main$1$1$1$1.invokeSuspend(Code8-8.kt:9)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	...
[main @Coroutine2#3] 코루틴 실행

Process finished with exit code 0
*/