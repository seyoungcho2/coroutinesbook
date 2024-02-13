package chapter11.code25

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.resume

fun main() = runBlocking<Unit> {
  val result = suspendCancellableCoroutine<String> { continuation: CancellableContinuation<String> -> // runBlocking 코루틴 일시 중단 시작
      thread { // 새로운 스레드 생성
        Thread.sleep(1000L) // 1초간 대기
        continuation.resume("실행 결과") // runBlocking 코루틴 재개
      }
    }
  println(result) // 코루틴 재개 시 반환 받은 결과 출력
}
/*
// 결과:
실행 결과

Process finished with exit code 0
*/