package chapter6.code1

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
  val coroutineContext: CoroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")

  launch(context = coroutineContext) {
    println("[${Thread.currentThread().name}] 실행")
  }
}
/*
// 결과:
[MyThread @MyCoroutine#2] 실행
*/