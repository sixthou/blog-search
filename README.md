# Blog-search
Executable jar - 다운로드
## API 명세

### 블로그 검색

- 기본 정보
    - 요청 URL : /search/blog
    - HTTP 메서드 : GET
- request

| Name | Type | Required | Description                                           |
| --- | --- |-------------------------------------------------------| --- |
| query | String | Y | 검색어                                                   |
| sort | String | N | 검색 결과 정렬 방법 - ACCURACY : 정확도순 (기본값) / - RECENCY : 최신순 |
| size | Integer | N | 한 번에 표시할 검색 결과 개수 (기본값 : 10, 최대값 50)                  |
| page | Integer | N | 검색페이지 (기본값 : 1, 최대값 50)                               |

- response

| Name | Type | Description |
| --- | --- | --- |
| totalSize | String | 전체 페이지 개수 |
| totalPage | String | 전체 페이지 수 |
| size | Integer | 한 번에 표시할 검색 결과 개수 |
| page | Integer | 검색페이지 |
| documents | List | 검색 결과 리스트 |
| documents.title | String | 블로그 포스트 제목 |
| documents.contents | String | 블로그 포스트 내용 |
| documents.url | String | 블로그 포스트 URL |
| documents.blogName | String | 블로그의 이름 |
| documents.dateTime | dateTime | 블로그 포스트가 작성된 날짜 |
```json
{
  "documents": [
    {
      "title": "React_<b>netflix</b>-clone_1",
      "contents": "학습 목표 <b>netflix</b>를 만들어 보자고 1. <b>netflix</b>-clone_1 : The Movie DB API Key 생성하기 가장 처음으로는 react-<b>netflix</b>-clone 최상위 폴더를 만들고 터미널에 요롷게 해당 디렉토리에 리액트 앱을 설치해준다. <b>넷플릭스</b>를 만들기 위해선 우선적으로 영화 정보를 가져와야겠지?? 그 곳이 바로 The Movie DB이고 API를...",
      "url": "http://oyatplum.tistory.com/27",
      "blogName": "oyatplum",
      "datetime": "2023-02-03T11:17:26"
    }
  ],
  "totalSize": 800,
  "totalPage": 800,
  "size": 1,
  "page": 1
}
```

### 인기 검색어 목록
- 기본 정보
  - 요청 URL : /keyword/rank
  - HTTP 메서드 : GET 
- request
- response

| Name | Type | Description |
| --- | --- | --- |
| ranking | List | 인기 검색어 순위 |
| ranking.rank | Integer | 검색어 순위 |
| ranking.keyword | String | 검색어 |
| ranking.count | Integer | 검색 |

```json
{
  "ranking": [
    {
      "rank": 1,
      "keyword": "더 글로리 파트 2",
      "count": 68
    },
    {
      "rank": 2,
      "keyword": "날씨의 아이",
      "count": 42
    },
    {
      "rank": 3,
      "keyword": "신성한, 이혼",
      "count": 35
    },
    {
      "rank": 4,
      "keyword": "더 글로리",
      "count": 28
    },
    {
      "rank": 5,
      "keyword": "혜미리예채",
      "count": 27
    },
    {
      "rank": 6,
      "keyword": "대행사",
      "count": 23
    },
    {
      "rank": 7,
      "keyword": "압꾸",
      "count": 22
    },
    {
      "rank": 8,
      "keyword": "나는 신이다: 신이 배신한 사람들",
      "count": 13
    },
    {
      "rank": 9,
      "keyword": "일타 스캔들",
      "count": 5
    },
    {
      "rank": 10,
      "keyword": "netflix",
      "count": 1
    }
  ]
}
```

## Library

- spring-boot-starter-data-jpa
  - JPA(Java Persistence API)를 사용할 수 있도록 지원하는 스타터 패키지
- spring-boot-starter-web
  - 웹 애플리케이션을 개발할 때 필요한 기본적인 웹 관련 의존성을 제공하는 스타터 패키지
- spring-retry
  - 메서드 실행 중 장애가 발생했을 때 지정된 조건에 따라 자동으로 재시도(retry)할 수 있는 기능을 제공하는 라이브러리
- spring-boot-starter-validation
  - Bean Validation API를 사용하여 데이터 유효성 검사를 수행하는 데 필요한 의존성을 제공하는 스타터 패키지
- spring-boot-starter-cache
  - 캐싱(caching)을 구현하기 위한 기능을 제공하는 스타터 패키지
- com.github.ben-manes.caffeine:caffeine
  - 캐시 저장을 위한 Caffeine Cache 라이브러리 
- lombok
  - 반복적으로 작성하는 코드 메서드을를 자동으로 생성해주는 라이브러리
- h2
  - RDBMS로 인메모리 DB기능 사용 
