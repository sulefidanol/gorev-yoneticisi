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
		System.out.println("Kaydolmak için 1 e Basýnýz");
		System.out.println("Kiþi silmek için  2ye Basýnýz");
		System.out.println("Bilgileri Güncellemek için3 e Basýnýz");
		int secim = Integer.parseInt(scanner.nextLine());
		if (secim == 1) {
			System.out.println("lütfen adýnýzý girin ");
			String kisiAdi = scanner.nextLine();
			System.out.println("lütfen soyadýnýzý girin ");
			String kisiSoyadi = scanner.nextLine();
			kisiService.yeniKisiOlustur(kisiAdi, kisiSoyadi, kisiId);
		} else if (secim == 2) {
			System.out.println("Lütfen Silmek Ýstediðiniz kiþiyi Seçiniz.");
			int count = 1;
			for (Kisi kisi : kisiService.hepsiniGetir()) {
				System.out.println(kisi.getKisiId() + " " + kisi.toString());
				count++;
			}
			int secim3 = Integer.parseInt(scanner.nextLine());
			kisiService.kisiSilme(secim3);
		} else if (secim == 3) {
			System.out.println("Lütfen Düzenlemek Ýstediðiniz kiþiyi Seçiniz.");
			
			for (Kisi kisi : kisiService.hepsiniGetir()) {
				System.out.println(kisi.getKisiId() + " " + kisi.toString());
				
			}
			int secim2 = Integer.parseInt(scanner.nextLine());
			Kisi secilenKisi = kisiService.kisiGetir(secim2);
			System.out.println("Adýnýzý Giriniz");
			String kisiAdi = scanner.nextLine();
			System.out.println("Soyadýnýzý griniz");
			String kisiSoyadi = scanner.nextLine();
			kisiService.kisiGüncelleme(secim2, kisiAdi, kisiSoyadi);
		}
	}
}