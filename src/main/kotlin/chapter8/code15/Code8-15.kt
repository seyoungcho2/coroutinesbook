package chapter8.code15

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  try {
    launch(CoroutineName("Coroutine1")) {
      throw Exception("Coroutine1에 예외가 발생했습니다")
    }
  } catch (e: Exception) {
    println(e.message)
  }
  launch(CoroutineName("Coroutine2")) {
    delay(100L)
    println("Coroutine2 실행 완료")
  }
}
/*
// 결과:
Exception in thread "main" java.lang.Exception: Coroutine1에 예외가 발생했습니다
	at chapter8.code15.Main8_15Kt$main$1$1.invokeSuspend(Main8-15.kt:8)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	...

Process finished with exit code 1
*/