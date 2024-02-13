package chapter6.code9

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val coroutineName: CoroutineName = CoroutineName("MyCoroutine")

  if (coroutineName.key === CoroutineName.Key) {
    println("coroutineName.key와 CoroutineName.Key 동일합니다")
  }
}
/*
// 결과:
coroutineName.key와 CoroutineName.Key 동일합니다
*/