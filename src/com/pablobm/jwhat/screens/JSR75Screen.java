package com.pablobm.jwhat.screens;

import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class JSR75Screen
	extends Form {

	ProfileSupport details;
	StringItem summary;

	public JSR75Screen() {
		super("JSR75");

		details = new JSR75Support();
		summary = new StringItem("Summary", "detecting...");

		append(summary);
		new Thread(new DetectionProcess()).start();
	}

	private class DetectionProcess
		implements Runnable {

		public void run() {
			summary.setText(details.getSummary());
		}
	}
}
