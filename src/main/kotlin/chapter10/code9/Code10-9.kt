package chapter10.code9

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val dispatcher = newFixedThreadPoolContext(2, "MyThread")
  launch(dispatcher) {
    repeat(5) {
      println("[${Thread.currentThread().name}] 코루틴 실행이 일시 중단 됩니다") // launch 코루틴을 실행 중인 스레드를 출력한다.
      delay(100L) // delay 함수를 통해 launch 코루틴을 100밀리초간 일시 중단한다.
      println("[${Thread.currentThread().name}] 코루틴 실행이 재개 됩니다") // launch 코루틴이 재개되면 코루틴을 실행 중인 스레드를 출력한다.
    }
  }
}
/*
// 결과:
[MyThread-1 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 재개 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-1 @coroutine#2] 코루틴 실행이 재개 됩니다
[MyThread-1 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-1 @coroutine#2] 코루틴 실행이 재개 됩니다
[MyThread-1 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-1 @coroutine#2] 코루틴 실행이 재개 됩니다
[MyThread-1 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 재개 됩니다
*/