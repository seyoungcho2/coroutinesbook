package chapter8.code9

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("[예외 발생] ${throwable}")
  }
  CoroutineScope(exceptionHandler).launch(CoroutineName("Coroutine1")) {
    throw Exception("Coroutine1에 예외가 발생했습니다")
  }
  delay(1000L)
}
/*
// 결과:
[예외 발생] java.lang.Exception: Coroutine1에 예외가 발생했습니다
*/