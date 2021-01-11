package controller;

import java.util.Scanner;

import model.Gorev;
import service.GorevService;

public class GorevController {
	public void gorev() {

		Scanner scanner = new Scanner(System.in);
		GorevService gorevService = new GorevService();	
		boolean devamEt = true;
		while (devamEt) {
			System.out.println("HO�GELD�N�Z");
			System.out.println("G�rev Ekleme ��in 1 e Bas�n�z.");
			System.out.println("G�rev Silme ��in 2 ye Bas�n�z.");
			System.out.println("G�rev D�zenleme ��in 3 e Bas�n�z.");
			System.out.println("G�revleri Listelemek ��in 4 e Bas�n�z.");
			System.out.println("Yapt���n�z G�revleri ��aretlemek ��in 5 e Bas�n�z. ");
			int secim = Integer.parseInt(scanner.nextLine());

			if (secim == 1) {
				System.out.println("L�tfen G�reve Ad Veriniz.");
				String gorevAdi = scanner.nextLine();
				System.out.println("L�tfen G�rev A��klamas� Giriniz.");
				String gorevAciklamasi = scanner.nextLine();
				gorevService.yeniGorevOlustur(gorevAdi, gorevAciklamasi);
				System.out.println("G�rev Ad�:" + " " + gorevAdi + " " + "G�rev A��klamas�:" + gorevAciklamasi + " "
						+ "olan g�rev olu�turuldu.");

			} else if (secim == 2) {

				while (true) {
					int count = 1;
					System.out.println("L�tfen Silmek �stedi�iniz G�revi Se�iniz.");
					for (Gorev gorev : gorevService.hepsiniGetir()) {
						System.out.println(count + " " + gorev.toString());
						count++;
					}
					int secim3 = Integer.parseInt(scanner.nextLine());
					System.out.println("Silinen G�rev:" + " " + gorevService.gorevGetir(secim3 - 1));
					gorevService.gorevSil(secim3-1);
				}
			} else if (secim == 3) {
				while (true) {
					int count = 1;
					System.out.println("L�tfen D�zenlemek �stedi�iniz G�revi Se�iniz.");
					for (Gorev gorev : gorevService.hepsiniGetir()) {
						System.out.println(count + " " + gorev.toString());
						count++;
					}
					int secim2 = Integer.parseInt(scanner.nextLine());
					Gorev secilenGorev = gorevService.gorevGetir(secim2 - 1);
					System.out.println();
					System.out.println("Yeni G�rev Ad�n� Giriniz.");
					String gorevAdi = scanner.nextLine();
					System.out.println(gorevAdi);
					System.out.println("Yeni G�rev A��klamas�n� Giriniz.");
					String gorevAciklamasi = scanner.nextLine();
					System.out
							.println("G�rev:" + " " + gorevAdi + " " + gorevAciklamasi + " " + "olarak de�i�tirildi.");
					gorevService.gorevG�ncelle(secim2-1, gorevAdi, gorevAciklamasi);

				}
			} else if (secim == 4) {
				for (Gorev gorev : gorevService.hepsiniGetir()) {
					System.out.println(gorev.toString());

				}

			} else if (secim == 5) {

				while (true) {
					int count = 1;
					System.out.println("L�tfen ��aretlemek �stedi�iniz G�revi Se�iniz.");
					for (Gorev gorev : gorevService.hepsiniGetir()) {
						System.out.println(count + " " + gorev.toString());
						count++;
					}
					int secim4 = Integer.parseInt(scanner.nextLine());
					System.out.println("Yap�lan G�rev:" + " " + gorevService.gorevGetir(secim4-1));
					gorevService.gorevTamamla(secim4-1);
				}

			} else {
				devamEt = false;
				System.out.println("G�LE G�LE");
			}
			scanner.close();
		}
	}
}


