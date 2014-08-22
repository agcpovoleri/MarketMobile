package com.marketmobile.mobile.utils;

import android.util.Log;

public class LogUtils {
	private static final int LOGLEVEL = 5;
	private static final String TAG_PREFIX = "[PESQUISA-OPINIAO]";
	
	
	private static String tag(String tag) {
		//return TAG_PREFIX + ":"+tag;
		return TAG_PREFIX;
	}
	
	public static void LogVerbose(String tag, String message)
	{
		if (LOGLEVEL >= 5)
		{
			Log.v(tag(tag), message);
		}
	}
	
	public static void LogDebug(String tag, String message)
	{
		if (LOGLEVEL >= 4)
		{
			Log.d(tag(tag), message);
		}
	}
	
	public static void LogInfo(String tag, String message)
	{
		if (LOGLEVEL >= 3)
		{
			Log.i(tag(tag), message);
		}
	}
	
	public static void LogWarning(String tag, String message)
	{
		if (LOGLEVEL >= 2)
		{
			Log.w(tag(tag), message);
		}
	}

	
	public static void LogError(String tag, String message, Exception e)
	{
		if (LOGLEVEL>=1) {
			Log.e(tag(tag),message,e);
		}
	}
	
	public static void LogError(String tag, String message)
	{
		if (LOGLEVEL>=1) {
			Log.e(tag(tag),message);
		}
	}
	
}
