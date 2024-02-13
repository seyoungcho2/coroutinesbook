package chapter11.code9

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger

var count = AtomicInteger(0)

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        count.getAndUpdate { // 만약 다른 스레드가 연산을 실행중이면, 코루틴은 스레드를 블로킹 시키고 대기한다.
          it + 1
        }
      }
    }
  }
  println("count = ${count}")
}
/*
// 결과:
count = 10000
*/