

import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class CRUDemo{
  



  public static void main(String args[])
	{ String sql;
 	   int ch,student_no,k;
	   String student_name;
	   String student_DOB,student_DOJ;
        
          Scanner sc=new Scanner(System.in);
	
          try{     
               Class.forName("com.mysql.jdbc.Driver");
  	       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
	       Statement stmt=conn.createStatement();
	   do           
	      {
                System.out.println(" 1. Insert \n 2. Update \n 3. Delete \n 4. Search \n 5. Display \n 6. Exit");
                System.out.print("Enter your choice: ");
		ch=sc.nextInt();
		switch(ch)
                {
                    case 1:
			int n;
                        System.out.print("How many records to be inserted?");
                        n=sc.nextInt();
                        for(int i=0;i<n;i++)
                        {
                            System.out.println("Enter Student No : ");
                            student_no=sc.nextInt();
                            System.out.println("Enter Name : ");
                            student_name=sc.next();
                            System.out.println("Enter Date of Birth: ");
                            student_DOB=sc.next();
                            System.out.println("Enter Date of joining: ");
                            student_DOJ=sc.next();
                            SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
                         
		            sql="insert into student values("+student_no+",'"+student_name+"',"+student_DOB+","+student_DOJ+")";	
			  System.out.println(sql);	
                            k=stmt.executeUpdate(sql);
                            if(k>0)
                               System.out.println("Record Inserted Successfully");
                          }
                        break;
                    case 2:
                        System.out.print("Enter the Student no: ");
                       student_no=sc.nextInt();
                        System.out.print("Enter the Sname: ");
                        student_name=sc.next();
			 sql="Update student set student_name='"+student_name+"' where student_no="+student_no;
                        k=stmt.executeUpdate(sql);
                        if(k>0)
                            System.out.println("Record Updated");
                 	break;
                    case 3:
                        System.out.print("Enter the Student no: ");
                        student_no=sc.nextInt();
			 sql="delete from student where student_no="+student_no;
                        k=stmt.executeUpdate(sql);
                        if(k>0)
                            System.out.println("Record Is Deleted");
                       break;
                    case 4:
			int r;
			Date p,j = null;
			String na;
                        System.out.print("Enter the Student no Whoes record is to be searched: ");
                        student_no=sc.nextInt();
                        sql="Select * from student where student_no="+student_no;
                        ResultSet rs1=stmt.executeQuery(sql);
                        while(rs1.next())
                        {   r=rs1.getInt("student_no");
			    na=rs1.getString("student_name");
                            p=rs1.getDate("student_DOB");
                            System.out.println("Rollno="+r+"\nName="+na+"\nDOB="+p+"\nDOJ="+j+"");  
                        }
                        break;
                    case 5:
			sql="Select * from student";
                        ResultSet rs=stmt.executeQuery(sql);
                        while(rs.next())
                        {
      			    r=rs.getInt("student_no");
			    na=rs.getString("student_name");
                            p=rs.getDate("student_DOB");
                            j=rs.getDate("student_DOJ");
                            System.out.println("Rollno="+r+"\nName="+na+"\nDOB="+p+"\nDOJ="+j);  
                        }
                        break;
                    case 6:
                        System.exit(0);
                }
            
           } while(ch!=6);
  
        }catch(SQLException se)
		{
			System.out.println("error"+se);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
}



