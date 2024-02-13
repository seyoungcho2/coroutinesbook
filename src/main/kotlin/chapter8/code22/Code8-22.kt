package chapter8.code22

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>(CoroutineName("Parent Coroutine")) {
  try {
    withTimeout(1000L) { // 실행 시간을 1초로 제한
      delay(2000L) // 2초의 시간이 걸리는 작업
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  } catch (e: Exception) {
    println(e)
  }
}
/*
// 결과:
kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 1000 ms
*/