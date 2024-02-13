package chapter5.code8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val result: String = withContext(Dispatchers.IO) {
    delay(1000L) // 네트워크 요청
    return@withContext "Dummy Response" // 문자열 반환
  }
  println(result)
}
/*
// 결과:
Dummy Response
*/