package service;

import java.util.ArrayList;
import model.Kisi;
import repository.KisiRepository;

public class KisiService {
	KisiRepository kisiRepository = new KisiRepository();

	public Kisi yeniKisiOlustur(String kisiAdi, String kisiSoyadi, int kisiId) {
		Kisi yeniKisi = new Kisi(kisiId, kisiAdi, kisiSoyadi);
		kisiRepository.create(yeniKisi);
		return yeniKisi;
	}

	public void kisiSilme(int index) {
		kisiRepository.delete(index);
	}

	public Kisi kisiGüncelleme(int kisiId, String kisiAdi, String kisiSoyadi) {
		Kisi kisi = kisiRepository.getKisi(kisiId);
		kisi.setKisiAdi(kisiAdi);
		kisi.setKisiSoyadi(kisiSoyadi);
		kisiRepository.update(kisi);
		return kisi;
	}

	public Kisi kisiGetir(int index) {
		return kisiRepository.getKisi(index);

	}

	public ArrayList<Kisi> hepsiniGetir() {
		return kisiRepository.getKisiler();
	}
}
