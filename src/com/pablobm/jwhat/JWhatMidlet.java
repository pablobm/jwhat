package com.pablobm.jwhat;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import com.pablobm.jwhat.profiles.*;

public class JWhatMidlet
	extends MIDlet
	implements CommandListener {

	private Screen screen;

	public JWhatMidlet() {
		screen = createScreen();
		new JSR75Support();
	}

	public void startApp() {
		Display.getDisplay(this).setCurrent(screen);
	}
	
	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {}

	public void commandAction(Command c, Displayable s) {
		notifyDestroyed();
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
		List ret = new List("Supported profiles", List.IMPLICIT);
		int i = 0;
		
		while(keys.hasMoreElements()) {
			String e = (String)keys.nextElement();
			String propname = (String)props.get(e);
			String line = e + ": " + System.getProperty(propname);
			ret.append(line, null);
		}
		
		return ret;
	}
}

