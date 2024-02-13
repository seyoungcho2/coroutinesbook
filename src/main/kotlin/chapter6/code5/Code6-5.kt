package chapter6.code5

import kotlinx.coroutines.*

fun main() {
  val dispatcherKey1 = Dispatchers.IO.key
  val dispatcherKey2 = Dispatchers.Default.key

  println("dispatcherKey1과 dispatcherKey2는 동일한가 >> ${dispatcherKey1 === dispatcherKey2}")
}
/*
// 결과:
dispatcherKey1과 dispatcherKey2는 동일한가 >> true
*/