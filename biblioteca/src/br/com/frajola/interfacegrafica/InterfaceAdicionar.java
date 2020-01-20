package br.com.frajola.interfacegrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceAdicionar extends InterfaceGenerica {
	JLabel lblTitulo, lblAutor, lblAno;
	JTextField txtTitulo, txtAutor, txtAno;

	private static final long serialVersionUID = 1L;
	private JPanel pnlAdicionar;
	private JPanel pnlLivro, pnlTCC, pnlRevista;
	private JComboBox<String> cbxOpcoesExemplares;

	public InterfaceAdicionar() {

		pnlAdicionar = new JPanel();
		pnlLivro = new JPanel();
		
		
		lblTitulo = new JLabel("Titulo");
		lblAutor = new JLabel("Autor");
		lblAno = new JLabel("Ano");
		
		txtTitulo = new JTextField();
		txtAutor = new JTextField();
		txtAno = new JTextField();

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

				// String tipo = String.valueOf(cbxOpcoesExemplares.getSelectedItem());
				if (arg0.getSource() == String.valueOf(cbxOpcoesExemplares.getSelectedIndex())) {
					pnlLivro = new JPanel();
					JLabel lblTeste = new JLabel("Fonfon");
					pnlLivro.add(lblTeste);
					trocarPainel(pnlLivro);

				}
			}
		});
		pnlAdicionar.add(cbxOpcoesExemplares);
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
		pnlLivro.add(lblTitulo);
		pnlLivro.add(txtTitulo);
		pnlLivro.add(lblAutor);
		pnlLivro.add(txtAutor);
		pnlLivro.add(lblAno);
		pnlLivro.add(txtAno);

	}

}
