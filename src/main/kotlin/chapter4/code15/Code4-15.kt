package chapter4.code15

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val whileJob: Job = launch(Dispatchers.Default) {
    while(true) {
      println("작업 중")
      yield()
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