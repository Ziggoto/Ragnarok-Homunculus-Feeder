package gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.FeedThread;
import core.WindowThread;

public class MainWindow extends JFrame {
	private JButton btnCria1Janela, btnApaga1Janela, btnCria2Janela, btnApaga2Janela,
					btnTesta1Janela, btnTesta2Janela, btnExecuta;
	
	private JLabel pos1Janela, pos2Janela;
	
	private WindowThread janela1, janela2;
	private int pontoX1, pontoY1, pontoX2, pontoY2;
	
	private FeedThread feedThread;
	
	public MainWindow(){
		super();
		
		janela1 = new WindowThread();
		janela2 = new WindowThread();
		
		this.setSize(new Dimension(600, 600)); //Serve pra nada lol
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{117, 117, 0};
		gbl_panel.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		pos1Janela = new JLabel("1º:");
		GridBagConstraints gbc_pos1Janela = new GridBagConstraints();
		gbc_pos1Janela.insets = new Insets(0, 0, 5, 5);
		gbc_pos1Janela.gridx = 0;
		gbc_pos1Janela.gridy = 0;
		panel.add(pos1Janela, gbc_pos1Janela);
		
		pos2Janela = new JLabel("2º:");
		GridBagConstraints gbc_pos2Janela = new GridBagConstraints();
		gbc_pos2Janela.insets = new Insets(0, 0, 5, 0);
		gbc_pos2Janela.gridx = 1;
		gbc_pos2Janela.gridy = 0;
		panel.add(pos2Janela, gbc_pos2Janela);
		
		btnCria1Janela = new JButton("Criar 1ª Janela");
		GridBagConstraints gbc_btnCria1Janela = new GridBagConstraints();
		gbc_btnCria1Janela.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCria1Janela.insets = new Insets(0, 0, 5, 5);
		gbc_btnCria1Janela.gridx = 0;
		gbc_btnCria1Janela.gridy = 1;
		panel.add(btnCria1Janela, gbc_btnCria1Janela);
		
		btnApaga1Janela = new JButton("Aplicar 1ª Janela");
		GridBagConstraints gbc_btnApaga1Janela = new GridBagConstraints();
		gbc_btnApaga1Janela.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnApaga1Janela.insets = new Insets(0, 0, 5, 0);
		gbc_btnApaga1Janela.gridx = 1;
		gbc_btnApaga1Janela.gridy = 1;
		panel.add(btnApaga1Janela, gbc_btnApaga1Janela);
		
		btnCria2Janela = new JButton("Criar 2ª Janela");
		GridBagConstraints gbc_btnCria2Janela = new GridBagConstraints();
		gbc_btnCria2Janela.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCria2Janela.insets = new Insets(0, 0, 5, 5);
		gbc_btnCria2Janela.gridx = 0;
		gbc_btnCria2Janela.gridy = 2;
		panel.add(btnCria2Janela, gbc_btnCria2Janela);
		
		btnApaga2Janela = new JButton("Aplicar 2ª Janela");
		GridBagConstraints gbc_btnApaga2Janela = new GridBagConstraints();
		gbc_btnApaga2Janela.insets = new Insets(0, 0, 5, 0);
		gbc_btnApaga2Janela.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnApaga2Janela.gridx = 1;
		gbc_btnApaga2Janela.gridy = 2;
		panel.add(btnApaga2Janela, gbc_btnApaga2Janela);
		
		JLabel lblNewLabel_2 = new JLabel("Testar as janelas:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		btnTesta1Janela = new JButton("Testar 1ª Janela");
		GridBagConstraints gbc_btnTesta1Janela = new GridBagConstraints();
		gbc_btnTesta1Janela.insets = new Insets(0, 0, 5, 5);
		gbc_btnTesta1Janela.gridx = 0;
		gbc_btnTesta1Janela.gridy = 4;
		panel.add(btnTesta1Janela, gbc_btnTesta1Janela);
		
		btnTesta2Janela = new JButton("Testar 2ª Janela");
		GridBagConstraints gbc_btnTesta2Janela = new GridBagConstraints();
		gbc_btnTesta2Janela.insets = new Insets(0, 0, 5, 0);
		gbc_btnTesta2Janela.gridx = 1;
		gbc_btnTesta2Janela.gridy = 4;
		panel.add(btnTesta2Janela, gbc_btnTesta2Janela);
		
		btnExecuta = new JButton("Executar");
		GridBagConstraints gbc_btnExecuta = new GridBagConstraints();
		gbc_btnExecuta.gridwidth = 2;
		gbc_btnExecuta.insets = new Insets(0, 0, 0, 5);
		gbc_btnExecuta.gridx = 0;
		gbc_btnExecuta.gridy = 5;
		panel.add(btnExecuta, gbc_btnExecuta);
		
		this.addEventos();
		
		this.pack();
		this.setVisible(true);
		
	}
	
	//Adiciona os eventos
	private void addEventos(){
		
		//EVENTOS DE CRIAÇÃO DE JANELAS
		btnCria1Janela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				janela1.start();
			}
		});
		
		btnCria2Janela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				janela2.start();
			}
		});
		
		//EVENTO DE EXCLUSÃO DE JANELAS
		btnApaga1Janela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pontoX1 = janela1.getWindow().getPontoX();
				pontoY1 = janela1.getWindow().getPontoY();
				pos1Janela.setText("1º: ("+pontoX1+", "+pontoY1+")");
				
				janela1.destroi();
			}
		});
		
		btnApaga2Janela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pontoX2 = janela2.getWindow().getPontoX();
				pontoY2 = janela2.getWindow().getPontoY();
				pos2Janela.setText("2º: ("+pontoX2+", "+pontoY2+")");
				
				janela2.destroi();
			}
		});
		
		//EVENTOS DE TESTES DE JANELA
		btnTesta1Janela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Robot robot = new Robot();
					robot.mouseMove(pontoX1, pontoY1);
					
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.delay(500);					
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		btnTesta2Janela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Robot robot = new Robot();
					robot.mouseMove(pontoX2, pontoY2);
					
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.delay(500);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//EVENTO FINAL..
		btnExecuta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				feedThread = new FeedThread(new Dimension(pontoX1, pontoY1), new Dimension(pontoX2, pontoY2));
				feedThread.start();
			}
		});
	}
}



