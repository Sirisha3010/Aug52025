package pack2;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	
	public class Lab11 {
		
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			String url="jdbc:mysql://127.0.0.1:3306/aug4_2025";
			String user="root";
			String password="Siri@3010";
			try(Connection con=DriverManager.getConnection(url,user,password))
			{
				System.out.println("Connect to DB");
				String insertsql="INSERT INTO students(id,name,age) VALUES(?,?,?)";
				try(PreparedStatement pstmt=con.prepareStatement(insertsql))
				{
					pstmt.setInt(1, 101);
					pstmt.setString(2, "Siri");
					pstmt.setInt(3, 21);
					int rows=pstmt.executeUpdate();
					System.out.println("Inserted:"+rows);
				}
				
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			

		}

	}


