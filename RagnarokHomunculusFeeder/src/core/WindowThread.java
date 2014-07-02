package core;

import gui.JanelaTransparente;

public class WindowThread extends Thread {
	private JanelaTransparente janela;
	
	@Override
	public void run() {
		janela = new JanelaTransparente();
	}
	
	public JanelaTransparente getWindow(){
		return this.janela;
	}
	
	public void destroi(){
		janela.setVisible(false);
	}
}
