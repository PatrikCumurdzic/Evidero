package osoba;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class OsobaCTRL {
	private List <OsobaMODEL> listaOsoba = new ArrayList <OsobaMODEL>();
	
	public List<OsobaMODEL> dohvatiOsobe() {
		ucitajIzDatoteke();
		return listaOsoba;
			
	}
	
	private void ucitajIzDatoteke() {
		
		try {
			FileInputStream citanjeDatoteke = new FileInputStream("listaOsoba.dat");
			if (citanjeDatoteke.available() > 0) {
				ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
				listaOsoba = (List<OsobaMODEL>) citajObjekt.readObject();
			}
		} catch (ClassNotFoundException e){
			//e.printStackTrace();
		} catch (IOException e){
			//e.printStackTrace();
		}
	}

	public void ubaci(OsobaMODEL osoba) {	
		listaOsoba.add(osoba);
		spremiUDatoteku();
	}
	
	private void spremiUDatoteku(){
		try {
			FileOutputStream upisUDatoteku = new FileOutputStream("listaOsoba.dat");
			ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
			upisObjekta.writeObject (listaOsoba);
		} catch (IOException e){
			//e.printStackTrace();
		}
	}
}
