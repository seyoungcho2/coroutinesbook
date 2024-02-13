package chapter8.code14

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(CoroutineName("Coroutine1")) {
    try {
      throw Exception("Coroutine1에 예외가 발생했습니다")
    } catch (e: Exception) {
      println(e.message)
    }
  }
  launch(CoroutineName("Coroutine2")) {
    delay(100L)
    println("Coroutine2 실행 완료")
  }
}
/*
// 결과:
Coroutine1에 예외가 발생했습니다
Coroutine2 실행 완료
*/