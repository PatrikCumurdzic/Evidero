package administracija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import administracija.AdministracijaMODEL;

public class AdministracijaCTRL {
	private List <AdministracijaMODEL> listaMjestaStanovanja = new ArrayList <AdministracijaMODEL>();
	private List <AdministracijaMODEL> listaTvrtka = new ArrayList <AdministracijaMODEL>();
	private List <AdministracijaMODEL> listaFakulteta = new ArrayList <AdministracijaMODEL>();
	private List <AdministracijaMODEL> listaSrednjaSkola = new ArrayList <AdministracijaMODEL>();
	private List <AdministracijaMODEL> listaOsnovnaSkola = new ArrayList <AdministracijaMODEL>();
	
	public List <AdministracijaMODEL> dohvatiMjestaStanovanja(){
		ucitajMjestaStanovanjaIzDatoteke();;
		return listaMjestaStanovanja;
	}
	public List <AdministracijaMODEL> dohvatiTvrtke(){
		ucitajTvrtkeIzDatoteke();
		return listaTvrtka;
	}
	public List <AdministracijaMODEL> dohvatiFakultete(){
		ucitajFakulteteIzDatoteke();
		return listaFakulteta;
	}
	public List <AdministracijaMODEL> dohvatiOsnovneSkole(){
		ucitajOsnovneSkoleIzDatoteke();
		return listaOsnovnaSkola;
	}
	public List <AdministracijaMODEL> dohvatiSrednjeSkole(){
		ucitajSrednjeSkoleIzDatoteke();
		return listaSrednjaSkola;
	}

	
//Izmjenjivanje
	public void izmjeniMjestaStanovanja(AdministracijaMODEL mjesto) {	
		int index = listaMjestaStanovanja.indexOf(mjesto);
		if (index >= 0) {
			listaMjestaStanovanja.set(index, mjesto);
			spremiMjestaStanovanjaUDatoteku();
		}
	}
	public void izmjeniTvrtke(AdministracijaMODEL firma) {	
		int index = listaTvrtka.indexOf(firma);
		if (index >= 0) {
			listaTvrtka.set(index, firma);
			spremiTvrtkeUDatoteku();
		}
	}
	public void izmjeniFakultete(AdministracijaMODEL fax) {	
		int index = listaFakulteta.indexOf(fax);
		if (index >= 0) {
			listaFakulteta.set(index, fax);
			spremiFakulteteUDatoteku();
		}
	}
	public void izmjeniOsnovneSkole(AdministracijaMODEL osnovna) {	
		int index = listaOsnovnaSkola.indexOf(osnovna);
		if (index >= 0) {
			listaOsnovnaSkola.set(index, osnovna);
			spremiOsnovneSkoleUDatoteku();
		}
	}
	public void izmjeniSrednjeSkole(AdministracijaMODEL srednja) {	
		int index = listaSrednjaSkola.indexOf(srednja);
		if (index >= 0) {
			listaSrednjaSkola.set(index, srednja);
			spremiSrednjeSkoleUDatoteku();
		}
	}

	
//Ubacivanje u listu
	public void ubaciMjestaStanovanja(AdministracijaMODEL mjesto) {	
		listaMjestaStanovanja.add(mjesto);
		spremiMjestaStanovanjaUDatoteku();
	}
	public void ubaciTvrtke(AdministracijaMODEL firma) {
		listaTvrtka.add(firma);
		spremiTvrtkeUDatoteku();
	}
	public void ubaciFakultete(AdministracijaMODEL fax) {	
		listaFakulteta.add(fax);
		spremiFakulteteUDatoteku();
	}
	public void ubaciOsnovneSkole(AdministracijaMODEL osnovna) {
		listaOsnovnaSkola.add(osnovna);
		spremiOsnovneSkoleUDatoteku();
	}
	public void ubaciSrednjeSkole(AdministracijaMODEL srednja) {
		listaSrednjaSkola.add(srednja);
		spremiSrednjeSkoleUDatoteku();
	}
	
	
//Brisanje
	public void obrisiMjestaStanovanja(AdministracijaMODEL mjesto) {
		int index = listaMjestaStanovanja.indexOf(mjesto);
		if (index >= 0) {	
			listaMjestaStanovanja.remove(index);
			spremiMjestaStanovanjaUDatoteku();
		}
	}
	public void obrisiTvrtke(AdministracijaMODEL firma) {
		int index = listaTvrtka.indexOf(firma);
		if (index >= 0) {	
			listaTvrtka.remove(index);
			spremiTvrtkeUDatoteku();
		}
	}
	public void obrisiFakultete(AdministracijaMODEL fax) {
		int index = listaFakulteta.indexOf(fax);
		if (index >= 0) {	
			listaFakulteta.remove(index);
			spremiFakulteteUDatoteku();
		}
	}
	public void obrisiOsnovneSkole(AdministracijaMODEL osnovna) {
		int index = listaOsnovnaSkola.indexOf(osnovna);
		if (index >= 0) {	
			listaOsnovnaSkola.remove(index);
			spremiOsnovneSkoleUDatoteku();
		}
	}
	public void obrisiSrednjeSkole(AdministracijaMODEL srednja) {
		int index = listaSrednjaSkola.indexOf(srednja);
		if (index >= 0) {	
			listaSrednjaSkola.remove(index);
			spremiSrednjeSkoleUDatoteku();
		}
	}
	
	
//Spremanja u datoteku	
	private void spremiMjestaStanovanjaUDatoteku(){
		try {
			FileOutputStream upisUDatoteku = new FileOutputStream("mjestaStanovanja.dat");
			ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
			upisObjekta.writeObject (listaMjestaStanovanja);
		} catch (IOException e){
			//e.printStackTrace();
		}
	}
	private void spremiTvrtkeUDatoteku(){
		try {
			FileOutputStream upisUDatoteku = new FileOutputStream("tvrtke.dat");
			ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
			upisObjekta.writeObject (listaTvrtka);
		} catch (IOException e){
			//e.printStackTrace();
		}
	}
	private void spremiFakulteteUDatoteku(){
		try {
			FileOutputStream upisUDatoteku = new FileOutputStream("fakulteti.dat");
			ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
			upisObjekta.writeObject (listaFakulteta);
		} catch (IOException e){
			//e.printStackTrace();
		}
	}
	private void spremiOsnovneSkoleUDatoteku(){
		try {
			FileOutputStream upisUDatoteku = new FileOutputStream("osnovnaSkola.dat");
			ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
			upisObjekta.writeObject (listaOsnovnaSkola);
		} catch (IOException e){
			//e.printStackTrace();
		}
	}
	private void spremiSrednjeSkoleUDatoteku(){
		try {
			FileOutputStream upisUDatoteku = new FileOutputStream("srednjaSkola.dat");
			ObjectOutput upisObjekta = new ObjectOutputStream(upisUDatoteku);
			upisObjekta.writeObject (listaSrednjaSkola);
		} catch (IOException e){
			//e.printStackTrace();
		}
	}
	
	
//Citanja iz datoteke	
	private void ucitajMjestaStanovanjaIzDatoteke() {
		
		try {
			FileInputStream citanjeDatoteke = new FileInputStream("mjestaStanovanja.dat");
			if (citanjeDatoteke.available() > 0) {
				ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
				listaMjestaStanovanja = (List<AdministracijaMODEL>) citajObjekt.readObject();
			}
		} catch (ClassNotFoundException e){
			//e.printStackTrace();
		} catch (IOException e){
			//e.printStackTrace();
		}
	}
	private void ucitajTvrtkeIzDatoteke() {
	
	try {
		FileInputStream citanjeDatoteke = new FileInputStream("tvrtke.dat");
		if (citanjeDatoteke.available() > 0) {
			ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
			listaTvrtka = (List<AdministracijaMODEL>) citajObjekt.readObject();
			}
		} catch (ClassNotFoundException e){
		//e.printStackTrace();
		} catch (IOException e){
		//e.printStackTrace();
		}
	}
	private void ucitajFakulteteIzDatoteke() {
	
	try {
		FileInputStream citanjeDatoteke = new FileInputStream("fakulteti.dat");
		if (citanjeDatoteke.available() > 0) {
			ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
			listaFakulteta = (List<AdministracijaMODEL>) citajObjekt.readObject();
			}
		} catch (ClassNotFoundException e){
		//e.printStackTrace();
		} catch (IOException e){
		//e.printStackTrace();
		}
	}
	private void ucitajOsnovneSkoleIzDatoteke() {
	
		try {
			FileInputStream citanjeDatoteke = new FileInputStream("osnovnaSkola.dat");
			if (citanjeDatoteke.available() > 0) {
				ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
				listaOsnovnaSkola = (List<AdministracijaMODEL>) citajObjekt.readObject();
			}
		} catch (ClassNotFoundException e){
		//e.printStackTrace();
		} catch (IOException e){
		//e.printStackTrace();
		}
	}
	private void ucitajSrednjeSkoleIzDatoteke() {
	
		try {
			FileInputStream citanjeDatoteke = new FileInputStream("srednjaSkola.dat");
			if (citanjeDatoteke.available() > 0) {
				ObjectInputStream citajObjekt = new ObjectInputStream (citanjeDatoteke);
				listaSrednjaSkola = (List<AdministracijaMODEL>) citajObjekt.readObject();
			}
		} catch (ClassNotFoundException e){
		//e.printStackTrace();
		} catch (IOException e){
		//e.printStackTrace();
		}
	}

}