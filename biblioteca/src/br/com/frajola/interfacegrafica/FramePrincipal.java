package br.com.frajola.interfacegrafica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class FramePrincipal extends JFrame implements ActionListener{
	private JLayeredPane jlpPrincipal;
	private JFrame jFrame;
	private JPanel pnlPainel, pnlOpcoes, pnlAdicionar;
	private JLabel lblTitulo;
	private JTextField txtTitulo;
	private JButton btnAdicionar, btnRemover, btnEditar, btnConsultar;

	public FramePrincipal() {
		
		//#Criação do Frame Inicial#//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(600, 500));
		setLocationRelativeTo(null);
		
		//#Criação do Painel Inicial#//
		pnlPainel = new JPanel(new CardLayout());
		//pnlPainel.setLayout(new GridLayout(3, 5, 10, 70));
		
		//#Criação e Adição do Painel de Camadas#/
		jlpPrincipal = new JLayeredPane();
		pnlPainel.add(jlpPrincipal, BorderLayout.CENTER);
		jlpPrincipal.setLayout(null);
		
		//#Adição de Componentes#//
		JPanel painel = new JPanel();
		jlpPrincipal.setLayer(painel, 0);
		painel.setBounds(82, 65, 900, 900);
		JLabel texto = new JLabel("Ai dento");
		painel.add(texto);
		jlpPrincipal.add(painel);

		JPanel painel1 = new JPanel();
		jlpPrincipal.setLayer(painel1, 1);
		painel1.setBounds(82, 65, 315, 132);
		JLabel texto1 = new JLabel("Ai Fora");
		painel1.add(texto1);
		jlpPrincipal.add(painel1);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pnlAdicionar = new JPanel();
				painel1.setVisible(false);
				
			}
		});
		
		btnRemover = new JButton("Remover");
		btnEditar = new JButton("Editar");
		btnConsultar = new JButton("Consultar");
		
		pnlPainel.add(painel);
		pnlPainel.add(painel1);
		
		pnlPainel.add(btnAdicionar);
		pnlPainel.add(btnRemover);
		pnlPainel.add(btnEditar);
		pnlPainel.add(btnConsultar);

		getContentPane().add(jlpPrincipal, BorderLayout.CENTER);
		
		//#Visualização da interface#//
		painel.setVisible(false);
		pnlPainel.setOpaque(true);
		setContentPane(pnlPainel);
		
			
		pack();
		setVisible(false);

	}
	
	public static void main(String[] args) {
		new FramePrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
