package chapter12.code2

interface UserNameRepository {
    fun saveUserName(id: String, name: String)
    fun getNameByUserId(id: String): String
}