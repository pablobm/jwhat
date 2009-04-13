package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class JSR135Screen
	extends JWhatProfileScreen {

	public JSR135Screen(JWhatScreen parent) {
		super(parent, new JSR135Support());
	}

	protected void render() {
		getForm().append(version);
		Enumeration props = buildPropertiesTable();

		while (props.hasMoreElements()) {
			getForm().append((Item)props.nextElement());
		}
	}
}
