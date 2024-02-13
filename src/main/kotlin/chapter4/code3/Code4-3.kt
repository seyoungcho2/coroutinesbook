package chapter4.code3

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val updateTokenJob = launch(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] 토큰 업데이트 시작")
    delay(100L)
    println("[${Thread.currentThread().name}] 토큰 업데이트 완료")
  }
  updateTokenJob.join() // updateTokenJob이 완료될 때까지 일시 중단
  val networkCallJob = launch(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] 네트워크 요청")
  }
}
/*
// 결과:
[DefaultDispatcher-worker-1 @coroutine#2] 토큰 업데이트 시작
[DefaultDispatcher-worker-1 @coroutine#2] 토큰 업데이트 완료
[DefaultDispatcher-worker-1 @coroutine#3] 네트워크 요청
*/