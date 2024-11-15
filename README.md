| 기능               | Method | URL              | Request                                                                 | Response                                                                 | 상태코드                          | 제약사항                          |
|--------------------|--------|------------------|-------------------------------------------------------------------------|--------------------------------------------------------------------------|-----------------------------------|-----------------------------------|
| 게시글 생성        | POST   | /boards          | {<br>  "title": "게시글 제목",<br>  "contents": "게시글 내용",<br>  "username": "작성자 이름"<br>} | {<br>  "id": "게시글 ID",<br>  "title": "게시글 제목",<br>  "contents": "게시글 내용",<br>  "username": "작성자 이름"<br>} | - 201 게시글 생성 성공<br>- 400 요청 실패 | - 제목은 필수 값<br>- 내용은 1000자 이내 |
| 게시글 전체 조회   | GET    | /boards          | 없음                                                                    | [{<br>  "id": "게시글 ID",<br>  "title": "게시글 제목",<br>  "contents": "게시글 내용",<br>  "username": "작성자 이름"<br>}, ...] | - 200 정상 조회                  | 없음                              |
| 게시글 단건 조회   | GET    | /boards/{id}     | 요청 param<br>- id                                                     | {<br>  "id": "게시글 ID",<br>  "title": "게시글 제목",<br>  "contents": "게시글 내용",<br>  "username": "작성자 이름",<br>  "age": "작성자 나이"<br>} | - 200 정상 조회<br>- 404 게시글 미존재 | 없음                              |
| 게시글 삭제        | DELETE | /boards/{id}     | 없음                                                                    | 없음                                                                     | - 200 삭제 성공<br>- 404 게시글 미존재 | 없음                              |
| 회원가입           | POST   | /members/signup   | {<br>  "username": "사용자명",<br>  "password": "비밀번호",<br>  "age": "나이"<br>} | {<br>  "id": "회원 ID",<br>  "username": "사용자명",<br>  "age": "나이"<br>} | - 201 회원가입 성공<br>- 400 요청 실패 | - 사용자명 중복 불가<br>- 비밀번호 필수 |
| 회원 단건 조회     | GET    | /members/{id}     | 요청 param<br>- id                                                     | {<br>  "id": "회원 ID",<br>  "username": "사용자명",<br>  "age": "나이"<br>} | - 200 정상 조회<br>- 404 회원 미존재 | 없음                              |
| 비밀번호 수정      | PATCH  | /members/{id}     | {<br>  "oldPassword": "기존 비밀번호",<br>  "newPassword": "새 비밀번호"<br>} | 없음                                                                     | - 200 수정 성공<br>- 400 요청 실패<br>- 404 회원 미존재 | - 기존 비밀번호가 일치해야 수정 가능 |


# API 상세 정보

### 1. 게시글 생성- **Method**: POST
- **URL**: `/boards`- **Request Body**:
    ```json
    {
        "title": "게시글 제목",
        "contents": "게시글 내용",
        "username": "작성자 이름"
    }
    ```
- **Response**:
    ```json
    {
        "id": "게시글 ID",
        "title": "게시글 제목",
        "contents": "게시글 내용",
        "username": "작성자 이름"
    }
    ```
- **Status Code**: 
  - 201: 게시글 생성 성공
  - 400: 요청 실패
- **제약사항**: 
  - 제목은 필수 값
  - 내용은 1000자 이내

---

### 2. 게시글 전체 조회- **Method**: GET
- **URL**: `/boards`- **Request Parameter**: 없음
- **Response**:
    ```json
    [
        {
            "id": "게시글 ID",
            "title": "게시글 제목",
            "contents": "게시글 내용",
            "username": "작성자 이름"
        },
        {
            "id": "게시글 ID",
            "title": "게시글 제목",
            "contents": "게시글 내용",
            "username": "작성자 이름"
        }
    ]
    ```
- **Status Code**: 
  - 200: 정상 조회
- **제약사항**: 없음

---

### 3. 게시글 단건 조회- **Method**: GET
- **URL**: `/boards/{id}`- **Request Parameter**:
    - `id`: 조회할 게시글 ID
- **Response**:
    ```json
    {
        "id": "게시글 ID",
        "title": "게시글 제목",
        "contents": "게시글 내용",
        "username": "작성자 이름",
        "age": "작성자 나이"
    }
    ```
- **Status Code**: 
  - 200: 정상 조회
  - 404: 게시글이 존재하지 않음
- **제약사항**: 없음

---

### 4. 게시글 삭제- **Method**: DELETE
- **URL**: `/boards/{id}`- **Request Parameter**:
    - `id`: 삭제할 게시글 ID
- **Response**: 없음
- **Status Code**: 
  - 200: 삭제 성공
  - 404: 게시글이 존재하지 않음
- **제약사항**: 없음

---

### 5. 회원가입- **Method**: POST
- **URL**: `/members/signup`- **Request Body**:
    ```json
    {
        "username": "사용자명",
        "password": "비밀번호",
        "age": "나이"
    }
    ```
- **Response**:
    ```json
    {
        "id": "회원 ID",
        "username": "사용자명",
        "age": "나이"
    }
    ```
- **Status Code**: 
  - 201: 회원가입 성공
  - 400: 요청 실패
- **제약사항**: 
  - 사용자명 중복 불가
  - 비밀번호 필수

---

### 6. 회원 단건 조회- **Method**: GET
- **URL**: `/members/{id}`- **Request Parameter**:
    - `id`: 조회할 회원 ID
- **Response**:
    ```json
    {
        "id": "회원 ID",
        "username": "사용자명",
        "age": "나이"
    }
    ```
- **Status Code**: 
  - 200: 정상 조회
  - 404: 회원이 존재하지 않음
- **제약사항**: 없음

---

### 7. 비밀번호 수정- **Method**: PATCH
- **URL**: `/members/{id}`- **Request Body**:
    ```json
    {
        "oldPassword": "기존 비밀번호",
        "newPassword": "새 비밀번호"
    }
    ```
- **Response**: 없음
- **Status Code**: 
  - 200: 수정 성공
  - 400: 요청 실패
  - 404: 회원이 존재하지 않음
- **제약사항**: 
  - 기존 비밀번호가 일치해야 수정 가능


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


