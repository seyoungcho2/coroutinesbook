package chapter3.code8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(Dispatchers.Default){
    println("[${Thread.currentThread().name}] 코루틴 실행")
  }
}
/*
// 결과:
[DefaultDispatcher-worker-1 @coroutine#2] 코루틴 실행
*/