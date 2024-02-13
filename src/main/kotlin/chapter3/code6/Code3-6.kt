package chapter3.code6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val multiThreadDispatcher = newFixedThreadPoolContext(
    nThreads = 2,
    name = "MultiThread"
  )
  launch(multiThreadDispatcher) { // 부모 Coroutine
    println("[${Thread.currentThread().name}] 부모 코루틴 실행")
    launch { // 자식 코루틴 실행
      println("[${Thread.currentThread().name}] 자식 코루틴 실행")
    }
    launch { // 자식 코루틴 실행
      println("[${Thread.currentThread().name}] 자식 코루틴 실행")
    }
  }
}
/*
// 결과:
[MultiThread-1 @coroutine#2] 부모 코루틴 실행
[MultiThread-2 @coroutine#3] 자식 코루틴 실행
[MultiThread-1 @coroutine#4] 자식 코루틴 실행
*/