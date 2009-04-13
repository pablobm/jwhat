package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class WMAScreen
	extends JWhatProfileScreen {

	public WMAScreen(JWhatScreen parent) {
		super(parent, new WMASupport());
	}

	protected void render() {
		getForm().append(version);
		Enumeration props = buildPropertiesTable();

		while (props.hasMoreElements()) {
			getForm().append((Item)props.nextElement());
		}
	}
}
