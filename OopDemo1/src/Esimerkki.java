import java.util.ArrayList;

public class Esimerkki {

	public static void main(String[] args) {
				
		ArrayList<Integer> lista = new ArrayList<Integer>();
	
		Opiskelija opiskelija = new Opiskelija("Baa", "Buu");
		
		opiskelija.asetaPaaaine("Boo");
		
		
		for (int i=0; i<5; i++) {
			lista.add(i);
			System.out.println(lista);
		}
		
	}

}
