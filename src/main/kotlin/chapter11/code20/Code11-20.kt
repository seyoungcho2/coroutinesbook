package chapter11.code20

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  println("작업1")
  launch(Dispatchers.Unconfined) { // Dispatchers.Unconfined를 사용해 실행되는 코루틴
    println("작업2")
  }
  println("작업3")
}
/*
// 결과:
작업1
작업2
작업3
*/