package design_pattern_edu.template_method_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeWithHook extends CaffeineBeverageWithHook{

	@Override
	public void brew() {
		System.out.println("���͸� ���ؼ� Ŀ�Ǹ� ������� ��");
	}
	
	@Override
	public void addCondiments() {
		System.out.println("������ ������ �߰��ϴ� ��");
	}


	public boolean customerWantsCondiments() {
		String answer = getUserInput();
		
		if(answer.toLowerCase().startsWith("y")) {
			return true;
		}else {
			return false;
		}
	}
	
	private String getUserInput() {
		String answer = null;
		
		System.out.println("Ŀ�ǿ� ������ ������ �־� �帱���? (y/n) ");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch(IOException e) {
			System.out.println("IO ����");
		}
		
		if(answer == null) {
			return "no";
		}
		
		return answer;
	}
}
