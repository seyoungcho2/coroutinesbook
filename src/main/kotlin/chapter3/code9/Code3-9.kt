package chapter3.code8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(Dispatchers.Default.limitedParallelism(2)){
    repeat(10) {
      launch {
        println("[${Thread.currentThread().name}] 코루틴 실행")
      }
    }
  }
}
/*
// 결과:
[DefaultDispatcher-worker-2 @coroutine#3] 코루틴 실행
[DefaultDispatcher-worker-1 @coroutine#4] 코루틴 실행
[DefaultDispatcher-worker-2 @coroutine#5] 코루틴 실행
...
[DefaultDispatcher-worker-1 @coroutine#10] 코루틴 실행
[DefaultDispatcher-worker-2 @coroutine#11] 코루틴 실행
[DefaultDispatcher-worker-2 @coroutine#12] 코루틴 실행
*/