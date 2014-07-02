package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaTransparente extends JFrame implements MouseMotionListener {
	private Ponto ponto;	
	
	public JanelaTransparente() {
		super();
		
		this.addMouseMotionListener(this);
		
		this.setSize(new Dimension(50, 50));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ponto = new Ponto(this.getSize());
		getContentPane().add(ponto, BorderLayout.CENTER);
		
		this.setUndecorated(true);
		this.setOpacity(0.50f);
		
		this.setVisible(true);
	}

	public int getPontoX(){
		int x = this.getLocation().x;
		
		return x + (this.getSize().width/2);
	}
	
	public int getPontoY(){
		int y = this.getLocation().y;
		
		return y + (this.getSize().height/2);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.setLocation(e.getLocationOnScreen().x + (this.getSize().width / 2), e.getLocationOnScreen().y + (this.getSize().height / 2));
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
}

class Ponto extends JPanel{
	private int x, y;
	
	public Ponto(Dimension tamanho) {
		super();
		this.x = (int) (tamanho.getWidth() / 2);
		this.y = (int) (tamanho.getHeight() / 2);
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
			
		g.setColor(Color.RED);
		g.fillOval(0, 0, 2, 2);
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}
