package chapter10.code5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  repeat(10) { repeatTime ->
    launch {
      Thread.sleep(1000L) // 1초 동안 스레드 블로킹(코루틴의 스레드 점유 유지)
      println("[${getElapsedTime(startTime)}] 코루틴${repeatTime} 실행 완료") // 지난 시간과 함께 "코루틴 실행 완료" 출력
    }
  }
}

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
/*
// 결과:
[지난 시간: 1007ms] 코루틴0 실행 완료
[지난 시간: 2014ms] 코루틴1 실행 완료
[지난 시간: 3016ms] 코루틴2 실행 완료
[지난 시간: 4019ms] 코루틴3 실행 완료
[지난 시간: 5024ms] 코루틴4 실행 완료
[지난 시간: 6030ms] 코루틴5 실행 완료
[지난 시간: 7036ms] 코루틴6 실행 완료
[지난 시간: 8041ms] 코루틴7 실행 완료
[지난 시간: 9045ms] 코루틴8 실행 완료
[지난 시간: 10051ms] 코루틴9 실행 완료
*/