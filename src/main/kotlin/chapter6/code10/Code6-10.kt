package chapter6.code10

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking<Unit> {
  val coroutineName = CoroutineName("MyCoroutine")
  val dispatcher = Dispatchers.IO
  val myJob = Job()
  val coroutineContext: CoroutineContext = coroutineName + dispatcher + myJob

  val deletedCoroutineContext = coroutineContext.minusKey(CoroutineName)

  println(deletedCoroutineContext[CoroutineName])
  println(deletedCoroutineContext[CoroutineDispatcher])
  println(deletedCoroutineContext[Job])
}
/*
// 결과:
null
Dispatchers.IO
JobImpl{Active}@65e2dbf3
*/