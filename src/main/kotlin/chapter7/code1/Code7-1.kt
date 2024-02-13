package chapter7.code1

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch { // 부모 코루틴
    launch {  // 자식 코루틴
      println("자식 코루틴 실행")
    }
  }
}