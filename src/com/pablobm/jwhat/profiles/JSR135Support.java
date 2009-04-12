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
	}

	public Hashtable getFeatures() {
		Hashtable ret = new Hashtable();

		storeBoolFeature(ret, "supports.mixing");
		storeBoolFeature(ret, "supports.audio.capture");
		storeBoolFeature(ret, "supports.video.capture");
		storeBoolFeature(ret, "supports.recording");

		return ret;
	}

	private void storeBoolFeature(Hashtable storage, String featureName) {
		storage.put(featureName, new BaseFeature(featureName, boolProp(featureName)));
	}
}

