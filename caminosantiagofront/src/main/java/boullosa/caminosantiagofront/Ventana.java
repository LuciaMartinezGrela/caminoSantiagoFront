package boullosa.caminosantiagofront;

import java.awt.EventQueue;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	private ExperienciasService experienciasService = new ExperienciasService();
	
	public JFrame frame;
	public JTextArea textAreaExp;
	public JTextArea textAreaAutor;

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public Ventana() throws InterruptedException {
		
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);
		
		textAreaExp = new JTextArea();
		textAreaExp.setFont(new Font("Arial", Font.PLAIN, 55));
		textAreaExp.setBackground(Color.WHITE);
		textAreaExp.setBounds(92, 51, 1648, 585);
		textAreaExp.setLineWrap(true);//salto de linea automatico
		textAreaExp.setWrapStyleWord(true);//busca que el salto de linea sea entre espacios
		textAreaExp.setEditable(false);
		contentPane.add(textAreaExp);
		
		textAreaAutor = new JTextArea();
		textAreaAutor.setFont(new Font("Arial", Font.PLAIN, 55));
		textAreaAutor.setBackground(Color.white);
		textAreaAutor.setBounds(942, 741, 476, 74);
		textAreaAutor.setLineWrap(true);
		textAreaAutor.setWrapStyleWord(true);
		textAreaAutor.setEditable(false);
		contentPane.add(textAreaAutor);
		
		setUndecorated(true);
		textAreaExp.setLineWrap(true);
		
		
		setVisible(true);
		
		mostrarExperiencias();
	}
	
	public void mostrarExperiencias() throws InterruptedException {
		while (true) {
			//Cambiar esto por una llamada al servidor http://localhost:8080/obtenerExperiencias
			ExperienciaDto[] experiencias = experienciasService.obtenerExperiencias();
			for (ExperienciaDto experiencia : experiencias) {
				//mostrar datos experiencia en pantalla
				
				textAreaAutor.setText(experiencia.getNombre());
				textAreaExp.setText(experiencia.getExperiencia());
				
				TimeUnit.SECONDS.sleep(20);
			}
		}
	}
}
