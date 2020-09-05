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
import java.awt.Insets;

import javax.swing.JTextField;

public class Ventana extends JFrame{

	private ExperienciasService experienciasService = new ExperienciasService();
	
	public JFrame frame;
	public JTextArea textAreaExp;
	public JTextField textAreaAutor;

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
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textAreaExp = new JTextArea();
		textAreaExp.setFont(new Font("Arial", Font.PLAIN, 55));
		textAreaExp.setBackground(Color.WHITE);
		textAreaExp.setLineWrap(true);//salto de linea automatico
		textAreaExp.setWrapStyleWord(true);//busca que el salto de linea sea entre espacios
		textAreaExp.setMargin(new Insets(50,50,50,50));	
		textAreaExp.setEditable(false);
		contentPane.add(textAreaExp, BorderLayout.PAGE_START);
		
		textAreaAutor = new JTextField();
		textAreaAutor.setFont(new Font("Arial", Font.PLAIN, 55));
		textAreaAutor.setBorder(new EmptyBorder(50, 50, 50, 50));
		textAreaAutor.setBackground(Color.white);
		textAreaAutor.setHorizontalAlignment(JTextField.CENTER);
		textAreaAutor.setEditable(false);
		contentPane.add(textAreaAutor, BorderLayout.PAGE_END);
		
		setUndecorated(true);		
		
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
