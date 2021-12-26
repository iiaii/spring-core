# Spring Core (핵심 기술)

# 객체 지향 설계와 스프링

### 자바 진영의 추운 겨울과 스프링의 탄생

- Java 진영에서 EJB(Enterprise Java Beans, = J2EE)라는 표준 기술이 있었음
- 여러 기능을 제공했지만 비싸고 어렵고 복잡하고 느렸다 (한마디로 지옥)
- 너무 EJB에 의존적이고 복잡하다보니 POJO(Plain Old Java Object)가 나오기도 한다
- 고통받던 선배 개발자들이 EJB를 비판하며 Spring, Hibernate 같은 것들을 만들어냄

---

### 스프링이란?

- 필수
    - 스프링 프레임워크
    - 스프링 부트
- 선택
    - 스프링 데이터
    - 스프링 세션
    - 스프링 시큐리티
    - 스프링 Rest Docs
    - 스프링 배치
    - 스프링 클라우드...


→ 핵심은 스프링 프레임워크고 이를 쉽게 사용할수 있게 하는게 스프링 부트다

- 스프링 프레임워크
    - 핵심 기술: 스프링 DI 컨테이너, AOP, 이벤트, 기타
    - 웹 기술: 스프링 MVC, 스프링 WebFlux
    - 데이터 접근 기술: 트랜잭션, JDBC, ORM 지원, XML 지원
    - 기술 통합: 캐시, 이메일, 원격접근, 스케줄링
    - 테스트: 스프링 기반 테스트 지원
    - 언어: 코틀린, 그루비
- 스프링 부트
    - **스프링을 편리하게 사용할 수 있도록 지원, 최근에는 기본으로 사용**
    - 단독으로 실행할 수 있는 스프링 애플리케이션을 쉽게 생성
    - Tomcat 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 됨
    - 손쉬운 빌드 구성을 위한 starter 종속성 제공
    - 스프링과 3rd parth(외부) 라이브러리 자동 구성 (외부 라이브러리 버전간 문제가 없도록됨)
    - 메트릭, 상태확인, 외부 구성 같은 프로덕션 준비 기능 제공
    - 관례에 의한 간결한 설정

- 스프링
    - 스프링 DI 컨테이너 기술
    - 스프링 프레임워크
    - 스프링 부트, 스프링 프레임워크 등을 모두 포함한 스프링 생태계

- 스프링의 진짜 핵심
    - 스프링은 자바 언어 기반의 프레임워크
    - 자바 언어의 가장 큰 특징 - 객체 지향
    - 스프링은 객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크
    - 스프링은 **좋은 객체 지향** 애플리케이션을 개발할 수 있게 도와주는 프레임워크

---

### 좋은 객체 지향 프로그래밍이란?

- 객체지향 특징
    - 추상화
    - 캡슐화
    - 상속
    - **다형성 (역할**과 **구현)**

- 객체들의 **모임**, 메시지를 주고받으며 **협력**
- **유연**하고 **변경**에 용이

- 자동차 역할을 다른 자동차들이 대체
- 로미오, 줄리엣 역할을 다른 배우들이 대체

- 역할과 구현을 분리
    - 역할과 구현으로 구분하면 단순해지고, 유연해지며 변경도 편리해짐
    - 클라이언트는 역할(인터페이스)만 알면된다
    - 클라이언트는 구현 대상의 내부 구조를 몰라도 된다
    - 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다
    - 클라이언트는 구현대상을 자체를 변경해도 영향 받지 않는다

- 자바 언어의 다형성을 활용
    - 역할 = 인터페이스
    - 구현 = 인터페이스를 구현한 클래스, 구현 객체
    - 객체를 설계할 때 역할과 구현을 명확히 분리
    - 객체 설계시 역할(인터페이스)를 먼저 부여하고 역할을 수행하는 구현객체 만들기

- 혼자 있는 객체는 없다
- 수 많은 객체 클라이언트와 객체 서버는 서로 협력 관계를 가진다

- 다형성의 본질 (**다형성이 가장 중요하다!**)
    - 인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경할 수 있다
    - 다형성의 본질을 이해하려면 협력이라는 객체사이의 관계에서 시작해야함
    - **클라이언트를 변경하지 않고, 서버 구현 기능을 유연하게 변경할 수 있다**

- usb a, usb c, 변환 젠더를 비유해서 객체지향 설명

- 스프링은 다형성을 극대화해서 이용할 수 있게 도와준다
- 스프링에서 이야기하는 제어의 역전(IoC), 의존관계 주입(DI)은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원한다
- 스프링을 사용하면 마치 레고 블럭 조립하듯이! 공연 무대의 배우를 선택하듯이! 구현을 편리하게 변경할 수 있다

---

### 좋은 객체 지향 설계의 5가지 원칙 (SOLID)

**다형성과 SOLID가 중요함**

- SRP 단일 책임 원칙
    - 한 클래스는 하나의 책임만 가져야 한다
    - 하나의 책임이라는 것은 모호 (클수도, 작을수도 문맥과 상황에 따라 다름)
    - **중요한 기준은 변경**이다. 변경이 있을때 파급효과가 적으면 단일 책임 원칙을 잘 따른것
        - UI 변경, 객체의 생성과 사용을 분리

- OCP 개방-폐쇄 원칙 (가장 중요)
    - 소프트웨어 요소는 **확장에는 열려** 있으나 **변경에는 닫혀** 있어야 한다 (기존 코드는 그대로 새 기능만 추가)
    - **다형성**을 활용
    - 인터페이스를 구현한 새 클래스를 하나 만들어서 새 기능을 구현 (**역할과 구현의 분리**)
    - 문제점
        - MemberRepository m = new MemoryMemberRepository();
        - MemberRepository m = new JdbcMemberRepository();
        - 구현 객체를 변경하려면 클라이언트 코드를 변경해야 함
        - 다형성을 사용했지만 OCP 원칙을 지킬 수 없음
        - 객체를 생성하고 연관관계를 맺어주는 별도의 조립, 설정자가 필요


- LSP 리스코프 치환 법칙
    - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다
    - 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것, 다형성을 지원하기 위한 원칙, 인터페이스를 구현한 구현체는 믿고 사용하려면 이 원칙이 필요
    - 단순히 컴파일에 성공하는 것을 넘어서는 이야기
    - 예) 자동차 인터페이스의 엑셀은 앞으로 가라는 기능, 뒤로 가게 구현하면 LSP 위반, 느리더라도 앞으로 가야함

- ISP 인터페이스 분리 원칙
    - 특정 클라이언트를 위한 인터페이스 여러개가 범용 인터페이스 하나보다 낫다
    - 자동차 인터페이스 → 운전 인터페이스, 정비 인터페이스로 분리
    - 사용자 클라이언트 → 운전자 클라이언트, 정비사 클라이언트로 분리
    - 분리하면 정비 인터페이스 자체가 변해도 운전자 클라이언트에 영향을 주지 않음
    - 인터페이스가 명확해지고, 대체 가능성이 높아진다

- DIP 의존관계 역전 원칙 (두번째로 중요!)
    - 프로그래머는 추상화에 의존해야지 구체화에 의존하면 안된다 (의존성 주입)
    - 쉽게 이야기해서 구현 클래스에 의존하지 말고, 인터페이스에 의존하라는 뜻
    - **역할에 의존하게 해야 한다는 것과 같다** (구현체에 의존하면 변경이 매우 어려워짐)


→ 객체지향의 핵심은 다형성이지만 **다형성만 가지고는 SOLID (OCP, DIP)를 만족할 수 없다**

---

### 객체지향 설계와 스프링

- **스프링은 다음 기술로 다형성 + OCP, DIP 를 가능하게 지원**
    - DI(Dependency Injection): 의존관계, 의존성 주입
    - DI 컨테이너 제공
- **클라이언트 코드의 변경 없이 기능 확장**
- 쉽게 부품을 교체하듯이 개발
- 모든 설계에 역할과 구현을 분리 (이상적으로는)

→ OCP, DIP를 지키기 위해 코드를 작성하다 보니 핵심 로직을 제외한 코드가 너무 많아졌고 그래서 스프링이 만들어 졌다


---
# 다형성만으로는 OCP, DIP를 준수할 수 없다!

다형성을 활용하여 구현과 역할을 분리하더라도 문제가 발생한다

- 역할과 구현을 분리했는가? (O)
- 다형성도 활용하고 인터페이스와 구현 객체를 분리했는가? (O)
- OCP, DIP 를 준수했는가? (X)
  - 다형성(인터페이스)을 활용하더라도 클라이언트 코드에서 추상 인터페이스와 구현 클래스 모두 의존하고 수정이 발생하게 된다 (DIP 위배)
  - 인터페이스를 구현하는 새로운 확장이 발생하면 클라이언트 코드에도 수정이 일어나야 한다 (OCP 위배)
  
#### 해결방법

1. 클라이언트가 추상 인터페이스에만 의존하도록 수정한다 (구현 클래스가 클라이언트 코드상에 없도록 만든다)
2. [관심사를 분리] 클라이언트에 구현 객체를 대신 생성하고 주입하는 역할의 객체를 만든다 (그것이 바로 Spring!!)
   -> 마치 연극의 배우를 캐스팅하고 배치하는 누군가가 필요하다! (이전에는 배우가 캐스팅도하는 즉, 클라이언트의 역할과 책임이 너무 많았던것!)
3. 2번에서 만든 생성,관리,주입 역할을 하는 객체가 생성자를 통해 구현체를 주입해준다 (의존관계에 대한 고민은 외부에게 맡기고 실행에만 집중!)
   -> 의존관계를 외부에서 주입해주는 상황! (의존관계 주입 = 의존성 주입 = Dependency Injection)


---
# IoC, DI 그리고 컨테이너

### 제어의 역전 IoC (Inversion of Control)

- 기존 프로그램은 구현 객체가 스스로 프로그램 흐름을 제어했다
- AppConfig 가 등장하면서 구현 객체는 자신의 로직을 실행하는 역할만 담당한다
- 프로그램에 대한 제어 흐름에 대한 권한은 모두 AppConfig 가 가지고 있다 (프로그램 흐름을 외부에서 관리하는 것이 IoC)

#### 프레임워크 vs 라이브러리

- Junit 과 같이 내가 작성한 코드를 제어하고 대신 실행하면 프레임 워크
- 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 라이브러리


### 의존관계 주입 DI (Dependency Injection)

- 의존관계는 정적인 클래스 의존관계와 실행 시점에 결정되는 동적인 객체(인스턴스) 의존관계로 분리해서 생각해야 한다
- 정적인 클래스 의존관계로는 실제 실행에서 어떤것이 주입될지 알 수 없다
- 실행 시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는 것을 의존관계 주입이라고 한다
- 의존관계 주입을 사용하면 클라이언트 코드 변경없이 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다 
- 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다

### IoC 컨테이너, DI 컨테이너

- AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결하는 것을 IoC 컨테이너 혹은 DI 컨테이너라고 한다
- 의존관계 주입에 초점을 두어 DI 컨테이너라고 주로 부른다 (= Assembler, Object Factory)
- AppConfig = DI 컨테이너 = ApplicationContext


---
### 스프링 컨테이너의 생성과정

1. 스프링 컨테이너 생성 (빈이름 - 빈객체 형태의 저장소)
2. 스프링 빈 등록 (어노테이션 기반)
  - 빈 이름은 다르게 부여되어야 함
3. 스프링 빈 의존관계 설정 - 준비
4. 스프링 빈 의존관계 설정 - 완료 
  - 스프링 컨테이너는 설정 정보를 참고해서 의존 관계를 주입 (스프링은 빈을 생성하고 의존관계를 주입하는 단계가 나누어져 있다)
  - 단순히 자바코드를 호출하는것 같지만 차이가 있다 (싱글톤 컨테이너)


### 스프링 빈 조회 

- 빈 조회시 동일한 타입이 둘이상인 경우 `NoUniqueBeanDefinitionException` 예외가 발생된다
- 부모  타입으로 조회하면 자식 타입도 함께 조회된다
- Object 타입으로 조회하면 모든 스프링 빈을 조회한다 


### BeanFactory 와 ApplicationContext

```
<<Interface>>BeanFactory <- <<Interface>>ApplicationContext <- AnnotationConfigApplicationContext
```

##### BeanFactory

- 스프링 컨테이너의 최상위 인터페이스이다
- 스프링 빈을 관리하고 조회하는 역할을 담당한다
- `getBean()` 제공

##### ApplicationContext

- BeanFactory 기능을 모두 상속받아서 제공
- 빈을 관리하고 검색하는 기능을 BeanFactory가 제공해주는데 둘의 차이는?
- 애플리케이션 개발에는 빈 관리 조회 뿐만아니라 수많은 부가기능이 필요하다
  - 메시지 소스를 활용한 국제화 기능 (한국 -> 한국어, 일본 -> 일본어)
  - 환경변수 (로컬, 개발, 운영 구분해서 처리)
  - 애플리케이션 이벤트 (이벤트 발행 구독 모델을 편리하게 지원)
  - 편리한 리소스 조회 (파일, 클래스패스, 외부 등에서 리소스를 편리하게 조회)

정리하면
- ApplicationContext 는 BeanFactory 의 기능을 상속받는다
- ApplicationContext 는 빈 관리기능 + 편리한 부가기능을 제공한다
- BeanFactory 를 직접 사용할 일은 거의 없다 (대부분 부가기능이 포함된 ApplicationContext 사용)
- BeanFactory, ApplicationContext 를 스프링 컨테이너라고 한다


### 스프링 빈 설정 메타 정보 (BeanDefinition)

- 스프링은 다양한 설정 형식을 지원하는데 `BeanDefinition` 의 추상화를 통해 가능하게 한다
- 역할과 구현을 개념적으로 나눈것!
  - 자바코드, XML을 읽어서 BeanDefinition을 만들면된다
  - 스프링 컨테이너는 자바코드인지 XML인지 몰라도 된다 (오직 BeanDefinition만 알면 된다)
- `BeanDefinition` 을 빈 설정 메타정보라고 한다 
  - `@Bean`, `<bean>` 당 각각 하나씩 메타정보가 생성된다
- 스프링컨테이너는 이 메타정보(`BeanDefinition`)를 기반으로 스프링 빈을 생성한다


---
# 싱글톤 컨테이너

### 웹 애플리케이션과 싱글톤

- 스프링은 기업용 온라인 서비스 기술을 지원하기 위해 탄생했다
- 대부분의 스프링 애플리케이션은 웹 애플리케이션이다 (웹이 아닌것도 가능)
- 웹은 보통 여러 고객이 동시에 요청을 한다
- 스프링이 없다면 매번 객체가 생성되고 소멸되며 메모리 낭비가 심해진다 -> **싱글톤**
  - 싱글톤을 구현하는 방법은 매우 다양하다 (공통적인 것은 private 생성자)
  - 싱글톤 패턴 클라이언트가 구체클래스에 의존해 DIP를 위반한다
  - 내부 속성을 변경하거나 초기화하기 어렵다
  - private 생성자로 자식 클래스를 만들기 어렵다
  - 유연성이 떨어져 안티패턴으로 불리기도 한다


### 스프링 싱글톤 컨테이너

- 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하며 객체를 싱글톤으로 관리한다 (모든 스프링 빈은 싱글톤)
- 스프링 컨테이너는 싱글톤 컨테이너 역할을 한다 (싱글톤 레지스트리)
- 스프링 컨테이너로 인해 싱글톤 패턴을 위한 지저분한 코드가 없다
- 스프링 컨테이너로 인해 DIP, OCP, 테스트, private 생성자로 부터 자유롭게 싱글톤을 사용할 수 있다


### 싱글톤 방식의 주의점

- 객체 인스턴스를 하나만 생성해서 공유하는 싱글톤 방식은 여러 클라이언트가 하나의 같은 객체 인스턴스를 공유하기 때문에 **싱글톤 객체는 상태를 유지하게 설계하면 안된다**
- 무상태로 설계해야한다 (불변객체!)
  - 특정 클라이언트에 의존적인 필드가 없어야한다
  - 특정 클라이언트 값을 변경할 수 있는 필드가 있으면 안된다
  - 가급적 읽기만 가능해야 한다
  - 필드 대신 자바에서 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다
- 스프링 빈의 필드에 공유 값을 설정하면 정말 큰 장애가 발생할 수 있다!


### @Configuration 

```
AppConfig <- AppConfig@CGLIB
```

- `@Configuration`이 붙은 클래스를 `ApplicationContext` 에서 꺼내서 출력하면 클래스 명에 CGLIB가 붙는다
- 임의의 다른 클래스(`AppConfig@CGLIB`)가 싱글톤이 되도록 보장해준다 (스프링 컨테이너에 등록되어 있으면 가져오고 없으면 생성하도록)
- `@Configuration`이 없다면 `@Bean`을 붙여도 싱글톤이 보장되지 않는다
- `@Configuration`이 없다면 `@Bean`이 붙어있는 메서드를 호출할때마다 새로운 객체가 생성된다 


---
### 컴포넌트 스캔

- `@Bean` 은 메서드 레벨에서 직접 선언하고 `@Component`는 클래스 레벨에서 선언한다 (`@Component`는 스프링이 스캔하여 등록함)
- 빈 등록을 명시적으로 하기에는 관리할 것이 너무 많은데 `@ComponentScan`과 `@AutoWired`를 통해 빈을 등록하고 주입한다
- `@SpringBootApplication`에 `@ComponentScan`가 포함되어 있다 (기본적으로 현재 위치에서 하위 패키지를 모두 스캔함)
- 컴포넌트 스캔은 다음이 추가로 대상에 포함된다
  - `@Component`
  - `@Controller`
  - `@Service`
  - `@Repository`
  - `@Configuration`
- 컴포넌트 스캔 시 같은 컴포넌트 이름이 있으면 충돌이 발생한다
- 기존에 자동등록과 수동등록 빈의 이름이 중복되는 경우 수동등록이 오버라이딩해버렸는데, 최근 스프링 부트에서는 이 경우에도 오류가 발생하도록 기본이 되었다


---
# 의존관계 주입 


### 의존관계 주입 방법

스프링은 컨테이너는 2가지 라이프 사이클을 가짐

1. 모든 스프링 빈 등록
2. 의존관계 주입

##### 생성자 주입 (추천!)

```java
@AutoWired
public OrderServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
}
```

- 생성자를 통해서 의존관계를 주입받음
- 생성자 호출시점에 딱 1번만 호출되는 것이 보장
- 불변, 필수 의존관계에 사용 (세터가 없어야함)
- 생성자가 1개만 있으면 `@AutoWired`를 생략해도 자동으로 의존관계가 주입됨 
- 생성자주입은 빈을 등록하면서 자동으로 주입된다


##### 수정자 주입

```java
@AutoWired
public void setMemberRepository(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
}
```

- 수정자 주입은 객체 생성 이후에 주입된다 (생성자 주입은 생성되면서 주입됨)


##### 필드 주입

```java
@AutoWired
private MemberRepository membmerRepository;
```

- 필드에 바로 주입하는 방식으로 편해보이지만 외부에서 변경이 불가능해서 안티패턴으로 분류된다
- DI 프레임워크가 없으면 아무것도 할수 없다 (사용하지 말것! 사용한다면 테스트 코드정도에서!)