# Springboot-JPA-QLRM-Baseball
야구팀 관리 웹

![image](https://user-images.githubusercontent.com/63082842/112444638-9d136380-8d91-11eb-9de8-4a53ccdda287.png)

## 사용 라이브러리
 - Spring Web
 - Lombok
 - MySQL Driver
 - Spring Boot DevTools
 - Spring Data JPA
 - QLRM
 - JSTL
 - tomcat-embed-jasper
 
## MySQL 유저 및 DB 생성
```sql
create user 'baseball'@'%' identified by 'baseball1234';
grant all on *.* to 'baseball'@'%';
create database baseball;
```

### pivot
```sql
p.position as 'position', 
GROUP_CONCAT((CASE WHEN p.teamId = 2 THEN p.name ELSE null END)) as 'lotte', 
GROUP_CONCAT((CASE WHEN p.teamId = 3 THEN p.name ELSE null END)) as 'samsung', 
GROUP_CONCAT((CASE WHEN p.teamId = 4 THEN p.name ELSE null END)) as 'kt' 
from player p GROUP BY p.position;
```
![image](https://user-images.githubusercontent.com/63082842/112444553-840ab280-8d91-11eb-9bd9-e418a1d5d8b4.png)
