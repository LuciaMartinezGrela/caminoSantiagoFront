package boullosa.caminosantiagofront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class Ventana extends JFrame{

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public Ventana() {
		
		
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	    
		setBounds(100, 100, ancho, alto);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);//centrar ventana en la pantalla
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setUndecorated(true);
		
		
		JTextArea textAreaExp = new JTextArea();
		contentPane.add(textAreaExp);
		
		JTextArea textAreaAutor = new JTextArea();
		contentPane.add(textAreaAutor);
		//frame.setUndecorated();
	}

}
