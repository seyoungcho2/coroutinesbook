package chapter3.code4

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val dispatcher = newSingleThreadContext(name = "SingleThread")
  launch(dispatcher) {
    println("[${Thread.currentThread().name}] 실행")
  }
}