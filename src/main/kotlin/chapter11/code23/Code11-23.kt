package chapter11.code23

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  println("runBlocking 코루틴 일시 중단 호출")
  suspendCancellableCoroutine<Unit> { continuation: CancellableContinuation<Unit> ->
    println("일시 중단 시점의 runBlocking 코루틴 실행 정보: ${continuation.context}")
  }
  println("일시 중단된 코루틴이 재개되지 않아 실행되지 않는 코드")
}
/*
// 결과:
runBlocking 코루틴 일시 중단 호출
일시 중단 시점의 runBlocking 코루틴 실행 정보: [CoroutineId(1), "coroutine#1":BlockingCoroutine{Active}@51cdd8a, BlockingEventLoop@d44fc21]

프로세스가 종료되지 않는다.
*/