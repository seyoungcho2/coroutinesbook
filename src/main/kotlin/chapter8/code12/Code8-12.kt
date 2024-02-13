package chapter8.code12

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("[예외 발생] ${throwable}")
  }
  val supervisedScope = CoroutineScope(SupervisorJob() + exceptionHandler)
  supervisedScope.apply {
    launch(CoroutineName("Coroutine1")) {
      throw Exception("Coroutine1에 예외가 발생했습니다")
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
[예외 발생] java.lang.Exception: Coroutine1에 예외가 발생했습니다
[DefaultDispatcher-worker-2] 코루틴 실행
*/