package chapter9.code10

import kotlinx.coroutines.*

suspend fun searchByKeyword(keyword: String): Array<String> {
  val dbResults = searchFromDB(keyword)
  val serverResults = searchFromServer(keyword)
  return arrayOf(*dbResults, *serverResults)
}

suspend fun searchFromDB(keyword: String): Array<String> {
  delay(1000L)
  return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}

suspend fun searchFromServer(keyword: String): Array<String> {
  delay(1000L)
  return arrayOf("[Server]${keyword}1", "[Server]${keyword}2")
}