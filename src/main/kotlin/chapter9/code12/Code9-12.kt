package chapter9.code12

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  val startTime = System.currentTimeMillis() // 1. 시작 시간 기록
  val results = searchByKeyword("Keyword") // 2. 검색 실행 및 결과 값 반환 받기
  println("[결과] ${results.toList()}") // 3. 결과값 출력
  println(getElapsedTime(startTime)) // 4. 지난 시간 표시
}

suspend fun searchByKeyword(keyword: String): Array<String> = coroutineScope { // this: CoroutineScope
  val dbResultsDeferred = async {
    searchFromDB(keyword)
  }
  val serverResultsDeferred = async {
    searchFromServer(keyword)
  }

  return@coroutineScope arrayOf(*dbResultsDeferred.await(), *serverResultsDeferred.await())
}

suspend fun searchFromDB(keyword: String): Array<String> {
  delay(1000L)
  return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}

suspend fun searchFromServer(keyword: String): Array<String> {
  delay(1000L)
  return arrayOf("[Server]${keyword}1", "[Server]${keyword}2")
}

fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"

/*
// 결과:
[결과] [[DB]Keyword1, [DB]Keyword2, [Server]Keyword1, [Server]Keyword2]
지난 시간: 1039ms
*/