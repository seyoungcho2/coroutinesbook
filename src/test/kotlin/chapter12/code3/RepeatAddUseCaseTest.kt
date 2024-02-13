package chapter12.code3

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * 오류가 생기는 테스트
 * 일시 중단 함수로 인해 아래와 같이 작성하면 오류가 생긴다.
 */
//class RepeatAddUseCaseTest {
//  @Test
//  fun `100번 더하면 100이 반환된다`() {
//    // Given
//    val repeatAddUseCase = RepeatAddUseCase()
//
//    // When
//    val result = repeatAddUseCase.add(100)
//
//    // Then
//    assertEquals(100, result)
//  }
//}

class RepeatAddUseCaseTest {
  @Test
  fun `100번 더하면 100이 반환된다`() = runBlocking {
    // Given
    val repeatAddUseCase = RepeatAddUseCase()

    // When
    val result = repeatAddUseCase.add(100)

    // Then
    assertEquals(100, result)
  }
}