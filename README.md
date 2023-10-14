# 원티드 프리온보딩 백엔드 인턴십 - 사전 과제
### 이름 : 서명진
자세한 내용은 깃허브 위키에서 작성하였으며, 리드미에는 요약만 작성했습니다.<br>
[깃허브 위키](https://github.com/myoungjinseo/wanted-pre-onboarding-backend/wiki)

## 요구사항 분석 및 실행 여부
1. 채용공고 CRUD : create(post), Read(Jpa, QueryDSL 이용해서 표현), update(patch -> JPA 더티체킹 이용), delete(delete)<br>
2. ORM 사용 구현 : Spring Data JPA, QueryDSL <br>
3. RDBMS 사용 : Mysql(본 내용), h2(테스트 코드)<br>
4. Unit Test 구현 : junit을 이용한 테스트 코드 구현 <br>
   
## 구현과정
0. 회사 및 사용자 등록 <br>
.sql 파일을 이용해서 진행 <br>
### 1. 채용 공고 등록 (POST)
/api/employment
#### 요청 
---json
{
    "companyId" : 1,

    "position": "백엔드 주니어 개발자",

    "compensation" : 1000000,

    "content" : "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",

    "skill" : "Python"
}   
```
#### 응답
```json
{
    "data": {
        "employmentId": 1,
        "companyId": 1,
        "position": "2",
        "compensation": 1,
        "content": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
        "skill": "1"
    }
}
```
### 2. 채용 공고 수정 (PATCH)
/api/employment/1
#### 요청
```json
{

    "position": "백엔드 주니어 개발자",

    "compensation" : 1500000,

    "content" : "원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..",

    "skill" : "Python"
}
```
#### 응답
```json
{
    "data": {
        "employmentId": 1,
        "position": "백엔드 주니어 개발자",
        "compensation": 1500000,
        "content": "원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..",
        "skill": "Python"
    }
}
```

### 3. 채용 공고 삭제 (PATCH)
/api/employment/{employmentId}
#### 요청
```json
```
#### 응답
204 코드 
```json
```

### 4. 채용 공고 목록 (GET)
/findAll
#### 요청
```json
```
#### 응답
```json
{
    "data": [
        {
            "employmentId": 3,
            "companyName": "원티드",
            "country": "한국",
            "region": "서울",
            "position": "백엔드 주니어 개발자",
            "compensation": 1300000,
            "skill": "Django"
        },
        {
            "employmentId": 2,
            "companyName": "네이버",
            "country": "한국",
            "region": "판교",
            "position": "백엔드 주니어 개발자",
            "compensation": 1000000,
            "skill": "Django"
        },
        {
            "employmentId": 1,
            "companyName": "원티드",
            "country": "한국",
            "region": "서울",
            "position": "백엔드 주니어 개발자",
            "compensation": 1500000,
            "skill": "Python"
        }
    ]
}
```
### 5. 채용 공고 검색 (GET)
/some/url?search=원티드
#### 요청
##### 쿼리 파라미터
|이름|타입|설명|필수|
|------|---|---|---|
|search|String|검색 내용|O|
```json
```
#### 응답
```json
{
    "data": [
        {
            "employmentId": 3,
            "companyName": "원티드",
            "country": "한국",
            "region": "서울",
            "position": "백엔드 주니어 개발자",
            "compensation": 1300000,
            "skill": "Django"
        },
        {
            "employmentId": 1,
            "companyName": "원티드",
            "country": "한국",
            "region": "서울",
            "position": "백엔드 주니어 개발자",
            "compensation": 1500000,
            "skill": "Python"
        }
    ]
}
```

### 6. 채용 공고 상세 (GET)
/some/url?search=원티드
#### 요청
```json
```
#### 응답
```json
{
    "data": {
        "employmentId": 1,
        "companyName": "원티드",
        "country": "한국",
        "region": "서울",
        "position": "백엔드 주니어 개발자",
        "compensation": 1500000,
        "skill": "Python",
        "content": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
        "orderId": [
            3
        ]
    }
}
```

### 7. 채용 공고 지원 (POST)
/some/url?search=원티드
#### 요청
```json
{
    "memberId" : 1,
    "name" : "서명진"
}
```
#### 응답
```json
{
    "applyId": 1,
    "employmentId": 1,
    "memberId": 3
}
```

## ERD 다이어그램
<img src="https://github.com/myoungjinseo/wanted-pre-onboarding-backend/assets/80959635/bdd0ed62-6e35-4cee-9d1a-925b083ab56a" width="300" height="600"/>
