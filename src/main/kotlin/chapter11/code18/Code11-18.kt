package chapter11.code18

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>(Dispatchers.IO) {
  println("runBlocking 코루틴 실행 스레드: ${Thread.currentThread().name}") // runBlocking 코루틴이 실행되는 스레드 출력
  launch(Dispatchers.Unconfined) { // Dispatchers.Unconfined를 사용해 실행되는 코루틴
    println("launch 코루틴 실행 스레드: ${Thread.currentThread().name}") // launch 코루틴이 실행되는 스레드 출력
  }
}
/*
// 결과:
runBlocking 코루틴 실행 스레드: DefaultDispatcher-worker-1 @coroutine#1
launch 코루틴 실행 스레드: DefaultDispatcher-worker-1 @coroutine#2
*/