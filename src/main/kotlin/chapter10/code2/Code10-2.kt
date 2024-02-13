package chapter10.code2

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch {
    while(true) {
      println("자식 코루틴에서 작업 실행 중")
      yield() // 스레드 사용 권한 양보
    }
  }

  while(true) {
    println("부모 코루틴에서 작업 실행 중")
    yield() // 스레드 사용 권한 양보
  }
}
/*
// 결과:
...
부모 코루틴에서 작업 실행 중
자식 코루틴에서 작업 실행 중
부모 코루틴에서 작업 실행 중
자식 코루틴에서 작업 실행 중
부모 코루틴에서 작업 실행 중
자식 코루틴에서 작업 실행 중
...
*/