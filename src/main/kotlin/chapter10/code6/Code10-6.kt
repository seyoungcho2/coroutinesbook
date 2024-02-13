package chapter10.code6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val job = launch {
    println("1. launch 코루틴 작업이 시작됐습니다")
    delay(1000L) // 1초간 대기
    println("2. launch 코루틴 작업이 완료됐습니다")
  }
  println("3. runBlocking 코루틴이 곧 일시 중단 되고 메인 스레드가 양보됩니다")
  job.join() // job 내부의 코드가 모두 실행될 때까지 메인 스레드 일시 중단
  println("4. runBlocking이 메인 스레드에 분배돼 작업이 다시 재개됩니다")
}

/*
// 결과:
3. runBlocking 코루틴이 곧 일시 중단 되고 메인 스레드가 양보됩니다
1. launch 코루틴 작업이 시작됐습니다
2. launch 코루틴 작업이 완료됐습니다
4. runBlocking이 메인 스레드에 분배돼 작업이 다시 재개됩니다
*/