import java.sql.*;

public class JDBCDemo{
	
	public static void main(String[ ] args){

  try{
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con = DriverManager.getConnection(
                                "jdbc:odbc:contAcad", "", "");  
       Statement stmt = con.createStatement();

       ResultSet rs = stmt.executeQuery(
       	                            "SELECT * FROM Aluno");

       System.out.println("Mat.1 \t Nome");
  
       while (rs.next())
          System.out.println(rs.getString(1) + '\t' 
                                       + rs.getString(2) );
  
       int i = stmt.executeUpdate(
        "INSERT INTO Aluno VALUES(\'m0004\',\'Aluno04\')");


      rs = stmt.executeQuery(
       	                            "SELECT * FROM Aluno");
       System.out.println("**** Depois da atualização do BD ****");
       System.out.println("Mat.1 \t Nome");
       while (rs.next())
          System.out.println(rs.getString(1) + '\t' 
                                       + rs.getString(2) );
  
     con.close(); 
   }  catch (SQLException ex){
          System.out.println(ex.getMessage());
    } catch (Exception ex){
        System.out.println(ex.getMessage());

    } //fim catch
  
    }// fim main

}//fim class