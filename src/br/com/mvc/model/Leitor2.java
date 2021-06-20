package br.com.mvc.model;

public class Leitor2 {
	
	//atributos
	
	private int RgmAluno;
	private String Semestre;
	private double Nota;
	private int Faltas;
	private String Disciplina;
	

	//construtores

	public Leitor2() {
		
	}
	
	public Leitor2(int RgmAluno,String semestre, double nota, int faltas, String disciplina) {
		this.Semestre = semestre;
		this.Nota = nota;
		this.Faltas = faltas;
		this.Disciplina = disciplina;
		this.RgmAluno=RgmAluno;
	}

	public String getSemestre() {
		return Semestre;
	}

	public void setSemestre(String semestre) {
		Semestre = semestre;
	}

	public double getNota() {
		return Nota;
	}

	public void setNota(double nota) {
		Nota = nota;
	}

	public int getFaltas() {
		return Faltas;
	}

	public void setFaltas(int faltas) {
		Faltas = faltas;
	}

	public String getDisciplina() {
		return Disciplina;
	}

	public void setDisciplina(String disciplina) {
		Disciplina = disciplina;
	}

	public int getRgmAluno() {
		return RgmAluno;
	}

	public void setRgmAluno(int rgmAluno) {
		RgmAluno = rgmAluno;
	}
	
	//gets e sets
	
	
	}