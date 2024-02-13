package chapter11.code4

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

var count = 0
val mutex = Mutex()

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        mutex.withLock {
          count += 1
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