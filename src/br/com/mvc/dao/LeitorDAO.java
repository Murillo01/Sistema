package br.com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.mvc.model.Leitor;
import br.com.mvc.model.Leitor2;
import br.com.mvc.util.ConnectionFactory;

public class LeitorDAO {  // CRUD
	
	private Leitor leitor;
	private Connection conn; // conecta com o banco de dados
	private PreparedStatement ps; // permite executar querys
	private ResultSet rs; // tabela

	

	public LeitorDAO() throws Exception {
		
		try {
			conn = ConnectionFactory.getConnection();
		}catch (Exception e) {
			throw new Exception("Erro "+ e.getMessage());
		}
		
	}
	
	public void salvar(Leitor leitor) throws Exception {
		
		try {
			
			String sql="INSERT INTO DadosPessoais(RgmAluno,NomeAluno,DataNasc,CpfAluno,EmailAluno,EndAluno,"
					+ "Municipio,UF,Celular,CursoAluno,Campus,Periodo)"
					+ "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, leitor.getRgmAluno());
			ps.setString(2, leitor.getNomeAluno());
			ps.setString(3, leitor.getDataNasc());
			ps.setString(4, leitor.getCpfAluno());
			ps.setString(5, leitor.getEmailAluno());
			ps.setString(6, leitor.getEndAluno());
			ps.setString(7, leitor.getMunicipio());
			ps.setString(8, leitor.getUF());
			ps.setString(9, leitor.getCelular());
			ps.setString(10, leitor.getCursoAluno());
			ps.setString(11, leitor.getCampus());
			ps.setString(12, leitor.getPeriodo());
			/*
			String sql1="INSERT INTO curso(CursoAluno,Campus,Periodo)" + 
									 "values (?, ?, ?)";
			ps = conn.prepareStatement(sql1);
			ps.setString(1, leitor.getCursoAluno());
			ps.setString(2, leitor.getCampus());
			ps.setString(3, leitor.getPeriodo());
			
			String sql2="INSERT INTO NotaFalta(RgmAluno,Disciplina,Semestre,Nota,Faltas)" + 
					 "values (?, ?, ?, ?)";
			ps = conn.prepareStatement(sql2);
			ps.setString(1, leitor.getSemestre());
			ps.setDouble(2, leitor.getNota());
			ps.setInt(3, leitor.getFaltas());
			ps.setString(4, leitor.getDisciplina());**/
			ps.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Erro ao salvar "+ e.getMessage());
		}
		
	}
	
	
	
	
public void alterar(Leitor leitor) throws Exception {
		
		try {
			
			String sql="UPDATE dadospessoais SET NomeAluno=?,DataNasc=?,CpfAluno=?,EmailAluno=?,EndAluno=?,Municipio=?,UF=?,Celular=?"
					+ ",CursoAluno=?,Campus=?,Periodo=? WHERE RgmAluno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, leitor.getNomeAluno()); // seria o primeiro ponte de interrogação
			ps.setString(2, leitor.getDataNasc()); // seria o segundo ponto de interrogação
			ps.setString(3, leitor.getCpfAluno());// seria a condição para dar o update
			ps.setString(4,leitor.getEmailAluno());
			ps.setString(5,leitor.getEndAluno());
			ps.setString(6,leitor.getMunicipio());
			ps.setString(7,leitor.getUF());
			ps.setString(8,leitor.getCelular());
			ps.setString(9,leitor.getCursoAluno());
			ps.setString(10,leitor.getCampus());
			ps.setString(11,leitor.getPeriodo());
			ps.setInt(12,leitor.getRgmAluno());
			ps.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Erro ao alterar "+ e.getMessage());
		}
		
	}
	



public void excluir(int RgmAluno) throws Exception {
	
	try {
		
		String sql="DELETE FROM dadospessoais WHERE RgmAluno=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, RgmAluno); // seria a condição para dar o DELETE
		ps.executeUpdate();
	}catch (Exception e) {
		throw new Exception("Erro excluir "+ e.getMessage());
	}
	
}

	
	public List listarTodos() throws Exception { // método para pegar do banco os dados do boletim
		List<Leitor> lista = new ArrayList<Leitor>();
			try {
			String sql = "SELECT * FROM aluno";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				 
				 int RgmAluno =  rs.getInt("RgmAluno");
				 String NomeAluno = rs.getString("NomeAluno");
				 String DataNasc = rs.getString("DataNasc");
				 String CPFAluno =	rs.getString("CpfAluno");
				 String EmailAluno =	rs.getString("EmailAluno");
				 String EndAluno =	rs.getString("EndAluno");
				 String Municipio =	rs.getString("Municipio");
				 String UF =	rs.getString("UF");
				 String Celular =	rs.getString("Celular");
				 String CursoAluno =	rs.getString("CursoAluno");
				 String Campus =	rs.getString("Campus");
				 String Periodo =	rs.getString("Periodo");
				 
					
				 leitor = new Leitor(RgmAluno, NomeAluno, DataNasc, CPFAluno, EmailAluno, EndAluno, Municipio, UF, Celular, CursoAluno, Campus,
						 Periodo);
				 lista.add(leitor);
				 
			}
			return lista;
			
		} catch(Exception e) {
			throw new Exception("Erro ao listar "+ e.getMessage());
		}
			
		
	}
	public Leitor consultar(int RgmAluno) throws Exception {

		try {
			String SQL = "SELECT * FROM dadospessoais WHERE RgmAluno=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, RgmAluno);			
			rs = ps.executeQuery();
			if (rs.next()) {
				String NomeAluno = rs.getString("NomeAluno");
				String DataNasc=rs.getString("DataNasc");
				String CpfAluno=rs.getString("CpfAluno");
				String EmailAluno=rs.getString("EmailAluno");
				String EndAluno=rs.getString("EndAluno");
				String Municipio=rs.getString("Municipio");
				String UF=rs.getString("UF");
				String Celular=rs.getString("Celular");
				String CursoAluno=rs.getString("CursoAluno");
				String Campus=rs.getString("Campus");
				String Periodo=rs.getString("Periodo");
		
				leitor = new Leitor( RgmAluno,NomeAluno, DataNasc, CpfAluno, EmailAluno,
						 EndAluno, Municipio,  UF, Celular, CursoAluno, Campus,
						 Periodo);
			}
			return leitor;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		}
	}
	}	


