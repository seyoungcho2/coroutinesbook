package chapter12.code7

import kotlinx.coroutines.*

/**
 * 테스트 불가능한 StringStateHolder 객체
 */
//class StringStateHolder {
//  private val coroutineScope = CoroutineScope(Dispatchers.IO)
//
//  var stringState = ""
//    private set
//
//  fun updateStringWithDelay(string: String) {
//    coroutineScope.launch {
//      delay(1000L)
//      stringState = string
//    }
//  }
//}

/**
 * 테스트 가능한 StringStateHolder 객체
 */
class StringStateHolder(
  private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
  private val coroutineScope = CoroutineScope(dispatcher)

  var stringState = ""
    private set

  fun updateStringWithDelay(string: String) {
    coroutineScope.launch {
      delay(1000L)
      stringState = string
    }
  }
}