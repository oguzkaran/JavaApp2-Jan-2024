plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
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
		url = uri("https://raw.github.com/oguzkaran/javaapp1-nov-2023-maven-repo/main")
	}

	maven {
		url = uri("https://raw.github.com/oguzkaran/javaapp2-jan-2024-karandev-maven-repo/main")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.csystem:org-csystem-util:12.0.0")
	implementation("org.csystem:RandomGeneratorProtoLib:1.0.0")
	implementation("net.devh:grpc-server-spring-boot-starter:3.1.0.RELEASE")
	implementation("org.csystem:org-csystem-util-grpc:1.0.0")

	compileOnly("org.projectlombok:lombok:1.18.32")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
