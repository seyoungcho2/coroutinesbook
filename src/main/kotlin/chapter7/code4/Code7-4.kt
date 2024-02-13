package chapter7.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { // 부모 코루틴 생성
  val runBlockingJob = coroutineContext[Job] // 부모 코루틴의 CoroutineContext로부터 부모 코루틴의 Job 추출
  launch { // 자식 코루틴 생성
    val launchJob = coroutineContext[Job] // 자식 코루틴의 CoroutineContext로부터 자식 코루틴의 Job 추출
    if (runBlockingJob === launchJob) {
      println("runBlocking으로 생성된 Job과 launch로 생성된 Job이 동일합니다")
    } else {
      println("runBlocking으로 생성된 Job과 launch로 생성된 Job이 다릅니다")
    }
  }
}
/*
// 결과:
runBlocking으로 생성된 Job과 launch로 생성된 Job이 다릅니다
*/