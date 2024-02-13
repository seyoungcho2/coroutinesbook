package chapter7.code16

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch {
    async {
      // 작업 실행
    }
  }
}