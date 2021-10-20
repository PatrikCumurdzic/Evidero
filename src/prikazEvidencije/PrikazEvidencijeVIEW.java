package prikazEvidencije;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PrikazEvidencijeVIEW {

	protected Shell shlPrikazEvidencije;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PrikazEvidencijeVIEW window = new PrikazEvidencijeVIEW();
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
		shlPrikazEvidencije.open();
		shlPrikazEvidencije.layout();
		while (!shlPrikazEvidencije.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPrikazEvidencije = new Shell();
		shlPrikazEvidencije.setSize(700, 600);
		shlPrikazEvidencije.setText("Prikaz evidencije");
		
		text = new Text(shlPrikazEvidencije, SWT.BORDER);
		text.setBounds(10, 10, 664, 501);
		
		Combo cmbTrazi = new Combo(shlPrikazEvidencije, SWT.NONE);
		cmbTrazi.setEnabled(false);
		cmbTrazi.setBounds(70, 529, 91, 23);

		
		Button btnTrazi = new Button(shlPrikazEvidencije, SWT.CHECK);
		btnTrazi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cmbTrazi.setEnabled(true);
			}
		});
		btnTrazi.setBounds(10, 536, 46, 16);
		btnTrazi.setText("Tra\u017Ei");
	}
}
