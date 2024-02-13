package chapter8.code17

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  async(CoroutineName("Coroutine1")) {
    throw Exception("Coroutine1에 예외가 발생했습니다")
  }
  launch(CoroutineName("Coroutine2")) {
    delay(100L)
    println("[${Thread.currentThread().name}] 코루틴 실행")
  }
}
/*
// 결과:
Exception in thread "main" java.lang.Exception: Coroutine1에 예외가 발생했습니다
	at chapter8.code17.Main8_17Kt$main$1$1.invokeSuspend(Main8-17.kt:7)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	...

Process finished with exit code 1
*/