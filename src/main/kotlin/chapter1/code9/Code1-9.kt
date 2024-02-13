package chapter1.code9

fun main() {
  val startTime = System.currentTimeMillis()

  println("[${getElapsedTime(startTime)}] 메인 스레드 시작")
  Thread.sleep(1000L) // 1초 동안 스레드 대기(스레드 블로킹)
  println("[${getElapsedTime(startTime)}] 스레드 블로킹이 끝나고 실행되는 작업")
}
/*
// 결과:
[지난 시간: 8ms] 메인 스레드 시작
[지난 시간: 1024ms] 스레드 블로킹이 끝나고 실행되는 작업
*/

fun getElapsedTime(startTime: Long): String =
  "지난 시간: ${System.currentTimeMillis() - startTime}ms"