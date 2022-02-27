package design_pattern_edu.template_method_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends CaffeineBeverageWithHook{

	@Override
	public void brew() {
		System.out.println("차를 우려내는 중");
		
	}
	
	@Override
	public void addCondiments() {
		System.out.println("레몬을 추가하는 중");
		
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
		
		System.out.println("레몬을 추가할까요? (y/n) ");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch(IOException e) {
			System.out.println("IO 오류");
		}
		
		if(answer == null) {
			return "no";
		}
		
		return answer;
	}
}
