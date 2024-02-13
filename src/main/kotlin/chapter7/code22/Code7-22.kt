package chapter7.code22

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { // 루트 Job 생성
  val newScope = CoroutineScope(Dispatchers.IO) // 새로운 루트 Job 생성
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
}
/*
// 결과:
Process finished with exit code 0
*/