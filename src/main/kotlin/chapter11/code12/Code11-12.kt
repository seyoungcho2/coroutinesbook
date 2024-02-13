package chapter11.code12

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch {
    println("작업1")
  }
  println("작업2")
}
/*
// 결과:
작업2
작업1
*/