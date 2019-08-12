import javax.swing.JOptionPane;

public class JDBCDemoPrep{
	
	public static void main(String[ ] args){

   String matricula = JOptionPane.showInputDialog
                          ("Informe Matricula:");
   String nome = JOptionPane.showInputDialog
                          ("Informe Nome:");                       
    
    AlunoDAOBDR dao = new AlunoDAOBDR();
    Aluno a = new Aluno (matricula,nome);
    dao.inserir(a);
    
    }// fim main

}//fim class