# ScheduleManagementApp

# 일정 관리 앱 API 설계문서

## API 목록

| **기능**               | **Method** | **URL**                                   | **Request**               | **Response**               | **상태코드**                          | **제약사항**                          |
|------------------------|------------|-------------------------------------------|---------------------------|----------------------------|---------------------------------------|---------------------------------------|
| 일정 생성              | POST       | /schedules                                | {<br>  "password": "1234",<br>  "work": "일정",<br>  "userId": "유저 아이디",<br>  "userName": "유저 이름",<br>  "schedulesDate": "19990510"<br>} | 200 OK                     | - 200 정상 등록 <br> - 400 등록 실패 | - 비밀번호, 일정은 필수값 <br> - 일정은 200자 이내 <br> - userinfo 테이블에 유저 아이디가 존재해야 일정 생성 가능 |
| 회원가입              | POST       | /Schedules/create-user                    | {<br>  "userId": "유저아이디",<br>  "userName": "유저 이름",<br>  "email": "email@Naver.com"<br>} | 201 CREATED                | - 201 정상 등록                     | - 유저 아이디 중복 불가 <br> - 이메일 중복 불가 |
| 일정 단건 조회        | GET        | /schedules/{scheduleId}                  | 요청 param <br> - id      | {<br>  "id": 20,<br>  "userId": "1",<br>  "work": "회식112",<br>  "userName": "장대산1",<br>  "schedulesDate": "1999-05-10",<br>  "createdDate": "2024-11-08 03:30:20",<br>  "modifiedDate": "2024-11-08 03:30:20"<br>} | - 200 정상 조회 <br> - 400 요청 실패 |                                       |
| 일정 이름 또는 수정일로 조회 (페이징) | GET | /Schedules?userName=유저이름&modifiedDate=2024-11-08&page=3&size=10 | 요청 param <br> userId, userName, page: 페이지 번호, size: 페이지 사이즈 | [<br>{<br>  "id": 20,<br>  "userId": "1",<br>  "work": "회식112",<br>  "userName": "장대산1",<br>  "schedulesDate": "1999-05-10",<br>  "createdDate": "2024-11-08 03:30:20",<br>  "modifiedDate": "2024-11-08 03:30:20"<br>},<br>{<br>  "id": 21,<br>  "userId": "1",<br>  "work": "회식112",<br>  "userName": "장대산1",<br>  "schedulesDate": "1999-05-10",<br>  "createdDate": "2024-11-08 03:33:13",<br>  "modifiedDate": "2024-11-08 03:33:13"<br>},<br>{<br>  "id": 22,<br>  "userId": "1",<br>  "work": "회식112",<br>  "userName": "장대산1",<br>  "schedulesDate": "1999-05-10",<br>  "createdDate": "2024-11-08 03:35:09",<br>  "modifiedDate": "2024-11-08 03:35:09"<br>}<br>] | - 200 정상 조회 <br> - 400 요청 실패 | param 필수 아님 <br> 아무것도 적지 않을 시 전체 조회 |
| 일정 수정              | PATCH      | /Schedules/{id}                          | {<br>  "password": "123",<br>  "work": "일정수정",<br>  "userName": "수정이름"<br>} | {<br>  "id": 9,<br>  "userId": "1",<br>  "work": "일정수정",<br>  "userName": "수정이름",<br>  "schedulesDate": "2024-10-29",<br>  "createdDate": "2024-11-07 13:22:12",<br>  "modifiedDate": "2024-11-08 03:11:42"<br>} | - 200 정상 수정 <br> - 400 요청 실패 <br> - 404 존재하지 않는 id로 시도 | - 비밀번호가 일치해야 수정 가능 <br> - 할일 200자 이내 |
| 일정 삭제              | DELETE     | /schedules/{id}                          | {<br>  "password": "1234"<br>} | 200 OK                     | - 200 정상 삭제 <br> - 400 요청 실패 <br> - 404 존재하지 않는 id로 시도 | - 비밀번호가 일치해야 삭제 가능 |

## API 세부 정보

### 1. 일정 생성
- **Method**: POST
- **URL**: `/schedules`
- **Request Body**:
    ```json
    {
        "id": "1",
        "userId": "qwe123",
        "scheduleDate": "2024-10-29 18:30:42",
        "work": "회식"
    }
    ```
- **Response**: (등록 응답 정보)

---

### 2. 회원가입
- **Method**: POST
- **URL**: `http://localhost:8080/Schedules/create-user`
- **Request Body**:
    ```json
    {
        "userId": "1",
        "userName": "테스트1",
        "email": "1@Naver.com"
    }
    ```
- **Response**: (응답 정보)

---

### 3. 일정 이름 또는 수정일로 조회
- **Method**: GET
- **URL**: (URL 입력 필요)
- **Request**: (요청 파라미터 입력 필요)
- **Response**: (응답 정보)

---

### 4. 일정 아이디로 조회
- **Method**: GET
- **URL**: (URL 입력 필요)
- **Request**: (요청 파라미터 입력 필요)
- **Response**: (응답 정보)

---

### 5. 일정 수정
- **Method**: PATCH
- **URL**: `http://localhost:8080/Schedules/9`
- **Request Body**:
    ```json
    {
        "password": "123",  
        "work": "미호크 잡기123", 
        "userName": "김조로"  
    }
    ```
- **Response**: (수정 응답 정보)

---

### 6. 일정 단건 삭제
- **Method**: DELETE
- **URL**: `http://localhost:8080/Schedules/12`
- **Request Body**:
    ```json
    {
        "password": "123"
    }
    ```
- **Response**: (단건 삭제 정보)

## 데이터베이스 테이블 생성 쿼리

### 일정 테이블

```sql
CREATE TABLE Schedules (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '일정을 구분하는 id',
                          userId BIGINT NOT NULL COMMENT '유저의 id',
                          title VARCHAR(100) NOT NULL COMMENT '일정 제목',
                          content TEXT COMMENT '일정 내용',
                          createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '',
                          updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '',
                          FOREIGN KEY (userId) REFERENCES User(id) ON DELETE CASCADE
);
```

### 유저 테이블

```sql
CREATE TABLE User (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '',
                      name VARCHAR(50) NOT NULL COMMENT '',
                      email VARCHAR(100) UNIQUE NOT NULL COMMENT '',
                      createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '',
                      updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT ''
);
```




### ERD
![image](https://github.com/user-attachments/assets/dab6077b-6187-426a-8922-bcd933179203)


