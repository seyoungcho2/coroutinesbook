package chapter3.code2

import kotlinx.coroutines.*
import kotlinx.coroutines.newFixedThreadPoolContext

val multiThreadDispatcher: CoroutineDispatcher = newFixedThreadPoolContext(
  nThreads = 2,
  name = "MultiThread"
)