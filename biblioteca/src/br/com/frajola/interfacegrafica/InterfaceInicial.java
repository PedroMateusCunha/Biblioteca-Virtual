package br.com.frajola.interfacegrafica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.frajola.biblioteca.Biblioteca;

public class InterfaceInicial extends InterfaceGenerica {

	private JPanel pnlInicial, pnlConsulta;
	private JButton btnAdicionar, btnRemover, btnEditar, btnConsultar;
	private JLabel lblTitulo, lblAutor, lblAno;
	private JComboBox<String> cbxOpcoesExemplares;
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dflTabela;
	private InterfaceAdicionar interfaceAdicionar;
	private JTable tblTabela;
	
	public InterfaceInicial() {

		pnlInicial = new JPanel();
		pnlConsulta = new JPanel();
		interfaceAdicionar = new InterfaceAdicionar();

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
				dflTabela.insertRow(0, new Object[] {interfaceAdicionar.getTxtTitulo().getText(),
						interfaceAdicionar.getTxtAutor().getText(), interfaceAdicionar.getTxtAno().getText(),
						interfaceAdicionar.getTxtEditora().getText(), interfaceAdicionar.getTxtIsbn().getText()
				});
				tblTabela = new JTable(dflTabela);
				getContentPane().add(new JScrollPane(tblTabela));
				pnlConsulta.add(tblTabela);
				trocarPainel(pnlConsulta);
			}
		});

		pnlInicial.add(btnAdicionar);
		pnlInicial.add(btnRemover);
		pnlInicial.add(btnEditar);
		pnlInicial.add(btnConsultar);
		
		dflTabela = new DefaultTableModel();
		dflTabela.addColumn("Titulo");
		dflTabela.addColumn("Autor");
		dflTabela.addColumn("Ano");
		dflTabela.addColumn("Editora");
		dflTabela.addColumn("ISBN");

		getContentPane().add(pnlInicial);
		pack();
		setVisible(true);
	}

	

}
