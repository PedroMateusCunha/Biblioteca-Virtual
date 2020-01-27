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
import br.com.frajola.exemplares.Exemplar;
import br.com.frajola.exemplares.Livro;
import br.com.frajola.exemplares.Revista;
import br.com.frajola.exemplares.TCC;

public class InterfacePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pnlInicial, pnlAdicionar, pnlRemover, pnlConsulta, pnlEditar;
	private JButton btnAdicionar, btnRemover, btnEditar, btnConsultar, btnAdicionarExemplar, btnVoltarAdicionar,
			btnVoltarRemover, btnVoltarEditar, btnVoltarConsultar, btnRemoverExemplar, btnEditarExemplar;
	private JLabel lblTitulo, lblAutor, lblAno, lblEditora, lblIsbn, lblTipo, lblOrientador, lblAreaDeConhecimento,
			lblTituloRemover, lblTituloEditar, lblNovoTituloEditar, lblNovoAutorEditar, lblNovoAnoEditar;
	private JTextField txtTitulo, txtAutor, txtAno, txtEditora, txtIsbn, txtTipo, txtOrientador, txtAreaDeConhecimento,
			txtTituloRemover, txtTituloEditar, txtNovoTituloEditar, txtNovoAutorEditar, txtNovoAnoEditar;
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
		setPreferredSize(new Dimension(500, 500));
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
		pnlEditar = new JPanel();
		pnlEditar.setLayout(layout);

		// #Instancias do Painel Inicial#//
		btnAdicionar = new JButton("Adicionar");
		btnRemover = new JButton("Remover");
		btnEditar = new JButton("Editar");
		btnConsultar = new JButton("Consultar");

		// #Instancias do Painel Editar#//
		btnVoltarEditar = new JButton("Voltar");
		btnEditarExemplar = new JButton("Editar Exemplar");

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
		btnVoltarAdicionar = new JButton("Voltar");

		biblioteca = new Biblioteca();

		String[] tipos = { "Selecione o tipo de Exemplar", "Livro", "TCC", "Revista" };
		cbxOpcoesExemplares = new JComboBox<String>(tipos);
		cbxOpcoesExemplares.setSelectedIndex(0);

		// #Instancias de Tabela do Painel de Consulta#//
		btnVoltarConsultar = new JButton("Voltar");
		dflTabela = new DefaultTableModel();
		tblTabela = new JTable();

		// #Congiguracao da Tabela#//
		dflTabela = new DefaultTableModel();
		dflTabela.addColumn("Titulo");
		dflTabela.addColumn("Autor");
		dflTabela.addColumn("Ano");
		dflTabela.addColumn("Tipo");

		// #Instancias do Painel Remover#//
		btnRemoverExemplar = new JButton("Remover Exemplar");
		btnVoltarRemover = new JButton("Voltar");
		lblTituloRemover = new JLabel("Titulo");
		txtTituloRemover = new JTextField();

		// #Instancias do Painel Editar#//
		lblTituloEditar = new JLabel("Titulo");
		lblNovoTituloEditar = new JLabel("Novo Titulo");
		lblNovoAutorEditar = new JLabel("Novo Autor");
		lblNovoAnoEditar = new JLabel("Novo Ano");
		txtTituloEditar = new JTextField();
		txtNovoTituloEditar = new JTextField();
		txtNovoAutorEditar = new JTextField();
		txtNovoAnoEditar = new JTextField();

		// #Implementacao dos ActionListener do Painel Inicial#//
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				trocarPainel(pnlAdicionar);
			}
		});
		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				trocarPainel(pnlRemover);
			}
		});
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				trocarPainel(pnlEditar);
			}
		});
		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dflTabela.insertRow(0, new Object[] { lblTitulo.getText(), lblAutor.getText(), lblAno.getText(),
						lblEditora.getText(), lblIsbn.getText() });
				tblTabela = new JTable(dflTabela);
				getContentPane().add(new JScrollPane(tblTabela));
				adicionarComponente(pnlConsulta, tblTabela, 1, 1, 0, 0);
				adicionarComponente(pnlConsulta, btnVoltarConsultar, 1, 1, 0, 2);
				trocarPainel(pnlConsulta);
			}
		});

		// #Implementacao dos Action Listeners do Painel Adicionar#//

		cbxOpcoesExemplares.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String tipos = (String) cbxOpcoesExemplares.getSelectedItem();

				switch (tipos) {
				case "Livro":
					atualizarPainel(pnlAdicionar);
					adicionarComponente(pnlAdicionar, lblTitulo, 1, 1, 1, 1);
					adicionarComponente(pnlAdicionar, txtTitulo, 1, 1, 2, 1);
					adicionarComponente(pnlAdicionar, lblAutor, 1, 1, 1, 2);
					adicionarComponente(pnlAdicionar, txtAutor, 1, 1, 2, 2);
					adicionarComponente(pnlAdicionar, lblAno, 1, 1, 1, 3);
					adicionarComponente(pnlAdicionar, txtAno, 1, 1, 2, 3);
					adicionarComponente(pnlAdicionar, lblEditora, 1, 1, 1, 4);
					adicionarComponente(pnlAdicionar, txtEditora, 1, 1, 2, 4);
					adicionarComponente(pnlAdicionar, lblIsbn, 1, 1, 1, 5);
					adicionarComponente(pnlAdicionar, txtIsbn, 1, 1, 2, 5);
					break;
				case "TCC":
					atualizarPainel(pnlAdicionar);
					adicionarComponente(pnlAdicionar, lblTitulo, 1, 1, 1, 1);
					adicionarComponente(pnlAdicionar, txtTitulo, 1, 1, 2, 1);
					adicionarComponente(pnlAdicionar, lblAutor, 1, 1, 1, 2);
					adicionarComponente(pnlAdicionar, txtAutor, 1, 1, 2, 2);
					adicionarComponente(pnlAdicionar, lblAno, 1, 1, 1, 3);
					adicionarComponente(pnlAdicionar, txtAno, 1, 1, 2, 3);
					adicionarComponente(pnlAdicionar, lblEditora, 1, 1, 1, 4);
					adicionarComponente(pnlAdicionar, txtEditora, 1, 1, 2, 4);
					adicionarComponente(pnlAdicionar, lblOrientador, 1, 1, 1, 5);
					adicionarComponente(pnlAdicionar, txtOrientador, 1, 1, 2, 5);
					adicionarComponente(pnlAdicionar, lblAreaDeConhecimento, 1, 1, 1, 6);
					adicionarComponente(pnlAdicionar, txtAreaDeConhecimento, 1, 1, 2, 6);
					break;
				case "Revista":
					atualizarPainel(pnlAdicionar);
					adicionarComponente(pnlAdicionar, lblTitulo, 1, 1, 1, 1);
					adicionarComponente(pnlAdicionar, txtTitulo, 1, 1, 2, 1);
					adicionarComponente(pnlAdicionar, lblAutor, 1, 1, 1, 2);
					adicionarComponente(pnlAdicionar, txtAutor, 1, 1, 2, 2);
					adicionarComponente(pnlAdicionar, lblAno, 1, 1, 1, 3);
					adicionarComponente(pnlAdicionar, txtAno, 1, 1, 2, 3);
					adicionarComponente(pnlAdicionar, lblEditora, 1, 1, 1, 4);
					adicionarComponente(pnlAdicionar, txtEditora, 1, 1, 2, 4);
					adicionarComponente(pnlAdicionar, lblIsbn, 1, 1, 1, 5);
					adicionarComponente(pnlAdicionar, txtIsbn, 1, 1, 2, 5);
					adicionarComponente(pnlAdicionar, lblTipo, 1, 1, 1, 6);
					adicionarComponente(pnlAdicionar, txtTipo, 1, 1, 2, 6);
					break;
				default:
					atualizarPainel(pnlAdicionar);
					System.out.println("DEFAULT");
					break;
				}
			}
		});

		btnAdicionarExemplar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cbxOpcoesExemplares.getSelectedItem() == "Livro") {
					biblioteca.adicionarExemplar(new Livro(txtTitulo.getText(), txtAutor.getText(),
							Integer.valueOf(txtAno.getText()), txtEditora.getText(), txtIsbn.getText()));
					dflTabela.addRow(
							new Object[] { txtTitulo.getText(), txtAutor.getText(), txtAno.getText(), "Livro" });
				} else if (cbxOpcoesExemplares.getSelectedItem() == "TCC") {
					biblioteca.adicionarExemplar(
							new TCC(txtTitulo.getText(), txtAutor.getText(), Integer.valueOf(txtAno.getText()),
									txtOrientador.getText(), txtAreaDeConhecimento.getText()));
					dflTabela.addRow(new Object[] { txtTitulo.getText(), txtAutor.getText(), txtAno.getText(), "TCC" });
				} else if (cbxOpcoesExemplares.getSelectedItem() == "Revista") {
					biblioteca.adicionarExemplar(new Revista(txtTitulo.getText(), txtAutor.getText(),
							Integer.valueOf(txtAno.getText()), txtTipo.getText(), txtEditora.getText()));
					dflTabela.addRow(
							new Object[] { txtTitulo.getText(), txtAutor.getText(), txtAno.getText(), "Revista" });
				}

			}
		});

		btnVoltarAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				trocarPainel(pnlInicial);

			}
		});
		btnVoltarRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				trocarPainel(pnlInicial);

			}
		});
		btnVoltarEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				trocarPainel(pnlInicial);

			}
		});
		btnVoltarConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				trocarPainel(pnlInicial);

			}
		});

		btnRemoverExemplar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				deletarExemplar(txtTituloRemover.getText());
			}
		});

		btnEditarExemplar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editarExemplar(txtTitulo.getText(), txtTituloEditar.getText(), txtAno.getText(), txtNovoAnoEditar.getText(),
						txtAutor.getText(), txtNovoAutorEditar.getText());
			}
		});

		adicionarComponente(pnlAdicionar, btnAdicionarExemplar, 2, 1, 1, 7);
		adicionarComponente(pnlAdicionar, btnVoltarAdicionar, 2, 1, 1, 8);

		// #Adicao dos Componentes do Painel Editar#//
		adicionarComponente(pnlEditar, lblTituloEditar, 1, 1, 0, 0);
		adicionarComponente(pnlEditar, txtTituloEditar, 1, 1, 1, 0);
		adicionarComponente(pnlEditar, lblNovoTituloEditar, 1, 1, 0, 1);
		adicionarComponente(pnlEditar, txtNovoTituloEditar, 1, 1, 1, 1);
		adicionarComponente(pnlEditar, lblNovoAutorEditar, 1, 1, 0, 2);
		adicionarComponente(pnlEditar, txtNovoAutorEditar, 1, 1, 1, 2);
		adicionarComponente(pnlEditar, lblNovoAnoEditar, 1, 1, 0, 3);
		adicionarComponente(pnlEditar, txtNovoAnoEditar, 1, 1, 1, 3);
		adicionarComponente(pnlEditar, btnEditarExemplar, 2, 1, 0, 4);
		adicionarComponente(pnlEditar, btnVoltarEditar, 2, 1, 0, 5);

		// #Adicao dos Componentes do Painel Remover#//
		adicionarComponente(pnlRemover, lblTituloRemover, 1, 1, 0, 0);
		adicionarComponente(pnlRemover, txtTituloRemover, 3, 1, 1, 0);
		adicionarComponente(pnlRemover, btnRemoverExemplar, 4, 1, 0, 3);
		adicionarComponente(pnlRemover, btnVoltarRemover, 4, 1, 0, 4);

		// #Adicao dos Componentes do Painel Adicionar#//
		adicionarComponente(pnlAdicionar, cbxOpcoesExemplares, 3, 1, 0, 0);

		// #Adição dos Botoes com GridBagLayout#//
		adicionarComponente(pnlInicial, btnAdicionar, 1, 1, 0, 0);
		adicionarComponente(pnlInicial, btnRemover, 1, 1, 1, 0);
		adicionarComponente(pnlInicial, btnEditar, 1, 1, 2, 0);
		adicionarComponente(pnlInicial, btnConsultar, 1, 1, 3, 0);

		// #Visualização do Frame#//
		getContentPane().add(pnlInicial);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	// #Metodo Main#//
	public static void main(String[] args) {
		new InterfacePrincipal();
	}

	public void adicionarComponente(JPanel painel, Component componente, int largura, int altura, int coluna,
			int linha) {
		this.gbcGenerico.gridwidth = largura;
		this.gbcGenerico.gridheight = altura;
		this.gbcGenerico.gridx = coluna;
		this.gbcGenerico.gridy = linha;
		gbcGenerico.fill = GridBagConstraints.HORIZONTAL;
		painel.add(componente, this.gbcGenerico);
	}

	public void atualizarPainel(JPanel pnlTroca) {
		pnlTroca.revalidate();
		pnlTroca.repaint();
	}

	public void trocarPainel(JPanel pnlTroca) {
		getContentPane().removeAll();
		getContentPane().add(pnlTroca);
		atualizarPainel(pnlTroca);
	}

	public void deletarExemplar(String titulo) {
		for (int i = 0; i < dflTabela.getRowCount(); i++) {
			if (dflTabela.getValueAt(i, 0).toString().equals(titulo)) {
				dflTabela.removeRow(i);
			}
		}
	}

	public void editarExemplar(String titulo, String novoTitulo, String ano, String novoAno, String autor,
			String novoAutor) {
		for (int i = 0; i < dflTabela.getRowCount(); i++) {
			if (dflTabela.getValueAt(i, 0).toString().equals(titulo)) {
				dflTabela.setValueAt(novoTitulo, i, 0);
			}

			if (dflTabela.getValueAt(i, 0).toString().equals(ano)) {
				dflTabela.setValueAt(novoAno, i, 1);
			}

			if (dflTabela.getValueAt(i, 0).toString().equals(autor)) {
				dflTabela.setValueAt(novoAutor, i, 2);
			}
		}
	}
}
