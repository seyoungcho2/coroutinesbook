package chapter6.code2

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
  val coroutineContext: CoroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
  val newCoroutineContext: CoroutineContext = coroutineContext + CoroutineName("NewCoroutine")

  launch(context = newCoroutineContext) {
    println("[${Thread.currentThread().name}] 실행")
  }
}
/*
// 결과:
[MyThread @NewCoroutine#2] 실행
*/