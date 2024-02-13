package chapter3.code7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(Dispatchers.IO) {
    println("[${Thread.currentThread().name}] 코루틴 실행")
  }
}
/*
// 결과:
[DefaultDispatcher-worker-1 @coroutine#2] 코루틴 실행
*/