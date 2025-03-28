plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "org.csystem"
version = "1.0.0"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	mavenLocal()
	maven {
		url = uri("https://raw.github.com/oguzkaran/javaapp2-jan-2024-maven-repo/main")
	}

	maven {
		url = uri("https://raw.github.com/oguzkaran/javaapp2-jan-2024-karandev-maven-repo/main")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")

	implementation("org.springframework.kafka:spring-kafka")

	compileOnly("org.projectlombok:lombok:1.18.34")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("org.springframework.kafka:spring-kafka-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
