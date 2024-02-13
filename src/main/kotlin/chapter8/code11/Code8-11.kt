package chapter8.code11

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val coroutineContext = Job() + CoroutineExceptionHandler { coroutineContext, throwable ->
    println("[예외 발생] ${throwable}")
  }
  launch(CoroutineName("Coroutine1") + coroutineContext) {
    throw Exception("Coroutine1에 예외가 발생했습니다")
  }
  delay(1000L)
}
/*
// 결과:
[예외 발생] java.lang.Exception: Coroutine1에 예외가 발생했습니다
*/