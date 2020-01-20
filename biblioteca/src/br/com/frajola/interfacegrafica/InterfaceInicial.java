package br.com.frajola.interfacegrafica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceInicial extends InterfaceGenerica {

	private JPanel pnlInicial;
	private JButton btnAdicionar, btnRemover, btnEditar, btnConsultar;
	private JLabel lblTitulo, lblAutor, lblAno;
	private JComboBox<String> cbxOpcoesExemplares;
	private static final long serialVersionUID = 1L;

	public InterfaceInicial() {

		pnlInicial = new JPanel();

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
					InterfaceAdicionar interfaceAdicionar = new InterfaceAdicionar();
					trocarPainel(interfaceAdicionar.getPnlAdicionar());
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

		getContentPane().add(pnlInicial);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new InterfaceInicial();

	}

}
