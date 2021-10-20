package osoba;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BrisanjeOsobaVIEW {

	protected Shell shlBrisanjeEvidentiraneOsobe;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BrisanjeOsobaVIEW window = new BrisanjeOsobaVIEW();
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
		shlBrisanjeEvidentiraneOsobe.open();
		shlBrisanjeEvidentiraneOsobe.layout();
		while (!shlBrisanjeEvidentiraneOsobe.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBrisanjeEvidentiraneOsobe = new Shell();
		shlBrisanjeEvidentiraneOsobe.setSize(440, 130);
		shlBrisanjeEvidentiraneOsobe.setText("Brisanje evidentirane osobe");
		
		Label lblIzaberiteOsobuKoju = new Label(shlBrisanjeEvidentiraneOsobe, SWT.NONE);
		lblIzaberiteOsobuKoju.setBounds(10, 10, 404, 15);
		lblIzaberiteOsobuKoju.setText("Izaberite osobu koju \u017Eelite izbrisati:");
		
		Combo cmbOsobaZaBrisanje = new Combo(shlBrisanjeEvidentiraneOsobe, SWT.NONE);
		cmbOsobaZaBrisanje.setBounds(10, 31, 404, 23);
		
		Button btnObrisi = new Button(shlBrisanjeEvidentiraneOsobe, SWT.NONE);
		btnObrisi.setBounds(10, 60, 180, 25);
		btnObrisi.setText("Obri\u0161i");
		
		Button btnOdustani = new Button(shlBrisanjeEvidentiraneOsobe, SWT.NONE);
		btnOdustani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlBrisanjeEvidentiraneOsobe.close();
			}
		});
		btnOdustani.setBounds(234, 60, 180, 25);
		btnOdustani.setText("Odustani");

	}

}
