package main;

import render.MainFrame;
import symulation.Dystrybutor;
import symulation.Laborant;
import symulation.Organizm;

public class Main {

	public static Linia linia;
	public static Dystrybutor dystrybutor;
	public static int liczbaOrganizmów;
	public static int liczbaLaborantów;
	public static Laborant[] laboranci;

	public static void main(String[] args) {

		liczbaOrganizmów=10;
		liczbaLaborantów=2;

		linia=new Linia(liczbaOrganizmów);
		dystrybutor=new Dystrybutor();

		laboranci = new Laborant[liczbaLaborantów];
		laboranci[0]=new Laborant(1,true);
		laboranci[0].setDaemon(true);
		laboranci[0].start();
		laboranci[1]=new Laborant(5,true);
		laboranci[1].setDaemon(true);
		laboranci[1].start();


		MainFrame f =new MainFrame();
	}

}
