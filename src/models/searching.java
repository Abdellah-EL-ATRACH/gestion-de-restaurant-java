package models;

public class searching {
	private int idplat;
	private String  nplat;
	private float prix;
	private String tel;
	public searching() {
		super();
	}
	public searching(int i,String n,float px,String t) {
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