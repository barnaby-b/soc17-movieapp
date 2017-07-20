package hr.icm.soc17.examples.anchorpane;

public class Osoba {
	
	private String ime;
	private static int count;
	
	public Osoba(String ime2) {
		count++;
		ime = ime2;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime2) {
		ime = ime2;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		new Osoba("Ivan");
		new Osoba("Marko");
		
		System.out.println(Osoba.getCount());
		
		
	}
}
