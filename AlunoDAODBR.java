import java.sql.*;

public class AlunoDAOBDR{
	
	public void inserir(String matricula, String nome){
		try{
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection con = DriverManager.getConnection(
                                "jdbc:odbc:contAcad", "", "");                     
                                
       String sql = "INSERT INTO Aluno VALUES(?,?)";
       PreparedStatement ps = con.prepareStatement (sql);
       ps.setString(1,matricula);
       ps.setString(2,nome);
       int i = ps.executeUpdate();
       
       Statement stmt = con.createStatement ();
       
       ResultSet rs = stmt.executeQuery(
       	                            "SELECT * FROM Aluno");

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
  
	}
	
}