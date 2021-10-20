package administracija;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.io.LineNumberInputStream;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import administracija.AdministracijaMODEL;

public class AdministracijaVIEW{

	protected Shell shlAdministracija;
	private Text txtMjestoStanovanja;
	private Text txtTvrtka;
	private Text txtFakultet;
	private Text txtSrednjaSkola;
	private Text txtOsnovnaSkola;
	
	private AdministracijaMODEL korisnickiUnos = new AdministracijaMODEL();
	private AdministracijaCTRL controller = new AdministracijaCTRL();
	private List <AdministracijaMODEL> listafax;
	private List <AdministracijaMODEL> listamjesto;
	private List <AdministracijaMODEL> listaosnovna;
	private List <AdministracijaMODEL> listatvrtke;
	private List <AdministracijaMODEL> listasrednja;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AdministracijaVIEW window = new AdministracijaVIEW();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAdministracija.open();
		shlAdministracija.layout();
		while (!shlAdministracija.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAdministracija = new Shell();
		shlAdministracija.setSize(450, 598);
		shlAdministracija.setText("Administracija");
		
		Label lblMjestostanovanja = new Label(shlAdministracija, SWT.NONE);
		lblMjestostanovanja.setBounds(10, 13, 102, 15);
		lblMjestostanovanja.setText("Mjesto stanovanja:");
		
		Button btnIzmijeniMjestoStanovanja = new Button(shlAdministracija, SWT.NONE);
		btnIzmijeniMjestoStanovanja.setEnabled(false);
		
		Button btnObrisiMjestoStanovanja = new Button(shlAdministracija, SWT.NONE);
		btnObrisiMjestoStanovanja.setEnabled(false);
		
		Combo cmbMjestoStanovanja = new Combo(shlAdministracija, SWT.NONE);
		cmbMjestoStanovanja.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = listamjesto.get(cmbMjestoStanovanja.getSelectionIndex());
				txtMjestoStanovanja.setText(korisnickiUnos.getMjestoStanovanja());
				btnIzmijeniMjestoStanovanja.setEnabled(true);
				btnObrisiMjestoStanovanja.setEnabled(true);
			}
		});
		cmbMjestoStanovanja.setBounds(114, 10, 310, 23);
		
		listamjesto = controller.dohvatiMjestaStanovanja();
		
		for (int index = 0; index < listamjesto.size(); index++) {
			cmbMjestoStanovanja.add(listamjesto.get(index).getMjestoStanovanja(), index);	
		}
		
		txtMjestoStanovanja = new Text(shlAdministracija, SWT.BORDER);
		txtMjestoStanovanja.setBounds(10, 39, 414, 21);
		
		btnIzmijeniMjestoStanovanja.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setMjestoStanovanja(txtMjestoStanovanja.getText());
				
				if (provjeraMjesta(korisnickiUnos)){
				controller.izmjeniMjestaStanovanja(korisnickiUnos);
				cmbMjestoStanovanja.setText(korisnickiUnos.getMjestoStanovanja());
				cmbMjestoStanovanja.setItem(cmbMjestoStanovanja.getSelectionIndex(), korisnickiUnos.getMjestoStanovanja());
				}
			}
		});
		btnIzmijeniMjestoStanovanja.setBounds(174, 66, 75, 25);
		btnIzmijeniMjestoStanovanja.setText("Izmijeni");
		
		btnObrisiMjestoStanovanja.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(shlAdministracija, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        messageBox.setMessage("Želite li obrisati izabrano mjesto?");
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  controller.obrisiMjestaStanovanja(korisnickiUnos);
						
						cmbMjestoStanovanja.setText("");
						cmbMjestoStanovanja.remove(cmbMjestoStanovanja.getSelectionIndex());
						txtMjestoStanovanja.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
			}
		});
		btnObrisiMjestoStanovanja.setBounds(349, 66, 75, 25);
		btnObrisiMjestoStanovanja.setText("Obri\u0161i");
		
		Button btnNoviMjestoStanovanja = new Button(shlAdministracija, SWT.NONE);
		btnNoviMjestoStanovanja.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setMjestoStanovanja(txtMjestoStanovanja.getText());
				if (provjeraMjesta(korisnickiUnos)){
					controller.ubaciMjestaStanovanja(korisnickiUnos);
					
					cmbMjestoStanovanja.setText(korisnickiUnos.getMjestoStanovanja());
					cmbMjestoStanovanja.add(korisnickiUnos.getMjestoStanovanja());
					cmbMjestoStanovanja.select(cmbMjestoStanovanja.getItemCount() - 1);
					btnIzmijeniMjestoStanovanja.setEnabled(true);
					btnObrisiMjestoStanovanja.setEnabled(true);
				}
			}
		});
		
		btnNoviMjestoStanovanja.setBounds(10, 66, 75, 25);
		btnNoviMjestoStanovanja.setText("Novi");
		
		Label label = new Label(shlAdministracija, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 97, 414, 10);
		
		Label label_1 = new Label(shlAdministracija, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(10, 200, 414, 10);
		
		Label lblTvrtka = new Label(shlAdministracija, SWT.NONE);
		lblTvrtka.setBounds(10, 116, 36, 15);
		lblTvrtka.setText("Tvrtka:");
		
		Button btnObrisiTvrtka = new Button(shlAdministracija, SWT.NONE);
		btnObrisiTvrtka.setEnabled(false);
		
		Button btnIzmijeniTvrtka = new Button(shlAdministracija, SWT.NONE);
		btnIzmijeniTvrtka.setEnabled(false);
		
		Combo cmbTvrtka = new Combo(shlAdministracija, SWT.NONE);
		cmbTvrtka.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = listatvrtke.get(cmbTvrtka.getSelectionIndex());
				txtTvrtka.setText(korisnickiUnos.getFirma());
				btnIzmijeniTvrtka.setEnabled(true);
				btnObrisiTvrtka.setEnabled(true);
			}
		});
		cmbTvrtka.setBounds(52, 113, 372, 23);
		
		btnIzmijeniTvrtka.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setFirma(txtTvrtka.getText());
				
				if (provjeraTvrtke(korisnickiUnos)){
				controller.izmjeniTvrtke(korisnickiUnos);
				cmbTvrtka.setText(korisnickiUnos.getFirma());
				cmbTvrtka.setItem(cmbTvrtka.getSelectionIndex(), korisnickiUnos.getFirma());
				}
			}
		});
		
		listatvrtke = controller.dohvatiTvrtke();
		
		for (int index = 0; index < listatvrtke.size(); index++) {
			cmbTvrtka.add(listatvrtke.get(index).getFirma(), index);	
		}

		
		txtTvrtka = new Text(shlAdministracija, SWT.BORDER);
		txtTvrtka.setBounds(10, 142, 414, 21);
		
		Button btnNoviTvrtka = new Button(shlAdministracija, SWT.NONE);
		btnNoviTvrtka.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setFirma(txtTvrtka.getText());
				if (provjeraTvrtke(korisnickiUnos)){
				controller.ubaciTvrtke(korisnickiUnos);
				cmbTvrtka.setText(korisnickiUnos.getFirma());
				cmbTvrtka.add(korisnickiUnos.getFirma());
				cmbTvrtka.select(cmbTvrtka.getItemCount() - 1);
				btnIzmijeniTvrtka.setEnabled(true);
				btnObrisiTvrtka.setEnabled(true);
				}
			}
		});
		btnNoviTvrtka.setText("Novi");
		btnNoviTvrtka.setBounds(10, 169, 75, 25);
		
		btnIzmijeniTvrtka.setText("Izmijeni");
		btnIzmijeniTvrtka.setBounds(174, 169, 75, 25);
		
		btnObrisiTvrtka.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(shlAdministracija, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        messageBox.setMessage("Želite li obrisati izabranu tvrtku?");
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  controller.obrisiTvrtke(korisnickiUnos);
						
						cmbTvrtka.setText("");
						cmbTvrtka.remove(cmbTvrtka.getSelectionIndex());
						txtTvrtka.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
			}
		});
		btnObrisiTvrtka.setText("Obri\u0161i");
		btnObrisiTvrtka.setBounds(349, 169, 75, 25);
		
		Label lblFakultet = new Label(shlAdministracija, SWT.NONE);
		lblFakultet.setBounds(10, 219, 45, 15);
		lblFakultet.setText("Fakultet:");
		
		Button btnObrisiFakultet = new Button(shlAdministracija, SWT.NONE);
		btnObrisiFakultet.setEnabled(false);
		
		Button btnIzmijeniFakultet = new Button(shlAdministracija, SWT.NONE);
		btnIzmijeniFakultet.setEnabled(false);
		
		Combo cmbFakultet = new Combo(shlAdministracija, SWT.NONE);
		cmbFakultet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = listafax.get(cmbFakultet.getSelectionIndex());
				txtFakultet.setText(korisnickiUnos.getFakultet());	
				btnIzmijeniFakultet.setEnabled(true);
				btnObrisiFakultet.setEnabled(true);
			}
		});
		cmbFakultet.setBounds(61, 216, 363, 23);
		
		btnIzmijeniFakultet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setFakultet(txtFakultet.getText());
				
				if (provjeraFakulteta(korisnickiUnos)){
				controller.izmjeniFakultete(korisnickiUnos);
				cmbFakultet.setItem(cmbFakultet.getSelectionIndex(), korisnickiUnos.getFakultet());
				}
			}
		});
		
		listafax = controller.dohvatiFakultete();
		
		for (int index = 0; index < listafax.size(); index++) {
			cmbFakultet.add(listafax.get(index).getFakultet(), index);	
		}

		
		txtFakultet = new Text(shlAdministracija, SWT.BORDER);
		txtFakultet.setBounds(10, 245, 414, 21);
		
		Button btnNoviFakultet = new Button(shlAdministracija, SWT.NONE);
		
		btnNoviFakultet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setFakultet(txtFakultet.getText());
				if (provjeraFakulteta(korisnickiUnos)){
				controller.ubaciFakultete(korisnickiUnos);
				cmbFakultet.setText(korisnickiUnos.getFakultet());
				cmbFakultet.add(korisnickiUnos.getFakultet());
				cmbFakultet.select(cmbFakultet.getItemCount() - 1);
				btnObrisiFakultet.setEnabled(true);
				btnIzmijeniFakultet.setEnabled(true);
				}
			}
		});
		btnNoviFakultet.setText("Novi");
		btnNoviFakultet.setBounds(10, 272, 75, 25);

		btnIzmijeniFakultet.setText("Izmijeni");
		btnIzmijeniFakultet.setBounds(174, 272, 75, 25);
		
		btnObrisiFakultet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(shlAdministracija, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        messageBox.setMessage("Želite li obrisati izabrani fakultet?");
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  controller.obrisiFakultete(korisnickiUnos);
						
						cmbFakultet.setText("");
						cmbFakultet.remove(cmbFakultet.getSelectionIndex());
						txtFakultet.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
			}
		});
		btnObrisiFakultet.setText("Obri\u0161i");
		btnObrisiFakultet.setBounds(349, 272, 75, 25);
		
		Label label_2 = new Label(shlAdministracija, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(10, 303, 414, 10);
		
		Label lblSrednjakola = new Label(shlAdministracija, SWT.NONE);
		lblSrednjakola.setText("Srednja \u0161kola:");
		lblSrednjakola.setBounds(10, 322, 75, 15);
		
		Button btnObrisiSrednjaSkola = new Button(shlAdministracija, SWT.NONE);
		btnObrisiSrednjaSkola.setEnabled(false);
		
		Button btnIzmijeniSrednjaSkola = new Button(shlAdministracija, SWT.NONE);
		btnIzmijeniSrednjaSkola.setEnabled(false);
		
		Combo cmbSrednjaSkola = new Combo(shlAdministracija, SWT.NONE);
		cmbSrednjaSkola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = listasrednja.get(cmbSrednjaSkola.getSelectionIndex());
				txtSrednjaSkola.setText(korisnickiUnos.getSrednjaSkola());
				btnIzmijeniSrednjaSkola.setEnabled(true);
				btnObrisiSrednjaSkola.setEnabled(true);
			}
		});
		
		btnIzmijeniSrednjaSkola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setSrednjaSkola(txtSrednjaSkola.getText());
				
				if (provjeraSrednjeSkole(korisnickiUnos)){
				controller.izmjeniSrednjeSkole(korisnickiUnos);
				cmbSrednjaSkola.setItem(cmbSrednjaSkola.getSelectionIndex(), korisnickiUnos.getSrednjaSkola());
				}
			}
		});
		

		cmbSrednjaSkola.setBounds(91, 319, 333, 23);
		
		listasrednja = controller.dohvatiSrednjeSkole();
		
		for (int index = 0; index < listasrednja.size(); index++) {
			cmbSrednjaSkola.add(listasrednja.get(index).getSrednjaSkola(), index);	
		}
		
		txtSrednjaSkola = new Text(shlAdministracija, SWT.BORDER);
		txtSrednjaSkola.setBounds(10, 348, 414, 21);
		
		Button btnNoviSrednjaSkola = new Button(shlAdministracija, SWT.NONE);
		btnNoviSrednjaSkola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setSrednjaSkola(txtSrednjaSkola.getText());
				if (provjeraSrednjeSkole(korisnickiUnos)){
				controller.ubaciSrednjeSkole(korisnickiUnos);
				cmbSrednjaSkola.setText(korisnickiUnos.getSrednjaSkola());
				cmbSrednjaSkola.add(korisnickiUnos.getSrednjaSkola());
				cmbSrednjaSkola.select(cmbSrednjaSkola.getItemCount() - 1);
				btnIzmijeniSrednjaSkola.setEnabled(true);
				btnObrisiSrednjaSkola.setEnabled(true);
				}
			}
		});
		btnNoviSrednjaSkola.setText("Novi");
		btnNoviSrednjaSkola.setBounds(10, 375, 75, 25);
		
		btnIzmijeniSrednjaSkola.setText("Izmijeni");
		btnIzmijeniSrednjaSkola.setBounds(174, 375, 75, 25);
		
		btnObrisiSrednjaSkola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(shlAdministracija, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        messageBox.setMessage("Želite li obrisati izabranu srednju školu?");
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  controller.obrisiSrednjeSkole(korisnickiUnos);
						
						cmbSrednjaSkola.setText("");
						cmbSrednjaSkola.remove(cmbSrednjaSkola.getSelectionIndex());
						txtSrednjaSkola.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
			}
		});
		btnObrisiSrednjaSkola.setText("Obri\u0161i");
		btnObrisiSrednjaSkola.setBounds(349, 375, 75, 25);
		
		Label label_3 = new Label(shlAdministracija, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(10, 406, 414, 10);
		
		Label lblOsnovnakola = new Label(shlAdministracija, SWT.NONE);
		lblOsnovnakola.setText("Osnovna \u0161kola:");
		lblOsnovnakola.setBounds(10, 425, 86, 15);
	
		Button btnObrisiOsnovnaSkola = new Button(shlAdministracija, SWT.NONE);
		btnObrisiOsnovnaSkola.setEnabled(false);
		
		Button btnIzmijeniOsnovnaSkola = new Button(shlAdministracija, SWT.NONE);
		btnIzmijeniOsnovnaSkola.setEnabled(false);
		
		Combo cmbOsnovnaSkola = new Combo(shlAdministracija, SWT.NONE);
		cmbOsnovnaSkola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = listaosnovna.get(cmbOsnovnaSkola.getSelectionIndex());
				txtOsnovnaSkola.setText(korisnickiUnos.getOsnovnaSkola());	
				btnObrisiOsnovnaSkola.setEnabled(true);
				btnIzmijeniOsnovnaSkola.setEnabled(true);
			}
		});
		
		btnIzmijeniOsnovnaSkola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setOsnovnaSkola(txtOsnovnaSkola.getText());
				
				if (provjeraOsnovneSkole(korisnickiUnos)){
				controller.izmjeniOsnovneSkole(korisnickiUnos);
				cmbOsnovnaSkola.setItem(cmbOsnovnaSkola.getSelectionIndex(), korisnickiUnos.getOsnovnaSkola());
				}
			}
		});
		cmbOsnovnaSkola.setBounds(98, 422, 326, 23);
		
		listaosnovna = controller.dohvatiOsnovneSkole();
		
		for (int index = 0; index < listaosnovna.size(); index++) {
			cmbOsnovnaSkola.add(listaosnovna.get(index).getOsnovnaSkola(), index);	
		}

		
		txtOsnovnaSkola = new Text(shlAdministracija, SWT.BORDER);
		txtOsnovnaSkola.setBounds(10, 451, 414, 21);
		
		Button btnNoviOsnovnaSkola = new Button(shlAdministracija, SWT.NONE);
		btnNoviOsnovnaSkola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new AdministracijaMODEL();
				korisnickiUnos.setOsnovnaSkola(txtOsnovnaSkola.getText());
				if (provjeraOsnovneSkole(korisnickiUnos)){
				controller.ubaciOsnovneSkole(korisnickiUnos);
				cmbOsnovnaSkola.setText(korisnickiUnos.getOsnovnaSkola());
				cmbOsnovnaSkola.add(korisnickiUnos.getOsnovnaSkola());
				cmbOsnovnaSkola.select(cmbOsnovnaSkola.getItemCount() - 1);
				btnObrisiOsnovnaSkola.setEnabled(true);
				btnIzmijeniOsnovnaSkola.setEnabled(true);
				}
			}
		});
		btnNoviOsnovnaSkola.setText("Novi");
		btnNoviOsnovnaSkola.setBounds(10, 478, 75, 25);

		btnIzmijeniOsnovnaSkola.setText("Izmijeni");
		btnIzmijeniOsnovnaSkola.setBounds(174, 478, 75, 25);
		
		btnObrisiOsnovnaSkola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(shlAdministracija, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		        
		        messageBox.setText("Brisanje");
		        messageBox.setMessage("Želite li obrisati izabranu osnovnu školu?");
		        int buttonID = messageBox.open();
		        switch(buttonID) {
		          case SWT.YES:
		        	  controller.obrisiOsnovneSkole(korisnickiUnos);
						
						cmbOsnovnaSkola.setText("");
						cmbOsnovnaSkola.remove(cmbOsnovnaSkola.getSelectionIndex());
						txtMjestoStanovanja.setText("");
		          case SWT.NO:
		            // exits here ...
		            break;
		          case SWT.CANCEL:
		            // does nothing ...
		        }
			}
		});
		btnObrisiOsnovnaSkola.setText("Obri\u0161i");
		btnObrisiOsnovnaSkola.setBounds(349, 478, 75, 25);
		
		Label label_4 = new Label(shlAdministracija, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(10, 509, 414, 10);
		
		Button btnZatvori = new Button(shlAdministracija, SWT.NONE);
		btnZatvori.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAdministracija.close();
			}
		});
		btnZatvori.setBounds(10, 525, 414, 25);
		btnZatvori.setText("Zatvori");

	}
	
	boolean provjeraMjesta(AdministracijaMODEL mjesto) {
		if(mjesto.getMjestoStanovanja().isEmpty()) {
			MessageBox messageBox = new MessageBox (shlAdministracija,SWT.ICON_WARNING|SWT.OK);
			messageBox.setMessage("Naziv mjesta nemoze biti prazano.");
			messageBox.setText("Greška");
			messageBox.open();
			
			return false;
		}
		
		for(int index = 0; index<listamjesto.size();index++) {
			if(listamjesto.get(index).getMjestoStanovanja().equalsIgnoreCase(korisnickiUnos.getMjestoStanovanja())) {
				MessageBox messageBox=new MessageBox(shlAdministracija,SWT.ICON_WARNING|SWT.OK);
					messageBox.setText("Greška");
					messageBox.setMessage("Naziv mjesta veæ postoji.");
					messageBox.open();
					return false;
				}
			}
		return true;
	}
	boolean provjeraTvrtke(AdministracijaMODEL firma) {
		if(firma.getFirma().isEmpty()) {
			MessageBox messageBox = new MessageBox (shlAdministracija,SWT.ICON_WARNING|SWT.OK);
			messageBox.setMessage("Naziv tvrtke nemoze biti prazano.");
			messageBox.setText("Greška");
			messageBox.open();
			
			return false;
		}
		
		for(int index = 0; index<listatvrtke.size();index++) {
			if(listatvrtke.get(index).getFirma().equalsIgnoreCase(korisnickiUnos.getFirma())) {
				MessageBox messageBox=new MessageBox(shlAdministracija,SWT.ICON_WARNING|SWT.OK);
					messageBox.setText("Greška");
					messageBox.setMessage("Naziv tvrtke veæ postoji.");
					messageBox.open();
					return false;
				}
			}
		return true;
	}
	boolean provjeraFakulteta(AdministracijaMODEL fax) {
		if(fax.getFakultet().isEmpty()) {
			MessageBox messageBox = new MessageBox (shlAdministracija,SWT.ICON_WARNING|SWT.OK);
			messageBox.setMessage("Naziv fakulteta nemoze biti prazano.");
			messageBox.setText("Greška");
			messageBox.open();
			
			return false;
		}
		
		for(int index = 0; index<listafax.size();index++) {
			if(listafax.get(index).getFakultet().equalsIgnoreCase(korisnickiUnos.getFakultet())) {
				MessageBox messageBox=new MessageBox(shlAdministracija,SWT.ICON_WARNING|SWT.OK);
					messageBox.setText("Greška");
					messageBox.setMessage("Naziv fakulteta veæ postoji.");
					messageBox.open();
					return false;
				}
			}
		return true;
	}
	boolean provjeraSrednjeSkole(AdministracijaMODEL srednja) {
		if(srednja.getSrednjaSkola().isEmpty()) {
			MessageBox messageBox = new MessageBox (shlAdministracija,SWT.ICON_WARNING|SWT.OK);
			messageBox.setMessage("Naziv srednje škole nemoze biti prazano.");
			messageBox.setText("Greška");
			messageBox.open();
			
			return false;
		}
		
		for(int index = 0; index<listasrednja.size();index++) {
			if(listasrednja.get(index).getSrednjaSkola().equalsIgnoreCase(korisnickiUnos.getSrednjaSkola())) {
				MessageBox messageBox=new MessageBox(shlAdministracija,SWT.ICON_WARNING|SWT.OK);
					messageBox.setText("Greška");
					messageBox.setMessage("Naziv srednje škole veæ postoji.");
					messageBox.open();
					return false;
				}
			}
		return true;
	}
	boolean provjeraOsnovneSkole(AdministracijaMODEL osnovna) {
		if(osnovna.getOsnovnaSkola().isEmpty()) {
			MessageBox messageBox = new MessageBox (shlAdministracija,SWT.ICON_WARNING|SWT.OK);
			messageBox.setMessage("Naziv osnovne škole nemoze biti prazano.");
			messageBox.setText("Greška");
			messageBox.open();
			
			return false;
		}
		
		for(int index = 0; index<listaosnovna.size();index++) {
			if(listaosnovna.get(index).getOsnovnaSkola().equalsIgnoreCase(korisnickiUnos.getOsnovnaSkola())) {
				MessageBox messageBox=new MessageBox(shlAdministracija,SWT.ICON_WARNING|SWT.OK);
					messageBox.setText("Greška");
					messageBox.setMessage("Naziv osnovne škole veæ postoji.");
					messageBox.open();
					return false;
				}
			}
		return true;
	}
}
