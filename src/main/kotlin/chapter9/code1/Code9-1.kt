package chapter9.code1

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  delay(1000L)
  println("Hello World")
  delay(1000L)
  println("Hello World")
}