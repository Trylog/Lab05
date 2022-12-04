package render;

import main.Main;
import symulation.Laborant;

import javax.swing.*;
import java.awt.*;

public class Kanwa extends JPanel{
	JLabel[] labelkiOrg;
	JLabel[] labelkiLab;
	public Kanwa(){

		this.setBounds(0,0,500,800);
		labelkiOrg=new JLabel[Main.liczbaOrganizmów];
		labelkiLab=new JLabel[Main.liczbaLaborantów];
		for (int i =0; i<Main.liczbaOrganizmów;i++){
			labelkiOrg[i]=new JLabel("O" + i +": "+Main.linia.hodowla[i].pożywienie + " " + Main.linia.hodowla[i].żywotność);
			labelkiOrg[i].setBounds(200+10,(800-Main.liczbaOrganizmów*25)/2+i*25,100,25);
			this.add(labelkiOrg[i]);
		}
		for (int j=0; j<Main.liczbaLaborantów;j++){
			labelkiLab[j]=new JLabel("Lab");
			labelkiLab[j].setBounds(150+10,(800-Main.liczbaOrganizmów*25)/2+Main.laboranci[j].pozycja*25,50,25);
			this.add(labelkiLab[j]);
		}
		//this.setBackground(Color.cyan);


	}
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);

		if (this != null) {
			//program zadaje filozoficzne pytanie o byt
			this.rysuj((Graphics2D) arg0);
		}
	}

	void rysuj(Graphics g) {

		for (int i =0; i<Main.liczbaOrganizmów;i++) {
			labelkiOrg[i].setText("O" + i +": "+Main.linia.hodowla[i].pożywienie + " " + Main.linia.hodowla[i].żywotność);
			labelkiOrg[i].setBounds(200+10,(800-Main.liczbaOrganizmów*25)/2+i*25,100,25);
			labelkiOrg[i].repaint();
		}
		for (int j=0; j<Main.liczbaLaborantów;j++){
			labelkiLab[j].setText("L: "+Main.laboranci[j].zbiornik);
			labelkiLab[j].setBounds(150+10,(800-Main.liczbaOrganizmów*25)/2+Main.laboranci[j].pozycja*25,50,25);
			labelkiLab[j].repaint();
		}

		Graphics2D rys = (Graphics2D) g;
		rys.drawLine(150, (800-Main.liczbaOrganizmów*25)/2,150,Main.liczbaOrganizmów*25+(800-Main.liczbaOrganizmów*25)/2);
		rys.drawLine(200, (800-Main.liczbaOrganizmów*25)/2,200,Main.liczbaOrganizmów*25+(800-Main.liczbaOrganizmów*25)/2);
		rys.drawLine(275, (800-Main.liczbaOrganizmów*25)/2,275,Main.liczbaOrganizmów*25+(800-Main.liczbaOrganizmów*25)/2);
		for (int i=0;i<Main.liczbaOrganizmów+1;i++){
			rys.drawLine(150,(800-Main.liczbaOrganizmów*25)/2+i*25,275,(800-Main.liczbaOrganizmów*25)/2+i*25);
		}
	}
}
