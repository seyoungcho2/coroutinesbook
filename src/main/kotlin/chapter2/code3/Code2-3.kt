package chapter2.code3

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { // this: CoroutineScope
  println("[${Thread.currentThread().name}] 실행")
  launch {
    println("[${Thread.currentThread().name}] 실행")
  }
  launch {
    println("[${Thread.currentThread().name}] 실행")
  }
}
/*
// 실행 결과:
[main @coroutine#1] 실행
[main @coroutine#2] 실행
[main @coroutine#3] 실행
*/