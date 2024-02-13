package chapter10.code4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  repeat(10) { repeatTime ->
    launch {
      delay(1000L) // 1초 동안 코루틴 일시 중단
      println("[${getElapsedTime(startTime)}] 코루틴${repeatTime} 실행 완료") // 지난 시간과 함께 "코루틴 실행 완료" 출력
    }
  }
}

/*
// 결과:
[지난 시간: 1014ms] 코루틴0 실행 완료
[지난 시간: 1015ms] 코루틴1 실행 완료
[지난 시간: 1015ms] 코루틴2 실행 완료
[지난 시간: 1015ms] 코루틴3 실행 완료
[지난 시간: 1015ms] 코루틴4 실행 완료
[지난 시간: 1015ms] 코루틴5 실행 완료
[지난 시간: 1015ms] 코루틴6 실행 완료
[지난 시간: 1016ms] 코루틴7 실행 완료
[지난 시간: 1016ms] 코루틴8 실행 완료
[지난 시간: 1016ms] 코루틴9 실행 완료
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
