package chapter9.code11

import kotlinx.coroutines.*

// 주석을 지우고 오류 확인
//suspend fun searchByKeyword(keyword: String): Array<String> {
//  val dbResultsDeferred = async {
//    searchFromDB(keyword)
//  }
//  val serverResultsDeferred = async {
//    searchFromServer(keyword)
//  }
//  return arrayOf(*dbResultsDeferred.await(), *serverResultsDeferred.await())
//}

suspend fun searchFromDB(keyword: String): Array<String> {
  delay(1000L)
  return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}

suspend fun searchFromServer(keyword: String): Array<String> {
  delay(1000L)
  return arrayOf("[Server]${keyword}1", "[Server]${keyword}2")
}