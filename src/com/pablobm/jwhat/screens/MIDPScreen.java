package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class MIDPScreen
	extends JWhatProfileScreen {

	public MIDPScreen(JWhatScreen parent) {
		super(parent, new MIDPSupport());
	}

	protected void render() {
		getForm().append(version);
		Enumeration props = buildPropertiesTable();

		while (props.hasMoreElements()) {
			getForm().append((Item)props.nextElement());
		}
	}
}
