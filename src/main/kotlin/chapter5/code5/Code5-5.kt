package chapter5.code5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val participantDeferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
    delay(1000L)
    arrayOf("James","Jason")
  }

  val participantDeferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
    delay(1000L)
    arrayOf("Jenny")
  }

  val results: List<Array<String>> = awaitAll(participantDeferred1, participantDeferred2) // 요청이 끝날 때까지 대기

  println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*results[0], *results[1])}")
}
/*
// 결과:
[지난 시간: 1013ms] 참여자 목록: [James, Jason, Jenny]
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
