package chapter12.code8

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue

class BackgroundScopeTest {
  @Test
  fun `메인 스레드만 사용하는 runTest`() = runTest {
    println(Thread.currentThread())
  }
  /*
  // 결과:
  Thread[Test worker @kotlinx.coroutines.test runner#5,5,main]
  */

  @OptIn(ExperimentalCoroutinesApi::class)
  @Test
  fun `끝나지 않아 실패하는 테스트`() = runTest {
    var result = 0

    launch {
      while (true) {
        delay(1000L)
        result += 1
      }
    }

    advanceTimeBy(1500L)
    Assertions.assertEquals(1, result)
    advanceTimeBy(1000L)
    Assertions.assertEquals(2, result)
  }

  /*
  // 결과:
  After waiting for 10s, the test coroutine is not completing, there were active child jobs: ["coroutine#3":StandaloneCoroutine{Active}@381f03c1]
  kotlinx.coroutines.test.UncompletedCoroutinesError: After waiting for 10s, the test coroutine is not completing, there were active child jobs: ["coroutine#3":StandaloneCoroutine{Active}@381f03c1]
  at app//kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$2$1.invoke(TestBuilders.kt:349)
  at app//kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$2$1.invoke(TestBuilders.kt:333)
  ...
  */

  @Test
  fun `backgroundScope를 사용하는 테스트`() = runTest {
    var result = 0

    backgroundScope.launch {
      while (true) {
        delay(1000L)
        result += 1
      }
    }

    advanceTimeBy(1500L)
    Assertions.assertEquals(1, result)
    advanceTimeBy(1000L)
    Assertions.assertEquals(2, result)
  }
}