package service;

import java.util.ArrayList;

import model.Gorev;
import repository.GorevRepository;

public class GorevService {
	
	private GorevRepository gorevRepository = new GorevRepository();
	
	public Gorev yeniGorevOlustur(String gorevAdi,String gorevAciklamasi) {
		Gorev yeniGorev = new Gorev(gorevAdi, gorevAciklamasi, false);
		gorevRepository.create(yeniGorev);
		return yeniGorev;
	}
	
	public void gorevSil(int index) {
		gorevRepository.delete(index);
	}
	
	public Gorev gorevGetir(int index) {
		return gorevRepository.getGorev(index);
		
	}
	
	public ArrayList<Gorev> hepsiniGetir(){
		return gorevRepository.getGorevler();
	}

	public Gorev gorevGüncelle(int index,String gorevAdi,String gorevAciklamasi) {
		Gorev gorev = gorevRepository.getGorev(index);
		gorev.setGorevAciklamasi(gorevAciklamasi);
		gorev.setGorevAdý(gorevAdi);
		gorevRepository.update(gorev);
		return gorev;
	}
	
	public Gorev gorevTamamla(int index) {
		Gorev gorev = gorevRepository.getGorev(index);
		gorev.setYapýlmýsGorev(!gorev.isYapýlmýsGorev());
		gorevRepository.update(gorev);
		return gorev;
	}
	
}
