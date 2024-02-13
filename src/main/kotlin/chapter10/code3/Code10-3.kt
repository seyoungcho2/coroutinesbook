package chapter10.code3

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  launch {
    delay(1000L) // 1초 동안 코루틴 일시 중단
    println("[${getElapsedTime(startTime)}] 코루틴 실행 완료") // 지난 시간과 함께 "코루틴 실행 완료" 출력
  }
}
/*
// 결과:
[지난 시간: 1012ms] 코루틴 실행 완료
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
