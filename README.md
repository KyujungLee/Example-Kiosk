# Example-Kiosk

## Kiosk Lv.1
- main 매서드 : 입력받은 String input 을 검증하여 선택된 메뉴 출력.
- Verify 클래스 : 입력값 예외 검증 기능.
- MenuItem 클래스 : 저장된 menuItem 배열 필드를 기준으로, menuItem 요소 전체출력 기능, 입력값에 해당하는 메뉴 선택출력 기능.

###### 예외사항
- 입력값이 0이면 프로그램 종료.
- 입력값이 Int로 변환할 수 없다면 프로그램 재시작.
- 입력값이 menuItem 배열의 인덱스를 초과하면 프로그램 재시작.


## Kiosk Lv.2
- main 매서드 : 전체 흐름을 제어하는 클래스의 인스턴스 생성 및 동작 매서드 입력
- Kiosk 클래스 : Kiosk Lv.2 의 전체 흐름을 제어 // MenuItem 클래스의 menuItems 리스트 필드에 들어갈 메뉴 초기화. 
- Verify 클래스 : 입력값 예외 검증 기능.
- MenuItem 클래스 : 저장된 menuItems 리스트 필드를 기준으로, menuItems 요소 전체출력 기능, 입력값에 해당하는 메뉴 선택출력 기능. // private 생성자를 통해, MenuItem 클래스의 인스턴스를 오직 하나만 생성하고, 그 인스턴스를 모두가 공유하는 기능 생성 (static 인스턴스 생성을 통한 menuItems 리스트 필드 초기화 방지)

## Kiosk Lv.3
- Lv.2와 동일하나, MenuItem 인스턴스의 static 인스턴스화 대신, Kiosk 클래스에서 menuItem 필드가 필요한 매서드에 직접 인스턴스를 매개변수로서 전달.( ex. Verify.isInsideMenuIndex(String input, MenuItem menuItem) )
