package br.com.frajola.interfacegrafica;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FramePrincipal implements ActionListener{
	JLayeredPane jlpPrincipal;
	JLabel lblNome;
	JTextField txtNome;

	public FramePrincipal() {
		JFrame jFrame = new JFrame("Biblioteca");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setPreferredSize(new Dimension(300, 400));
		jlpPrincipal = new JLayeredPane();
		
		//#Criação do Painel#//
		JPanel pnlPainel = new JPanel();
		pnlPainel.setLayout(new GridLayout(9, 1));
		
		//#Adição de Componentes#//
		lblNome = new JLabel("Nome");
		pnlPainel.add(lblNome);
		txtNome = new JTextField();
		pnlPainel.add(txtNome);

		jFrame.add(jlpPrincipal);
		
		//#Visualização da interface#//
		pnlPainel.setOpaque(true);
		jFrame.setContentPane(pnlPainel);
		jFrame.pack();
		jFrame.setVisible(true);

	}
	
	public static void main(String[] args) {
		new FramePrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
