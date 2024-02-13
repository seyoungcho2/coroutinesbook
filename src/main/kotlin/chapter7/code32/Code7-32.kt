package chapter7.code32

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch {
    delay(1000L)
    println("[${Thread.currentThread().name}] launch 코루틴 종료")
  }
  delay(2000L)
  println("[${Thread.currentThread().name}] runBlocking 코루틴 종료")
}

/*
// 결과:
[main @coroutine#2] launch 코루틴 종료
[main @coroutine#1] runBlocking 코루틴 종료
*/