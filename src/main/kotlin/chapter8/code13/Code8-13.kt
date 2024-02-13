package chapter8.code13

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("[예외 발생] ${throwable}")
  }
  launch(CoroutineName("Coroutine1") + exceptionHandler) {
    throw Exception("Coroutine1에 예외가 발생했습니다")
  }
}
/*
// 결과:
Exception in thread "main" java.lang.Exception: Coroutine1에 예외가 발생했습니다
	at chapter8.code13.Main8_13Kt$main$1$1.invokeSuspend(Main8-13.kt:10)
  ...
*/