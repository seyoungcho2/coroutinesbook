package chapter1.code6

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
  val startTime = System.currentTimeMillis()
  // ExecutorService 생성
  val executorService: ExecutorService = Executors.newFixedThreadPool(2)

  // 작업1 제출
  executorService.submit {
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업1 시작")
    Thread.sleep(1000L) // 1초간 대기
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업1 완료")
  }
  // 작업2 제출
  executorService.submit {
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업2 시작")
    Thread.sleep(1000L) // 1초간 대기
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}]작업2 완료")
  }

  // ExecutorService 종료
  executorService.shutdown()
}
/*
// 결과:
[pool-1-thread-1][지난 시간: 4ms]작업1 시작
[pool-1-thread-2][지난 시간: 4ms]작업2 시작
[pool-1-thread-1][지난 시간: 1009ms]작업1 완료
[pool-1-thread-2][지난 시간: 1009ms]작업2 완료

Process finished with exit code 0
*/

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}ms"