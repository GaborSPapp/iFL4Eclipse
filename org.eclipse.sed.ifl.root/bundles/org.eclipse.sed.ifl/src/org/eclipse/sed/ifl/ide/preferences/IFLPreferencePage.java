package org.eclipse.sed.ifl.ide.preferences;


import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;

import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.sed.ifl.ide.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class IFLPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	public IFLPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preferences page of the iFL plug-in");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		//t�roljuk el a userID, MAC, scenarioID konkaten�lt stringj�t (MD5 esetleg) az ID node-ba
		//m�dos�t�s eset�n �jragener�lni
		//legyen kim�solhat� mez�be ezek alatt
		
		//szerver tesztel�s gomb
		
		BooleanFieldEditor logKeyField = new BooleanFieldEditor("logKey", "Enable logging", getFieldEditorParent());
		addField(logKeyField);
		
		StringFieldEditor userIdField = new StringFieldEditor("userId", "User ID: ", getFieldEditorParent());
		addField(userIdField);
		
		StringFieldEditor scenarioIdField = new StringFieldEditor("scenarioId", "Scenario ID: ", getFieldEditorParent());
		addField(scenarioIdField);
		
		StringFieldEditor hostField = new StringFieldEditor("host", "Host: ", getFieldEditorParent());
		addField(hostField);
		
		StringFieldEditor portField = new StringFieldEditor("port", "Port: ", getFieldEditorParent());
		addField(portField);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}