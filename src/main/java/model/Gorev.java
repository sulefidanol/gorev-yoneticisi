package model;

public class Gorev {
	private int id;
	private String gorevAd�;
	private String gorevAciklamasi;
	private boolean yap�lm�sGorev;

	public Gorev(String gorevAd�, String gorevAciklamasi, boolean yap�lm�sGorev) {
		super();
		this.gorevAd� = gorevAd�;
		this.gorevAciklamasi = gorevAciklamasi;
		this.yap�lm�sGorev = yap�lm�sGorev;
	} 
	

	public Gorev(int id,String gorevAd�, String gorevAciklamasi, boolean yap�lm�sGorev) {
		super();
		this.id = id;
		this.gorevAd� = gorevAd�;
		this.gorevAciklamasi = gorevAciklamasi;
		this.yap�lm�sGorev = yap�lm�sGorev;
	}


	public String getGorevAd�() {
		return gorevAd�;
	}

	public void setGorevAd�(String gorevAd�) {
		this.gorevAd� = gorevAd�;
	}

	public String getGorevAciklamasi() {
		return gorevAciklamasi;
	}

	public void setGorevAciklamasi(String gorevAciklamasi) {
		this.gorevAciklamasi = gorevAciklamasi;
	}

	public boolean isYap�lm�sGorev() {
		return yap�lm�sGorev;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setYap�lm�sGorev(boolean yap�lm�sGorev) {
		this.yap�lm�sGorev = yap�lm�sGorev;
	}
	public void show�nfos() {
		System.out.println("G�rev Ad�"+ " "+ this.gorevAd�);
		System.out.println("G�rev A��klamas�"+ " " + this.gorevAciklamasi);
		
	}
	public String toString(){
		return this.gorevAd�+" "+ this.gorevAciklamasi+" "+this.yap�lm�sGorev;
		

}
}
