package chapter11.code17

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(Dispatchers.Unconfined) { // Dispatchers.Unconfined를 사용해 실행되는 코루틴
    println("launch 코루틴 실행 스레드: ${Thread.currentThread().name}") // launch 코루틴이 실행되는 스레드 출력
  }
}
/*
// 결과:
launch 코루틴 실행 스레드: main @coroutine#2
*/