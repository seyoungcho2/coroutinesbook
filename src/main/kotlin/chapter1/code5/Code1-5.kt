package chapter1.code5

import kotlin.concurrent.thread

fun main() {
  println("[${Thread.currentThread().name}] 메인 스레드 시작")
  thread(isDaemon = false) {
    println("[${Thread.currentThread().name}] 새로운 스레드 시작")
    Thread.sleep(2000L) // 2초 동안 대기
    println("[${Thread.currentThread().name}] 새로운 스레드 종료")
  }
  Thread.sleep(1000L) // 1초 동안 대기
  println("[${Thread.currentThread().name}] 메인 스레드 종료")
}
/*
// 결과:
[main] 메인 스레드 시작
[Thread-0] 새로운 스레드 시작
[main] 메인 스레드 종료
[Thread-0] 새로운 스레드 종료

Process finished with exit code 0
*/