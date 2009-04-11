package com.pablobm.jwhat;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import com.pablobm.jwhat.profiles.*;
import com.pablobm.jwhat.screens.*;

public class JWhatMidlet
	extends MIDlet {

	private Screen mainScreen;

	public JWhatMidlet() {
		mainScreen = new MainScreen(this);
	}

	public void startApp() {
		Display.getDisplay(this).setCurrent(mainScreen);
	}
	
	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {}

	public void exit() {
		destroyApp(false);
		notifyDestroyed();
	}
}

