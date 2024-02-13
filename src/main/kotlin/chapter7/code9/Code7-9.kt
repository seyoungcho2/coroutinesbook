package chapter7.code9

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
  val infiniteJob = launch {
    while (true) {
      delay(1000L) // 1초간 대기
    }
  }
  infiniteJob.invokeOnCompletion { // 부모 코루틴이 종료될 시 호출되는 콜백 등록
    println("invokeOnCompletion 콜백 실행됨")
  }
  infiniteJob.cancel()
}
/*
// 결과:
invokeOnCompletion 콜백 실행됨
*/

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"