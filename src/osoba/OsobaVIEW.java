package osoba;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class OsobaVIEW {

	protected Shell shlEvidentiranjeOsobe;
	NovaOsobaVIEW novaOsoba = new NovaOsobaVIEW();
	BrisanjeOsobaVIEW brisanjeOsoba = new BrisanjeOsobaVIEW();
	IzmjenaOsobaVIEW izmjenaOsoba = new IzmjenaOsobaVIEW();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			OsobaVIEW window = new OsobaVIEW();
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
		shlEvidentiranjeOsobe.open();
		shlEvidentiranjeOsobe.layout();
		while (!shlEvidentiranjeOsobe.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEvidentiranjeOsobe = new Shell();
		shlEvidentiranjeOsobe.setSize(260, 477);
		shlEvidentiranjeOsobe.setText("Evidentiranje osobe");
		
		Button btnEvidentiranjeNoveOsobe = new Button(shlEvidentiranjeOsobe, SWT.NONE);
		btnEvidentiranjeNoveOsobe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				novaOsoba.open();
			}
		});
		btnEvidentiranjeNoveOsobe.setBounds(44, 30, 156, 75);
		btnEvidentiranjeNoveOsobe.setText("Evidentiranje nove osobe");
		
		Button btnIzmjenaEvidentiraneOsobe = new Button(shlEvidentiranjeOsobe, SWT.NONE);
		btnIzmjenaEvidentiraneOsobe.setText("Izmjena evidentirane osobe");
		btnIzmjenaEvidentiraneOsobe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				izmjenaOsoba.open();
			}
		});
		btnIzmjenaEvidentiraneOsobe.setBounds(44, 135, 156, 75);
		
		Button btnBrisanjeEvidentiraneOsobe = new Button(shlEvidentiranjeOsobe, SWT.NONE);
		btnBrisanjeEvidentiraneOsobe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				brisanjeOsoba.open();
			}
		});
		btnBrisanjeEvidentiraneOsobe.setText("Brisanje evidentirane osobe");
		btnBrisanjeEvidentiraneOsobe.setBounds(44, 240, 156, 75);
		
		Button btnIzlaz = new Button(shlEvidentiranjeOsobe, SWT.NONE);
		btnIzlaz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlEvidentiranjeOsobe.close();
			}
		});
		btnIzlaz.setBounds(44, 345, 156, 75);
		btnIzlaz.setText("Izlaz");

	}

}
