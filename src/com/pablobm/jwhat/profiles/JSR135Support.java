package com.pablobm.jwhat.profiles;

import java.util.*;

public class JSR135Support
	extends BaseProfileSupport
{
	public JSR135Support() {
		name = "JSR-135";
		version = System.getProperty("microedition.media.version");
		longName = "Mobile Media API";
		description = "Handling of media content and protocols";
		summary = null;
	}

	public Hashtable getFeatures() {
		Hashtable ret = new Hashtable();

		ret.put("supports.mixing", new BaseFeature("supports.mixing", boolProp("supports.mixing")));
		ret.put("supports.audio.capture", new BaseFeature("supports.audio.capture", boolProp("supports.audio.capture")));
		ret.put("supports.video.capture", new BaseFeature("supports.video.capture", boolProp("supports.video.capture")));
		ret.put("supports.recording", new BaseFeature("supports.recording", boolProp("supports.recording")));

		return ret;
	}

	protected String composeSummary() {
		Vector supports = new Vector();
		
		if (boolProp("supports.mixing")) {
			supports.addElement("mixing");
		}
		if (boolProp("supports.audio.capture")) {
			supports.addElement("audio capture");
		}
		if (boolProp("supports.video.capture")) {
			supports.addElement("video capture");
		}
		if (boolProp("supports.recording")) {
			supports.addElement("recording");
		}
		
		return vectorToString(supports);
	}
	
	private String vectorToString(Vector v) {
		if (v.size() == 0) {
			return "no support";
		}

		Enumeration strings = v.elements();
		String ret = (String)strings.nextElement();
		while (strings.hasMoreElements()) {
			ret += ", " + strings.nextElement();
		}
		
		return ret;		
	}
}

