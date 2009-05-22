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

	public Enumeration getFeatures() {
		Vector ret = new Vector();

		storeBoolFeature(ret, "supports.mixing");
		storeBoolFeature(ret, "supports.audio.capture");
		storeBoolFeature(ret, "supports.video.capture");
		storeBoolFeature(ret, "supports.recording");
		storeStringFeature(ret, "audio.encodings");
		storeStringFeature(ret, "video.encodings");
		storeStringFeature(ret, "video.snapshots.encodings");

		return ret.elements();
	}
}

