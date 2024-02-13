package chapter12.code6

interface OfficialAccountRepository {
  suspend fun searchByName(name: String): Array<Follower.OfficialAccount>
}