package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
    	if(s == null || s.isEmpty()) return PasswordStrength.INVALID;
    	int metCounts = getMetCriteriaCounts(s);
    	
    	if(metCounts <= 1) return PasswordStrength.WEEK;
    	if(metCounts == 2) return PasswordStrength.NORMAL;
    	
        return PasswordStrength.STRONG;
    }
    
    private int getMetCriteriaCounts(String s) {
    	int metCounts = 0;
    	if(s.length() >= 8) metCounts ++;
    	if(meetsContainingNumberCrieria(s)) metCounts++;
    	if(meetsContainingUppercaseCrieria(s)) metCounts++;
    	return metCounts;
    }
    
    private boolean meetsContainingNumberCrieria(String s) {
    	for(char ch : s.toCharArray()) {
    		if(ch >= '0' && ch <= '9') {
    			return true;
    		}
    	}
    	return false;
    }
    
    private boolean meetsContainingUppercaseCrieria(String s) {
    	for(char ch : s.toCharArray()) {
    		if(Character.isUpperCase(ch)) {
    			return true;
    		}
    	}
    	return false;
    }

}
