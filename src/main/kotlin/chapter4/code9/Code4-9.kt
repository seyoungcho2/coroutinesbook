package chapter4.code9

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val longJob: Job = launch(Dispatchers.Default) {
    repeat(10) { repeatTime ->
      delay(1000L) // 1000밀리초 대기
      println("[${getElapsedTime(startTime)}] 반복횟수 ${repeatTime}")
    }
  }
}
/*
// 결과:
[지난 시간: 1015ms] 반복횟수 0
[지난 시간: 2022ms] 반복횟수 1
[지난 시간: 3028ms] 반복횟수 2
...
[지난 시간: 8050ms] 반복횟수 7
[지난 시간: 9057ms] 반복횟수 8
[지난 시간: 10062ms] 반복횟수 9
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"