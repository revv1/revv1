import java.sql.*;
public class basic
{

public static void main(String[] args) {
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from emp");
		 while(rs.next())
		 {
			 System.out.print(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3));
			 
		 }
		
		
		
	}catch (Exception e)
	{
System.out.print("error=="+e);	}
}	
	
}
