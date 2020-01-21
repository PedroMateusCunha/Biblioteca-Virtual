package br.com.frajola.interfacegrafica;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class InterfaceGenerica extends JFrame {

	private static final long serialVersionUID = 1L;

	public InterfaceGenerica() {
		
		// #Criação do Frame Inicial#//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
	}
	
	public void trocarPainel(JPanel pnlTroca) {
		getContentPane().removeAll();
		getContentPane().add(pnlTroca);
		revalidate();
		repaint();
	}
	
}
