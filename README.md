# my-slipp
youtub 박재성님 https://www.youtube.com/playlist?list=PLqaSEyuwXkSppQAjwjXZgKkjWbFoUdNXC

### 배포 방법
```
$ ./mvnw clean package 
$ java -jar target/my-slipp.jar &
```

### mustache 파일 인식 못하는 에러
mustache 에서 ~~{{ > /include/header }}~~ 가 아니라 `{{ > include/header }}` 로 표시해야 제대로 인식됩니다.  
 
`UserController.java`에서도 마찬가지입니다. 파일 경로를 표시할 때, ~~"/user/list"~~ 가 아니라 `"user/list"` 로 작성해야 합니다.
 
 
### maven 에서 spring boot 를 실행하는 방법.(jar 로 압축하지 않는 방법)
```
./mvnw spring-boot:run &
```

### 리펙토링
가능한 데이터를 꺼내지 말고(getId..), 객체한테 메시지 보내며 물어봐. 

### 외부 Tomcat을 이용한 war 배포
1. pom.xml 에 아래 내용 추가

https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/reference/html/build-tool-plugins-maven-plugin.html
```xml
<packaging>war</packaging>
<!-- ... -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
    <!-- ... -->
</dependencies>
```

2. tomcat 설치 

설치 url 은 아파치 톰캣 홈페이지에 가서 맞는 거 받으면 됨.
```
curl -O https://downloads.apache.org/tomcat/tomcat-9/v9.0.39/bin/apache-tomcat-9.0.39.tar.gz
```
받은 파일 압축 해제
```
tar -xvf apache-tomcat-9.0.39.tar.gz
```
(옵션) 링크 걸기 
위 파일을 압축해제 하면, 이름이 길고 복잡하니까 간단한 이름으로 링크 거는 것.
```
ln -s apache-tomcat-9.0.39 tomcat
```
apache-tomcat-9.0.39 를 tomcat 이라는 이름으로 접근 가능. 

tomcat 실행 
```
cd tomcat/bin
./startup.sh
```

tomcat 종료
```
./shutdown.sh
```

(옵션) tomcat 포트 변경
```
cd tomcat/conf
vi server.xml
```
아래 port 를 변경해주면 됨.
```
...
<Connector port="8080" protocol="HTTP/1.1"
           connectionTimeout="20000"
           redirectPort="8443" />
...
```

3. war 로 빌드
```
./mvnw clean package 
```
  
 
 