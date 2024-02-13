package chapter8.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val supervisorJob = SupervisorJob()
  launch(CoroutineName("Coroutine1") + supervisorJob) {
    launch(CoroutineName("Coroutine3")) {
      throw Exception("예외 발생")
    }
    delay(100L)
    println("[${Thread.currentThread().name}] 코루틴 실행")
  }
  launch(CoroutineName("Coroutine2") + supervisorJob) {
    delay(100L)
    println("[${Thread.currentThread().name}] 코루틴 실행")
  }
  delay(1000L)
}
/*
// 결과:
Exception in thread "main" java.lang.Exception: 예외 발생
	at chapter8.code4.Code8_4Kt$main$1$1$1.invokeSuspend(Code8-4.kt:9)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	...
[main @Coroutine2#3] 코루틴 실행

Process finished with exit code 0
*/