package chapter12.code6

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class FollowerSearcher(
  private val officialAccountRepository: OfficialAccountRepository,
  private val personAccountRepository: PersonAccountRepository
) {
  suspend fun searchByName(name: String): List<Follower> = coroutineScope {
    val officialAccountsDeferred = async {
      officialAccountRepository.searchByName(name)
    }
    val personAccountsDeferred = async {
      personAccountRepository.searchByName(name)
    }

    return@coroutineScope listOf(
      *officialAccountsDeferred.await(),
      *personAccountsDeferred.await()
    )
  }
}