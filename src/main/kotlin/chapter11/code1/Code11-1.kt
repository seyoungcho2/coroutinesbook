package chapter11.code1

import kotlinx.coroutines.*

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
// 결과1:
count = 9062 // 매번 다른 값이 나온다.
// 결과2:
count = 9019 // 매번 다른 값이 나온다.
// 결과3:
count = 8644 // 매번 다른 값이 나온다.
*/