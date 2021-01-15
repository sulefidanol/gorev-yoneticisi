package model;

public class Kisi {
	private int kisiId;
	private String kisiAdi;
	private String kisiSoyadi;

	public Kisi(int kisiId, String kisiAdi, String kisiSoyadi) {
		super();
		this.kisiId = kisiId;
		this.kisiAdi = kisiAdi;
		this.kisiSoyadi = kisiSoyadi;
	}

	public int getKisiId() {
		return kisiId;
	}

	public void setKisiId(int kisiId) {
		this.kisiId = kisiId;
	}

	public String getKisiAdi() {
		return kisiAdi;
	}

	public void setKisiAdi(String kisiAdi) {
		this.kisiAdi = kisiAdi;
	}

	public String getKisiSoyadi() {
		return kisiSoyadi;
	}

	public void setKisiSoyadi(String kisiSoyadi) {
		this.kisiSoyadi = kisiSoyadi;
	}

	public String toString() {
		return this.kisiAdi + "," + this.kisiSoyadi; 

	}

}
