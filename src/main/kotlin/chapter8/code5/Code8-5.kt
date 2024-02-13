package chapter8.code5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  // supervisorJob의 parent로 runBlocking으로 생성된 Job 객체 설정
  val supervisorJob = SupervisorJob(parent = this.coroutineContext[Job])
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
  supervisorJob.complete() // supervisorJob 완료 처리
}
/*
// 결과:
Exception in thread "main" java.lang.Exception: 예외 발생
	at chapter8.code5.Code8_5Kt$main$1$1$1.invokeSuspend(Code8-5.kt:9)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	...
[main @Coroutine2#3] 코루틴 실행

Process finished with exit code 0
*/