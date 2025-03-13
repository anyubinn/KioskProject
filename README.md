## 키오스크 과제
### 🚀 프로젝트 소개
이 프로젝트는 단계별로 기능을 확장하여 콘솔 기반의 키오스크를 구현하는 과정입니다. 장바구니 기능과 결제 기능을 추가해 실제 키오스크와 비슷하게 구현했습니다.

### 🚀 기술 스택
- Java
- 객체지향 프로그래밍
- 예외 처리
- 컬랙션 프레임워크
- Enum, 제네릭
- 람다, 스트림

### 🚀 프로젝트 구조

```
.
├── README.md
├── kiosk.iml
├── out
│   └── production
│       └── kiosk
│           ├── Kiosk.class
│           ├── Main.class
│           ├── README.md
│           ├── cart
│           │   ├── Cart.class
│           │   └── Discount.class
│           ├── io
│           │   ├── KioskInput.class
│           │   └── KioskOutput.class
│           └── menu
│               ├── Menu.class
│               └── MenuItem.class
└── src
    ├── Kiosk.java
    ├── Main.java
    ├── README.md
    ├── cart
    │   ├── Cart.java
    │   └── Discount.java
    ├── io
    │   ├── KioskInput.java
    │   └── KioskOutput.java
    └── menu
        ├── Menu.java
        └── MenuItem.java


```