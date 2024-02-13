package chapter11.code10

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger

var count = AtomicInteger(0)

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        val currentCount = count.get()
        // 위 코드와 아래 코드의 실행 사이에 다른 스레드가 count의 값을 읽거나 변경할 수 있다.
        count.set(currentCount + 1)
      }
    }
  }
  println("count = ${count}")
}
/*
// 결과:
count = 8399
*/