package service;

import java.util.ArrayList;

import model.Gorev;

public class GorevService {
	private ArrayList<Gorev> gorevler = new ArrayList<Gorev>();
	public Gorev yeniGorevOlustur(String gorevAdi,String gorevAciklamasi) {
		
		Gorev yeniGorev = new Gorev(gorevAdi, gorevAciklamasi, false);
		gorevler.add(yeniGorev);
		return yeniGorev;
	}
	public void gorevSil(int index) {
		gorevler.remove(index);
	}
	public Gorev gorevGetir(int index) {
		return gorevler.get(index);
		
	}
	public ArrayList<Gorev> hepsiniGetir(){
		return gorevler;
	}

	public Gorev gorevG�ncelle(int index,String gorevAdi,String gorevAciklamasi) {
		Gorev gorev = gorevGetir(index);
		gorev.setGorevAciklamasi(gorevAciklamasi);
		gorev.setGorevAd�(gorevAdi);
		return gorev;
	}
	public Gorev gorevTamamla(int index) {
		Gorev gorev = gorevGetir(index);
		gorev.setYap�lm�sGorev(true);
		return gorev;
	}
	
}
