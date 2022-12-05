package render;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	Kanwa scena;
	public MainFrame(){
		this.setSize(new Dimension(500,835));
		this.setName("Lab05");
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		scena=new Kanwa();
		this.add(scena);
	}
	public void rysuj(){
		scena.repaint();;
	}
}
