package chapter11.code7

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger

var count = AtomicInteger(0)

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        count.getAndUpdate {
          it + 1 // count값 1 더하기
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