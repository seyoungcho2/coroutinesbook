package chapter3.code8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(Dispatchers.IO.limitedParallelism(100)) {
    repeat(200) {
      launch {
        Thread.sleep(1000L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
      }
    }
  }
}
/*
// 결과: 사용된 스레드의 순서는 매번 다르게 나온다.
[DefaultDispatcher-worker-60] 코루틴 실행
[DefaultDispatcher-worker-74] 코루틴 실행
[DefaultDispatcher-worker-68] 코루틴 실행
...
[DefaultDispatcher-worker-85] 코루틴 실행
[DefaultDispatcher-worker-49] 코루틴 실행
[DefaultDispatcher-worker-98] 코루틴 실행
*/