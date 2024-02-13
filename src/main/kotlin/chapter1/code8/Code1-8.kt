package chapter1.code8

import java.util.concurrent.*

fun main() {
  val executorService: ExecutorService = Executors.newFixedThreadPool(2)
  val future: Future<String> = executorService.submit<String> {
    Thread.sleep(2000)
    return@submit "작업 1완료"
  }

  val result = future.get() // 메인 스레드가 블로킹 됨
  println(result)
  executorService.shutdown()
}