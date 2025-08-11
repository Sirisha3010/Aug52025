package pack2;
	import java.util.ArrayList;
	import java.util.Collections;

	public class Lab44 {
	    public static void main(String[] args) {
	        ArrayList<String> products = new ArrayList<>();

	 
	        products.add("Mobile");
	        products.add("Laptop");
	        products.add("Headphones");
	        products.add("Camera");
	        products.add("Smartwatch");

	       
	        Collections.sort(products);

	     
	        System.out.println("Sorted Product Names:");
	        for (String product : products) {
	            System.out.println(product);
	        }
	    }
	}


