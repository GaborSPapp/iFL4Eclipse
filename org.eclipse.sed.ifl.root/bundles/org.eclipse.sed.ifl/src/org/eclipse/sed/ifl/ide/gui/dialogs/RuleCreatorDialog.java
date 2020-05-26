package org.eclipse.sed.ifl.ide.gui.dialogs;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.sed.ifl.ide.gui.rulecreator.BooleanRuleCreator;
import org.eclipse.sed.ifl.ide.gui.rulecreator.DoubleRuleCreator;
import org.eclipse.sed.ifl.ide.gui.rulecreator.IntegerRuleCreator;
import org.eclipse.sed.ifl.ide.gui.rulecreator.StringRuleCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;

public class RuleCreatorDialog extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public RuleCreatorDialog(Shell parent, int style) {
		super(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		setText("Create rule");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(420, 241);
		shell.setText(getText());
		shell.setLayout(new GridLayout(1, false));
		
		Label infoLabel = new Label(shell, SWT.NONE);
		infoLabel.setText("Create rule for filtering.");
		
		CBanner banner = new CBanner(shell, SWT.NONE);
		banner.setRightWidth(320);
		GridData gd_banner = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_banner.heightHint = 183;
		gd_banner.widthHint = 408;
		banner.setLayoutData(gd_banner);
		
		Composite ruleCreatorComposite = new Composite(banner, SWT.NONE);
		banner.setRight(ruleCreatorComposite);
		ruleCreatorComposite.setLayout(new GridLayout(1, true));
		
		Composite buttonBarComposite = new Composite(banner, SWT.NONE);
		banner.setBottom(buttonBarComposite);
		RowLayout rl_buttonBarComposite = new RowLayout(SWT.HORIZONTAL);
		rl_buttonBarComposite.pack = false;
		buttonBarComposite.setLayout(rl_buttonBarComposite);
		
		Button okButton = new Button(buttonBarComposite, SWT.NONE);
		okButton.setText("Add");
		
		Button cancelButton = new Button(buttonBarComposite, SWT.NONE);
		cancelButton.setText("Cancel");
		
		Composite listComposite = new Composite(banner, SWT.NONE);
		banner.setLeft(listComposite);
		
		List domainList = new List(listComposite, SWT.BORDER);
		domainList.setItems(new String[] {"Score", "Name", "Signature", "Parent type", "Path", "Position", "Context size", "Interactivity", "Last action"});
		domainList.setBounds(0, 0, 96, 148);
		domainList.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(domainList.getSelection()[0]);
				for(Control control : ruleCreatorComposite.getChildren()) {
					control.dispose();
				}
				switch (domainList.getSelection()[0]) {
				case "Score": new DoubleRuleCreator(ruleCreatorComposite, SWT.NONE);
					break;
				case "Name": new StringRuleCreator(ruleCreatorComposite, SWT.NONE);
					break;
				case "Signature": new StringRuleCreator(ruleCreatorComposite, SWT.NONE);
					break;
				case "Parent type": new StringRuleCreator(ruleCreatorComposite, SWT.NONE);
					break;
				case "Path": new StringRuleCreator(ruleCreatorComposite, SWT.NONE);
					break;
				case "Position": new IntegerRuleCreator(ruleCreatorComposite, SWT.NONE);
					break;
				case "Context size": new IntegerRuleCreator(ruleCreatorComposite, SWT.NONE);
					break;
				case "Interactivity": new BooleanRuleCreator(ruleCreatorComposite, SWT.NONE);
					break;
				case "Last Action":
					break;
				}
				ruleCreatorComposite.requestLayout();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
			
		});

	}
}