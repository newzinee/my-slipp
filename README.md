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

 

 
  
 
 