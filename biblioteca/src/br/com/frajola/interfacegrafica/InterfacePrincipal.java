package br.com.frajola.interfacegrafica;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.frajola.biblioteca.Biblioteca;
import br.com.frajola.exemplares.Livro;
import br.com.frajola.exemplares.Revista;
import br.com.frajola.exemplares.TCC;

public class InterfacePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pnlInicial, pnlAdicionar, pnlRemover, pnlConsulta;
	private JButton btnAdicionar, btnRemover, btnEditar, btnConsultar, btnAdicionarExemplar, btnVoltar;
	private JLabel lblTitulo, lblAutor, lblAno, lblEditora, lblIsbn, lblTipo, lblOrientador, lblAreaDeConhecimento;
	private JTextField txtTitulo, txtAutor, txtAno, txtEditora, txtIsbn, txtTipo, txtOrientador, txtAreaDeConhecimento;
	private JComboBox<String> cbxOpcoesExemplares;
	private Biblioteca biblioteca;
	private GridBagLayout layout;
	private GridBagConstraints gbcGenerico;
	private DefaultTableModel dflTabela;
	private JTable tblTabela;

	public InterfacePrincipal() {

		// #Instancia do Layout#//
		layout = new GridBagLayout();

		// #Criação do Frame Inicial#//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 300));
		// setLocationRelativeTo(null);
		setTitle("Biblioteca");
		// setLayout(layout);

		// #Instancia do GridBagContainers#//
		gbcGenerico = new GridBagConstraints();

		// #Instancias de Paineis#//
		pnlInicial = new JPanel();
		pnlInicial.setLayout(layout);
		pnlAdicionar = new JPanel();
		pnlAdicionar.setLayout(layout);
		pnlConsulta = new JPanel();
		pnlConsulta.setLayout(layout);
		pnlRemover = new JPanel();
		pnlRemover.setLayout(layout);

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
		lblTipo = new JLabel("Tipo");
		lblOrientador = new JLabel("Orientador");
		lblAreaDeConhecimento = new JLabel("Area de Conhecimento");

		txtTitulo = new JTextField();
		txtAutor = new JTextField();
		txtAno = new JTextField();
		txtEditora = new JTextField();
		txtIsbn = new JTextField();
		txtTipo = new JTextField();
		txtOrientador = new JTextField();
		txtAreaDeConhecimento = new JTextField();

		btnAdicionarExemplar = new JButton("Adicionar");
		btnVoltar = new JButton("Voltar");

		biblioteca = new Biblioteca();

		String[] tipos = { "Selecione o tipo de Exemplar", "Livro", "TCC", "Revista" };
		cbxOpcoesExemplares = new JComboBox<String>(tipos);
		cbxOpcoesExemplares.setSelectedIndex(0);
		
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
				if (arg0.getSource() == btnRemover) {
					trocarPainel(pnlRemover);
				}

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

				if (arg0.getSource() == btnConsultar) {
					dflTabela.insertRow(0, new Object[] { lblTitulo.getText(), lblAutor.getText(), lblAno.getText(),
							lblEditora.getText(), lblIsbn.getText() });
					tblTabela = new JTable(dflTabela);
					getContentPane().add(new JScrollPane(tblTabela));
					adicionarComponente(pnlConsulta, tblTabela, gbcGenerico, 1, 1, 0, 0);
					trocarPainel(pnlConsulta);
				}
			}
		});

		// #Implementacao dos Action Listeners do Painel Adicionar#//

		cbxOpcoesExemplares.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String tipos = (String) cbxOpcoesExemplares.getSelectedItem();

				switch (tipos) {
				case "Livro":
					System.out.println("LIVRO");
					adicionarComponente(pnlAdicionar, lblTitulo, gbcGenerico, 1, 1, 1, 1);
					adicionarComponente(pnlAdicionar, txtTitulo, gbcGenerico, 1, 1, 2, 1);
					adicionarComponente(pnlAdicionar, lblAutor, gbcGenerico, 1, 1, 1, 2);
					adicionarComponente(pnlAdicionar, txtAutor, gbcGenerico, 1, 1, 2, 2);
					adicionarComponente(pnlAdicionar, lblAno, gbcGenerico, 1, 1, 1, 3);
					adicionarComponente(pnlAdicionar, txtAno, gbcGenerico, 1, 1, 2, 3);
					adicionarComponente(pnlAdicionar, lblEditora, gbcGenerico, 1, 1, 1, 4);
					adicionarComponente(pnlAdicionar, txtEditora, gbcGenerico, 1, 1, 2, 4);
					adicionarComponente(pnlAdicionar, lblIsbn, gbcGenerico, 1, 1, 1, 5);
					adicionarComponente(pnlAdicionar, txtIsbn, gbcGenerico, 1, 1, 2, 5);
					break;
				case "TCC":
					adicionarComponente(pnlAdicionar, lblTitulo, gbcGenerico, 1, 1, 1, 1);
					adicionarComponente(pnlAdicionar, txtTitulo, gbcGenerico, 1, 1, 2, 1);
					adicionarComponente(pnlAdicionar, lblAutor, gbcGenerico, 1, 1, 1, 2);
					adicionarComponente(pnlAdicionar, txtAutor, gbcGenerico, 1, 1, 2, 2);
					adicionarComponente(pnlAdicionar, lblAno, gbcGenerico, 1, 1, 1, 3);
					adicionarComponente(pnlAdicionar, txtAno, gbcGenerico, 1, 1, 2, 3);
					adicionarComponente(pnlAdicionar, lblEditora, gbcGenerico, 1, 1, 1, 4);
					adicionarComponente(pnlAdicionar, txtEditora, gbcGenerico, 1, 1, 2, 4);
					adicionarComponente(pnlAdicionar, lblOrientador, gbcGenerico, 1, 1, 1, 5);
					adicionarComponente(pnlAdicionar, txtOrientador, gbcGenerico, 1, 1, 2, 5);
					adicionarComponente(pnlAdicionar, lblAreaDeConhecimento, gbcGenerico, 1, 1, 1, 6);
					adicionarComponente(pnlAdicionar, txtAreaDeConhecimento, gbcGenerico, 1, 1, 2, 6);
					System.out.println("TCC");
					break;
				case "Revista":
					adicionarComponente(pnlAdicionar, lblTitulo, gbcGenerico, 1, 1, 1, 1);
					adicionarComponente(pnlAdicionar, txtTitulo, gbcGenerico, 1, 1, 2, 1);
					adicionarComponente(pnlAdicionar, lblAutor, gbcGenerico, 1, 1, 1, 2);
					adicionarComponente(pnlAdicionar, txtAutor, gbcGenerico, 1, 1, 2, 2);
					adicionarComponente(pnlAdicionar, lblAno, gbcGenerico, 1, 1, 1, 3);
					adicionarComponente(pnlAdicionar, txtAno, gbcGenerico, 1, 1, 2, 3);
					adicionarComponente(pnlAdicionar, lblEditora, gbcGenerico, 1, 1, 1, 4);
					adicionarComponente(pnlAdicionar, txtEditora, gbcGenerico, 1, 1, 2, 4);
					adicionarComponente(pnlAdicionar, lblIsbn, gbcGenerico, 1, 1, 1, 5);
					adicionarComponente(pnlAdicionar, txtIsbn, gbcGenerico, 1, 1, 2, 5);
					adicionarComponente(pnlAdicionar, lblTipo, gbcGenerico, 1, 1, 1, 6);
					adicionarComponente(pnlAdicionar, txtTipo, gbcGenerico, 1, 1, 2, 6);
					System.out.println("REVISTA");
					break;
				default:
					System.out.println("DEFAULT");
					break;
				}
			}
		});
		gbcGenerico.fill = GridBagConstraints.HORIZONTAL;
		adicionarComponente(pnlAdicionar, btnAdicionarExemplar, gbcGenerico, 2, 1, 1, 7);
		adicionarComponente(pnlAdicionar, btnVoltar, gbcGenerico, 2, 1, 1, 8);
		btnAdicionarExemplar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cbxOpcoesExemplares.getSelectedItem() == "Livro") {
					biblioteca.adicionarExemplar(new Livro(txtTitulo.getText(), txtAutor.getText(),
							Integer.valueOf(txtAno.getText()), txtEditora.getText(), txtIsbn.getText()));
				} else if (cbxOpcoesExemplares.getSelectedItem() == "TCC") {
					biblioteca.adicionarExemplar(
							new TCC(txtTitulo.getText(), txtAutor.getText(), Integer.valueOf(txtAno.getText()),
									txtOrientador.getText(), txtAreaDeConhecimento.getText()));
				} else if (cbxOpcoesExemplares.getSelectedItem() == "Revista") {
					biblioteca.adicionarExemplar(new Revista(txtTitulo.getText(), txtAutor.getText(),
							Integer.valueOf(txtAno.getText()), txtTipo.getText(), txtEditora.getText()));
				}

			}
		});

		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				trocarPainel(pnlInicial);

			}
		});

		//#Adicao dos Componentes do Painel Remover#//
		adicionarComponente(pnlRemover, lblTitulo, gbcGenerico, 1, 1, 0, 0);
		adicionarComponente(pnlRemover, txtTitulo, gbcGenerico, 1, 1, 1, 0);
		//adicionarComponente(pnlRemover, btnRemover, gbcGenerico, 1, 1, 0, 1);
		//adicionarComponente(pnlRemover, btnVoltar, gbcGenerico, 2, 1, 0, 2);
		
		// #Adicao dos Componentes do Painel Adicionar#//
		adicionarComponente(pnlAdicionar, cbxOpcoesExemplares, gbcGenerico, 3, 1, 0, 0);
		gbcGenerico.fill = GridBagConstraints.HORIZONTAL;

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

	// #Metodo Main#//r
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
