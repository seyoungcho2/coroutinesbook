package chapter10.code10

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val dispatcher = newFixedThreadPoolContext(2, "MyThread")
  launch(dispatcher) {
    repeat(5) {
      println("[${Thread.currentThread().name}] 스레드를 점유한채로 100밀리초간 대기합니다")
      Thread.sleep(100L) // 스레드를 점유한 채로 100 밀리초 동안 대기
      println("[${Thread.currentThread().name}] 점유한 스레드에서 마저 실행됩니다")
    }
  }
}
/*
// 결과:
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100밀리초간 대기합니다
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행됩니다
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100밀리초간 대기합니다
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행됩니다
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100밀리초간 대기합니다
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행됩니다
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100밀리초간 대기합니다
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행됩니다
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100밀리초간 대기합니다
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행됩니다
*/