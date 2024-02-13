package chapter6.code7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val coroutineContext = CoroutineName("MyCoroutine") + Dispatchers.IO
  val nameFromContext = coroutineContext[CoroutineName] // '.Key'제거
  println(nameFromContext)
}
/*
// 결과:
CoroutineName(MyCoroutine)
*/