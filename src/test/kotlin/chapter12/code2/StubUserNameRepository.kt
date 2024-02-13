package chapter12.code2

// 유연하지 않은 StubUserNameRepository
//class StubUserNameRepository : UserNameRepository {
//    private val userNameMap = mapOf<String, String>(
//        "0x1111" to "홍길동",
//        "0x2222" to "조세영"
//    )
//
//    override fun saveUserName(id: String, name: String) {
//        // 구현하지 않는다.
//    }
//
//    override fun getNameByUserId(id: String): String {
//        return userNameMap[id] ?: ""
//    }
//}

// 유연한 StubUserNameRepository
class StubUserNameRepository(
    private val userNameMap: Map<String, String> // 데이터 주입
) : UserNameRepository {
    override fun saveUserName(id: String, name: String) {
        // 구현하지 않는다.
    }

    override fun getNameByUserId(id: String): String {
        return userNameMap[id] ?: ""
    }
}