public class Aluno{
	private String matricula,
	                     nome;
	                     
	public Aluno(String pMat, String pNome){
		this.matricula = pMat;
		this.nome = pNome;
	}
	
	public String getMatricula(){
		return matricula;
	}
	public String getNome(){
		return nome;
	}
	
}