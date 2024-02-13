package chapter8.code19

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>(CoroutineName("runBlocking 코루틴")) {
  launch(CoroutineName("Coroutine1")) {
    launch(CoroutineName("Coroutine2")) {
      throw CancellationException()
    }
    delay(100L)
    println("[${Thread.currentThread().name}] 코루틴 실행")
  }
  delay(100L)
  println("[${Thread.currentThread().name}] 코루틴 실행")
}
/*
// 결과:
[main @runBlocking 코루틴#1] 코루틴 실행
[main @Coroutine1#2] 코루틴 실행
*/