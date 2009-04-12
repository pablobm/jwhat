package com.pablobm.jwhat;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import com.pablobm.jwhat.profiles.*;
import com.pablobm.jwhat.screens.*;

public class JWhatMIDlet
	extends MIDlet {

	private JWhatScreen mainScreen;

	public JWhatMIDlet() {
		JWhatScreen.setMIDlet(this);
		mainScreen = new MainScreen();
	}

	public void startApp() {
		mainScreen.display();
	}
	
	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {}

	public void exit() {
		destroyApp(false);
		notifyDestroyed();
	}
}

