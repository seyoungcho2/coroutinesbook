package chapter11.code6

import kotlinx.coroutines.*

var count = 0
val countChangeDispatcher = newSingleThreadContext("CountChangeThread")

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch { // count 값을 변경 시킬 때만 사용
        increaseCount()
      }
    }
  }
  println("count = ${count}")
}

suspend fun increaseCount() = coroutineScope {
  withContext(countChangeDispatcher) {
    count += 1
  }
}
/*
// 결과:
count = 10000
*/