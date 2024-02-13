package chapter5.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis() // 1. 시작 시간 기록
  val participantDeferred1: Deferred<Array<String>> = async(Dispatchers.IO) { // 2. 플랫폼1에서 등록한 관람객 목록을 가져오는 코루틴
    delay(1000L)
    return@async arrayOf("James","Jason")
  }

  val participantDeferred2: Deferred<Array<String>> = async(Dispatchers.IO) { // 3. 플랫폼2에서 등록한 관람객 목록을 가져오는 코루틴
    delay(1000L)
    return@async arrayOf("Jenny")
  }

  val participants1 = participantDeferred1.await() // 4. 결과가 수신 될 때까지 대기
  val participants2 = participantDeferred2.await() // 5. 결과가 수신 될 때까지 대기

  println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*participants1, *participants2)}") // 6. 지난 시간 기록 및 참여자 목록 병합
}
/*
// 결과:
[지난 시간: 1018ms] 참여자 목록: [James, Jason, Jenny]
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
