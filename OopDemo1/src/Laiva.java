
public class Laiva {
	private String nimi;
	private double pituus;
	private double syvays;
	private double nopeus;
	
	public Laiva(String nimi, double pituus, double syvays, double nopeus) {
		super();
		this.nimi = nimi;
		this.pituus = pituus;
		this.syvays = syvays;
		this.nopeus = nopeus;
	}


	//Laskee ajan tunteina
	public double aikaMatkalla(int matka, double nopeus){
	//matka=km, nopeus=solmu
		return matka*nopeus*1.852;
	}
	

}
