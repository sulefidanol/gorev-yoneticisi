package controller;

import java.util.Scanner;

import model.Kisi;
import service.KisiService;
import repository.KisiRepository;

public class KisiController {
	private int kisiId;

	public void Kisi() {
		Scanner scanner = new Scanner(System.in);
		KisiService kisiService = new KisiService();
		System.out.println("Kaydolmak i�in 1 e Bas�n�z");
		System.out.println("Ki�i silmek i�in  2ye Bas�n�z");
		System.out.println("Bilgileri G�ncellemek i�in3 e Bas�n�z");
		int secim = Integer.parseInt(scanner.nextLine());
		if (secim == 1) {
			System.out.println("l�tfen ad�n�z� girin ");
			String kisiAdi = scanner.nextLine();
			System.out.println("l�tfen soyad�n�z� girin ");
			String kisiSoyadi = scanner.nextLine();
			kisiService.yeniKisiOlustur(kisiAdi, kisiSoyadi, kisiId);
		} else if (secim == 2) {
			System.out.println("L�tfen Silmek �stedi�iniz ki�iyi Se�iniz.");
			int count = 1;
			for (Kisi kisi : kisiService.hepsiniGetir()) {
				System.out.println(kisi.getKisiId() + " " + kisi.toString());
				count++;
			}
			int secim3 = Integer.parseInt(scanner.nextLine());
			kisiService.kisiSilme(secim3);
		} else if (secim == 3) {
			System.out.println("L�tfen D�zenlemek �stedi�iniz ki�iyi Se�iniz.");
			
			for (Kisi kisi : kisiService.hepsiniGetir()) {
				System.out.println(kisi.getKisiId() + " " + kisi.toString());
				
			}
			int secim2 = Integer.parseInt(scanner.nextLine());
			Kisi secilenKisi = kisiService.kisiGetir(secim2);
			System.out.println("Ad�n�z� Giriniz");
			String kisiAdi = scanner.nextLine();
			System.out.println("Soyad�n�z� griniz");
			String kisiSoyadi = scanner.nextLine();
			kisiService.kisiG�ncelleme(secim2, kisiAdi, kisiSoyadi);
		}
	}
}