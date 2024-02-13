package chapter2.code2

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  println("[${Thread.currentThread().name}] 실행")
}