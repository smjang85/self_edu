package co.kr.programmers.hash;


/**
 * 1) ���� ����
 * ��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
 * ��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
 * 
 * ������ : 119
 * ���ؿ� : 97 674 223
 * ������ : 11 9552 4421
 * ��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 2) ���� ����
 * phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
 * �� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
 * 
 * 3) ����� ����
 * phone_book	return
 * [119, 97674223, 1195524421]	false
 * [123,456,789]	true
 * [12,123,1235,567,88]	false
 * 
 * 4) ����� �� ����
 * ����� �� #1
 * �տ��� ������ ���� �����ϴ�.
 * 
 * ����� �� #2
 * �� ��ȣ�� �ٸ� ��ȣ�� ���λ��� ��찡 �����Ƿ�, ���� true�Դϴ�.
 * 
 * ����� �� #3
 * ù ��° ��ȭ��ȣ, ��12���� �� ��° ��ȭ��ȣ ��123���� ���λ��Դϴ�. ���� ���� false�Դϴ�.
 * 
 * �˸�
 * 
 * 2019�� 5�� 13��, �׽�Ʈ ���̽��� ����Ǿ����ϴ�. �̷� ���� ������ ����ϴ� �ڵ尡 �� �̻� ������� ���� �� �ֽ��ϴ�.
 * @author SMJANG
 *
 */
public class PhoneNumberList {
/*	
    public boolean solution(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
             for(int j=i+1; j<phoneBook.length; j++) {
                 if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                 if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
             }
         }
         return true;
     }
*/ 
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        if(null != phone_book && phone_book.length > 0 && phone_book.length <= 1000000) {
        	loop:
	        for(int i = 0; i < phone_book.length-1; i++) {
	        	String phoneNum = phone_book[i];
	        	if(phoneNum.length() > 0 &&  phoneNum.length() <= 20) {
	        		for(int j = 0; j < phone_book.length; j++) {
	        			if(i != j) {
	        				String phoneNum2 = phone_book[j];
		        			if(phoneNum2.length() > 0 &&  phoneNum2.length() <= 20) {
		        				if(phoneNum2.startsWith(phoneNum)) {
				        			answer = false;
				        			break loop;
				        		}
		        			}
	        			}
		        	}
	        	}
	    	}
        }
       
        return answer;
    }
	
	public static void main(String[] args) throws Exception {
		//String[] phone_book = {"119", "97674223", "1195524421"};
		//String[] phone_book = {"123","456","789"};
		//String[] phone_book = {"12","123","1235","567","88"};
		String[] phone_book = {"12232332", "12", "222222"};
		System.out.println(solution(phone_book));
	}
}
