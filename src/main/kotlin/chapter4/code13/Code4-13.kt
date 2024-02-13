package chapter4.code13

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val whileJob: Job = launch(Dispatchers.Default) {
    while(true) {
      println("작업 중")
    }
  }
  delay(100L) // 100밀리초 대기
  whileJob.cancel() // 코루틴 취소
}
/*
// 결과:
...
작업 중
작업 중
작업 중
...
*/