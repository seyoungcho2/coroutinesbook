package chapter7.code23

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val newScope = CoroutineScope(Dispatchers.IO)
  newScope.launch(CoroutineName("Coroutine1")) { // Coroutine1 실행
    launch(CoroutineName("Coroutine3")) { // Coroutine3 실행
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    launch(CoroutineName("Coroutine4")) { // Coroutine4 실행
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  newScope.launch(CoroutineName("Coroutine2")) { // Coroutine2 실행
    launch(CoroutineName("Coroutine5")) { // Coroutine5 실행
      delay(100L)
      println("[${Thread.currentThread().name}] 코루틴 실행")
    }
  }
  delay(1000L) // 1초간 대기
}
/*
// 결과:
[DefaultDispatcher-worker-3 @Coroutine3#4] 코루틴 실행
[DefaultDispatcher-worker-8 @Coroutine5#6] 코루틴 실행
[DefaultDispatcher-worker-2 @Coroutine4#5] 코루틴 실행
*/