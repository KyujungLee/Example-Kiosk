# Example-Kiosk

## Kiosk Lv.1
- Main 매서드 : 입력받은 String input 을 검증하여 선택된 메뉴 출력.
- Verify 클래스 : 입력값 예외 검증 기능.
- MenuItem 클래스 :  저장된 menuItem 배열 필드를 기준으로, menuItem 요소 전체출력 기능, 입력값에 해당하는 메뉴 선택출력 기능.

###### 예외사항
- 입력값이 0이면 프로그램 종료.
- 입력값이 Int로 변환할 수 없다면 프로그램 재시작.
- 입력값이 menuItem 배열의 인덱스를 초과하면 프로그램 재시작.