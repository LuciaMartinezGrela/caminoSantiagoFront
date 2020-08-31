package boullosa.caminosantiagofront;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class Ventana extends JFrame{

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public Ventana() {
		//frame = new JFrame();
		
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	    
		frame.setBounds(100, 100, ancho, alto);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//centrar ventana en la pantalla
		frame.setUndecorated(true);
		
		
		JTextArea textAreaExp = new JTextArea();
		frame.getContentPane().add(textAreaExp, BorderLayout.CENTER);
		
		JTextArea textAreaAutor = new JTextArea();
		frame.getContentPane().add(textAreaAutor, BorderLayout.SOUTH);
		//frame.setUndecorated();
	}

}
