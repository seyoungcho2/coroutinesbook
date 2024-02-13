package chapter10.code7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val job = launch {
    while (this.isActive) {
      println("작업 중")
    }
  }
  delay(100L) // 100밀리초 대기(스레드 양보)
  job.cancel() // 코루틴 취소
}
/*
// 결과:
...
작업 중
작업 중
작업 중
...
*/