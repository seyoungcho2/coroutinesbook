package chapter7.code20

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { // 루트 Job 생성
  println("[${Thread.currentThread().name}] 코루틴 실행")
}