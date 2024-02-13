package chapter12.code6

interface PersonAccountRepository {
  suspend fun searchByName(name: String): Array<Follower.PersonAccount>
}