package chapter12.code4

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RepeatAddWithDelayUseCaseTest {
  @Test
  fun `runBlocking_100번 더하면 100이 반환된다`() = runBlocking {
    // Given
    val repeatAddUseCase = RepeatAddWithDelayUseCase()

    // When
    var result = 0
    result = repeatAddUseCase.add(100)

    // Then
    assertEquals(100, result)
  }

  @Test
  fun `100번 더하면 100이 반환된다`() {
    // Given
    val testCoroutineScheduler = TestCoroutineScheduler()
    val testDispatcher = StandardTestDispatcher(testCoroutineScheduler)

    val repeatAddUseCase = RepeatAddWithDelayUseCase()

    // When
    var result = 0
    CoroutineScope(testDispatcher).launch {
      result = repeatAddUseCase.add(100)
    }
    testCoroutineScheduler.advanceUntilIdle()

    // Then
    assertEquals(100, result)
  }
}
