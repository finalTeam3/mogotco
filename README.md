# MOGOTCO
<img  src="https://user-images.githubusercontent.com/83347312/207089142-e9d840c9-f774-49a1-9e94-0096fd6eea14.png" width="60%" height="100%">

---
> 팀정보 + 시연영상
## 팀이름 : MOGOTCO  

## 팀원
- 팀장 : 조윤영
- 팀원 : 박성훈, 박혜정, 신동준  

## 시연영상
> url주소

# 프로젝트 정보
## 1. 프로젝트 주제
- 개발 멘토링 사이트를 구축하여 영상채팅을 통해 개발자에게 도움을 받을 수 있는 공간을 만든다.
## 2. 프로젝트 목적
1. 클라우드 환경 사용(NCP)
1. i-connect API를 이용해 화상 회의를 이용한 멘토링 서비스 구현
1. AI Platform(CLOVA OCR)을 활용한 명함 인식을 통한 신뢰성 높은 멘토가 있는 서비스 구현
1. AI Platform(CLOVA CHATBOT)을 활용한 챗봇 기능 구현
1. 카카오, 깃허브 등 다양한 로그인 API를 활용한 로그인 기능 구현

## 3. 프로젝트 기능 구현
1. 화상 회의를 통해 멘토링 기능 구현
1. 로그인 API(OAuth) 사용해 로그인 및 회원가입 기능
1. CLOVA OCR을 이용한 멘토의 명함 인식 서비스 기능
1. 결제 API 기능
1. 멘토링 카테고리별, type별 검색 기능, 멘토 카테고리별, 회사별 검색 기능
1. 이메일을 통한 멘토링 알림 기능 및 인증기능
1. 리뷰, 평점 기능
1. CLOVA Chatbot을 pop up으로 이용하여 어느곳에서든 문의가 가능한 기능 구현
	
## 4. 프로젝트 역할 분담

|**팀원**|**역할**|
|----|----|
|조윤영|멘토링 결제기능(API,coupon,point사용), 멘토링&멘토 검색기능(메인페이지, 멘토링페이지, 멘토리스트페이지에서 카페고리별, type별, 회사별 검색), 페이징처리&scrolling,CLOVA CHATBOT(문의하기)|
|박성훈|CLOVA OCR(명함 인식 서비스),CLOVA CHATBOT(문의하기), 멘토 위시리스트, admin (전체적 페이지, 멘토 승인)|
|박혜정|회원가입, 일반로그인&소셜로그인(kakao,github)기능, 이메일 사용 기능(회원가입시 인증번호, 멘토링 알림메일, 멘토 승인 메일), 리뷰&평점 기능, Q&A및 자주하는 질문, admin (Q&A)|
|신동준|화상회의기능(API), 멘토링 장소 지도로 보여줌(API), 멘토링 등록 기능(날짜, 시간 선택 가능)|

## 5. 프로젝트 개발 환경 및 수행 도구
|**협업도구**|**database&framework&개발도구**|**backend**|**frontend**|**API**|
|---|---|---|---|---|
|구들닥스|MYSQL(8.0.17)|java(11.0.15.1)|js|CLOVA OCR|
|네이버카페|Spring Boot(2.7.4)|apache-tomcat(8.5.27)|Html5|CLOVA ChatBot|
|ZOOM|MyBatis(2.2.2)|NCP(Naver Cloud Platform)|CSS|Import|
|Git|Eclipse(4.18.0)||jQuery(3.2.1)|kakao I Connect API|
|GitHub|JUnit(5.8.2)||AJAX|kakao map|
|Gather Town|Spring Boot Maile Sender(2.7.5)||thymeleaf(3.0.15)|github login API|
|Erd Cloud|||BootStrap(4)|kakao login API
|Notion||||kakao 공유하기|
|Figma|

## 6. WBS
![WBS](https://user-images.githubusercontent.com/111735748/206927107-40fc6d9b-70bd-4dcd-b57d-ee9ccdd34eea.jpg)
## 7. 데이터베이스 설계
![mogotco (4)](https://user-images.githubusercontent.com/83347312/206660375-1d1bb75e-1428-46f4-99ef-5ae8baf753ad.png)
## 8. 유저 플로우
<img  src="https://user-images.githubusercontent.com/83347312/206914954-c3f9e2e1-a53b-4a32-a2e6-f3e2233507cb.png" width="100%" height="100%">
<br/>
<br/>

# 프로젝트 내용
주요기능들은 반응형 웹 화면까지 같이 보여주는+ 각자 gif에 어떤 기능 보여주고 싶은지 생각해오기
## 1. 회원로그인 
- 로그인기능, 회원가입기능, 소셜 로그인기능, 비회원일때 멘토리스트까지만 볼 수 있는 기능, 마이페이지 기능

## 2. 멘토링 검색
- 전체검색기능, 상(분야별)하위 메뉴바(시간별, 대면종류별, 수강후기순, 별점 순, 사후서비스 유무), 문의하기기능
멘토들은 크롤링을 통해 가지고 옴

## 3. 멘토링 상세 
- 멘토 위시리스트, 오프라인일 경우 지도+마커 뿌려주기


## 4. 멘토 
> 명함 및 사원증 회사 인증 후 등록(OCR) 및 수정 등록 

### 4.1 OCR 연동 프로세스

- ajax 비동기 요청 

  - 화면단에서 사용자가 명함 이미지를 업로드하면 파일이 formdata에 담겨지고 명함 등록하는 post 요청을 AjaxController에 비동기로 전송.

<br>

- 파일 저장 및 ocr 시스템 실행 [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/AjaxController.java#L121)
  
  - AjaxController에서는 화면단에서 넘어온 파일을 Util클래스의 메서드를 통해 사용자 페이지와 관리자 페이지에 동시에 저장. 그 후 시스템에 저장된 명함이미지를 ocrservice의 ocrresult 메서드의 파라미터로 넘겨주면 json 객체가 ajax의 url을 통해 화면단으로 반환.

<br>

- OCR 실행 결과 추출 [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/mentor/mentorregister.html#L132)

  - AjaxController에서 화면단으로 json 객체를 보내어 js의 display함수를 통해 파싱을 한 뒤 각각의 input창에 id값을 할당하여 데이터를 입력.

<br>

### 4.2. 실제 작동 화면
![ocr 실제 작동 화면]()

<br>

## 5. 구매 
- import 결제 기능 ( 기능), 포인트 사용

## 6. 멘토링 진행 
- kako i-connect API를 사용하여 영상으로 멘토링 진행, 웹소켓을 사용하여 채팅창 지원

## 7. 후기 및 평점 
- 리뷰쓰기 및 보는 기능 & 별점 추가

## 8. 문의하기 
- 챗봇 (NCP CLOVA의 chatbot custom API)
  - CLOVA Chatbot 빌더에서 설정한 도메인의 학습결과를 기반으로 질의 응답을 제공하는 API를 이용한 고객 문의 대응

### 8.1. chatbot custom API
-  NCP CLOVA의 chatbot custom API는 CLOVA Chatbot 빌더에서 설정한 도메인의 학습결과를 기반으로 상대방의 질문에 대한 응답을 제공하는 API

### 8.2. 개발 프로세스
> - 네이버 클라우드 연동 관련 설정
>  
> - Chatbot 빌더를 이용하여 대화시나리오 작성한 후 인증키를 발급받고 ChatbotController에 Secret Key를 입력한 후 네이버 api 연동
> 
> - 웹소켓
>   - 메세지를 주고 받기 위해 StomWebSocketConfig.java에서 웹소켓 설정한 후 화면단에서 javascript로 통해 챗봇 구현

### 8.3. 실제 작동 화면
![챗봇 실제 작동 화면]()


## 9.  관리자로그인 
- 멘토 승인 기능, 멘토권한 박탈 기능, 사용자데이터분석 차트 (분야별, 온오프라인)
<br/>
<br/>

# 트러블 슈팅💥
각자 트러블 슈팅 올리고 싶은거 최대한 정리해서 오기 => 일단 팀적으로전체다 트러블 슈팅을 적고 나중에 포크를 해서 각자 트러블만 남겨두는 걸로!
