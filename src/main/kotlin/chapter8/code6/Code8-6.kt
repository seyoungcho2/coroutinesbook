package chapter8.code6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val coroutineScope = CoroutineScope(SupervisorJob())
  coroutineScope.apply {
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
  delay(1000L)
}
/*
// 결과:
Exception in thread "DefaultDispatcher-worker-1" java.lang.Exception: 예외 발생
	at chapter8.code6.Code8_6Kt$main$1$1$1$1.invokeSuspend(Code8-6.kt:10)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	...
[DefaultDispatcher-worker-1 @Coroutine2#3] 코루틴 실행

Process finished with exit code 0
*/