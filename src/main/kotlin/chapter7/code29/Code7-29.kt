package chapter7.code29

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(CoroutineName("Coroutine1")) {
    val coroutine1Job = this.coroutineContext[Job]
    val newJob = Job(coroutine1Job)
    launch(CoroutineName("Coroutine2") + newJob) {
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    newJob.complete() // 명시적으로 완료 호출
  }
}
/*
// 결과:
[main @Coroutine2#3] 코루틴 실행

Process finished with exit code 0
*/