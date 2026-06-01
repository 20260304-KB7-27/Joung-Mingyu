// Java 플러그인은 Gradle에 적용
plugins {
    id("java")
}

// 프로젝트 그룹, 버전 관리
group = "org.example"
version = "1.0-SNAPSHOT"

// mavenCentral 원격 저장소 사용
repositories {
    mavenCentral()
}

// 의존성을 추가한 내용들
/* *
 * implementation - 내가 쓸 라이브러리
 * compileOnly - 컴파일 때만 필요함, jar에 포함 안됨 (Lombok)
 * runtimeOnly - 런타임에만 필요
 * annotationProcessor - 컴파일 중 코드를 생성하는 것 (Lombok)
 * test... - 테스트 코드 전용
 * */
dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // AssertJ
    testImplementation("org.assertj:assertj-core:3.27.7")

    // MySQL JDBC 드라이버
    implementation("com.mysql:mysql-connector-j:9.7.0")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")

    testCompileOnly("org.projectlombok:lombok:1.18.46")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.46")
}

tasks.test {
    useJUnitPlatform()
}