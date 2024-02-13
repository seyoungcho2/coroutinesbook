package chapter12.code1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddUseCaseTest {
  @Test
  fun `1 더하기 2는 3이다`() {
    val addUseCase: AddUseCase = AddUseCase()
    val result = addUseCase.add(1, 2)
    assertEquals(3, result)
  }
}
