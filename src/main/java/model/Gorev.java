package model;

public class Gorev {
	private int id;
	private String gorevAdý;
	private String gorevAciklamasi;
	private boolean yapýlmýsGorev;

	public Gorev(String gorevAdý, String gorevAciklamasi, boolean yapýlmýsGorev) {
		super();
		this.gorevAdý = gorevAdý;
		this.gorevAciklamasi = gorevAciklamasi;
		this.yapýlmýsGorev = yapýlmýsGorev;
	} 
	

	public Gorev(int id,String gorevAdý, String gorevAciklamasi, boolean yapýlmýsGorev) {
		super();
		this.id = id;
		this.gorevAdý = gorevAdý;
		this.gorevAciklamasi = gorevAciklamasi;
		this.yapýlmýsGorev = yapýlmýsGorev;
	}


	public String getGorevAdý() {
		return gorevAdý;
	}

	public void setGorevAdý(String gorevAdý) {
		this.gorevAdý = gorevAdý;
	}

	public String getGorevAciklamasi() {
		return gorevAciklamasi;
	}

	public void setGorevAciklamasi(String gorevAciklamasi) {
		this.gorevAciklamasi = gorevAciklamasi;
	}

	public boolean isYapýlmýsGorev() {
		return yapýlmýsGorev;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setYapýlmýsGorev(boolean yapýlmýsGorev) {
		this.yapýlmýsGorev = yapýlmýsGorev;
	}
	public void showÝnfos() {
		System.out.println("Görev Adý"+ " "+ this.gorevAdý);
		System.out.println("Görev Açýklamasý"+ " " + this.gorevAciklamasi);
		
	}
	public String toString(){
		return this.gorevAdý+" "+ this.gorevAciklamasi+" "+this.yapýlmýsGorev;
		

}
}
