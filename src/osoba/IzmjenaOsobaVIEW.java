package osoba;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class IzmjenaOsobaVIEW {

	protected Shell shlIzmjenaEvidentiranOsobe;
	private Text txtIme;
	private Text txtPrezime;
	private Text txtDatumRodjenja;
	private Text txtGodinaRodjenja;
	private Text txtMjestoRodjenja;
	private Text txtOIB;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IzmjenaOsobaVIEW window = new IzmjenaOsobaVIEW();
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
		shlIzmjenaEvidentiranOsobe.open();
		shlIzmjenaEvidentiranOsobe.layout();
		while (!shlIzmjenaEvidentiranOsobe.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlIzmjenaEvidentiranOsobe = new Shell();
		shlIzmjenaEvidentiranOsobe.setSize(400, 605);
		shlIzmjenaEvidentiranOsobe.setText("Izmjena evidentirane osobe");
		
		Label label = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label.setText("Ime:");
		label.setBounds(10, 79, 29, 15);
		
		txtIme = new Text(shlIzmjenaEvidentiranOsobe, SWT.BORDER);
		txtIme.setBounds(121, 76, 250, 21);
		
		txtPrezime = new Text(shlIzmjenaEvidentiranOsobe, SWT.BORDER);
		txtPrezime.setBounds(121, 116, 250, 21);
		
		Label label_1 = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label_1.setText("Prezime:");
		label_1.setBounds(10, 119, 52, 15);
		
		Label label_2 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(10, 103, 361, 10);
		
		Label label_3 = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label_3.setText("Datum ro\u0111enja:");
		label_3.setBounds(10, 156, 91, 15);
		
		txtDatumRodjenja = new Text(shlIzmjenaEvidentiranOsobe, SWT.BORDER);
		txtDatumRodjenja.setBounds(121, 153, 250, 21);
		
		txtGodinaRodjenja = new Text(shlIzmjenaEvidentiranOsobe, SWT.BORDER);
		txtGodinaRodjenja.setBounds(121, 193, 250, 21);
		
		Label label_4 = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label_4.setText("Godina ro\u0111enja:");
		label_4.setBounds(10, 196, 84, 15);
		
		Label label_5 = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label_5.setText("Spol:");
		label_5.setBounds(10, 236, 35, 15);
		
		Combo cmbSpol = new Combo(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		cmbSpol.setBounds(121, 228, 250, 23);
		
		txtMjestoRodjenja = new Text(shlIzmjenaEvidentiranOsobe, SWT.BORDER);
		txtMjestoRodjenja.setBounds(121, 273, 250, 21);
		
		Label label_6 = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label_6.setText("Mjesto ro\u0111enja:");
		label_6.setBounds(10, 276, 99, 15);
		
		Label label_7 = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label_7.setText("Mjesto stanovanja:");
		label_7.setBounds(10, 319, 99, 15);
		
		Combo cmbMjestoStanovanja = new Combo(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		cmbMjestoStanovanja.setBounds(121, 316, 250, 23);
		
		Combo cmbBracniStatus = new Combo(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		cmbBracniStatus.setBounds(121, 359, 250, 23);
		
		Label label_8 = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label_8.setText("Bra\u010Dni status:");
		label_8.setBounds(10, 359, 70, 15);
		
		Label label_9 = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label_9.setText("Radni status:");
		label_9.setBounds(10, 404, 84, 15);
		
		Combo cmbRadniStatus = new Combo(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		cmbRadniStatus.setBounds(121, 404, 250, 23);
		
		txtOIB = new Text(shlIzmjenaEvidentiranOsobe, SWT.BORDER);
		txtOIB.setBounds(121, 478, 250, 21);
		
		Label label_10 = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		label_10.setText("OIB:");
		label_10.setBounds(10, 481, 55, 15);
		
		Label label_11 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_11.setBounds(10, 462, 361, 10);
		
		Label label_12 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_12.setBounds(10, 505, 361, 10);
		
		Label label_13 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_13.setBounds(10, 388, 361, 10);
		
		Label label_14 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_14.setBounds(10, 343, 361, 10);
		
		Label label_15 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_15.setBounds(10, 300, 361, 10);
		
		Label label_16 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_16.setBounds(10, 257, 361, 10);
		
		Label label_17 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_17.setBounds(10, 217, 361, 10);
		
		Label label_18 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_18.setBounds(10, 180, 361, 10);
		
		Label label_19 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_19.setBounds(10, 140, 361, 10);
		
		Label label_20 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR);
		label_20.setBounds(110, 76, 10, 423);
		
		Button btnIzmijeni = new Button(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		btnIzmijeni.setBounds(10, 521, 165, 40);
		btnIzmijeni.setText("Izmijeni");
		
		Button btnOdustani = new Button(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlIzmjenaEvidentiranOsobe.close();
			}
		});
		btnOdustani.setText("Odustani");
		btnOdustani.setBounds(209, 521, 165, 40);
		
		Combo cmbRadniStatus2 = new Combo(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		cmbRadniStatus2.setBounds(121, 433, 250, 23);
		
		Label lblIzaberiteOsobuKoju = new Label(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		lblIzaberiteOsobuKoju.setBounds(10, 10, 361, 15);
		lblIzaberiteOsobuKoju.setText("Izaberite osobu koju \u017Eelite izmijeniti:");
		
		Combo cmbOsobaZaIzmjenu = new Combo(shlIzmjenaEvidentiranOsobe, SWT.NONE);
		cmbOsobaZaIzmjenu.setBounds(10, 31, 361, 23);
		
		Label label_21 = new Label(shlIzmjenaEvidentiranOsobe, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_21.setBounds(10, 60, 361, 10);

	}

}
