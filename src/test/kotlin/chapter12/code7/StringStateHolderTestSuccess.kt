package chapter12.code7

import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class StringStateHolderTestSuccess {
  @Test
  fun `updateStringWithDelay("ABC")가 호출되면 문자열이 ABC로 변경된다`() {
    // Given
    val testDispatcher = StandardTestDispatcher()
    val stringStateHolder = StringStateHolder(
      dispatcher = testDispatcher
    )

    // When
    stringStateHolder.updateStringWithDelay("ABC")

    // Then
    testDispatcher.scheduler.advanceUntilIdle()
    Assertions.assertEquals("ABC", stringStateHolder.stringState)
  }
}