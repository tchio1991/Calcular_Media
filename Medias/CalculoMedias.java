package Medias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculoMedias extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField notaUm;
	private JTextField notaDois;
	private JTextField notaTres;
	private JTextField notaQuatro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoMedias frame = new CalculoMedias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculoMedias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculador de Médias");
		lblNewLabel.setBounds(24, 11, 157, 19);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 32, 555, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nota 1", "Nota 2", "Nota 3", "Nota 4", "Médias"
			}
		)
				);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Nota 1");
		lblNewLabel_1.setBounds(24, 222, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nota 2");
		lblNewLabel_2.setBounds(148, 222, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nota 3");
		lblNewLabel_3.setBounds(265, 222, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nota 4");
		lblNewLabel_4.setBounds(389, 222, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		notaUm = new JTextField();
		notaUm.setBounds(24, 247, 86, 20);
		contentPane.add(notaUm);
		notaUm.setColumns(10);
		
		notaDois = new JTextField();
		notaDois.setBounds(145, 247, 86, 20);
		contentPane.add(notaDois);
		notaDois.setColumns(10);
		
		notaTres = new JTextField();
		notaTres.setBounds(265, 247, 86, 20);
		contentPane.add(notaTres);
		notaTres.setColumns(10);
		
		notaQuatro = new JTextField();
		notaQuatro.setBounds(389, 247, 86, 20);
		contentPane.add(notaQuatro);
		notaQuatro.setColumns(10);
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Vamos receber o que foi digitado
				
				String nota1 = notaUm.getText().trim();
				String nota2 = notaDois.getText().trim();
				String nota3 = notaTres.getText().trim();
				String nota4 = notaQuatro.getText().trim();
				
				//Vamos calcular as medias
				
				float medias = (Float.parseFloat(nota1) + Float.parseFloat(nota2) + Float.parseFloat(nota3) + Float.parseFloat(nota4))/4;
				
				// Vamos adicionar as notas e resultados na tabela
				
				DefaultTableModel tabelinha = (DefaultTableModel) table.getModel();
				tabelinha.addRow(new String[] {nota1, nota2, nota3, nota4, medias+""});
				
				// Limpar campos
				
				notaUm.setText("");
				notaDois.setText("");
				notaTres.setText("");
				notaQuatro.setText("");
				
				notaUm.requestFocus();
			}
		});
		btnCadastro.setBounds(110, 300, 112, 34);
		contentPane.add(btnCadastro);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());;
			}
		});
		btnExcluir.setBounds(232, 300, 112, 34);
		contentPane.add(btnExcluir);
	}
}
