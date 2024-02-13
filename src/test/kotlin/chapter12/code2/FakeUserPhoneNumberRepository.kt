package chapter12.code2

class FakeUserPhoneNumberRepository : UserPhoneNumberRepository {
  private val userPhoneNumberMap = mutableMapOf<String, String>()

  override fun saveUserPhoneNumber(id: String, phoneNumber: String) {
    userPhoneNumberMap[id] = phoneNumber
  }

  override fun getPhoneNumberByUserId(id: String): String {
    return userPhoneNumberMap[id] ?: ""
  }
}