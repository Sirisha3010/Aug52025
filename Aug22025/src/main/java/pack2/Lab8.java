package pack2;

public class Lab8 {

	    public static String performOperation(String input, int choice) {
	        switch (choice) {
	            case 1:
	                
	                return input + input;

	            case 2:
	                
	                StringBuilder replaced = new StringBuilder(input);
	                for (int i = 0; i < replaced.length(); i++) {
	                    if (i % 2 == 1) { // odd index
	                        replaced.setCharAt(i, '#');
	                    }
	                }
	                return replaced.toString();

	            case 3:
	                
	                StringBuilder noDuplicates = new StringBuilder();
	                for (int i = 0; i < input.length(); i++) {
	                    char c = input.charAt(i);
	                    if (noDuplicates.indexOf(String.valueOf(c)) == -1) {
	                        noDuplicates.append(c);
	                    }
	                }
	                return noDuplicates.toString();

	            case 4:
	                
	                StringBuilder modified = new StringBuilder();
	                for (int i = 0; i < input.length(); i++) {
	                    char c = input.charAt(i);
	                    if (i % 2 == 1) { // odd index
	                        modified.append(Character.toUpperCase(c));
	                    } else {
	                        modified.append(c);
	                    }
	                }
	                return modified.toString();

	            default:
	                return "Invalid choice.";
	        }
	    }

	    public static void main(String[] args) {
	        String input = "helloWorld";
	        int choice = 4;

	        String result = performOperation(input, choice);
	        System.out.println("Result: " + result);
	    }
	}


