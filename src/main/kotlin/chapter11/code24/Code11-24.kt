package chapter11.code24

import kotlinx.coroutines.*
import kotlin.coroutines.resume

fun main() = runBlocking<Unit> {
  println("runBlocking 코루틴 일시 중단 호출")
  suspendCancellableCoroutine<Unit> { continuation: CancellableContinuation<Unit> ->
    println("일시 중단 시점의 runBlocking 코루틴 실행 정보: ${continuation.context}")
    continuation.resume(Unit) // 코루틴 재개 호출
  }
  println("runBlocking 코루틴 재개 후 실행되는 코드")
}
/*
// 결과:
runBlocking 코루틴 일시 중단 호출
일시 중단 시점의 runBlocking 코루틴 실행 정보: [BlockingCoroutine{Active}@551aa95a, BlockingEventLoop@35d176f7]
runBlocking 코루틴 재개 후 실행되는 코드

Process finished with exit code 0
*/