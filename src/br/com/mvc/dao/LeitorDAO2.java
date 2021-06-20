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

public class LeitorDAO2 {  // CRUD
	
	private Leitor2 leitor2;
	private Connection conn; // conecta com o banco de dados
	private PreparedStatement ps; // permite executar querys
	private ResultSet rs; // tabela

	

	public LeitorDAO2() throws Exception {
		
		try {
			conn = ConnectionFactory.getConnection();
		}catch (Exception e) {
			throw new Exception("Erro "+ e.getMessage());
		}
		
	}
	
	public void salvar(Leitor2 leitor2) throws Exception {
		
		try {
			String sql2="INSERT INTO NotaFalta(RgmAluno,Disciplina,Semestre,Nota,Faltas)" + 
				 "values (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, leitor2.getRgmAluno());
			ps.setString(2, leitor2.getDisciplina());
			ps.setString(3, leitor2.getSemestre());
			ps.setDouble(4, leitor2.getNota());
			ps.setInt(5, leitor2.getFaltas());
			ps.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Erro ao salvar "+ e.getMessage());
		}
		
	}
	
	
	
	
public void alterar(Leitor2 leitor2) throws Exception {
		
		try {
			
			String sql2="UPDATE NotaFalta SET Disciplina=?,Semestre=?,Nota=?,Faltas=?"
					+ " WHERE RgmAluno=?";
			ps = conn.prepareStatement(sql2);
			ps.setString(1, leitor2.getDisciplina()); // seria o primeiro ponte de interrogação
			ps.setString(2, leitor2.getSemestre()); // seria o segundo ponto de interrogação
			ps.setDouble(3, leitor2.getNota()); // seria a condição para dar o update
			ps.setInt(4, leitor2.getFaltas());
			ps.setInt(5, leitor2.getRgmAluno());
			ps.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Erro ao alterar "+ e.getMessage());
		}
		
	}
	



public void excluir(int RgmAluno) throws Exception {
	
	try {
		
		String sql2="DELETE FROM NotaFalta"
				+ " WHERE RGMAluno=?";
		ps = conn.prepareStatement(sql2);
		ps.setInt(1, RgmAluno); // seria a condição para dar o DELETE
		ps.executeUpdate();
	}catch (Exception e) {
		throw new Exception("Erro ao excluir "+ e.getMessage());
	}
	
}
///////////////////////////////////////////////////////////////////////////////////////////q
	
public List listarTodos() throws Exception { // método para pegar do banco os dados do boletim
	List<Leitor2> list = new ArrayList<Leitor2>();
		try {
		String sql = "SELECT * FROM cadaluno";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			int RgmAluno=rs.getInt(1);
			String disciplina=rs.getString(2);
			String semestre = rs.getString(3);
			double nota = rs.getDouble(4);
			int faltas = rs.getInt(5);
			list.add(new Leitor2(RgmAluno, semestre, nota,faltas,disciplina));
			 
			 
		}
		return list;
		
	} catch(Exception e) {
		throw new Exception("Erro ao listar "+ e.getMessage());
	}
		
	
}

public Leitor2 consultar(int RgmAluno) throws Exception {

	try {
		String SQL = "SELECT * FROM notafalta WHERE RgmAluno=?";
		conn = this.conn;
		ps = conn.prepareStatement(SQL);
		ps.setInt(1, RgmAluno);			
		rs = ps.executeQuery();
		if (rs.next()) {
			int Rgm = rs.getInt(1);
			String semestre = rs.getString(2);
			double nota=rs.getDouble(3);
			int faltas=rs.getInt(4);
			String disciplina=rs.getString(5);
	
			leitor2 = new Leitor2(Rgm, semestre, nota,faltas,disciplina);
		}
		return leitor2;
	} catch (SQLException sqle) {
		throw new Exception(sqle);
	}
}
}
	
	
	
	
	
	
	
	
		

	


