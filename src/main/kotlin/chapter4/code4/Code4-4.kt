package chapter4.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val updateTokenJob = launch(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] 토큰 업데이트 시작")
    delay(100L)
    println("[${Thread.currentThread().name}] 토큰이 업데이트 됐습니다")
  }
  val independentJob = launch(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] 독립적인 작업 실행")
  }
  updateTokenJob.join()
  val networkCallJob = launch(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] 네트워크 요청")
  }
}
/*
// 결과:
[DefaultDispatcher-worker-1 @coroutine#2] 토큰 업데이트 시작
[DefaultDispatcher-worker-3 @coroutine#3] 독립적인 작업 실행
[DefaultDispatcher-worker-1 @coroutine#2] 토큰이 업데이트 됐습니다
[DefaultDispatcher-worker-1 @coroutine#4] 네트워크 요청
*/