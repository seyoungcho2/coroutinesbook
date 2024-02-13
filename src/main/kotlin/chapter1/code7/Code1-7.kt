package chapter1.code7

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
  val startTime = System.currentTimeMillis()
  val executorService: ExecutorService = Executors.newFixedThreadPool(2)
  // 작업1 제출
  executorService.submit {
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업1 시작")
    Thread.sleep(1000L)
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업1 완료")
  }
  // 작업2 제출
  executorService.submit {
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업2 시작")
    Thread.sleep(1000L)
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업2 완료")
  }
  // 작업3 제출
  executorService.submit {
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업3 시작")
    Thread.sleep(1000L)
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업3 완료")
  }

  executorService.shutdown()
}
/*
// 결과:
[pool-1-thread-1][지난 시간: 4ms] 작업1 시작
[pool-1-thread-2][지난 시간: 4ms] 작업2 시작
[pool-1-thread-1][지난 시간: 1009ms] 작업1 완료
[pool-1-thread-2][지난 시간: 1011ms] 작업2 완료
[pool-1-thread-1][지난 시간: 1012ms] 작업3 시작
[pool-1-thread-1][지난 시간: 2016ms] 작업3 완료
*/

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}ms"