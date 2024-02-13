package chapter2.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>(context = CoroutineName("Main")) {
  println("[${Thread.currentThread().name}] 실행")
  launch(context = CoroutineName("Coroutine1")) {
    println("[${Thread.currentThread().name}] 실행")
  }
  launch(context = CoroutineName("Coroutine2")) {
    println("[${Thread.currentThread().name}] 실행")
  }
}
/*
// 실행 결과:
[main @Main#1] 실행
[main @Coroutine1#2] 실행
[main @Coroutine2#3] 실행
*/