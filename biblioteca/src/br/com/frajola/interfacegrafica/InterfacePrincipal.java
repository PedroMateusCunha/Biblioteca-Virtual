package br.com.frajola.interfacegrafica;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfacePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	// #Declaracao dos Componentes do Painel Inicial#//
	private JPanel pnlInicial;
	private JButton btnAdicionar, btnRemover, btnEditar, btnConsultar;
	// # Declaracao dos Componentes do Painel de Adicionar#//
	private JPanel pnlAdicionar;
	private JLabel lblTitulo, lblAutor, lblAno, lblEditora, lblIsbn;
	private JTextField txtTitulo, txtAutor, txtAno, txtEditora, txtIsbn;
	// #Declaracao do Layout#//
	private GridBagLayout layout;
	// #Declaracao dos GridBagContainers#//
	private GridBagConstraints gbcGenerico;
	// #Declaracao de Tabela do Painel de Consulta#//
	private JPanel pnlConsulta;
	private DefaultTableModel dflTabela;
	private JTable tblTabela;

	public InterfacePrincipal() {

		// #Instancia do Layout#//
		layout = new GridBagLayout();

		// #Criação do Frame Inicial#//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400, 400));
		setLocationRelativeTo(null);
		setTitle("Biblioteca");
		//setLayout(layout);

		// #Instancia do GridBagContainers#//
		gbcGenerico = new GridBagConstraints();
		GridBagConstraints gbcTeste = new GridBagConstraints();

		// #Instancias de Paineis#//
		pnlInicial = new JPanel();
		pnlInicial.setLayout(layout);
		pnlAdicionar = new JPanel();
		pnlConsulta = new JPanel();
		pnlConsulta.setLayout(layout);

		// #Instancias do Painel Inicial#//
		btnAdicionar = new JButton("Adicionar");
		btnRemover = new JButton("Remover");
		btnEditar = new JButton("Editar");
		btnConsultar = new JButton("Consultar");
		
		// #Instancias do Painel de Adicionar#//
		lblTitulo = new JLabel("Titulo");
		lblAutor = new JLabel("Autor");
		lblAno = new JLabel("Ano");
		lblEditora = new JLabel("Editora");
		lblIsbn = new JLabel("ISBN");
		
		txtTitulo = new JTextField();
		txtAutor = new JTextField();
		txtAno = new JTextField();
		txtEditora = new JTextField();
		txtIsbn = new JTextField();
		
		btnAdicionar = new JButton("Adicionar");
		
		// #Instancias do Painel de Consulta#//
		JButton btnTeste = new JButton();
		// #Instancias de Tabela do Painel de Consulta#//
		dflTabela = new DefaultTableModel();
		tblTabela = new JTable();

		// #Congiguracao da Tabela#//
		dflTabela = new DefaultTableModel();
		dflTabela.addColumn("Titulo");
		dflTabela.addColumn("Autor");
		dflTabela.addColumn("Ano");
		dflTabela.addColumn("Editora");
		dflTabela.addColumn("ISBN");


		// #Implementacao dos ActionListener do Painel Inicial#//
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnAdicionar) {
					trocarPainel(pnlAdicionar);
				}
			}
		});
		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dflTabela.insertRow(0, new Object[] { lblTitulo.getText(), lblAutor.getText(), lblAno.getText(),
						lblEditora.getText(), lblIsbn.getText() });
				tblTabela = new JTable(dflTabela);
				getContentPane().add(new JScrollPane(tblTabela));
				adicionarComponente(pnlConsulta, tblTabela, gbcTeste, 1, 1, 0, 0);
				trocarPainel(pnlConsulta);				
			}
		});

		// #Adição dos Botoes com GridBagLayout#//
		adicionarComponente(pnlInicial, btnAdicionar, gbcGenerico, 1, 1, 0, 0);
		adicionarComponente(pnlInicial, btnRemover, gbcGenerico, 1, 1, 1, 0);
		adicionarComponente(pnlInicial, btnEditar, gbcGenerico, 1, 1, 2, 0);
		adicionarComponente(pnlInicial, btnConsultar, gbcGenerico, 1, 1, 3, 0);

		// #Visualização do Frame#//
		getContentPane().add(pnlInicial);
		pack();
		setVisible(true);

	}

	public static void main(String[] args) {
		new InterfacePrincipal();
	}

	public void adicionarComponente(JPanel painel, Component componente, GridBagConstraints gbc, int largura,
			int altura, int coluna, int linha) {
		gbc.gridwidth = largura;
		gbc.gridheight = altura;
		gbc.gridx = coluna;
		gbc.gridy = linha;
		painel.add(componente, gbc);
	}

	public void trocarPainel(JPanel pnlTroca) {
		getContentPane().removeAll();
		getContentPane().add(pnlTroca);
		revalidate();
		repaint();
	}

}
