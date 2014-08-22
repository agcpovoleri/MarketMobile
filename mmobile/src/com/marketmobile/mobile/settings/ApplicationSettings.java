package com.marketmobile.mobile.settings;

import android.app.Application;

public class ApplicationSettings extends Application {
	
	private static boolean firstInit = true;
	
	private static int minimumDistance;
	private static int minimumTimeSeconds; 

	private static boolean sendWS;
	private static boolean writeDB;
	
	private static String WS_BASE_URL;
	private static String DATABASE_NAME;
	
	private static boolean preferCellTower;
	
	public static boolean isPreferCellTower() {
		return preferCellTower;
	}

	public static void setPreferCellTower(boolean preferCellTower) {
		ApplicationSettings.preferCellTower = preferCellTower;
	}

	public static int getMinimumDistance() {
		return minimumDistance;
	}
	
	public static void setMinimumDistance(int minimumDistance) {
		ApplicationSettings.minimumDistance = minimumDistance;
	}
	
	public static int getMinimumTimeSeconds() {
		return minimumTimeSeconds;
	}
	
	public static void setMinimumTimeSeconds(int minimumTimeSeconds) {
		ApplicationSettings.minimumTimeSeconds = minimumTimeSeconds;
	}
	
	public static boolean isSendWS() {
		return sendWS;
	}
	
	public static void setSendWS(boolean sendWS) {
		ApplicationSettings.sendWS = sendWS;
	}
	
	public static boolean isWriteDB() {
		return writeDB;
	}
	
	public static void setWriteDB(boolean writeDB) {
		ApplicationSettings.writeDB = writeDB;
	}
	
	public static String getWS_BASE_URL() {
		return WS_BASE_URL;
	}
	
	public static void setWS_BASE_URL(String wS_BASE_URL) {
		WS_BASE_URL = wS_BASE_URL;
	}
	
	public static String getDATABASE_NAME() {
		return DATABASE_NAME;
	}
	
	public static void setDATABASE_NAME(String dATABASE_NAME) {
		DATABASE_NAME = dATABASE_NAME;
	}

	public static boolean isFirstInit() {
		return firstInit;
	}

	public static void setFirstInit(boolean firstInit) {
		ApplicationSettings.firstInit = firstInit;
	}

	
	
}
