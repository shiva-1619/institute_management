import java.sql.*; 
import java.util.*; 
 
class MysqlCbp{ 
 public static void main(String args[]) throws SQLException{ 
   
   
  
  String UR="jdbc:mysql://localhost:3306/harry"; 
 
  Connection 
conn=DriverManager.getConnection(UR,"root","Shiva@1211"); 
 
  Statement stmt=conn.createStatement(); 
 
  
  Scanner t=new Scanner(System.in); 
  int value=1; 
 
  System.out.println("   <<<  WELCOME TO VNR 
DATABASE  >>>>\n"); 
  System.out.println(""); 
  System.out.println("select the options :-"); 
  System.out.println(""); 
  System.out.println(" 1.Add new student details"); 
  System.out.println(" 2.To retrive All Student data"); 
  System.out.println(" 3.Add new Faculty details"); 
  System.out.println(" 4.To retrive faculty details"); 
  System.out.println(" 5.Search details using student ID"); 
  System.out.println(" 6.Search details using Teacher ID"); 
  System.out.println(" 0.EXIT"); 
  System.out.println(""); 
  while(value!=0) 
  { 
   System.out.println(""); 
   System.out.print("Your choice: "); 
   value=t.nextInt(); 
 
  switch(value) 
  { 
 
   case 1: 
    PreparedStatement ins=conn.prepareStatement("insert into 
student values(?,?,?,?,?,'VNR')");   
    int n=1; 
    while(n==1) 
    { 
     int id,y; 
     String name,dept,g; 
     Scanner s=new Scanner(System.in); 
     System.out.print("Enter student ID: "); 
     id=s.nextInt(); 
     System.out.print("Name: "); 
     name=s.next(); 
     System.out.print("Department: "); 
     dept=s.next(); 
     System.out.print("Year pursuing now: "); 
     y=s.nextInt(); 
     System.out.print("Gender: "); 
     g=s.next(); 
      
     ins.setInt(1,id); 
     ins.setString(2,name); 
     ins.setString(3,dept); 
     ins.setInt(4,y); 
     ins.setString(5,g); 
 
     ins.executeUpdate(); 
     System.out.println("if u want to exit press 0, else enter 
1");   
     n=s.nextInt(); 
    } 
   break; 
 
    
   case 2: 
    String s="SELECT * FROM student"; 
 
 
    ResultSet rs=stmt.executeQuery(s); 
 
    while(rs.next()) 
    { 
     int ids=rs.getInt("id"); 
     String names=rs.getString("name"); 
     String deps=rs.getString("department"); 
     int ys=rs.getInt("year"); 
     String gs=rs.getString("gender"); 
     String clg=rs.getString("college"); 
 
     System.out.println(ids+"  "+names+"  "+deps+" 
"+ys+" "+gs+" "+clg); 
    } 
     
    rs.close(); 
 
   break; 
 
   case 3: 
    PreparedStatement ins1=conn.prepareStatement("insert into 
teacher values(?,?,?,?,?)");   
    int n1=1; 
    while(n1==1) 
    { 
     int id,salary; 
     String name,dept,g; 
     Scanner sc=new Scanner(System.in); 
     System.out.print("Enter Faculty ID: "); 
     id=sc.nextInt(); 
     System.out.print("Name: "); 
     name=sc.next(); 
     System.out.print("Department: "); 
     dept=sc.next(); 
     System.out.print("Salary/month: "); 
     salary=sc.nextInt(); 
     System.out.print("Gender: "); 
     g=sc.next(); 
      
     ins1.setInt(1,id); 
     ins1.setString(2,name); 
     ins1.setString(3,dept); 
     ins1.setInt(4,salary); 
     ins1.setString(5,g); 
 
     ins1.executeUpdate(); 
 
     System.out.print("if u want to exit press 0, else enter 
1: ");   
     n1=sc.nextInt(); 
    }  
   break; 
    
   case 4: 
    String q2="SELECT id,name,dept,salary,gender FROM 
teacher"; 
 
 
    ResultSet rs1=stmt.executeQuery(q2); 
 
    while(rs1.next()) 
    { 
     int idp=rs1.getInt("id"); 
     String namep=rs1.getString("name"); 
     String depp=rs1.getString("dept"); 
     int salp=rs1.getInt("salary"); 
     String gp=rs1.getString("gender"); 
 
     System.out.println(idp+"  "+namep+"  "+depp+" 
"+salp+" "+gp); 
    } 
     
    rs1.close(); 
   break; 
 
   case 5: 
 
    System.out.print("enter student ID:"); 
    Scanner k5=new Scanner(System.in); 
    int tid5=11; 
    tid5=k5.nextInt(); 
    PreparedStatement en5=conn.prepareStatement("SELECT * 
FROM student where id=?");  
    en5.setInt(1,tid5); 
   try 
   { 
    ResultSet rs5=en5.executeQuery(); 
    rs5.next(); 
     int ids=rs5.getInt("id"); 
     String names=rs5.getString("name"); 
     String deps=rs5.getString("department"); 
     int ys=rs5.getInt("year"); 
     String gs=rs5.getString("gender"); 
     String clg=rs5.getString("college"); 
 
     System.out.println(ids+"  "+names+"  "+deps+" 
"+ys+" "+gs+" "+clg); 
    
    rs5.close(); 
   } 
   catch(SQLException sqe) 
   { 
    System.out.println("No details on that ID, once please check 
"); 
   } 
    
   break; 
 
   case 6: 
    System.out.print("enter teacher ID:"); 
    Scanner k1=new Scanner(System.in); 
    int tid=120; 
    tid=k1.nextInt(); 
    PreparedStatement en1=conn.prepareStatement("SELECT * 
FROM teacher where id=?");  
    en1.setInt(1,tid); 
   try{ 
    ResultSet rs6=en1.executeQuery(); 
    rs6.next(); 
     int idp=rs6.getInt("id"); 
     String namep=rs6.getString("name"); 
     String depp=rs6.getString("dept"); 
     int salp=rs6.getInt("salary"); 
     String gp=rs6.getString("gender"); 
 
     System.out.println(idp+"  "+namep+"  "+depp+" 
"+salp+" "+gp); 
    
    rs6.close(); 
   } 
   catch(SQLException sqe) 
   { 
    System.out.println("No details on that ID, once please check 
"); 
   } 
  } 
  } 
  stmt.close(); 
 } 
}