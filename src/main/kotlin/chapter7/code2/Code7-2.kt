package chapter7.code2

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("CoroutineA")
  launch(coroutineContext){ // 부모 코루틴 생성
    println("[${Thread.currentThread().name}] 부모 코루틴 실행")
    launch {  // 자식 코루틴 생성
      println("[${Thread.currentThread().name}] 자식 코루틴 실행")
    }
  }
}
/*
// 결과:
[MyThread @CoroutineA#2] 부모 코루틴 실행
[MyThread @CoroutineA#3] 자식 코루틴 실행
*/