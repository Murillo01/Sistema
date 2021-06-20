package br.com.mvc.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.mvc.dao.LeitorDAO;
import br.com.mvc.dao.LeitorDAO2;
import br.com.mvc.model.Leitor;
import br.com.mvc.model.Leitor2;




public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAluno;
	private JMenu mnNotaseFaltas;
	private JMenu mnAjuda;
	private JMenuItem ItmSalvarA;
	private JMenuItem ItmAlterarA;
	private JMenuItem itmConsultarA;
	private JMenuItem itmExcluirA;
	private JMenuItem itmSairA;
	private JSeparator separator;
	private JMenuItem itmSalvarNF;
	private JMenuItem ItmAlterarNF;
	private JMenuItem ItmExcluirNF;
	private JMenuItem ItmConsultarNF;
	private JMenuItem ItmSobre;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JFormattedTextField txtRgmAluno;
	private JFormattedTextField txtDataNasc;
	private JComboBox txtUF;
	private JFormattedTextField txtCelular;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JComboBox cmbCampus;
	private JLabel lblNewLabel_11;
	private JRadioButton rdbMatutino;
	private JRadioButton rdbVespertino;
	private JRadioButton rdbNoturno;
	private JButton btnPowerC;
	private JComboBox CursoAluno;
	private JButton btnPastaAzuC;
	private JButton btnPastaAC;
	private JButton btnJARC;
	private JButton btnJavaC;
	private JButton btnArquivoANT;
	private JButton btnArquivoAzuNT;
	private JButton btnJARNT;
	private JButton btnJAVANT;
	private JButton btnPOWERNT;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JComboBox cmbSemestre;
	private JComboBox cmbDisciplinaNotaseFaltas;
	private JFormattedTextField RgmAluno2;
	private JLabel lblNomeDoAluno;
	private JLabel lblCursoAluno;
	private JLabel lblNewLabel_17;
	private JFormattedTextField txtRGMboletim;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNomeBoletim;
	private JLabel lblCursoBoletim;
	private JLabel lblFaltasBoletim;
	private JLabel lblNewLabel_24;
	private JFormattedTextField txtNomeAluno;
	private JFormattedTextField txtEndAluno;
	private JFormattedTextField txtMunicipio;
	private JFormattedTextField txtEmailAluno;
	private final ButtonGroup Periodo = new ButtonGroup();
	private JTextField txtNotaFalta;
	private TextArea txtArNotas;
	private TextArea txtArDisciplinas;
	private JButton btnBuscar;
	private JLabel lblResposta;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JFormattedTextField txtCpfAluno;
	private JButton btnBuscarNotasFaltas;
	private JTextField txtNota;
	private Leitor leitor;
	private LeitorDAO dao;
	private LeitorDAO2 dao2;
	private Leitor2 leitor2;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() throws Exception  {
		setTitle("Cadastro de Aluno"); // esse throws é para a formatação do campo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 447);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAluno = new JMenu("Aluno");
		mnAluno.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnAluno);
		
		ItmSalvarA = new JMenuItem("Salvar");
		ItmSalvarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					leitor = new Leitor();
					leitor.setRgmAluno(Integer.parseInt(txtRgmAluno.getText()));
					leitor.setNomeAluno(txtNomeAluno.getText());
					leitor.setDataNasc(txtDataNasc.getText());
					leitor.setCpfAluno(txtCpfAluno.getText());
					leitor.setEmailAluno(txtEmailAluno.getText());
					leitor.setEndAluno(txtEndAluno.getText());
					leitor.setMunicipio(txtMunicipio.getText());
					leitor.setCelular(txtCelular.getText());
					leitor.setUF((String)txtUF.getSelectedItem());
					leitor.setCursoAluno((String)CursoAluno.getSelectedItem());
					leitor.setCampus((String)cmbCampus.getSelectedItem());
					if(rdbMatutino.isSelected()) {
						leitor.setPeriodo((String) "Matutino");
					}
					else if(rdbVespertino.isSelected()) {
						leitor.setPeriodo((String) "Vespertino");
					}
					else {
						leitor.setPeriodo((String) "Noturno");
					}
					
					dao = new LeitorDAO();
					dao.salvar(leitor);
					System.out.println("Salvo com sucesso");
					
				} catch (Exception e2) {
					System.out.println("Erro ao salvar "+e2);
				}
				
			}
		});
		ItmSalvarA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		ItmSalvarA.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnAluno.add(ItmSalvarA);
		
		ItmAlterarA = new JMenuItem("Alterar");
		ItmAlterarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//========================================================
				try {
				leitor=new Leitor();
				leitor.setRgmAluno(Integer.parseInt(txtRgmAluno.getText()));
				leitor.setNomeAluno(txtNomeAluno.getText());
				leitor.setDataNasc(txtDataNasc.getText());
				leitor.setCpfAluno(txtCpfAluno.getText());
				leitor.setEmailAluno(txtEmailAluno.getText());
				leitor.setEndAluno(txtEndAluno.getText());
				leitor.setMunicipio(txtMunicipio.getText());
				leitor.setCelular(txtCelular.getText());
				leitor.setUF((String)txtUF.getSelectedItem());
				leitor.setCursoAluno((String)CursoAluno.getSelectedItem());
				leitor.setCampus((String)cmbCampus.getSelectedItem());
				if(rdbMatutino.isSelected()) {
					leitor.setPeriodo((String) "Matutino");
				}
				else if(rdbVespertino.isSelected()) {
					leitor.setPeriodo((String) "Vespertino");
				}
				else {
					leitor.setPeriodo((String) "Noturno");
				}
				dao = new LeitorDAO();
				dao.alterar(leitor);
				
				System.out.println("Alterado com sucesso");
				}catch(Exception e) {
					System.out.println("Erro ao alterar "+e);
				}
				//========================================================
				
			}
		});
		ItmAlterarA.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnAluno.add(ItmAlterarA);
		
		itmConsultarA = new JMenuItem("Consultar");
		itmConsultarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				dao=new LeitorDAO();
				int rgm=Integer.parseInt(txtRgmAluno.getText());
				leitor=dao.consultar(rgm);
				txtNomeAluno.setText(leitor.getNomeAluno());
				txtUF.setSelectedItem(leitor.getUF());
				txtDataNasc.setText(leitor.getDataNasc());
				txtEmailAluno.setText(leitor.getEmailAluno());
				txtEndAluno.setText(leitor.getEndAluno());
				txtCelular.setText(leitor.getCelular());
				txtCpfAluno.setText(leitor.getCpfAluno());
				txtMunicipio.setText(leitor.getMunicipio());
				CursoAluno.setSelectedItem(leitor.getCursoAluno());
				cmbCampus.setSelectedItem(leitor.getCampus());
				if(leitor.getPeriodo().equalsIgnoreCase("Matutino")) {
					rdbMatutino.setSelected(true);
				}
				else if(leitor.getPeriodo().equalsIgnoreCase("Vespertino")) {
					rdbVespertino.setSelected(true);
				}
				else {
					rdbNoturno.setSelected(true);
				}
				
				
				}catch(Exception e1) {
					System.out.println("Erro ao consultar "+e1);
				}
			}
		});
		itmConsultarA.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnAluno.add(itmConsultarA);
		
		itmExcluirA = new JMenuItem("Excluir");
		itmExcluirA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//========================================================
				try {
					dao = new LeitorDAO();
					dao.excluir(Integer.parseInt(txtRgmAluno.getText()));
					
					System.out.println("Excluido com sucesso");
					}catch(Exception e) {
						System.out.println("Erro ao excluir "+e);
					}
				//========================================================	
				
			}
		});
		itmExcluirA.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnAluno.add(itmExcluirA);
		
		separator = new JSeparator();
		mnAluno.add(separator);
		
		itmSairA = new JMenuItem("Sair");
		itmSairA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//========================================================
				JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema!!");
				System.exit(0);
			}//========================================================
		});
		itmSairA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
		itmSairA.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnAluno.add(itmSairA);
		
		mnNotaseFaltas = new JMenu("Notas e Faltas");
		mnNotaseFaltas.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNotaseFaltas);
		
		itmSalvarNF = new JMenuItem("Salvar");
		itmSalvarNF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//========================================================
				try{
				Leitor2 leitor2=new Leitor2();
				leitor2.setRgmAluno(Integer.parseInt(RgmAluno2.getText()));
				leitor2.setDisciplina((String) cmbDisciplinaNotaseFaltas.getSelectedItem());
				leitor2.setFaltas(Integer.parseInt(txtNotaFalta.getText()));
				leitor2.setSemestre(((String) cmbSemestre.getSelectedItem()));
				leitor2.setNota(Double.parseDouble((String)txtNota.getText()));
				LeitorDAO2 dao2=new LeitorDAO2();
				dao2.salvar(leitor2);
				System.out.println("Salvo com sucesso 2");
				}catch(Exception e) {
					e.printStackTrace();
				}
				//========================================================
			}
		});
		itmSalvarNF.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNotaseFaltas.add(itmSalvarNF);
		
		ItmAlterarNF = new JMenuItem("Alterar");
		ItmAlterarNF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				leitor2=new Leitor2();
				leitor2.setRgmAluno(Integer.parseInt(RgmAluno2.getText()));
				leitor2.setDisciplina((String) cmbDisciplinaNotaseFaltas.getSelectedItem());
				leitor2.setFaltas(Integer.parseInt(txtNotaFalta.getText()));
				leitor2.setNota(Double.parseDouble(txtNota.getText()));
				leitor2.setSemestre((String) cmbSemestre.getSelectedItem());
				dao2 = new LeitorDAO2();
				dao2.alterar(leitor2);
				
				}catch(Exception e) {
					System.out.println("Erro ao alterar "+e);
				}
			}
		});
		ItmAlterarNF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		ItmAlterarNF.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNotaseFaltas.add(ItmAlterarNF);
		
		ItmExcluirNF = new JMenuItem("Excluir");
		ItmExcluirNF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dao2 = new LeitorDAO2();
					dao2.excluir(Integer.parseInt(RgmAluno2.getText()));
					
					System.out.println("Excluido com sucesso");
					}catch(Exception e) {
						System.out.println("Erro ao excluir "+e);
					}
				
			
			}
		});
		ItmExcluirNF.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNotaseFaltas.add(ItmExcluirNF);
		
		ItmConsultarNF = new JMenuItem("Consultar");
		ItmConsultarNF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				dao2=new LeitorDAO2();
				int rgm=Integer.parseInt(RgmAluno2.getText());
				leitor2=dao2.consultar(rgm);
				cmbSemestre.setSelectedItem(leitor2.getSemestre());
				cmbDisciplinaNotaseFaltas.setSelectedItem(leitor2.getDisciplina());
				txtNota.setText(String.valueOf(leitor2.getNota()));
				txtNotaFalta.setText(String.valueOf(leitor2.getFaltas()));
			}catch(Exception e1) {
				System.out.println("Erro ao consultar "+e1);
			}
			}
		});
		ItmConsultarNF.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNotaseFaltas.add(ItmConsultarNF);
		
		mnAjuda = new JMenu("Ajuda\r\n");
		mnAjuda.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnAjuda);
		
		ItmSobre = new JMenuItem("Sobre");
		ItmSobre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnAjuda.add(ItmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(37, 26, 628, 321);
		contentPane.add(tabbedPane);
		
		txtCelular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		txtCelular.setToolTipText("Digite seu Celular");
		txtCelular.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCelular.setBounds(459, 249, 154, 29);
		
		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("RGM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 30, 45, 34);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(10, 94, 135, 13);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(10, 155, 45, 13);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(10, 201, 72, 22);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Munic\u00EDpio");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(10, 256, 72, 19);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("UF");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(295, 256, 45, 13);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Celular");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setBounds(409, 256, 55, 13);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("CPF");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setBounds(372, 94, 45, 13);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Nome");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setBounds(270, 41, 45, 13);
		panel.add(lblNewLabel_8);
		
		txtRgmAluno = new JFormattedTextField(new MaskFormatter("########"));
		txtRgmAluno.setBackground(Color.WHITE);
		txtRgmAluno.setToolTipText("Digite seu RGM");
		txtRgmAluno.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtRgmAluno.setBounds(65, 34, 166, 29);
		panel.add(txtRgmAluno);
		
		txtDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtDataNasc.setToolTipText("Digite sua data de nascimento");
		txtDataNasc.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDataNasc.setBounds(164, 87, 166, 29);
		panel.add(txtDataNasc);
		
		
		txtUF = new JComboBox();
		txtUF.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		txtUF.setBounds(317, 254, 82, 21);
		panel.add(txtUF);
		panel.add(txtCelular);
		
		txtNomeAluno = new JFormattedTextField();
		txtNomeAluno.setToolTipText("Digite seu nome");
		txtNomeAluno.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNomeAluno.setBounds(317, 33, 296, 31);
		panel.add(txtNomeAluno);
		txtNomeAluno.setColumns(10);
		
		txtEndAluno = new JFormattedTextField();
		txtEndAluno.setToolTipText("Digite seu endere\u00E7o");
		txtEndAluno.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEndAluno.setBounds(87, 200, 423, 29);
		panel.add(txtEndAluno);
		txtEndAluno.setColumns(10);
		
		txtMunicipio = new JFormattedTextField();
		txtMunicipio.setToolTipText("Digite seu munic\u00EDpio");
		txtMunicipio.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(77, 250, 208, 29);
		panel.add(txtMunicipio);
		
		txtEmailAluno = new JFormattedTextField();
		txtEmailAluno.setToolTipText("Digite seu Email - N\u00E3o se esque\u00E7a do @ e do .com");
		txtEmailAluno.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEmailAluno.setColumns(10);
		txtEmailAluno.setBounds(87, 149, 423, 29);
		panel.add(txtEmailAluno);
		
		txtCpfAluno = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpfAluno.setToolTipText("Digite seu Cpf");
		txtCpfAluno.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCpfAluno.setBackground(Color.WHITE);
		txtCpfAluno.setBounds(429, 87, 166, 29);
		panel.add(txtCpfAluno);
		
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel_9 = new JLabel("Curso");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(20, 41, 66, 23);
		panel_1.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Campus");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(20, 95, 75, 23);
		panel_1.add(lblNewLabel_10);
		
		cmbCampus = new JComboBox();
		cmbCampus.setFont(new Font("Tahoma", Font.BOLD, 13));
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Selecione o campus:", "Campus Tatuape", "Campus Pinheiros", "Campus Virtual"}));
		cmbCampus.setBounds(145, 94, 437, 33);
		panel_1.add(cmbCampus);
		
		lblNewLabel_11 = new JLabel("Per\u00EDodo");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(20, 163, 75, 17);
		panel_1.add(lblNewLabel_11);
		
		rdbMatutino = new JRadioButton("Matutino");
		Periodo.add(rdbMatutino);
		rdbMatutino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbMatutino.setBounds(159, 163, 103, 21);
		panel_1.add(rdbMatutino);
		
		rdbVespertino = new JRadioButton("Vespertino");
		Periodo.add(rdbVespertino);
		rdbVespertino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbVespertino.setBounds(278, 163, 103, 21);
		panel_1.add(rdbVespertino);
		
		rdbNoturno = new JRadioButton("Noturno\r\n");
		Periodo.add(rdbNoturno);
		rdbNoturno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbNoturno.setBounds(397, 163, 103, 21);
		panel_1.add(rdbNoturno);
		
		btnPowerC = new JButton("");
		btnPowerC.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\power-off.png"));
		btnPowerC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPowerC.setSelectedIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\power-button.png"));
		btnPowerC.setBounds(30, 202, 85, 71);
		panel_1.add(btnPowerC);
		
		CursoAluno = new JComboBox();
		CursoAluno.setModel(new DefaultComboBoxModel(new String[] {"Selecione o curso:", "Arquitetura e Urbanismo", "Design de Interiores", "Design Grafico", "Comunicacao", "Fotografia", "Publicidade e Propaganda", "Direito", "Educacao Fisica", "Historia", "Letras \u2013 Portugues/Ingles", "Pedagogia", "Analise e Desenvolvimento de Sistemas", "Ciencia da Computacao", "Engenharia Civil", "Engenharia de Producao", "Engenharia Eletrica", "Engenharia Mecanica", "Engenharia Mecatronica", "Gestao da Tecnologia da Informacao", "Redes de Computadores", "Biomedicina;", "Ciencias Biologicas;", "Educa\u00E7ao Fisica;", "Enfermagem;", "Farmacia;", "Fisioterapia;", "Gestao Hospitalar;", "Medicina;", "Nutricao;", "Odontologia."}));
		CursoAluno.setFont(new Font("Tahoma", Font.BOLD, 13));
		CursoAluno.setBounds(145, 31, 437, 33);
		panel_1.add(CursoAluno);
		
		btnPastaAzuC = new JButton("");
		btnPastaAzuC.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\Azul.png"));
		btnPastaAzuC.setSelectedIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\folder.png"));
		btnPastaAzuC.setBounds(145, 202, 85, 71);
		panel_1.add(btnPastaAzuC);
		
		btnPastaAC = new JButton("");
		btnPastaAC.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\folderA.png"));
		btnPastaAC.setBounds(267, 202, 85, 71);
		panel_1.add(btnPastaAC);
		
		btnJARC = new JButton("");
		btnJARC.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\arquivo-jar.png"));
		btnJARC.setBounds(388, 202, 85, 71);
		panel_1.add(btnJARC);
		
		btnJavaC = new JButton("");
		btnJavaC.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\java (1).png"));
		btnJavaC.setSelectedIcon(new ImageIcon("C:\\Users\\lucas\\Downloads\\java (1).png"));
		btnJavaC.setBounds(507, 202, 85, 71);
		panel_1.add(btnJavaC);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);
		
		btnArquivoANT = new JButton("");
		btnArquivoANT.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\folderA.png"));
		btnArquivoANT.setBounds(31, 213, 85, 71);
		panel_2.add(btnArquivoANT);
		
		btnArquivoAzuNT = new JButton("");
		btnArquivoAzuNT.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\Azul.png"));
		btnArquivoAzuNT.setBounds(146, 213, 85, 71);
		panel_2.add(btnArquivoAzuNT);
		
		btnJARNT = new JButton("");
		btnJARNT.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\arquivo-jar.png"));
		btnJARNT.setBounds(268, 213, 85, 71);
		panel_2.add(btnJARNT);
		
		btnJAVANT = new JButton("");
		btnJAVANT.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\java (1).png"));
		btnJAVANT.setBounds(389, 213, 85, 71);
		panel_2.add(btnJAVANT);
		
		btnPOWERNT = new JButton("");
		btnPOWERNT.setIcon(new ImageIcon("C:\\Users\\lucas\\eclipse-workspace\\ProjetoMVC\\Imagens\\power-off.png"));
		btnPOWERNT.setBounds(508, 213, 85, 71);
		panel_2.add(btnPOWERNT);
		
		lblNewLabel_12 = new JLabel("RGM\r\n");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(22, 31, 45, 13);
		panel_2.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Disciplina");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(22, 122, 67, 19);
		panel_2.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Semestre\r\n");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14.setBounds(22, 173, 67, 13);
		panel_2.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Nota");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_15.setBounds(296, 173, 45, 13);
		panel_2.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Faltas\r\n");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_16.setBounds(439, 173, 45, 13);
		panel_2.add(lblNewLabel_16);
		
		cmbSemestre = new JComboBox();
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"", "2019-1", "2019-2", "2020-1", "2020-2", "2021-1", "2021-2"}));
		cmbSemestre.setFont(new Font("Tahoma", Font.BOLD, 13));
		cmbSemestre.setBounds(99, 171, 173, 21);
		panel_2.add(cmbSemestre);
		
		
		cmbDisciplinaNotaseFaltas = new JComboBox();
		cmbDisciplinaNotaseFaltas.setModel(new DefaultComboBoxModel(new String[] {"", "Engenharia de Software", "Analise de Requisitos", "Tecnicas de Programacao", "Direito Penal ", "Direito Civil", "Direito Penal", "Saude coletiva", "Estrategia da saude da familia", "Fundamentos tecnicos de Enfermagem", "Cenografia e Perspectiva.", "Conforto Ambiental.", "Desenho Tecnico.", "Desenho Artistico.", "Desenho Tecnico.", "Introdu\u00E7ao a Gestao de Projetos", "Biologia Celular e Molecular.", "Fisiologia. ", "Histologia", "Anatomia.", "Avaliacao Nutricional.", "Biologia Celular.", "Desenho Tecnico. ", "Calculo. ", "Fisica Geral e Experimental. ", "Comunica\u00E7ao e Expressao.", "Etica e Legisla\u00E7ao.", "Fotografia Cientifica."}));
		cmbDisciplinaNotaseFaltas.setFont(new Font("Tahoma", Font.BOLD, 13));
		cmbDisciplinaNotaseFaltas.setBounds(99, 120, 494, 21);
		panel_2.add(cmbDisciplinaNotaseFaltas);
		
		RgmAluno2 = new JFormattedTextField(new MaskFormatter("########"));
		RgmAluno2.setFont(new Font("Tahoma", Font.BOLD, 13));
		RgmAluno2.setBounds(71, 24, 160, 31);
		panel_2.add(RgmAluno2);
		
		lblNomeDoAluno = new JLabel("");
		lblNomeDoAluno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomeDoAluno.setForeground(Color.BLACK);
		lblNomeDoAluno.setBackground(Color.WHITE);
		lblNomeDoAluno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNomeDoAluno.setBounds(374, 21, 219, 36);
		panel_2.add(lblNomeDoAluno);
		
		lblCursoAluno = new JLabel("");
		lblCursoAluno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCursoAluno.setForeground(Color.BLACK);
		lblCursoAluno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblCursoAluno.setBackground(Color.WHITE);
		lblCursoAluno.setBounds(22, 74, 571, 36);
		panel_2.add(lblCursoAluno);
		
		txtNotaFalta = new JTextField();
		txtNotaFalta.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNotaFalta.setBounds(494, 166, 96, 31);
		panel_2.add(txtNotaFalta);
		txtNotaFalta.setColumns(10);
		
		btnBuscarNotasFaltas = new JButton("buscar\r\n");
		btnBuscarNotasFaltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				dao2=new LeitorDAO2();
				dao=new LeitorDAO();
				int rgm=Integer.parseInt(RgmAluno2.getText());
				leitor=dao.consultar(rgm);
				lblNomeDoAluno.setText(leitor.getNomeAluno());
				lblCursoAluno.setText(leitor.getCursoAluno());
				
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnBuscarNotasFaltas.setBounds(256, 29, 85, 19);
		panel_2.add(btnBuscarNotasFaltas);
		
		txtNota = new JTextField();
		txtNota.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNota.setColumns(10);
		txtNota.setBounds(336, 169, 96, 31);
		panel_2.add(txtNota);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);
		
		lblNewLabel_17 = new JLabel("Digite o RGM:");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_17.setBounds(10, 21, 133, 31);
		panel_3.add(lblNewLabel_17);
		
		txtRGMboletim = new JFormattedTextField(new MaskFormatter("########"));
		txtRGMboletim.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtRGMboletim.setBounds(142, 24, 237, 31);
		panel_3.add(txtRGMboletim);
		
		lblNewLabel_18 = new JLabel("Nome");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_18.setBounds(10, 71, 76, 31);
		panel_3.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("Curso");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_19.setBounds(10, 136, 76, 31);
		panel_3.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("Notas");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_20.setBounds(10, 220, 76, 31);
		panel_3.add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel("Faltas");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_21.setBounds(449, 136, 58, 31);
		panel_3.add(lblNewLabel_21);
		
		lblNomeBoletim = new JLabel("");
		lblNomeBoletim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomeBoletim.setForeground(Color.BLACK);
		lblNomeBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNomeBoletim.setBounds(85, 77, 428, 37);
		panel_3.add(lblNomeBoletim);
		
		lblCursoBoletim = new JLabel("");
		lblCursoBoletim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCursoBoletim.setForeground(Color.BLACK);
		lblCursoBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblCursoBoletim.setBounds(85, 137, 339, 37);
		panel_3.add(lblCursoBoletim);
		
		lblFaltasBoletim = new JLabel("");
		lblFaltasBoletim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFaltasBoletim.setForeground(Color.BLACK);
		lblFaltasBoletim.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblFaltasBoletim.setBounds(510, 137, 103, 37);
		panel_3.add(lblFaltasBoletim);
		
		lblNewLabel_24 = new JLabel("Disciplinas");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_24.setBounds(318, 220, 103, 31);
		panel_3.add(lblNewLabel_24);
		
		txtArNotas = new TextArea();
		txtArNotas.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtArNotas.setBounds(85, 183, 187, 101);
		panel_3.add(txtArNotas);
		
		txtArDisciplinas = new TextArea();
		txtArDisciplinas.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtArDisciplinas.setBounds(426, 183, 187, 101);
		panel_3.add(txtArDisciplinas);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					
				//	dao = new LeitorDAO();
					//int rgm = Integer.parseInt(txtRGMboletim.getText());
					//leitor = dao.consultar(rgm);
					//txt
					
					
					
					
				} catch(Exception e1) {

					lblResposta.setText("Erro ao consultar");
				}
				
				
				
				
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscar.setBounds(389, 29, 85, 21);
		panel_3.add(btnBuscar);
		
		lblResposta = new JLabel("");
		lblResposta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblResposta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblResposta.setBounds(495, 22, 118, 37);
		panel_3.add(lblResposta);
	}
	
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
