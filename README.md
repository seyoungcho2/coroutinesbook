## 소개
『코틀린 코루틴의 정석』, 에이콘 출판사(2024) 책의 코드를 모아 놓은 저장소 입니다.

<br>

## 코드 찾는 방법
책의 각 코드 위에는 코드의 위치에 관한 내용이 나와있습니다. 예를 들어 다음과 같은 코드는

```
코드 위치: src/main/chapter3/code3/Code3-3.kt
fun main() = runBlocking<Unit> {
  val dispatcher = newSingleThreadContext(name = "SingleThread")
  launch(context = dispatcher) {
    println("[${Thread.currentThread().name}] 실행")
  }
}
```

다음 위치에 있습니다.
- 소스 코드: /src/main/kotlin/chapter3/code3/Code3-3.kt
- GitHub: https://github.com/seyoungcho2/coroutinesbook/blob/main/src/main/kotlin/chapter3/code3/Code3-3.kt

<br>

## 코드 실행 방법
### 예시 코드
예시 코드는 main 함수 옆의 재생 버튼(►)을 누르고, Run '파일명' 버튼을 누르면 실행 가능합니다. <br>
<img width="498" alt="스크린샷 2024-02-13 오후 4 16 29" src="https://github.com/seyoungcho2/coroutinesbook/assets/59521473/4cf86a51-dbb4-4daf-ab65-f425ae01f244">

<br>

### 테스트 코드

테스트 코드는 테스트 함수 옆의 재생 버튼(►)을 누르고, Run'함수 이름' 버튼을 누르면 실행 가능합니다. <br>
<img width="410" alt="스크린샷 2024-02-13 오후 4 15 59" src="https://github.com/seyoungcho2/coroutinesbook/assets/59521473/30cd18a2-25d5-4561-af4a-00b3ea9aa40c">

<br> <br>

## 링크 목록
- 카카오톡 오픈챗: [코틀린, 안드로이드, 스프링 사용자 모임](https://open.kakao.com/o/gAmC7aVd)
- 책 구매: 이후 업데이트 예정
<br>

## 코드 문의 및 오타 신고 ⚠️
- 저자 이메일: seyoungcho2@gmail.com

<br>

## 책이 유용하다고 생각하셨나요?👍
- 깃허브 스타⭐를 통해 책을 지지해주세요!<br>책을 지지한 사람을 [Starganizers](https://github.com/seyoungcho2/coroutinesbook/stargazers) 페이지에서 볼 수 있습니다.
- 저를 [팔로우](https://github.com/seyoungcho2) 해서 이후의 소식에 대한 알림을 받아보세요.
