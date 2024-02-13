package chapter8.code10

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("[예외 발생] ${throwable}")
  }
  launch(CoroutineName("Coroutine1") + exceptionHandler) {
    throw Exception("Coroutine1에 예외가 발생했습니다")
  }
  delay(1000L)
}
/*
// 결과:
Exception in thread "main" java.lang.Exception: Coroutine1에 예외가 발생했습니다
	at chapter8.code10.Main8_10Kt$main$1$1.invokeSuspend(Main8-10.kt:10)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	...
*/