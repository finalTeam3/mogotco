# MOGOTCO
<img  src="https://user-images.githubusercontent.com/83347312/207089142-e9d840c9-f774-49a1-9e94-0096fd6eea14.png" width="60%" height="100%">

## 팀이름 : MOGOTCO  

## 팀원
- 팀장 : 조윤영
- 팀원 : 박성훈, 박혜정, 신동준  

## 시연영상
[MOGOTCO 시연 영상](https://www.youtube.com/watch?v=Y84_nNsFm80)

## 협업방식
![협업도구](https://user-images.githubusercontent.com/111735748/207840687-b748fed9-a3ca-4b2a-8fd4-08b06e36290a.png)

# 프로젝트 정보
## 1. 프로젝트 주제
개발 멘토링 사이트를 구축하여 영상채팅을 통해 개발자에게 도움을 받을 수 있는 공간을 만든다.

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
|조윤영|멘토링 결제기능(API,coupon,point사용), 멘토링&멘토 검색기능(메인페이지, 멘토링페이지, 멘토리스트페이지에서 카페고리별, type별, 회사별 검색), 페이징처리&scrolling|
|박성훈|CLOVA OCR(명함 인식 서비스),CLOVA CHATBOT(문의하기), 멘토 위시리스트, admin (전체적 페이지, 멘토 승인)|
|박혜정|회원가입, 일반로그인&소셜로그인(kakao,github)기능, 이메일 사용 기능(회원가입시 인증번호, 멘토링 알림메일, 멘토 승인 메일), 리뷰&평점 기능, Q&A및 자주하는 질문, admin (Q&A)|
|신동준|화상회의기능(API), 멘토링 장소 지도로 보여줌(API), 멘토링 시간 선택기능(남은 인원에 따른), 멘토링 등록 기능(날짜, 시간 선택 가능)|

## 5. 프로젝트 개발 환경 및 수행 도구

|**협업도구**|**database&framework&개발도구**|**backend**|**frontend**|**API**|
|---|---|---|---|---|
|구글닥스|MYSQL(8.0.17)|java(11.0.15.1)|js|CLOVA OCR|
|네이버카페|Spring Boot(2.7.4)|apache-tomcat(8.5.27)|Html5|CLOVA ChatBot|
|ZOOM|MyBatis(2.2.2)|NCP(Naver Cloud Platform)|CSS|Import|
|Git|Eclipse(4.18.0)||jQuery(3.2.1)|kakao I Connect API|
|GitHub|JUnit(5.8.2)||AJAX|kakao map|
|Gather Town|Spring Boot Mail Sender(2.7.5)||thymeleaf(3.0.15)|github login API|
|Erd Cloud|||BootStrap(4)|kakao login API
|Notion||||kakao 공유하기|
|Figma|

## 6. 시스템 구성도
<img width="3168" alt="모같코(MOGOTCO) (7)" src="https://user-images.githubusercontent.com/83347312/207788876-74d05230-a318-488b-b6b9-3a6e92bc2678.png" width="100%" height="80%">

## 7. WBS
![WBS](https://user-images.githubusercontent.com/111735748/207998698-202243b4-7c9a-4430-93c4-21591ac3f9c1.png)

## 8. 데이터베이스 설계
![mogotco (4)](https://user-images.githubusercontent.com/83347312/206660375-1d1bb75e-1428-46f4-99ef-5ae8baf753ad.png)
## 9. 유저 플로우
<img src="https://user-images.githubusercontent.com/111735748/207868540-57a4fb38-cd1d-4f09-a254-4c0ae22ebfba.png" width="100%" height="100%">
<br/>
<br/>

# 프로젝트 내용

## 1. 로그인 및 회원가입 기능 
### 1.1 회원가입
> 메인기능소개
- 아이디 중복 확인
    - [JavaScript] register.html [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/user/register.html#L37)
    - AjaxController.java [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/AjaxController.java#L104)

![아이디 중복 확인](https://user-images.githubusercontent.com/111735748/218775070-78503f77-da69-4878-98b6-df629045ce3e.png)
- 비밀번호 일치 여부 확인
    - [JavaScript] register.html [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/user/register.html#L26)

![비밀번호 일치 여부 확인](https://user-images.githubusercontent.com/111735748/218775443-6fc26799-b12d-46f0-908f-11c9ade0c23f.png)
- 메일 인증 기능 (주요 기능)

![이메일 정규식, 인증번호](https://user-images.githubusercontent.com/111735748/218778595-1f4618ce-15e5-4aab-b6d6-f886b685ea78.png)
![인증번호 일치 여부 확인](https://user-images.githubusercontent.com/111735748/218789829-1f6a8e1c-83fc-4fe0-ae22-5a571ab3660f.png)
  - [JavaScript] register.html (정규식 검사) [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/user/register.html#L53)
  - [JavaScript] register.html (인증번호 발송) [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/user/register.html#L70)
  - [JavaScript] register.html (인증번호 일치 여부 확인) [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/user/register.html#L104)
  - UserController.java [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/UserController.java#L162)
  
> 주요 기능 실제 작동 화면
- 메일 인증 기능
![이메일인증](https://user-images.githubusercontent.com/111735748/207772832-fb18b1a5-af24-4a57-97bf-89912e3797ff.gif)

### 1.2 소셜로그인
> 메인기능소개

![소셜로그인](https://user-images.githubusercontent.com/111735748/218779139-2b6a532b-3832-44de-a485-c4c82efb8fb2.png)
- [소셜 로그인 API] login.html [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/user/login.html#L103)
- KakaologinAPI.java [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/service/KakaologinAPI.java#L19)
- SNSLoginController.java [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/SNSLoginController.java#L34)
> 실제 작동 화면
<img src="https://user-images.githubusercontent.com/111735748/207778285-825d5081-c64d-45d1-97b1-7f07f90bba96.gif" width="80%">

### 1.3 마이페이지
> 메인기능소개
- [JavaScript] 회원 정보 수정 [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/user/mypage.html#L143)
> 실제 작동 화면
![마이페이지](https://user-images.githubusercontent.com/111735748/207809305-a8a313dc-3d16-4a1a-854b-350f0cb2480c.gif)

### 1.4 비회원시 접근 가능 페이지
> 메인기능소개
- [Controller] 비회원 판단 후 접근가능한 경로 따로 설정 [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/MentorController.java#L72)
> 실제 작동 화면
![비회원](https://user-images.githubusercontent.com/111735748/207810951-837d9423-cdee-4596-bfca-65dbaa08f097.gif)

## 2. 멘토링 검색
### 2.1 검색 기능(카테고리별, 필터별, 텍스트별)
> 메인 기능 소개
- [Controller] 카테고리, 필터, 텍스트의 유무를 check하는 class를 만들어 유저가 원하는 검색에 가까워지도록 만들어줌. 각각의 default controller를 만들어준 다음 멘토링 페이지 안에서 각각의 조건에 맞게 순환됨.[📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/MentoringController.java#L71)
- [SQL]멘토링의 검색과 관련된 query문을 정적으로 뽑음.(동적이 아닌 정적으로 뽑은 이유는 전체 검색도 하나의 controller로 동작하게 만들어주고 싶었기 때문.)[📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/mybatis/mentoringmapper.xml#L17)
> 실제 작동 화면

### 2.2 페이징 처리
> 메인 기능 소개
- [SQL]LIMIT를 사용하여 한 페이지당 6개의 멘토링이 검색되도록 설정. [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/mybatis/mentoringmapper.xml#L17)
- [Controller] 검색에서 사용하였던 controller함수를 이용하여 뿌려줌. [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/MentoringController.java#L3467)
> 실제 작동 화면

## 3. 멘토링 상세
### 3.1 멘토링 공유 기능
>멘토링 정보를 주변인들과 공유
- 해당 멘토링의 제목 옆에 있는 카카오톡 이모티콘을 클릭하여 카카오톡으로 공유하기 기능으로 자신이 원하는 사람에게 멘토링 추천을 위한 멘토링 정보를 공유할 수 있습니다.<br>

### 3.2 오프라인일 경우 지도+마커 뿌려주기<br>
>대면 멘토링을 진행을 위한 주소 확인
- 대면 멘토링 일 시 대면 장소를 클릭하면 kakap map API를 활용하여 주소와 마커를 보여줍니다.
멘토링 등록시에 데이터베이스에 저장되는 주소를 kakao map API 제공 해주는 자바스크립트 코드의 지도의 주소가 출력되는 부분에  Controller에서 전달 된 데이터를 Thymeleaf를 사용하여 추가 해주어 해당 대면 멘토링의 주소가 화면에 보여지도록 합니다.<br><br>
[📌대면 멘토링 장소 코드 바로가기](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/mentoring/mentoringdetail.html#L331)<br>
[📌해당 Controller 코드 바로가기](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/MentoringController.java#L670)<br><br>
<img src="https://user-images.githubusercontent.com/80161307/207608178-e8814250-3b57-4ab2-9f74-d2981b80b9f6.gif" width="500" height="450"></img>

### 3.3 시간 선택하기<br>
> 남은 인원을 확인하며 시간 선택
- Controller를 통해 받아온 해당 멘토링에 대한 시간데이터들을 Thymeleaf를 사용하여 시간별로 남은 인원을 화면에서 확인할 수 있게 하였습니다. 또, Thymeleaf 조건문을 활용하여 시간별  구매 가능한 멘토링 인원이 남아 있다면 원하는 시간을 선택할 수 있고, 없다면 해당 시간 버튼이 사라지게 하였습니다.<br><br>
  [📌인원, 시간 선택버튼 코드 바로가기](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/mentoring/mentoringdetail.html#L242)<br>
  [📌해당 Controller 코드 바로가기](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/MentoringController.java#L670)<br><br>
<img src="https://user-images.githubusercontent.com/80161307/207608196-0871bfa4-8034-4f6c-a9e4-5e7ad581ddda.gif" width="500" height="400"></img>


## 4. 멘토  
> 명함 및 사원증 회사 인증 후 등록(ocr) 및 수정 등록 
 

### 4.1 OCR 연동 프로세스
<img width="2085" alt="ocr4" src="https://user-images.githubusercontent.com/86956783/207764586-81d4a5e6-8800-4429-9e83-820202679ac9.png">
- ajax 비동기 요청 

  - 화면단에서 사용자가 명함 이미지를 업로드하면 파일이 formdata에 담겨지고 명함 등록하는 post 요청을 AjaxController에 비동기로 전송.

<br>

- 파일 저장 및 ocr 시스템 실행 [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/AjaxController.java#L121)
  
  - AjaxController에서는 화면단에서 넘어온 파일을 Util클래스의 메서드를 통해 사용자 페이지와 관리자 페이지에 동시에 저장. 그 후 시스템에 저장된 명함이미지를 OcrService의 ocrresult 메서드의 파라미터로 넘겨주면 json 객체가 ajax의 url을 통해 화면단으로 반환.

<br>

- OCR 실행 결과 추출 [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/mentor/mentorregister.html#L132)

  - AjaxController에서 화면단으로 json 객체를 보내어 js의 display함수를 통해 파싱을 한 뒤 각각의 input창에 id값을 할당하여 데이터를 입력.

<br>

### 4.2. 실제 작동 화면
<img  src="https://user-images.githubusercontent.com/86956783/207822347-4015fd7a-0170-45ed-af24-71f20c0fc1fd.gif" width="80%">

<br>

## 5. 구매 
### 5.1 포인트 사용
> 메인 기능 소개
- [JAVASCRIPT] session의 user정보를 통해 user의 point를 불러온 후 javascript를 통해 input창에 user이 쓰고 싶은 point에 따라 총 가격에 바로 반영되도록 함. [📌코드확인 ](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchase.html#L120)
> 실제 작동 화면

### 5.2 쿠폰 사용
> 메인 기능 소개
- [AJAX] session의 user의 보유 coupon여부를 ajax를 통해서 '쿠폰 사용하기'를 클릭했을 때 가져오도록 함. [📌코드확인 ](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchase.html#L193)
> 실제 작동 화면

### 5.3 결제 기능
> 메인 기능 소개
- [Controller] 비회원으로 멘토링 상세 페이지까지 볼 수 있고 구매는 로그인 이후에 가능하도록 설정. 따라서 user의 session정보 유무를 판단해줌. [📌코드확인 ](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/PurchaseController.java#L66)
- [iamport API] 실제 구매와 같은 환경을 구현해보기 위해 kg이니시스에서 제공해준 구매 api를 사용함. javascript를 이용해서 함수를 구현. [📌코드확인 ](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchase.html#L466)
> 실제 작동 화면

- [Controller] 구매 성공 후 sql에 필요한 정보들을 넣고 point및, 쿠폰, 멘토링의 멤버수의 변화를 controller를 통해서 구현. [📌코드확인 ](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchase.html#L466)
> 실제 작동 화면

## 6. 멘토링 진행 
### 6.1 멘토링 진행 전 메일 알림<br>
>멘토링 진행 관리
- 멘토링을 진행하기 전에 멘티가 구매한 멘토링의 날짜, 시간 정보에 맞추어 전날 아침 8시와 당일로 넘어가는 자정에 알림 메일을 보내주어 멘티가 멘토링 참여에 늦지 않도록 관리해줍니다.<br><br>
<img src="https://user-images.githubusercontent.com/80161307/207865692-a0bb8193-f4cc-4929-bc3a-1b4182ec632e.gif" width="500" height="450"><br>
[전날 아침8시에 알림 메일이 도착한 모습]<br><br>
<img src="https://user-images.githubusercontent.com/80161307/207865610-184274f8-5274-49c6-b8a6-f62bc595aac5.gif" width="500" height="450"><br>
[당일로 넘어가는 자정에 알림 메일이 도착한 모습]<br><br>

### 6.2 Kakao i connect API를 사용한 화상회의 멘토링 진행<br>
> 화상회의 멘토링 진행 
- 카카오에서 제공해주는 API의 소스 코드에 룸id가 생성되는 코드에 해당 멘토링의 멘토링 옵션에 들어가있는 각각의 시간의 고유한 멘토링옵션 아이디값을 컨트롤러에서 데이터를 받아와 타임리프를 활용하여 대입해주면 해당 시간의 고유의 룸이 생성되어 해당 멘토링의 시간을 구매한 멘티만이 멘토링에 참여할 수 있도록 진행됩니다.<br><br>[📌MOGOTCO 멘토링 서비스 페이지 코드 바로가기](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/mentoring/mentoringstart.html#L206)<br> [📌해당 Controller  코드 바로가기](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/MentoringController.java#L706)<br><br>
- 멘토링 시작 버튼을 클릭하여 상대방과 서로 화상채팅을 할 수 있고 멘토링 종료 버튼을 클릭하여 화상채팅을 종료할 수 있습니다.<br><br>
<img src="https://user-images.githubusercontent.com/80161307/207506925-4f7e3e58-5a49-43d8-ba4f-1d29f5eb2591.gif" width="500" height="450"></img><br><br>

>화상회의 멘토링 추가 기능 
- 화면공유하기 버튼을 클릭하면 자신이 원하는 화면을 선택하여 공유할 수 있고, 공유된 화면이 자신과 상대방에게 보여집니다. 그리고 상대방이 공유한 화면도 볼 수 있습니다. 화면공유 중지버튼을 클릭하면 화면 공유가 종료됩니다.<br><br>
<img src="https://user-images.githubusercontent.com/80161307/207507068-830f3a61-c913-4680-a1c7-f91b5da03c21.gif" width="500" height="450"></img>
<br>[멘티들이 화면을 공유한 모습]

## 7. 후기 및 평점
### 7.1 멘토링 후기 및 평점 남기기
> 메인기능소개
- [AJAX, CSS] 리뷰 작성 후 데이터 넘기기 [📌코드 확인](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchasedetail.html#L287)
> 실제 작동 화면
![리뷰](https://user-images.githubusercontent.com/111735748/207826741-e06826bf-a948-4f3d-ba5b-c959e2d11140.gif)

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
<img  src="https://user-images.githubusercontent.com/86956783/207822016-45fce848-5a00-4410-b81e-d94ee1776b1f.gif" width="50%">


## 9. 관리자페이지
### 9.1 멘토 승인시 알림 기능
> 메인기능소개
- [JavaMailSender] 멘토 승인시 알림 메일 발송 [📌코드 확인](https://github.com/finalTeam3/mogotcoadmin/blob/master/src/main/java/com/mogotcoadmin/controller/MentorController.java#L103)
> 실제 작동 화면
![관리자](https://user-images.githubusercontent.com/111735748/207832595-864baa7a-0a1a-4633-af9c-7d356cbd2db1.gif)

<br/>
<br/>

# 트러블 슈팅💥
1. 메일 알람 기능
- 문제 : Only no-arg methods may be annotated with @Scheduled 에러 발생
- 해결 : Scheduler가 parameter를 전달하지 않고 동작하기 때문에 발생한 에러, parameter를 전달하지 않고 단순히 함수만 정해진 시간에 실행하게 바꿈

2. 마이페이지 탈퇴 기능
- 문제 : 탈퇴버튼 클릭시 modal을 사용했는데 confirm이 아니라 true 값을 전달하려면 confirm, cancel 기능을 코딩해야 함
- 해결 : 코딩을 전부 해야하나 했는데 버튼에 id를 부여해 해당 버튼을 눌렀을 때 기능이 작동하게 함

3. point & coupon 기능
- 문제 : 사용하려는 point의 값과 coupon의 값들을 받아서 total price를 같이 계산하는 곳에 다양한 문제들이 있었음. 
- 해결 : point나 coupon에 사용에 따른 가격 변화를 hidden으로 저장해둔 다음에 값이 변화할때마다 hidden의 값을 가져와서 값의 변화를 해결함 [해결 코드](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchase.html#L118) 

4. 검색 기능(검색기능에 대한 더 자세한 트러블 슈팅은 [yyboom](https://github.com/yyboom/mogotco) 참고
- 문제 : 카테고리를 선택하고 검색어를 입력하고 type과 페이징 처리까지 같이 하니 어는 순간 특정한 이벤트에 따른 페이지의 순환이 잘 되지 않았음. 검색, 클릭에 따른 원하는 멘토링 아이템이 제대로 나오지 않음.
- 해결 : pagaingcheck controller를 이용하여 현재 사용자가 어떤 카테고리를 클릭했는지, 텍스트를 입력했는지, 어떤 type을 골랐는지에 따라서 판단하여 각각 해당 controller에 보내주는 방식으로 해결하였음. [해결 코드](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/mentoring/mentoring.html#L130)

<details>
<summary>조윤영</summary>
<div markdown="1">
1. 구매 기능
<ul>
<li>문제 : 결제는 되는 상황이지만 결제후의 정보들이 데이터베이스로 저장되지 않음.</li>
<li>해결 : callback함수 부분에 결제 후 받아온 객체 정보와 구매 페이지에 있는 정보들을 끌고와서 location.href로 controller주소로 보내주었음.</li>
[해결 코드 ](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchase.html#L464)
</ul>
2. point 기능
<ul>
<li>문제 : 분명히 html화면에서는 포인트가 잘 나오고 값이 빠진것도 보이는데 막상 결제로 넘어가면 포인트가 적용되지 않은 원래 멘토링 가격으로 값이 빠지는 것이었다. 즉 포인트 적용이 안된것이었음.</li>
<li>해결 : 아래 코드와 같이 html text로 나오는 부분 따로, input값을 넣어주는 부분 따로 해서(hidden으로 뿌려줌) val()값으로 뿌려주었다. [해결 코드 ](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchase.html#L118)</li>
  <ul><li>문제발생 : point를 쓸때는 결제가 되는데 point를 안쓸때는 결제가 실패했다고 뜬다.</li>
  <li>해결 : 아래와 같이 input tag의 기본 default value값을 앞단에서 넘겨준 멘토링 값으로 남겨주었다. 어제 포인트의 오류를 input hidden으로 해결했더니 default를 앞단에서 받아온걸로 설정이 가능하였다.[해결 코드](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchase.html#L422)</li></ul>
</ul>
3. 쿠폰 기능
<ul>
<li>문제 : purchase를 할 때 user의 coupon정보를 바로 불러올 수가 없음. 따라서 이를 purchase화면에서 coupon button을 눌렀을 때 ajax로 데이터를 가져오는 것으로 방법을 정하였다. 이때 ajax통신이 제대로 되지 않았었음.</li>
<li>해결 : ajax controller에 보내줄 data 값을 url을 이용해서 붙여주지 않고 아래와 같이 data를 따로 넣어서 보내주었다.</li>
  <ul><li>문제발생 : ajax controller을 이용해서 data를 Object의 형태로 받아오고 이 data들에서 우리가 쓸 column값들을 뽑아주는 작업이 제대로 되지 않았었음.</li>
  <li>해결 : 코드의 주석으로 대체하겠다.[해결 코드](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/purchase/purchase.html#L192)</li></ul>
</ul>
4. 검색 기능(검색기능에 대한 더 자세한 트러블 슈팅은 [yyboom](https://github.com/yyboom/mogotco) 참고)
<ul>
<li>문제 : 처음에 멘토링 상품이 있는 페이지를 볼 때 처음부터 특정 카테고리의 상품들이 보여지는 현상이 발생함.</li>
<li>해결 : 전체 상품을 꺼내오는 query문을 작성해준 후 멘토링 리스트가 있는 페이지를 처음 들어갈때는 전체 상품이 배열되게끔 바꿔주었다. 이때 전체와 카테고리를 구분하는 변수로 [해결 코드](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/mentoring/mentoring.html#L130)</li>
  <ul><li>문제발생 : 카테고리를 선택하고 검색어를 입력하고 type과 페이징 처리까지 같이 하니 어는 순간 특정한 이벤트에 따른 페이지의 순환이 잘 되지 않았음. 검색, 클릭에 따른 원하는 멘토링 아이템이 제대로 나오지 않음.</li>
  <li>해결 : pagaingcheck controller를 이용하여 현재 사용자가 어떤 카테고리를 클릭했는지, 텍스트를 입력했는지, 어떤 type을 골랐는지에 따라서 판단하여 각각 해당 controller에 보내주는 방식으로 해결하였음. [해결 코드](https://github.com/finalTeam3/mogotco/blob/master/src/main/resources/templates/mentoring/mentoring.html#L130)</li></ul>
</ul>

</div>
</details>
<details>
<summary>박혜정</summary>
<div markdown="1">
1. 메일 알람 기능
<ul>
<li>문제 : 멘토링 날짜가 다가왔을 때 알려줄 수 있는 기능을 넣고 싶음</li>
<li>해결 : 배웠던 Scheduler를 사용해 매일 정해진 시간에 멘토링 날짜가 다가온 사람들에게 메일을 보내줄 수 있다면 좋을 것 같다고 생각함</li>
  <ul><li>문제발생 : Only no-arg methods may be annotated with @Scheduled 에러 발생</li>
  <li>해결 : Scheduler가 parameter를 전달하지 않고 동작하기 때문에 발생한 에러, parameter를 전달하지 않고 단순히 함수만 정해진 시간에 실행하게 바꿈</li></ul>
</ul>
2. 마이페이지 탈퇴 기능
<ul>
<li>문제 : 탈퇴 버튼을 누르면 modal이 떠야 하는데 안 뜸</li>
<li>해결 : 기존에 정보수정 버튼을 누르면 modal이 뜨게 만들어둔 상태였기 때문에 기존 modal 때문이라고 생각했는데 출력값을 찍다보니 modal이 뜨기 전 기능이 실행되어 창이 이동되어 modal을 만날 수 없었던 것이라 함수를 추가해 기능 실행 전에 뜨게 함</li>
    <ul><li>문제 발생 : confirm이 아니라 true 값을 전달하려면 confirm, cancel 기능을 코딩해야 함</li>
    <li>해결 : 코딩을 전부 해야하나 했는데 버튼에 id를 부여해 해당 버튼을 눌렀을 때 기능이 작동하게 함</li></ul>
</ul>
<div>
</details>


<details>
<summary>박성훈</summary>
<div markdown="1">


### OCR연동을 위해 Ajax로 이미지를 업로드하는 과정에서 FormData 관련 문제
- 해당 프로젝트에서는 멘토의 신뢰성을 검증하기 위한 방법 중 하나로 OCR 기술을 통해 명함 내의 직급, 회사명 데이터를 인식하여 추출하는 방식을 사용.
- 이를 위해 화면단에서 명함 이미지만 Formdata객체에 담아서 AjaxController로 보내는 과정에서 ajax 내의 success함수가 실행되지 않는 문제가 발생
  
<details>
<summary>기존 코드</summary>
<div markdown="1">

```javascript
	$.ajax({
		type : "POST",
		url : "/ocrresult",
		processData : false,
		contentType : false,
	 	data: formData,
		success : function(data) {
			display(data);
		}
	});
```

</div>
</details>

> 타임리프 경로 처리와 FormData 사용법 미숙으로 인한 문제였으며 button의 onclick 속성을 th 걸었기때문에 ajax에서 전송시 작성하는 url에도 그에 맞는 형식으로 작성하고 button의 type 속성을 정의해주고 ajax로 다시 받을 dataType을 정의하여 해결. [참고자료](https://myeongdev.tistory.com/48)

<details>
<summary>개선 코드</summary>
<div markdown="1">

```javascript
$.ajax({
		type : "POST",
		url : "[[@{/ocrresult}]]",
		processData : false,
		contentType : false,
	 	data: formData,
	 	dataType : "JSON",
	 	success: function(obj) {
			display(obj);	
	 	}
	});
```

</div>
</details>
<br>


### 데이터 insert 작업 중 발생한 쿼리 오류
- 개발을 거의 마무리 한 후 데이터를 추가로 insert하기 위한 작업 중 문제가 발생.
- 해당 프로젝트에는 멘토가 승인된 멘토와 승인되지 않은 멘토로 분류가 되는데 사용자 페이지에서 멘토 신청단계를 완료하면 우선 승인되지 않은 멘토로 분류가 됨.
- 이 때 승인 되지 않은 멘토는 관리자에 의해 승인처리가 되기 때문에 신청단계에서는 관리자 데이터가 insert되지 않도록 input창을 만들고 value값을 넣지 않음.
- 당연히 null값이 들어갔을거라고 생각했고 db에도 데이터가 안 들어간게 보여서 그대로 넘어갔지만 mentor 테이블에 미승인 멘토 데이터를 insert하는 과정에서 관리자 데이터 null값을 넣어서 Null not allowed 에러가 발생.
> 관리자 칼럼은 NOT NULL로 정의되어 있었고, inset문에 null대신 ''(빈 문자열 또는 공백)을 넣어 해결함. 

- 기본적으로 ''을 입력하면 null 처리하는 ORACLE과 달리 My SQL은 null은 null대로 ''은 공백대로 처리되기 때문에 DB마다 NULL 처리에 있어서 약간의 차이가 있으므로 확인해야 함.

</div>
</details>

<details>
<summary>신동준</summary>
<div markdown="1">
<br>

> 화상회의 기능
- 문제 : 카카오 아이커넥트 지속적인 접속 실패
- 해결 : API에 대한 자바 스크립트 코드를 모두 넣어줬음에도 불구하고 계속 발급받은 아이디와 비밀번호로 접속이 불가능한 오류가 발생했다. 스크립트문을 header태그 부분에 넣어준 것이 문제였다. body 태그의 가장 끝에 넣어주니 문제가 해결 되었다. (DOM의 구조가 완료된 시점에서 실행)


> 멘토링 등록 기능
- 문제 : 멘토링 등록에서 멘토링, 멘토링옵션에 해당하는 데이터 동시 insert
- 해결 : [Controller 해결 코드](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/controller/MentoringController.java#L713) 와 같이 Controller에서 [mservice.register](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/mybatis/mentoringmapper.xml#L83) , [moservice.register](https://github.com/finalTeam3/mogotco/blob/master/src/main/java/com/mogotco/mybatis/mentoringoptionmapper.xml#L17) 를 활용하여 해결하였다.


> 멘토링 등록 버튼
- 문제 : 멘토 승인시 보이는 등록 버튼을 만들기 위한 컨트롤러 에서의 userid 전달 문제
- 해결 : 토링 페이지에서 유저의 정보를 받아오기 위한 기준인 userid를 Controller에서 받아올 수 가 없었다. 메인 페이지 session의 userid를 가지고 페이지로 이동하는 경로와 비 로그인시의 경로로 타임리프 조건을 활용하여 두가지로 나누어 해결하였다.


</div>
</details>
