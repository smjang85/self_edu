package design_pattern_edu.singleton_pattern;

/*
 * 5. �̱��� ����
 * �ش� Ŭ������ �ν��Ͻ��� �ϳ��� ���������, ��𼭵��� �� �ν��Ͻ��� ������ �� �ֵ��� �ϱ� ���� ���� 
 * 
 */
public class ChocolateBoiler {
	
	private boolean empty;
	private boolean boiled;
	
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	/* 1�� Ÿ�� -> getInstance() �޼ҵ带 ����ȭ�ϴ� ���
	 * �׻� �ùٸ� ����� ���´�. ���ݸ� ���Ϸ��� ��쿡�� �ӵ� ������ �׸� �߿����� �����Ƿ� �� ����� ���� ������.
	 * private static ChocolateBoiler instance;
	public static synchronized ChocolateBoiler getInstance() {
		if(instance == null) {
			instance = new ChocolateBoiler();
		}
		return instance;
	}
	*/
	
	/* 2�� Ÿ�� -> �ν��Ͻ��� �������ڸ��� ����� ���
	 * ���ݸ� ���Ϸ��� �ν��Ͻ��� �׻� �ʿ��ϱ� ������ �������� �ʱ�ȭ�ϴ� �͵� ������ ���
	 * private static ChocolateBoiler instance = new ChocolateBoiler();
	public static synchronized ChocolateBoiler getInstance() {
		
		return instance;
	}
	*/
	
	// 3�� Ÿ�� -> DCL�� ���� ��� (DCL Double-Checking Locking �� JDK1.4 ���� ���������� ���� ����)
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
			// ���Ϸ��� ����/���ݸ��� ȥ���� ����� �������
		}
	}
	
	public void drain() {
		if(!isEmpty() && isBoiled()) {
			//���� ��Ḧ ���� �ܰ�� �ѱ�
			empty = true;
		}
	}
	
	public void boil() {
		if(!isEmpty() && !isBoiled()) {
			// ��Ḧ ����
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
