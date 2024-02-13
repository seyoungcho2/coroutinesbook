package chapter11.code2

import kotlinx.coroutines.*

@Volatile
var count = 0

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        count += 1
      }
    }
  }
  println("count = ${count}")
}
/*
// 결과:
count = 9122
*/