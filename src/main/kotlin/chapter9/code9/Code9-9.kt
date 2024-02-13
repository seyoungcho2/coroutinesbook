package chapter9.code9

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  delayAndPrint(keyword = "I'm Parent Coroutine")
  launch {
    delayAndPrint(keyword = "I'm Child Coroutine")
  }
}

suspend fun delayAndPrint(keyword: String) {
  delay(1000L)
  println(keyword)
}

/*
// 결과:
I'm Parent Coroutine
I'm Child Coroutine
*/