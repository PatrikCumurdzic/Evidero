package osoba;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import administracija.AdministracijaCTRL;
import administracija.AdministracijaMODEL;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class NovaOsobaVIEW {

	protected Shell shlEvidentiranjeNoveOsobe;
	private Text txtIme;
	private Text txtGodinaRodjenja;
	private Text txtDatumRodjenja;
	private Text txtPrezime;
	private Label label_1;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private Label lblNewLabel_1;
	private Combo cmbMjestoStanovanja;
	private Combo cmbSpol;
	private Label lblMjestoRoenja;
	private Label label_6;
	private Text txtMjestoRodjenja;
	private Label label_5;
	private Combo cmbBracniStatus;
	private Label lblBraniStatus;
	private Label label_7;
	private Combo cmbRadniStatus;
	private Label lblRadniStatus;
	private Label label_8;
	private Label lblOib;
	private Text txtOIB;
	private Label label_10;
	private Button btnSpremi;
	private Button btnOdustani;
	private Combo cmbRadniStatus2;

	private OsobaMODEL korisnickiUnos = new OsobaMODEL();
	private OsobaCTRL controller = new OsobaCTRL();
	private AdministracijaMODEL administracija = new AdministracijaMODEL();
	private AdministracijaCTRL adminiCTRL = new AdministracijaCTRL();
	private List <OsobaMODEL> listaOsoba;
	private List <AdministracijaMODEL> listaMjesta;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NovaOsobaVIEW window = new NovaOsobaVIEW();
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
		shlEvidentiranjeNoveOsobe.open();
		shlEvidentiranjeNoveOsobe.layout();
		while (!shlEvidentiranjeNoveOsobe.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEvidentiranjeNoveOsobe = new Shell();
		shlEvidentiranjeNoveOsobe.setSize(397, 535);
		shlEvidentiranjeNoveOsobe.setText("Evidentiranje nove osobe");
		
		Label lblIme = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblIme.setBounds(10, 13, 29, 15);
		lblIme.setText("Ime:");
		
		txtIme = new Text(shlEvidentiranjeNoveOsobe, SWT.BORDER);
		txtIme.setBounds(121, 10, 250, 21);
		
		Label lblPrezime = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblPrezime.setBounds(10, 53, 52, 15);
		lblPrezime.setText("Prezime:");
		
		txtGodinaRodjenja = new Text(shlEvidentiranjeNoveOsobe, SWT.BORDER);
		txtGodinaRodjenja.setBounds(121, 127, 250, 21);
		
		Label lblNewLabel = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblNewLabel.setBounds(10, 90, 91, 15);
		lblNewLabel.setText("Datum ro\u0111enja:");
		
		Label lblGodinaRoenja = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblGodinaRoenja.setBounds(10, 130, 84, 15);
		lblGodinaRoenja.setText("Godina ro\u0111enja:");
		
		txtDatumRodjenja = new Text(shlEvidentiranjeNoveOsobe, SWT.BORDER);
		txtDatumRodjenja.setBounds(121, 87, 250, 21);
		
		Label lblSpol = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblSpol.setBounds(10, 170, 35, 15);
		lblSpol.setText("Spol:");
		
		txtPrezime = new Text(shlEvidentiranjeNoveOsobe, SWT.BORDER);
		txtPrezime.setBounds(121, 50, 250, 21);
		
		Label label = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 37, 361, 10);
		
		label_1 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(10, 74, 361, 10);
		
		label_2 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(10, 114, 361, 10);
		
		label_3 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(10, 151, 361, 10);
		
		label_4 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(10, 191, 361, 10);
		
		lblNewLabel_1 = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblNewLabel_1.setBounds(10, 253, 99, 15);
		lblNewLabel_1.setText("Mjesto stanovanja:");
		
		
		cmbMjestoStanovanja = new Combo(shlEvidentiranjeNoveOsobe, SWT.NONE);
		cmbMjestoStanovanja.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				listaMjesta = adminiCTRL.dohvatiMjestaStanovanja();
				for (int index = 0; index < listaMjesta.size(); index++) {
					cmbMjestoStanovanja.add(listaMjesta.get(index).getMjestoStanovanja(), index);	
				}
				administracija = new AdministracijaMODEL();
				administracija = listaMjesta.get(cmbMjestoStanovanja.getSelectionIndex());
			
			}
		});
		cmbMjestoStanovanja.setBounds(121, 250, 250, 23);
		
		cmbSpol = new Combo(shlEvidentiranjeNoveOsobe, SWT.NONE);
		cmbSpol.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		cmbSpol.setBounds(121, 162, 250, 23);
		
		lblMjestoRoenja = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblMjestoRoenja.setText("Mjesto ro\u0111enja:");
		lblMjestoRoenja.setBounds(10, 210, 99, 15);
		
		label_6 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_6.setBounds(10, 234, 361, 10);
		
		txtMjestoRodjenja = new Text(shlEvidentiranjeNoveOsobe, SWT.BORDER);
		txtMjestoRodjenja.setBounds(121, 207, 250, 21);
		
		label_5 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_5.setBounds(10, 277, 361, 10);
		
		cmbBracniStatus = new Combo(shlEvidentiranjeNoveOsobe, SWT.NONE);
		cmbBracniStatus.setBounds(121, 293, 250, 23);
		
		lblBraniStatus = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblBraniStatus.setBounds(10, 293, 70, 15);
		lblBraniStatus.setText("Bra\u010Dni status:");
		
		label_7 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_7.setBounds(10, 322, 361, 10);
		
		cmbRadniStatus = new Combo(shlEvidentiranjeNoveOsobe, SWT.NONE);
		cmbRadniStatus.setBounds(121, 338, 250, 23);
		
		lblRadniStatus = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblRadniStatus.setBounds(10, 338, 84, 15);
		lblRadniStatus.setText("Radni status:");
		
		label_8 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_8.setBounds(10, 396, 361, 10);
		
		lblOib = new Label(shlEvidentiranjeNoveOsobe, SWT.NONE);
		lblOib.setBounds(10, 415, 55, 15);
		lblOib.setText("OIB:");
		
		txtOIB = new Text(shlEvidentiranjeNoveOsobe, SWT.BORDER);
		txtOIB.setBounds(121, 412, 250, 21);
		
		Label label_9 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.VERTICAL);
		label_9.setBounds(110, 10, 10, 420);
		
		label_10 = new Label(shlEvidentiranjeNoveOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_10.setBounds(10, 436, 361, 10);
		
		btnSpremi = new Button(shlEvidentiranjeNoveOsobe, SWT.NONE);
		btnSpremi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				korisnickiUnos = new OsobaMODEL();
				korisnickiUnos.setIme(txtIme.getText());
				korisnickiUnos.setPrezime(txtPrezime.getText());
				korisnickiUnos.setDatumRoðenja(txtDatumRodjenja.getText());
				korisnickiUnos.setGodinaRoðenja(Integer.valueOf(txtGodinaRodjenja.getText()));
				korisnickiUnos.setSpol(cmbSpol.getText());
				korisnickiUnos.setMjestoRoðenja(txtMjestoRodjenja.getText());
				korisnickiUnos.setMjestoStanovanja(cmbMjestoStanovanja.getText());
				korisnickiUnos.setBracniStatus(cmbBracniStatus.getText());
				korisnickiUnos.setRadniStatus(cmbRadniStatus.getText());
				korisnickiUnos.setRadniStatus2(cmbRadniStatus2.getText());
				korisnickiUnos.setOIB(Integer.valueOf(txtOIB.getText()));
				if (provjeraOsoba(korisnickiUnos)){
					controller.ubaci(korisnickiUnos);
					
				}
				}
			}
		);
		btnSpremi.setBounds(10, 452, 165, 40);
		btnSpremi.setText("Spremi");
		
		btnOdustani = new Button(shlEvidentiranjeNoveOsobe, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlEvidentiranjeNoveOsobe.close();
			}
		});
		btnOdustani.setBounds(206, 452, 165, 40);
		btnOdustani.setText("Odustani");
		
		cmbRadniStatus2 = new Combo(shlEvidentiranjeNoveOsobe, SWT.NONE);
		cmbRadniStatus2.setEnabled(false);
		cmbRadniStatus2.setBounds(121, 367, 250, 23);

	}
	boolean provjeraOsoba(OsobaMODEL osoba) {
		if(osoba.getBracniStatus().isEmpty() && osoba.getDatumRoðenja().isEmpty() && osoba.getIme().isEmpty()
				&& osoba.getPrezime().isEmpty() && osoba.getMjestoStanovanja().isEmpty() && osoba.getRadniStatus().isEmpty()
				&& osoba.getSpol().isEmpty()) {
			MessageBox messageBox = new MessageBox (shlEvidentiranjeNoveOsobe,SWT.ICON_WARNING|SWT.OK);
			messageBox.setMessage("Ništa nemoze biti prazano.");
			messageBox.setText("Greška");
			messageBox.open();
			
			return false;
		}
		
		for(int index = 0; index<listaOsoba.size();index++) {
			if(listaOsoba.get(index).getOIB()==(Integer.valueOf(korisnickiUnos.getOIB()))) {
				MessageBox messageBox=new MessageBox(shlEvidentiranjeNoveOsobe,SWT.ICON_WARNING|SWT.OK);
					messageBox.setText("Greška");
					messageBox.setMessage("OIB veæ postoji.");
					messageBox.open();
					return false;
				}
			}
		return true;
	}
}
