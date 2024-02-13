package chapter11.code8

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicReference

data class Counter(val name: String, val count: Int)
val atomicCounter = AtomicReference(Counter("MyCounter", 0)) // 원자성 있는 Counter 만들기

fun main() = runBlocking<Unit> {
  withContext(Dispatchers.Default) {
    repeat(10_000) {
      launch {
        atomicCounter.getAndUpdate {
          it.copy(count = it.count + 1) // MyCounter의 count값 1 더하기
        }
      }
    }
  }
  println(atomicCounter.get())
}
/*
// 결과:
Counter(name=MyCounter, count=10000)
*/