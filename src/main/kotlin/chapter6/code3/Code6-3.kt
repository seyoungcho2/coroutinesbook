package chapter6.code3

import kotlinx.coroutines.*

val coroutineContext1 = CoroutineName("MyCoroutine1") + newSingleThreadContext("MyThread1")
val coroutineContext2 = CoroutineName("MyCoroutine2") + newSingleThreadContext("MyThread2")
val combinedCoroutineContext = coroutineContext1 + coroutineContext2
