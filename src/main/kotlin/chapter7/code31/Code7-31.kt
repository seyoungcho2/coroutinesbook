package chapter7.code31

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>(Dispatchers.IO) {
  delay(5000L)
  println("[${Thread.currentThread().name}] 코루틴 종료")
}
/*
// 결과:
[DefaultDispatcher-worker-1 @coroutine#1] 코루틴 종료
*/