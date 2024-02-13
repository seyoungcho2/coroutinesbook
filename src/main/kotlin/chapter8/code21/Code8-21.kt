package chapter8.code21

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>(CoroutineName("Parent Coroutine")) {
  launch(CoroutineName("Child Coroutine")) {
    withTimeout(1000L) { // 실행 시간을 1초로 제한
      delay(2000L) // 2초의 시간이 걸리는 작업
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  delay(2000L)
  println("[${Thread.currentThread().name}] 코루틴 실행")
}
/*
// 결과:
[main @Parent Coroutine#1] 코루틴 실행
*/