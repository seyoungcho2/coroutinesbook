package chapter4.code2

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val updateTokenJob = launch(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] 토큰 업데이트 시작")
    delay(100L)
    println("[${Thread.currentThread().name}] 토큰 업데이트 완료")
  }
  val networkCallJob = launch(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] 네트워크 요청")
  }
}
/*
// 결과:
[DefaultDispatcher-worker-1 @coroutine#2] 토큰 업데이트 시작
[DefaultDispatcher-worker-3 @coroutine#3] 네트워크 요청
[DefaultDispatcher-worker-1 @coroutine#2] 토큰 업데이트 완료
*/