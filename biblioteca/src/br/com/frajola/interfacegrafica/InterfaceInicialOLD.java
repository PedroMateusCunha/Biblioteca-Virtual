package br.com.frajola.interfacegrafica;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceInicialOLD extends JFrame {

	private JPanel pnlInicial, pnlAdicionar;
	private JButton btnAdicionar, btnRemover, btnEditar, btnConsultar;
	private JLabel lblTitulo, lblAutor, lblAno;
	private JComboBox<String> cbxOpcoesExemplares;
	private static final long serialVersionUID = 1L;

	public InterfaceInicialOLD() {

		// #Criação do Frame Inicial#//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setPreferredSize(new Dimension(600, 500));
		setLocationRelativeTo(null);

		pnlInicial = new JPanel();
		pnlAdicionar = new JPanel();

		// #Adições do Painel Inicial#//
		btnAdicionar = new JButton("Adicionar");
		btnRemover = new JButton("Remover");
		btnEditar = new JButton("Editar");
		btnConsultar = new JButton("Consultar");

		btnAdicionar.setPreferredSize(new Dimension(200, 30));
		btnRemover.setPreferredSize(new Dimension(200, 30));
		btnEditar.setPreferredSize(new Dimension(200, 30));
		btnConsultar.setPreferredSize(new Dimension(200, 30));

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
				// TODO Auto-generated method 
				
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
				// TODO Auto-generated method stub
				
			}
		});

		pnlInicial.add(btnAdicionar);
		pnlInicial.add(btnRemover);
		pnlInicial.add(btnEditar);
		pnlInicial.add(btnConsultar);

		// #Adições do Painel Adicionar#//
		cbxOpcoesExemplares = new JComboBox<String>();
		cbxOpcoesExemplares.addItem("Selecione o tipo de Exemplar");
		cbxOpcoesExemplares.addItem("Livro");
		cbxOpcoesExemplares.addItem("TCC");
		cbxOpcoesExemplares.addItem("Revista");
		cbxOpcoesExemplares.setSelectedIndex(0);
		
		
		
		cbxOpcoesExemplares.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tipo = String.valueOf(cbxOpcoesExemplares.getSelectedItem());
				switch (tipo) {
				case "Livro":
					JPanel pnlLivro = new JPanel();
					pnlLivro.setBounds(0, 40, 200, 300);
					JLabel lblTeste = new JLabel("Fonfon");
					pnlLivro.add(lblTeste);
					
					break;
				case "TCC":
					// TODO
					break;
				case "Revista":
					// TODO
					break;
				default:
					break;
				}
			}
		});
		pnlAdicionar.add(cbxOpcoesExemplares);
		pnlAdicionar.setBounds(0,0 , 200, 300);

		getContentPane().add(pnlInicial);
		pack();
		setVisible(true);

	}

	public static void main(String[] args) {
		new InterfaceInicialOLD();

	}
	
	public void trocarPainel(JPanel pnlTroca) {
		getContentPane().removeAll();
		getContentPane().add(pnlTroca);
		revalidate();
		repaint();
	}

}
