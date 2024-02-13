package chapter5.code6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis() // 시작 시간 기록
  val participantDeferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
    delay(1000L) // 참여자 이름 조회 요청
    arrayOf("James", "Jason") // 참여자 반환
  }

  val participantDeferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
    delay(1000L) // 참여자 이름 조회 요청
    arrayOf("Jenny") // 참여자 반환
  }

  val results: List<Array<String>> = listOf(participantDeferred1, participantDeferred2).awaitAll() // 요청이 끝날 때까지 대기

  println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*results[0], *results[1])}")
}
/*
// 결과:
[지난 시간: 1015ms] 참여자 목록: [James, Jason, Jenny]
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
