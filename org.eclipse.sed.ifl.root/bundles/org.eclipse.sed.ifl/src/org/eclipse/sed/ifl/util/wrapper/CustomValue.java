package org.eclipse.sed.ifl.util.wrapper;

public class CustomValue {
//TODO engedj�k el a UI-t
//TODO +1 adattag defineable-h�z k�pest: abszol�t-e vagy sem
//TODO �tnevezni (ne felt�tlen sz�rmazzon a defineable-b�l)
	public CustomValue(boolean isAbsolute, int value) {
		this.isAbsolute = isAbsolute;
		this.value = value;
	}

	public boolean isAbsolute() {
		return isAbsolute;
	}
	
	public int getValue() {
		return this.value;
	}
	
	private boolean isAbsolute;
	private int value;
}
