package chapter7.code28

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(CoroutineName("Coroutine1")) {
    val coroutine1Job = this.coroutineContext[Job] // Coroutine1의 Job
    val newJob = Job(parent = coroutine1Job)
    launch(CoroutineName("Coroutine2") + newJob) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
}
/*
// 결과:
[main @Coroutine2#3] 코루틴 실행
// 프로세스 종료 로그가 출력되지 않는다.
*/