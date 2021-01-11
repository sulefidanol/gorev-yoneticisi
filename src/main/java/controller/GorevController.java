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
			System.out.println("HOÞGELDÝNÝZ");
			System.out.println("Görev Ekleme Ýçin 1 e Basýnýz.");
			System.out.println("Görev Silme Ýçin 2 ye Basýnýz.");
			System.out.println("Görev Düzenleme Ýçin 3 e Basýnýz.");
			System.out.println("Görevleri Listelemek Ýçin 4 e Basýnýz.");
			System.out.println("Yaptýðýnýz Görevleri Ýþaretlemek Ýçin 5 e Basýnýz. ");
			int secim = Integer.parseInt(scanner.nextLine());

			if (secim == 1) {
				System.out.println("Lütfen Göreve Ad Veriniz.");
				String gorevAdi = scanner.nextLine();
				System.out.println("Lütfen Görev Açýklamasý Giriniz.");
				String gorevAciklamasi = scanner.nextLine();
				gorevService.yeniGorevOlustur(gorevAdi, gorevAciklamasi);
				System.out.println("Görev Adý:" + " " + gorevAdi + " " + "Görev Açýklamasý:" + gorevAciklamasi + " "
						+ "olan görev oluþturuldu.");

			} else if (secim == 2) {

				while (true) {
					int count = 1;
					System.out.println("Lütfen Silmek Ýstediðiniz Görevi Seçiniz.");
					for (Gorev gorev : gorevService.hepsiniGetir()) {
						System.out.println(count + " " + gorev.toString());
						count++;
					}
					int secim3 = Integer.parseInt(scanner.nextLine());
					System.out.println("Silinen Görev:" + " " + gorevService.gorevGetir(secim3 - 1));
					gorevService.gorevSil(secim3-1);
				}
			} else if (secim == 3) {
				while (true) {
					int count = 1;
					System.out.println("Lütfen Düzenlemek Ýstediðiniz Görevi Seçiniz.");
					for (Gorev gorev : gorevService.hepsiniGetir()) {
						System.out.println(count + " " + gorev.toString());
						count++;
					}
					int secim2 = Integer.parseInt(scanner.nextLine());
					Gorev secilenGorev = gorevService.gorevGetir(secim2 - 1);
					System.out.println();
					System.out.println("Yeni Görev Adýný Giriniz.");
					String gorevAdi = scanner.nextLine();
					System.out.println(gorevAdi);
					System.out.println("Yeni Görev Açýklamasýný Giriniz.");
					String gorevAciklamasi = scanner.nextLine();
					System.out
							.println("Görev:" + " " + gorevAdi + " " + gorevAciklamasi + " " + "olarak deðiþtirildi.");
					gorevService.gorevGüncelle(secim2-1, gorevAdi, gorevAciklamasi);

				}
			} else if (secim == 4) {
				for (Gorev gorev : gorevService.hepsiniGetir()) {
					System.out.println(gorev.toString());

				}

			} else if (secim == 5) {

				while (true) {
					int count = 1;
					System.out.println("Lütfen Ýþaretlemek Ýstediðiniz Görevi Seçiniz.");
					for (Gorev gorev : gorevService.hepsiniGetir()) {
						System.out.println(count + " " + gorev.toString());
						count++;
					}
					int secim4 = Integer.parseInt(scanner.nextLine());
					System.out.println("Yapýlan Görev:" + " " + gorevService.gorevGetir(secim4-1));
					gorevService.gorevTamamla(secim4-1);
				}

			} else {
				devamEt = false;
				System.out.println("GÜLE GÜLE");
			}
			scanner.close();
		}
	}
}


