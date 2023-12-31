# 📋 구현할 기능 목록
## 1️⃣ 시작 메세지를 출력한다.
-> OutputView#printStart()
### 기능
- "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."를 출력한다.

---

## 2️⃣ 12월 중 식당 예상 방문 날짜를 입력받는다.
-> InputView#readVisitDate(), VisitDate#VisitDate()
### 기능
- "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"를 출력한다.
- 방문 날짜를 입력받는다.
  - 공백이 입력된다면 공백을 제거 해야한다. 
  - 숫자만 입력받아야 한다.
- 아래의 예외 상황이 발생한다면 "[ERROR]"로 시작하는 에러 메세지를 출력 후, 그 부분부터 입력을 다시 받는다.

### ⚠️ 예외 상황
- 💻 입력
  - 입력값이 존재하지 않는 경우
    - "[ERROR] 입력하지 않았습니다. 다시 입력해 주세요." 에러 메세지를 출력한다.

- Convertor#toDate()
  - 숫자가 아닌 값이 입력된 경우
    - "[ERROR] 날짜는 숫자로 입력해야 합니다. 다시 입력해 주세요." 에러 메세지를 출력한다.

- 📆 방문 날짜
  - 1 이상 31 이하의 숫자가 아닌 경우
    - "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." 에러 메세지를 출력한다.

---

## 3️⃣ 주문할 메뉴와 개수를 입력 받는다.
-> InputView#readMenu(), OrderMenus#OrderMenus()
### 기능
- "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"를 출력한다.

- 메뉴와 개수를 입력받는다.
  - 쉼표를(,)를 기준으로 메뉴와 개수의 리스트를 구분한다.
  - 하이폰(-)을 기준으로 메뉴와 개수를 구분한다.
  - 메뉴는 문자열, 개수는 숫자만 입력받아야 한다.

### ⚠️ 예외 상황
- 💻 입력
  - 입력값이 존재하지 않는 경우
    - "[ERROR] 입력하지 않았습니다. 다시 입력해 주세요." 에러 메세지를 출력한다.

- Convertor#toMenus()
  - 메뉴의 형식이 다른 경우
    - 개수에 숫자가 아닌 값이 입력된 경우
    - 메뉴-개수 쌍으로 이뤄지지 않은 경우
    - "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 에러 메세지를 출력한다.
  - 중복 메뉴를 입력한 경우
    - "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 에러 메세지를 출력한다.

- 🍗 주문한 메뉴
  - 총 메뉴의 개수가 1 이상 20 이하의 숫자가 아닌 경우
    - "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 에러 메세지를 출력한다.
  - 메뉴의 개수가 1 이상 20 이하의 숫자가 아닌 경우
    - "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 에러 메세지를 출력한다.
  - 메뉴판에 없는 메뉴를 입력한 경우
    - "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 에러 메세지를 출력한다.
  - 음료만 주문한 경우
    - "[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요." 에러 메세지를 출력한다.
  
---

## 혜택, 가격 등의 모든 로직 수행

---

## 4️⃣ 식당 방문일 이벤트 혜택 안내 메세지를 출력한다.
-> OutputView#printGuide()
### 기능
- "12월 {방문 날짜}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"를 출력한다.

---

## 5️⃣ 주문 메뉴를 출력한다.
-> OutputView#printMenu()
### 기능
- "<주문 메뉴>"를 출력한다.

- 주문 메뉴를 출력한다.
  - "{메뉴 이름} {개수}개"의 형식으로 모든 주문 메뉴를 출력한다.
  - 이때 출력 순서는 상관없다.

---

## 6️⃣ 할인 전 총주문 금액을 계산 및 출력한다.
-> ChristmasService#setTotalPriceBeforeDiscount(), OutputView#printTotalPriceBeforeDiscount()
### 기능
- "<할인 전 총주문 금액>"를 출력한다.
- 할인 전 총 주문 금액을 계산한다.
  - 총 주문 금액 += (메뉴의 금액 * 메뉴의 개수) 반복
- 할인 전 총 주문 금액을 출력한다.
  - "{총 주문 금액}원"을 출력한다.
  - 금액은 천단위로 쉼표(,)를 넣어야 한다.

---

## 7️⃣ 증정 메뉴를 출력한다.
-> OutputView#printGiveAwayMenu(), GiveAway#GiveAway()
### 기능
- "<증정 메뉴>"를 출력한다.

- 증정 이벤트 로직을 수행한다.
  - 증정 이벤트
    - 할인 전 총 주문 금액이 12만원 이상일 때, 샴페인 1개를 증정한다.

- 증정 메뉴를 출력한다.
  - 증정 이벤트에 해당하는 경우, "샴페인 1개"를 출력한다.
  - 증정 이벤트에 해당하지 않는 경우, "없음"을 출력한다.

---

## 8️⃣ 혜택 내역을 출력한다.
-> OutputView#printDiscountHistory(), ChristmasService#setDiscountEvent()
### 기능
- "<혜택 내역>"을 출력한다.

- 할인 로직(크리스마스 디데이 할인, 평일 할인, 주말 할인, 특별 할인)을 수행한다.
  - 총 주문 금액이 10,000원 이상인 경우에만 할인이 적용된다. 
  - 크리스마스 디데이 할인
    - 이벤트 기간: 1일 ~ 25일
    - 1,000원으로 시작하여 크리스마스가 다가올수록 할인 금액이 100원씩 증가한다.
    - 총 주문 금액에서 해당 금액만큼 할인한다.

  - 평일 할인
    - 이벤트 기간: 매 주 일요일 ~ 목요일
    - 디저트 메뉴를 메뉴 1개당 2,023원 할인

  - 주말 할인
    - 이벤트 기간: 매 주 금요일 ~ 토요일
    - 메인 메뉴를 메뉴 1개당 2,023원 할인

  - 특별 할인
    - 이벤트 기간: 매 주 일요일, 25일(크리스마스 당일)
    - 총주문 금액에서 1,000원 

- 혜택 내역을 출력한다.
  - 적용된 혜택(할인, 이벤트)이 존재하는 경우
    - "{혜택 이름}: {차감된 금액}원"의 형식으로 고객에게 적용된 이벤트 내역만 출력한다.
    - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력의 순서는 상관없다.
      - 차감된 금액에 - 부호를 붙여야 한다.
      - 금액은 천단위로 쉼표(,)를 넣어야 한다.]
      
  - 적용된 이벤트가 하나도 없는 경우, "없음"을 출력한다.

---

## 9️⃣ 총혜택 금액을 출력한다.
-> DiscountEvent#getTotalDiscountPrice(), OutputView#printTotalDiscountPrice()
### 기능
- "<총혜택 금액>"을 출력한다.

- 총혜택 금액 계산 로직을 수행한다.
  - 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격

- "{총혜택 금액}원"을 출력한다.
  - 총혜택 금액에 - 부호를 붙여야 한다.
  - 금액은 천단위로 쉼표(,)를 넣어야 한다.

---

## 1️⃣0️⃣ 할인 후 예상 결제 금액을 출력한다.
-> discountEvent#getDiscountPrice(), OutputView#printExpectedPaymentPrice()
### 기능
- "<할인 후 예상 결제 금액>"을 출력한다.

- 할인 후 예상 결제 금액 계산 로직을 수행한다.
  - 할인 후 예상 결제 금액 =  할인 전 총주문 금액 - 할인 금액

- {할인 후 예상 결제 금액}원"을 출력한다.
  - 금액은 천단위로 쉼표(,)를 넣어야 한다.

---

## 1️⃣1️⃣ 이벤트 배지를 출력한다.
-> EventBadge#EventBadge(), OutputView#printEventBadge()
### 기능
- "<12월 이벤트 배지>"를 출력한다.

- 이벤트 배지 부여 로직을 수행한다.
  - 총혜택 금액에 따라 이벤트 배지를 부여한다.
  - 5천 원 이상: 별
  - 1만 원 이상: 트리
  - 2만 원 이상: 산타

- 이벤트 배지가 부여된 경우, "{이벤트 배지}"를 출력한다.
- 이벤트 배지가 부여되지 않는 경우, "없음"을 출력한다.

---

## ❗️ 주요 요구 사항
### 🍗 메뉴판
```
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```

<br>

### 📆 달력
![](../image.png)

<br>

### ⚠️ 예외 발생시
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시킨다.
  - `Exception`이 아닌 `IllegalArgumentException`등과 같은 명확한 유형을 처리한다.
- "[ERROR]"로 시작하는 에러 메세지를 출력 후, 그 부분부터 입력을 다시 받는다.

<br>

### 🗂️ 사용하는 라이브러리
- 사용자가 입력하는 값은 아래 라이브러리의 함수를 활용한다.
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()`

---