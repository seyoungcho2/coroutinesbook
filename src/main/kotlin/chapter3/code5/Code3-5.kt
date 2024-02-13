package chapter3.code5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val multiThreadDispatcher = newFixedThreadPoolContext(
    nThreads = 2,
    name = "MultiThread"
  )
  launch(context = multiThreadDispatcher) {
    println("[${Thread.currentThread().name}] 실행")
  }
  launch(context = multiThreadDispatcher) {
    println("[${Thread.currentThread().name}] 실행")
  }
}
/*
// 결과:
[MultiThread-1 @coroutine#2] 실행
[MultiThread-2 @coroutine#3] 실행
*/