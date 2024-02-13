package chapter10.code8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val job = launch {
    while (this.isActive) {
      println("작업 중")
      yield() // 스레드 양보
    }
  }
  delay(100L)
  job.cancel()
}
/*
// 결과:
...
작업 중
작업 중
작업 중
*/