package models;

public class Commande {
	private int idplat;
	private String  nplat;
	private float prix;
	private String tel;
	public Commande() {
		super();
	}
	public Commande(int i,String n,float px,String t) {
		super();
		this.tel=t;
		this.idplat=i;
		this.nplat=n;
		this.prix=px; 
	}
	public int getId() {
		return idplat;
	}
	public void setId(int id) {
		this.idplat = id;
	}
	public String getNplat() {
		return nplat;
	}
	public void setNplat(String nplat) {
		this.nplat = nplat;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}