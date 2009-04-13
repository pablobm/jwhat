package com.pablobm.jwhat.screens;

import javax.microedition.lcdui.*;

import com.pablobm.jwhat.*;
import com.pablobm.jwhat.screens.*;

public abstract class JWhatScreen {

	private static JWhatMIDlet midlet;
	public static JWhatMIDlet getMIDlet() {
		return midlet;
	}
	public static void setMIDlet(JWhatMIDlet midlet) {
		JWhatScreen.midlet = midlet;
	}

	private Screen screen;
	private JWhatScreen parent;

	public JWhatScreen(JWhatScreen parent, Screen screen) {
		this.parent = parent;
		this.screen = screen;
	}

	public Screen getScreen() {
		return screen;
	}

	public JWhatScreen getParent() {
		return parent;
	}

	public void display() {
		Display.getDisplay(JWhatScreen.getMIDlet()).setCurrent(getScreen());
	}

	protected abstract void render();
}
