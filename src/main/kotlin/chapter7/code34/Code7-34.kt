package chapter7.code34

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { // runBlocking 코루틴
  val startTime = System.currentTimeMillis()
  launch { // 하위 launch 코루틴
    delay(1000L)
    println("[${Thread.currentThread().name}] 하위 코루틴 종료")
  }
  println(getElapsedTime(startTime)) // 지난 시간 출력
}

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"

/*
// 결과:
지난 시간: 4ms
[main @coroutine#2] 하위 코루틴 종료
*/