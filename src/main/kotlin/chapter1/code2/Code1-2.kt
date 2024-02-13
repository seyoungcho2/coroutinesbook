package chapter1.code2

fun main() {
  println("메인 스레드 시작")
  throw Exception("Dummy Exception")
  println("메인 스레드 종료")
}
/*
// 결과:
메인 스레드 시작
Exception in thread "main" java.lang.Exception: Dummy Exception
	at chapter1.code2.Code1_2Kt.main(Code1-2.kt:5)
	at chapter1.code2.Code1_2Kt.main(Code1-2.kt)

Process finished with exit code 1 // 프로세스가 비정상적으로 종료
*/