package chapter3.code1

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.newSingleThreadContext

val dispatcher: CoroutineDispatcher = newSingleThreadContext(name = "SingleThread")