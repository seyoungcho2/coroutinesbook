package chapter11.code22

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  println("runBlocking 코루틴 실행 스레드: ${Thread.currentThread().name}") // runBlocking 코루틴이 실행되는 스레드 출력
  launch(start = CoroutineStart.UNDISPATCHED) { // CoroutineStart.UNDISPATCHED가 적용된 코루틴
    println("[CoroutineStart.UNDISPATCHED] 코루틴이 시작 시 사용하는 스레드: ${Thread.currentThread().name}")
    delay(100L)
    println("[CoroutineStart.UNDISPATCHED] 코루틴이 재개 시 사용하는 스레드: ${Thread.currentThread().name}")
  }.join()
  launch(context = Dispatchers.Unconfined) { // Dispatchers.Unconfined를 사용해 실행되는 코루틴
    println("[Dispatchers.Unconfined] 코루틴이 시작 시 사용하는 스레드: ${Thread.currentThread().name}")
    delay(100L)
    println("[Dispatchers.Unconfined] 코루틴이 재개 시 사용하는 스레드: ${Thread.currentThread().name}")
  }.join()
}
/*
// 결과:
runBlocking 코루틴 실행 스레드: main @coroutine#1
[CoroutineStart.UNDISPATCHED] 코루틴이 시작 시 사용하는 스레드: main @coroutine#2
[CoroutineStart.UNDISPATCHED] 코루틴이 재개 시 사용하는 스레드: main @coroutine#2
[Dispatchers.Unconfined] 코루틴이 시작 시 사용하는 스레드: main @coroutine#3
[Dispatchers.Unconfined] 코루틴이 재개 시 사용하는 스레드: kotlinx.coroutines.DefaultExecutor @coroutine#3
*/