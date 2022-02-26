package design_pattern_edu.singleton_pattern;

/*
 * 5. 싱글턴 패턴
 * 해당 클래스의 인스턴스가 하나만 만들어지고, 어디서든지 그 인스턴스에 접근할 수 있도록 하기 위한 패턴 
 * 
 */
public class ChocolateBoiler {
	
	private boolean empty;
	private boolean boiled;
	
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	/* 1번 타입 -> getInstance() 메소드를 동기화하는 방법
	 * 항상 올바른 결과가 나온다. 초콜릿 보일러의 경우에는 속도 문제가 그리 중요하지 않으므로 이 방법을 서도 괜찮다.
	 * private static ChocolateBoiler instance;
	public static synchronized ChocolateBoiler getInstance() {
		if(instance == null) {
			instance = new ChocolateBoiler();
		}
		return instance;
	}
	*/
	
	/* 2번 타입 -> 인스턴스를 시작하자마자 만드는 방법
	 * 초콜릿 보일러의 인스턴스는 항상 필요하기 때문에 정적으로 초기화하는 것도 괜찮은 방법
	 * private static ChocolateBoiler instance = new ChocolateBoiler();
	public static synchronized ChocolateBoiler getInstance() {
		
		return instance;
	}
	*/
	
	// 3번 타입 -> DCL을 쓰는 방법 (DCL Double-Checking Locking 은 JDK1.4 이전 버전에서는 쓸수 없음)
	private volatile static ChocolateBoiler instance;
	
	public static ChocolateBoiler getInstance() {
		if(instance == null) {
			synchronized (ChocolateBoiler.class) {
				if(instance == null) {
					instance = new ChocolateBoiler();
				}
			}
		}
		
		return instance;
	}

	
	public void fill() {
		if(isEmpty()) {
			empty = false;
			boiled = false;
			// 보일러에 우유/초콜릿을 혼합한 재료플 집어넣음
		}
	}
	
	public void drain() {
		if(!isEmpty() && isBoiled()) {
			//끓인 재료를 다음 단계로 넘김
			empty = true;
		}
	}
	
	public void boil() {
		if(!isEmpty() && !isBoiled()) {
			// 재료를 끓음
			boiled = true;
		}
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}

}
