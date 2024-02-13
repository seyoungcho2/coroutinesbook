package chapter12.code1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddUseCaseTestFail {
  @Test
  fun `1 더하기 2는 4이다`() {
    val addUseCase: AddUseCase = AddUseCase()
    val result = addUseCase.add(1, 2)
    assertEquals(4, result) // 1 더하기 2는 3이므로 단언은 실패한다.
  }
}
