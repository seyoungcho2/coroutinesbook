package chapter3.code3

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val dispatcher = newSingleThreadContext(name = "SingleThread")
  launch(context = dispatcher) {
    println("[${Thread.currentThread().name}] 실행")
  }
}
/*
// 결과:
[SingleThread @coroutine#2] 실행
*/