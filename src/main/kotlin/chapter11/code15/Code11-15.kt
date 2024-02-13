package chapter11.code15

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(start = CoroutineStart.UNDISPATCHED) {
    println("작업1")
  }
  println("작업2")
}
/*
// 결과:
작업1
작업2
*/