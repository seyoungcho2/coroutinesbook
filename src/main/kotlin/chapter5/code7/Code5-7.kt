package chapter5.code7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val networkDeferred: Deferred<String> = async(Dispatchers.IO) {
    delay(1000L) // 네트워크 요청
    return@async "Dummy Response" // 문자열 반환
  }
  val result = networkDeferred.await() // networkDeferred로부터 결과값이 반환될 때까지 대기
  println(result)
}
/*
// 결과:
Dummy Response
*/