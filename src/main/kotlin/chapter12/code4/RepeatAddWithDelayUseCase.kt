package chapter12.code4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RepeatAddWithDelayUseCase {
    suspend fun add(repeatTime: Int): Int {
        var result = 0
        repeat(repeatTime) {
            delay(100L)
            result += 1
        }
        return result
    }
}