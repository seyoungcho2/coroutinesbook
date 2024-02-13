package chapter11.code21

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(Dispatchers.Unconfined) {
    println("일시 중단 전 실행 스레드: ${Thread.currentThread().name}")
    delay(100L)
    println("일시 중단 후 실행 스레드: ${Thread.currentThread().name}")
  }
}
/*
// 결과:
일시 중단 전 실행 스레드: main
일시 중단 후 실행 스레드: kotlinx.coroutines.DefaultExecutor
*/