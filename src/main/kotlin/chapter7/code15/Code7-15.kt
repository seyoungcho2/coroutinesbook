package chapter7.code15

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  this.launch {
    this.async {
      // 작업 실행
    }
  }
}