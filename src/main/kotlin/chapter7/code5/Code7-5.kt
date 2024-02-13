package chapter7.code5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> { // 부모 코루틴
  val parentJob = coroutineContext[Job] // 부모 코루틴의 CoroutineContext로부터 부모 코루틴의 Job 추출
  launch { // 자식 코루틴
    val childJob = coroutineContext[Job] // 자식 코루틴의 CoroutineContext로부터 자식 코루틴의 Job 추출
    println("1. 부모 코루틴과 자식 코루틴의 Job은 같은가? ${parentJob === childJob}")
    println("2. 자식 코루틴의 Job이 가지고 있는 parent는 부모 코루틴의 Job인가? ${childJob?.parent === parentJob}")
    println("3. 부모 코루틴의 Job은 자식 코루틴의 Job을 참조를 가지는가? ${parentJob?.children?.contains(childJob)}")
  }
}
/*
// 결과:
1. 부모 코루틴과 자식 코루틴의 Job은 같은가? false
2. 자식 코루틴의 Job이 가지고 있는 parent는 부모 코루틴의 Job인가? true
3. 부모 코루틴의 Job은 자식 코루틴의 Job을 참조를 가지는가? true
*/