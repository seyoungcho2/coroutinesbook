package chapter12.code7

import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class StringStateHolderTestFail {
  @Test
  fun `updateStringWithDelay("ABC")가 호출되면 문자열이 ABC로 변경된다`() = runTest {
    // Given
    val stringStateHolder = StringStateHolder()

    // When
    stringStateHolder.updateStringWithDelay("ABC")

    // Then
    advanceUntilIdle()
    Assertions.assertEquals("ABC", stringStateHolder.stringState)
  }
}