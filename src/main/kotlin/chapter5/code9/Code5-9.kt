package chapter5.code9

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  println("[${Thread.currentThread().name}] runBlocking 블록 실행")
  withContext(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] withContext 블록 실행")
  }
}
/*
// 결과:
[main @coroutine#1] runBlocking 블록 실행
[DefaultDispatcher-worker-1 @coroutine#1] withContext 블록 실행
*/