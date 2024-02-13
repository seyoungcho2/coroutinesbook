package chapter11.code3

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex

var count = 0
val mutex = Mutex()

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        mutex.lock() // 임계 영역 시작 지점
        count += 1
        mutex.unlock() // 임계 영역 종료 지점
      }
    }
  }
  println("count = ${count}")
}
/*
// 결과:
count = 10000
*/