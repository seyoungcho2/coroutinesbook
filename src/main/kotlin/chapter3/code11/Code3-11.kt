package chapter3.code8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  launch(Dispatchers.Main){
    println("[${Thread.currentThread().name}] 코루틴 실행")
  }
}
/*
// 결과:
Exception in thread "main" java.lang.IllegalStateException: Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'
	at kotlinx.coroutines.internal.MainDispatchersKt.throwMissingMainDispatcherException(MainDispatchers.kt:81)
...
*/