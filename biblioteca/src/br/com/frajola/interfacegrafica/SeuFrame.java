package br.com.frajola.interfacegrafica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SeuFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel1;
	private JPanel panel2;
	private JButton botao1;
	private JButton botao2;

	public SeuFrame() {
		panel1 = new JPanel();
		panel2 = new JPanel();

		botao1 = new JButton("Trocar para panel2");
		botao1.setPreferredSize(new Dimension(200, 30));

		botao2 = new JButton("Trocar para panel1");
		botao2.setPreferredSize(new Dimension(200, 30));

		panel1.add(botao1);
		panel2.add(botao2);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panelTrocar = null;
				if (e.getSource() == botao1) {
					panelTrocar = panel2;
				} else {
					panelTrocar = panel1;
				}
				getContentPane().removeAll();
				getContentPane().add(panelTrocar);
				revalidate();
				repaint();
			}
		};

		botao1.addActionListener(actionListener);
		botao2.addActionListener(actionListener);

		getContentPane().add(panel1);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SeuFrame();
	}

}
