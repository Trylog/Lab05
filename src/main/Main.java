//Michał Bernacki-Janson

package main;

import render.MainFrame;
import symulation.Dystrybutor;
import symulation.Laborant;
import symulation.Organizm;

import javax.swing.*;

public class Main {

	public static Linia linia;
	public static Dystrybutor dystrybutor;
	public static int liczbaOrganizmów;
	public static int liczbaLaborantów;
	public static Laborant[] laboranci;
	public static int czasDystrybutor, czasOrganizmu, czasLaboranta;

	public static void main(String[] args) {

		String odp0, odp1, odp2, odp3, odp4;
		odp0 = JOptionPane.showInputDialog("Podaj liczbę organizmów");
		liczbaOrganizmów=Integer.parseInt(odp0);
		while (liczbaOrganizmów<1||liczbaOrganizmów>30){
			JOptionPane.showMessageDialog(null, "Nie poprawna liczba organizmów", "Błąd", JOptionPane.ERROR_MESSAGE);
			odp0=JOptionPane.showInputDialog("Podaj liczbę organizmów");
			liczbaOrganizmów=Integer.parseInt(odp0);
		}
		//liczbaOrganizmów=15;
		odp1=JOptionPane.showInputDialog("Podaj liczbę laborantów");
		liczbaLaborantów=Integer.parseInt(odp1);
		while (liczbaLaborantów<1||liczbaLaborantów>liczbaOrganizmów){
			JOptionPane.showMessageDialog(null,"Nie poprawna liczba laborantów","Błąd", JOptionPane.ERROR_MESSAGE);
			odp1=JOptionPane.showInputDialog("Podaj liczbę laborantów");
			liczbaLaborantów=Integer.parseInt(odp1);
		}
		odp2=JOptionPane.showInputDialog("Podaj czas potrzebny na napełnienie zbiornika laboranta");
		czasDystrybutor=Integer.parseInt(odp2);
		odp3=JOptionPane.showInputDialog("Podaj czas potrzebny na przemieszczenie się laboranta");
		czasLaboranta=Integer.parseInt(odp3);
		odp4=JOptionPane.showInputDialog("Podaj czas, po którym organizm zje jedno pożywienie");
		czasOrganizmu=Integer.parseInt(odp4);
/*
		czasDystrybutor=5000;
		czasOrganizmu=2000;
		czasLaboranta=500;*/
		linia=new Linia(liczbaOrganizmów);
		dystrybutor=new Dystrybutor();

		laboranci = new Laborant[liczbaLaborantów];
		for (int i=0;i<liczbaLaborantów;i++){
			laboranci[i]=new Laborant(liczbaOrganizmów/liczbaLaborantów*i,i%2==0?false:true);
			linia.linia[liczbaOrganizmów/liczbaLaborantów*i]=true;
			laboranci[i].setDaemon(true);

		}
		for (int i=0;i<liczbaLaborantów;i++){
			laboranci[i].start();
		}

		MainFrame f =new MainFrame();
	}

}
