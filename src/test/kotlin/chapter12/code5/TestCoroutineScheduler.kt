package chapter12.code5

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import kotlinx.coroutines.test.TestCoroutineScheduler
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestCoroutineScheduler {
  @Test
  fun `가상 시간 조절 테스트`() {
    // 테스트 환경 설정
    val testCoroutineScheduler = TestCoroutineScheduler()

    testCoroutineScheduler.advanceTimeBy(5000L) // 가상 시간에서 5초를 흐르게 만듦 : 현재 시간 5초
    assertEquals(5000L, testCoroutineScheduler.currentTime) // 현재 시간이 5초임을 단언
    testCoroutineScheduler.advanceTimeBy(6000L) // 가상 시간에서 6초를 흐르게 만듦 : 현재 시간 11초
    assertEquals(11000L, testCoroutineScheduler.currentTime) // 현재 시간이 11초임을 단언
    testCoroutineScheduler.advanceTimeBy(10000L) // 가상 시간에서 10초를 흐르게 만듦 : 현재 시간 21초
    assertEquals(21000L, testCoroutineScheduler.currentTime) // 현재 시간이 21초임을 단언
  }

  @Test
  fun `가상 시간 위에서 테스트 진행`() {
    // 테스트 환경 설정
    val testCoroutineScheduler: TestCoroutineScheduler = TestCoroutineScheduler()
    val testDispatcher: TestDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
    val testCoroutineScope = CoroutineScope(context = testDispatcher)

    // Given
    var result = 0

    // When
    testCoroutineScope.launch {
      delay(10000L) // 10초간 대기
      result = 1
      delay(10000L) // 10초간 대기
      result = 2
      println(Thread.currentThread().name)
    }

    // Then
    assertEquals(0, result)
    testCoroutineScheduler.advanceTimeBy(5000L) // 가상 시간에서 5초를 흐르게 만듦 : 현재 시간 5초
    assertEquals(0, result)
    testCoroutineScheduler.advanceTimeBy(6000L) // 가상 시간에서 6초를 흐르게 만듦 : 현재 시간 11초
    assertEquals(1, result)
    testCoroutineScheduler.advanceTimeBy(10000L) // 가상 시간에서 10초를 흐르게 만듦 : 현재 시간 21초
    assertEquals(2, result)
  }

  @Test
  fun `advanceUntilIdle의 동작 살펴보기`() {
    // 테스트 환경 설정
    val testCoroutineScheduler: TestCoroutineScheduler = TestCoroutineScheduler()
    val testDispatcher: TestDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
    val testCoroutineScope = CoroutineScope(context = testDispatcher)

    // Given
    var result = 0

    // When
    testCoroutineScope.launch {
      delay(10_000L) // 10초간 대기
      result = 1
      delay(10_000L) // 10초간 대기
      result = 2
    }
    testCoroutineScheduler.advanceUntilIdle() // testCoroutineScope 내부의 코루틴이 모두 실행되게 만듦

    // Then
    assertEquals(2, result)
  }

  @Test
  fun `StandardTestDispatcher 사용하기`() {
    // 테스트 환경 설정
    val testDispatcher: TestDispatcher = StandardTestDispatcher()
    val testCoroutineScope = CoroutineScope(context = testDispatcher)

    // Given
    var result = 0

    // When
    testCoroutineScope.launch {
      delay(10_000L) // 10초간 대기
      result = 1
      delay(10_000L) // 10초간 대기
      result = 2
    }

    testDispatcher.scheduler.advanceUntilIdle() // testCoroutineScope 내부의 코루틴이 모두 실행되게 만듦
    assertEquals(2, result)
  }

  @Test
  fun `TestScope 사용하기`() {
    // 테스트 환경 설정
    val testCoroutineScope: TestScope = TestScope()

    // Given
    var result = 0

    // When
    testCoroutineScope.launch {
      delay(10000L) // 10초간 대기
      result = 1
      delay(10000L) // 10초간 대기
      result = 2
    }

    testCoroutineScope.advanceUntilIdle() // testCoroutineScope 내부의 코루틴이 모두 실행되게 만듦
    assertEquals(2, result)
  }

  @Test
  fun `runTest 사용하기`() {
    // Given
    var result = 0

    // When
    runTest { // this: TestScope
      delay(10000L) // 10초간 대기
      result = 1
      delay(10000L) // 10초간 대기
      result = 2
    }

    // Then
    assertEquals(2, result)
  }

  @Test
  fun `runTest로 테스트 감싸기`() = runTest {  // this: TestScope
    // Given
    var result = 0

    // When
    delay(10000L) // 10초간 대기
    result = 1
    delay(10000L) // 10초간 대기
    result = 2

    // Then
    assertEquals(2, result)
  }

  @Test
  fun `runTest에서 가상 시간 확인`() = runTest {  // this: TestScope
    delay(10000L) // 10초간 대기
    println("가상 시간: ${this.currentTime}ms") // 가상 시간: 10000ms
    delay(10000L) // 10초간 대기
    println("가상 시간: ${this.currentTime}ms") // 가상 시간: 20000ms
  }
  /*
  // 결과:
  가상 시간: 10000ms
  가상 시간: 20000ms
  */


  @Test
  fun `runTest 내부에서 advanceUntilIdle 사용하기`() = runTest {  // this: TestScope
    var result = 0
    launch {
      delay(1000L)
      result = 1
    }

    println("가상 시간: ${this.currentTime}ms, result = ${result}") // 가상 시간: 0ms, result = 0
    advanceUntilIdle()
    println("가상 시간: ${this.currentTime}ms, result = ${result}") // 가상 시간: 1000ms, result = 1
  }

  @Test
  fun `runTest 내부에서 join 사용하기`() = runTest {  // this: TestScope
    var result = 0
    launch {
      delay(1000L)
      result = 1
    }.join()

    println("가상 시간: ${this.currentTime}ms, result = ${result}") // 가상 시간: 1000ms, result = 1
  }
}