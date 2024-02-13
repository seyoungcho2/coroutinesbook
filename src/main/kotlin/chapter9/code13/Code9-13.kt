package chapter9.code13

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
  println("[결과] ${searchByKeyword("Keyword").toList()}")
}
/*
// 결과:
[결과] [[Server]Keyword1, [Server]Keyword2]
*/

suspend fun searchByKeyword(keyword: String): Array<String> = supervisorScope { // this: CoroutineScope
  val dbResultsDeferred = async {
    throw Exception("dbResultsDeferred에서 예외가 발생했습니다")
    searchFromDB(keyword)
  }
  val serverResultsDeferred = async {
    searchFromServer(keyword)
  }

  val dbResults = try {
    dbResultsDeferred.await()
  } catch (e: Exception) {
    arrayOf() // 예외 발생 시 빈 결과 반환
  }

  val serverResults = try {
    serverResultsDeferred.await()
  } catch (e: Exception) {
    arrayOf() // 에러 발생 시 빈 결과 반환
  }

  return@supervisorScope arrayOf(*dbResults, *serverResults)
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