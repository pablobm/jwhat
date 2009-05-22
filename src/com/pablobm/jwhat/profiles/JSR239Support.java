package com.pablobm.jwhat.profiles;

import java.util.*;

public class JSR239Support
	extends BaseProfileSupport
{
	public JSR239Support() {
		name = "JSR-239";
		version = readVersion();
		longName = "OpenGL ES";
		description = "Java binding for OpenGL ES";
	}

	public Enumeration getFeatures() {
		return new Vector().elements();
	}

	private String readVersion() {
		String ret = null;
		
		try {
			Class.forName("javax.microedition.khronos.egl.EGL10");
			ret = "1.0";
			Class.forName("javax.microedition.khronos.egl.EGL11");
			ret = "1.1";
		}
		catch (ClassNotFoundException e) {
			// Ignore
		}
		
		return ret;
	}
}

