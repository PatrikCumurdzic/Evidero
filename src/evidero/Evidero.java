package evidero;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;


public class Evidero {

	protected Shell shlEvidero;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Evidero window = new Evidero();
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
		shlEvidero.open();
		shlEvidero.layout();
		while (!shlEvidero.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEvidero = new Shell();
		shlEvidero.setImage(SWTResourceManager.getImage("C:\\Users\\Ma\u0161ina\\Documents\\JAVA\\Evidero\\Screenshot_5.png"));
		shlEvidero.setSize(450, 600);
		shlEvidero.setText("Evidero");
		
		Button btnAdministracija = new Button(shlEvidero, SWT.NONE);
		btnAdministracija.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAdministracija.setBounds(116, 55, 200, 70);
		btnAdministracija.setText("Administracija");
		
		Button btnEvidentiranjeOsoba = new Button(shlEvidero, SWT.NONE);
		btnEvidentiranjeOsoba.setText("Evidentiranje osoba");
		btnEvidentiranjeOsoba.setBounds(116, 180, 200, 70);
		
		Button btnPrikazEvidencije = new Button(shlEvidero, SWT.NONE);
		btnPrikazEvidencije.setText("Prikaz evidencije");
		btnPrikazEvidencije.setBounds(116, 305, 200, 70);
		
		Button btnIzlaz = new Button(shlEvidero, SWT.NONE);
		btnIzlaz.setBounds(116, 430, 200, 70);
		btnIzlaz.setText("Izlaz");

	}

}
