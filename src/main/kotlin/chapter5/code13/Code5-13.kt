package chapter5.code13

import kotlinx.coroutines.*

private val myDispatcher1 = newSingleThreadContext("MyThread1")
private val myDispatcher2 = newSingleThreadContext("MyThread2")

fun main() = runBlocking<Unit> {
  println("[${Thread.currentThread().name}] 코루틴 실행")
  withContext(myDispatcher1) {
    println("[${Thread.currentThread().name}] 코루틴 실행")
    withContext(myDispatcher2) {
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    println("[${Thread.currentThread().name}] 코루틴 실행")
  }
  println("[${Thread.currentThread().name}] 코루틴 실행")
}
/*
// 결과:
[main @coroutine#1] 코루틴 실행
[MyThread1 @coroutine#1] 코루틴 실행
[MyThread2 @coroutine#1] 코루틴 실행
[MyThread1 @coroutine#1] 코루틴 실행
[main @coroutine#1] 코루틴 실행
*/