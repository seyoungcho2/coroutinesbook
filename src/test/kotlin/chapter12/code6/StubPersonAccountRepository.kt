package chapter12.code6

import kotlinx.coroutines.delay

class StubPersonAccountRepository(
  private val users: List<Follower.PersonAccount>
) : PersonAccountRepository {
  override suspend fun searchByName(name: String): Array<Follower.PersonAccount> {
    delay(1000L)
    return users.filter { user ->
      user.name.contains(name)
    }.toTypedArray()
  }
}