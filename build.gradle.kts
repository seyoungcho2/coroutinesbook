plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 코루틴 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    // JUnit5 테스트 프레임워크
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    // 코루틴 테스트 라이브러리
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.2")
}

// JUnit5을 사용하기 위한 옵션 추가
tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17) // jvmToolChain의 jdkVersion 17로 변경
}

application {
    mainClass.set("MainKt")
}