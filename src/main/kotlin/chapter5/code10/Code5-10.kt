package chapter5.code10

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  println("[${Thread.currentThread().name}] runBlocking 블록 실행")
  async(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] async 블록 실행")
  }.await()
}
/*
// 결과:
[main @coroutine#1] runBlocking 블록 실행
[DefaultDispatcher-worker-1 @coroutine#2] async 블록 실행
*/