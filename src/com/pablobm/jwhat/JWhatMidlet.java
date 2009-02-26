package com.pablobm.jwhat;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class JWhatMidlet
	extends MIDlet
	implements CommandListener {

	private Screen screen;

	public JWhatMidlet() {
		screen = createScreen();
		
		
		
		
		/*
		String v = versionOfJSR75();
		String support_str = null;
		mMainForm = new Form("HiFellas");
		mMainForm.append(new StringItem("Greeting", "Hi Pablo!\n"));
		if (v != null) {
			support_str = "v" + v;
		}
		else {
			support_str = "not available";
		}
		mMainForm.append(new StringItem("JSR 75 support:", support_str + "\n"));
		mMainForm.append(new StringItem(null, "...and that was it!"));
		mMainForm.addCommand(new Command("Exit", Command.EXIT, 0));
		mMainForm.setCommandListener(this);
		*/
	}

	public void startApp() {
		Display.getDisplay(this).setCurrent(screen);
	}
	
	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {}

	public void commandAction(Command c, Displayable s) {
		notifyDestroyed();
	}
	
	public String versionOfJSR75() {
		return System.getProperty("microedition.pim.version");
	}
	
	public Hashtable createPropertiesTable() {
		Hashtable ret = new Hashtable();
		ret.put("JSR-75", "microedition.pim.version");
		ret.put("JSR-120", "wireless.messaging.sms.smsc");
		ret.put("JSR-135", "microedition.media.version");
		
		return ret;
	}
	
	private Screen createScreen() {
		Hashtable props = createPropertiesTable();
		Enumeration keys = props.keys();
		String[] keys_array = new String[props.size()];
		int i = 0;
		
		while(keys.hasMoreElements()) {
			keys_array[i++] = (String)keys.nextElement();
		}		
		
		return new List("Supported profiles", List.IMPLICIT, keys_array, null);
	}
}

