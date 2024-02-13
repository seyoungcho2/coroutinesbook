package chapter4.code1

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val job: Job = launch(Dispatchers.IO) { // Job 객체 반환
    println("[${Thread.currentThread().name}] 실행")
  }
}