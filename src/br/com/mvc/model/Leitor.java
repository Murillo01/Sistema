package br.com.mvc.model;

public class Leitor {
	// Atributos 
	
	private int RgmAluno;
	private String NomeAluno;
	private String DataNasc;
	private String CpfAluno;
	private String EmailAluno;
	private String EndAluno;
	private String Municipio;
	private String UF;
	private String Celular;
	private String CursoAluno;
	private String Campus;
	private String Periodo;
	
	
	// construtores

	public Leitor() {
		
	}



	

	public Leitor(int RgmAluno, String NomeAluno, String DataNasc, String CpfAluno, String EmailAluno,
			String EndAluno, String Municipio, String UF, String Celular, String CursoAluno, String Campus,
			String Periodo) {
		this.RgmAluno = RgmAluno;
		this.NomeAluno = NomeAluno;
		this.DataNasc = DataNasc;
		this.CpfAluno = CpfAluno;
		this.EmailAluno = EmailAluno;
		this.EndAluno = EndAluno;
		this.Municipio = Municipio;
		this.UF = UF;
		this.Celular = Celular;
		this.CursoAluno = CursoAluno;
		this.Campus = Campus;
		this.Periodo = Periodo;
			}





	public int getRgmAluno() {
		return RgmAluno;
	}





	public void setRgmAluno(int rgmAluno) {
		RgmAluno = rgmAluno;
	}





	public String getNomeAluno() {
		return NomeAluno;
	}





	public void setNomeAluno(String nomeAluno) {
		NomeAluno = nomeAluno;
	}





	public String getDataNasc() {
		return DataNasc;
	}





	public void setDataNasc(String dataNasc) {
		DataNasc = dataNasc;
	}





	public String getCpfAluno() {
		return CpfAluno;
	}





	public void setCpfAluno(String cpfAluno) {
		CpfAluno = cpfAluno;
	}





	public String getEmailAluno() {
		return EmailAluno;
	}





	public void setEmailAluno(String emailAluno) {
		EmailAluno = emailAluno;
	}





	public String getEndAluno() {
		return EndAluno;
	}





	public void setEndAluno(String endAluno) {
		EndAluno = endAluno;
	}





	public String getMunicipio() {
		return Municipio;
	}





	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}





	public String getUF() {
		return UF;
	}





	public void setUF(String uF) {
		UF = uF;
	}





	public String getCelular() {
		return Celular;
	}





	public void setCelular(String celular) {
		Celular = celular;
	}





	public String getCursoAluno() {
		return CursoAluno;
	}





	public void setCursoAluno(String cursoAluno) {
		CursoAluno = cursoAluno;
	}





	public String getCampus() {
		return Campus;
	}





	public void setCampus(String campus) {
		Campus = campus;
	}





	public String getPeriodo() {
		return Periodo;
	}





	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}





	}

	//construtor para o metodo consultar não dar erro

	