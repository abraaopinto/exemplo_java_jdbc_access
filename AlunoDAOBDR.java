import java.sql.*;

public class AlunoDAOBDR{
	Connection con = null;
	
	public AlunoDAOBDR(){
	try{
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");                            
      } catch (Exception ex){
        System.out.println(ex.getMessage());
    } //fim catch
  
	}
	
	private void conectarBD(){
     try{
	  con = DriverManager.getConnection(
                                "jdbc:odbc:contAcad", "", "");                         
     }  catch (SQLException ex){
        System.out.println(ex.getMessage());
     }
	}
	
	public void inserir(Aluno pAluno){
	 try{   
	   conectarBD();                       
       String sql = "INSERT INTO Aluno VALUES(?,?)";
       PreparedStatement ps = con.prepareStatement (sql);
       ps.setString(1,pAluno.getMatricula());
       ps.setString(2,pAluno.getNome());
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