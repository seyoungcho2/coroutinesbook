package chapter7.code3

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("ParentCoroutine")
  launch(coroutineContext){ // 부모 코루틴 생성
    println("[${Thread.currentThread().name}] 부모 코루틴 실행")
    launch(CoroutineName("ChildCoroutine")) {  // 자식 코루틴 생성
      println("[${Thread.currentThread().name}] 자식 코루틴 실행")
    }
  }
}
/*
// 결과:
[MyThread @ParentCoroutine#2] 부모 코루틴 실행
[MyThread @ChildCoroutine#3] 자식 코루틴 실행
*/