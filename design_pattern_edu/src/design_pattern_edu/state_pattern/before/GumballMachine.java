package design_pattern_edu.state_pattern.before;

public class GumballMachine {
	
	final static int SOLD_OUT = 0;
	final static int NO_QUATER = 1;
	final static int HAS_QUATER = 2;
	final static int SOLD = 3;
	
	int state = SOLD_OUT;
	int count = 0;
	
	public GumballMachine(int count) {
		this.count = count;
		if(count > 0) {
			state = NO_QUATER;
		}
	}
	
	// ������ ���Ե� ���
	public void insertQuater() {
		if(state == HAS_QUATER) {
			System.out.println("������ �� ���� �־��ּ���.");
		} else if(state == NO_QUATER) {
			state = HAS_QUATER;
			System.out.println("������ �����̽��ϴ�.");
		} else if(state == SOLD_OUT) {
			System.out.println("�����Ǿ����ϴ�. ���� ��ȸ�� �̿����ּ���.");
		} else if(state == SOLD) {
			System.out.println("��� ��ٷ� �ּ���. �˸��̰� ������ �ֽ��ϴ�.");
		}
	}
	
	// ����ڰ� ������ ��ȯ �������� �ϴ� ���
	public void ejectQuarter() {
		if(state == HAS_QUATER) {
			System.out.println("������ ��ȯ�˴ϴ�.");
			state = NO_QUATER;
		} else if(state == NO_QUATER) {
			System.out.println("������ �־��ּ���.");
		} else if(state == SOLD) {
			System.out.println("�̹� �˸��̸� �����̽��ϴ�.");
		} else if(state == SOLD_OUT) {
			System.out.println("������ ���� �����̽��ϴ�. ������ ��ȯ���� �ʽ��ϴ�.");
		}
	}
	
	// �����̸� ������ ���
	public void turnCrank() {
		if(state == SOLD) {
			System.out.println("�����̴� �� ���� �����ּ���.");
		}else if(state == NO_QUATER) {
			System.out.println("������ �־��ּ���.");
		}else if(state == SOLD_OUT) {
			System.out.println("�����Ǿ����ϴ�.");
		}else if(state == HAS_QUATER) {
			System.out.println("�����̸� �����̽��ϴ�.");
			state = SOLD;
			dispense();
		}
	}
	
	// �˸��� ������
	public void dispense() {
		if(state == SOLD) {
			System.out.println("�˸��̰� ������ �ֽ��ϴ�.");
			count = count - 1;
			if(count == 0) {
				System.out.println("�� �̻� ����̰� �����ϴ�.");
				state = SOLD_OUT;
			}else {
				state = NO_QUATER;
			}
		}else if(state == NO_QUATER) {
			System.out.println("������ �־��ּ���.");
		}else if(state == SOLD_OUT) {
			System.out.println("�����Դϴ�.");
		}else if(state == HAS_QUATER) {
			System.out.println("�˸��̰� ���� �� �����ϴ�.");
		}
	}
	
	
	public String toString() {
		String result = "\n##### �ֽ�ȸ�� �ջ̱� #####\n" + "�ڹٷ� ����� 2004���� �̱� ���\n" + "���� ���� :" + count +"��\n" +"���� ���� �����\n";
		return result;
	}
}
