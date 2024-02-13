package chapter6.code4

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

val myJob = Job()
val coroutineContext: CoroutineContext = Dispatchers.IO + myJob
