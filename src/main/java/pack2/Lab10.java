package pack2;

public class Lab10 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String str="Apple";
			StringBuilder str2=new StringBuilder(str);
			int len=str.length();
			System.out.println(len);
			for(int i=0;i<len;i++)
			{
				if(i%2!=0)
				{
					str2.setCharAt(i,'#');
				}
			}
			

			System.out.println("odd replaced: " +str2);
			

		}
		

	}


