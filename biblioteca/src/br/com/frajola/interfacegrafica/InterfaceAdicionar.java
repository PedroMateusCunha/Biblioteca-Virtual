package br.com.frajola.interfacegrafica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.frajola.biblioteca.Biblioteca;
import br.com.frajola.exemplares.Livro;

public class InterfaceAdicionar extends InterfaceGenerica {
	private JLabel lblTitulo, lblAutor, lblAno, lblEditora, lblIsbn;
	private JTextField txtTitulo, txtAutor, txtAno, txtEditora, txtIsbn;
	private JPanel pnlAdicionar;
	private JPanel pnlLivro, pnlTCC, pnlRevista;
	private JComboBox<String> cbxOpcoesExemplares;
	private JButton btnAdicionar;
	private Biblioteca biblioteca;

	private Livro livro;

	private static final long serialVersionUID = 1L;

	public InterfaceAdicionar() {
		
		biblioteca = new Biblioteca();
		pnlAdicionar = new JPanel();
		pnlLivro = new JPanel();

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

		// #Adições do Painel Adicionar#//
		String[] tipos = { "Selecione o tipo de Exemplar", "Livro", "TCC", "Revista" };
		cbxOpcoesExemplares = new JComboBox<String>(tipos);
		cbxOpcoesExemplares.setSelectedIndex(0);

		cbxOpcoesExemplares.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String tipos = (String) cbxOpcoesExemplares.getSelectedItem();

				switch (tipos) {
				case "Livro":
					montarPainelLivro();
					trocarPainel(pnlLivro);
					System.out.println("LIVRO");
//					livro = new Livro(txtTitulo.getText(), txtAutor.getText(), Integer.valueOf(txtAno.getText().toString()),
//							txtEditora.getText(), txtIsbn.getText());
					break;
				case "TCC":
					System.out.println("TCC");
					break;
				case "Revista":
					System.out.println("REVISTA");
					break;
				default:
					System.out.println("DEFAULT");
					break;
				}

				if (arg0.getSource() == String.valueOf(cbxOpcoesExemplares.getSelectedIndex())) {
					pnlLivro = new JPanel();
					JLabel lblTeste = new JLabel("Fonfon");
					pnlLivro.add(lblTeste);
					trocarPainel(pnlLivro);

				}
			}
		});
		pnlAdicionar.add(cbxOpcoesExemplares);

		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				livro = new Livro(txtTitulo.getText(), txtAutor.getText(), Integer.valueOf(txtAno.getText().toString()),
						txtEditora.getText(), txtIsbn.getText());
				biblioteca.adicionarExemplar(livro);
				biblioteca.listarExemplares();
			}
		});
		pack();
		setVisible(true);

	}

	public JPanel getPnlAdicionar() {
		return pnlAdicionar;
	}

	public void setPnlAdicionar(JPanel pnlAdicionar) {
		this.pnlAdicionar = pnlAdicionar;
	}

	public void montarPainelLivro() {
		pnlLivro.setLayout(new GridLayout(6, 6, 20, 20));
		pnlLivro.add(lblTitulo);
		pnlLivro.add(txtTitulo);
		pnlLivro.add(lblAutor);
		pnlLivro.add(txtAutor);
		pnlLivro.add(lblAno);
		pnlLivro.add(txtAno);
		pnlLivro.add(lblEditora);
		pnlLivro.add(txtEditora);
		pnlLivro.add(lblIsbn);
		pnlLivro.add(txtIsbn);
		pnlLivro.add(btnAdicionar);

	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public JTextField getTxtAno() {
		return txtAno;
	}

	public void setTxtAno(JTextField txtAno) {
		this.txtAno = txtAno;
	}

	public JTextField getTxtEditora() {
		return txtEditora;
	}

	public void setTxtEditora(JTextField txtEditora) {
		this.txtEditora = txtEditora;
	}

	public JTextField getTxtIsbn() {
		return txtIsbn;
	}

	public void setTxtIsbn(JTextField txtIsbn) {
		this.txtIsbn = txtIsbn;
	}

}
