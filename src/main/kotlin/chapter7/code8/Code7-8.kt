package chapter7.code8

import kotlinx.coroutines.*


fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis()
  val parentJob = launch { // 부모 코루틴 실행
    launch { // 자식 코루틴 실행
      delay(1000L) // 1초간 대기
      println("[${getElapsedTime(startTime)}] 자식 코루틴 실행 완료")
    }
    println("[${getElapsedTime(startTime)}] 부모 코루틴이 실행하는 마지막 코드")
  }
  parentJob.invokeOnCompletion { // 부모 코루틴이 종료될 시 호출되는 콜백 등록
    println("[${getElapsedTime(startTime)}] 부모 코루틴 실행 완료")
  }
}
/*
// 결과:
[지난 시간: 3ms] 부모 코루틴이 실행하는 마지막 코드
[지난 시간: 1019ms] 자식 코루틴 실행 완료
[지난 시간: 1019ms] 부모 코루틴 실행 완료
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"