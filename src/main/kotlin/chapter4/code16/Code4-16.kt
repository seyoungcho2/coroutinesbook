package chapter4.code16

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val whileJob: Job = launch(Dispatchers.Default) {
    while(this.isActive) {
      println("작업 중")
    }
  }
  delay(100L)
  whileJob.cancel()
}
/*
// 결과:
...
작업 중
작업 중
작업 중

Process finished with exit code 0
*/