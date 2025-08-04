package pack2;

public class Lab7 {

	    public static boolean isPositiveString(String input) {
	        
	        input = input.toUpperCase();

	        for (int i = 0; i < input.length() - 1; i++) {
	            if (input.charAt(i) > input.charAt(i + 1)) {
	                return false; 
	            }
	        }

	        return true; 
	    }

	    public static void main(String[] args) {
	        String test1 = "ANT";    
	        String test2 = "CAT";     
	        String test3 = "ACE";     
	        String test4 = "aBZ";     

	        System.out.println(test1 + ": " + isPositiveString(test1));
	        System.out.println(test2 + ": " + isPositiveString(test2));
	        System.out.println(test3 + ": " + isPositiveString(test3));
	        System.out.println(test4 + ": " + isPositiveString(test4));
	    }
	}

