package chapter8.code23

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>(CoroutineName("Parent Coroutine")) {
  launch(CoroutineName("Child Coroutine")) {
    val result = withTimeoutOrNull(1000L) { // 실행 시간을 1초로 제한
      delay(2000L) // 2초의 시간이 걸리는 작업
      return@withTimeoutOrNull "결과"
    }
    println(result)
  }
}
/*
// 결과:
null
*/