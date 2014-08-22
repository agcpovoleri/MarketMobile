package com.marketmobile.mobile.settings;

import android.app.Application;
import android.location.Location;

public class Session extends Application {
	
		
	private static boolean questionarioInicializado;
	private static boolean resultadoProcessado;
	
	//GPS ativo
	private static boolean gpsEnabled;
	//TORRE DE CELULAR ativo
	private static boolean towerEnabled;
	
	//Servico iniciado
	private static boolean started;
	
	//Ultima localizacao válida
	private static boolean needLocation;
	private static Location currentLocation;
	private static boolean validLocation;
	
	private static boolean notificationVisible;
	
	private static boolean usingGps;
	
	private static long lastestTimeStamp;
	private static boolean boundToService;
	private static String lastError;
	
	
	private static boolean isServiceGPSactived;
	
	public static boolean isGpsEnabled() {
		return gpsEnabled;
	}
	public static void setGpsEnabled(boolean gpsEnabled) {
		Session.gpsEnabled = gpsEnabled;
	}
	public static boolean isTowerEnabled() {
		return towerEnabled;
	}
	public static void setTowerEnabled(boolean towerEnabled) {
		Session.towerEnabled = towerEnabled;
	}
	public static boolean isStarted() {
		return started;
	}
	public static void setStarted(boolean started) {
		Session.started = started;
	}
	public static Location getCurrentLocation() {
		return currentLocation;
	}
	public static void setCurrentLocation(Location currentLocation) {
		Session.currentLocation = currentLocation;
	}
	public static boolean isNotificationVisible() {
		return notificationVisible;
	}
	public static void setNotificationVisible(boolean notificationVisible) {
		Session.notificationVisible = notificationVisible;
	}
	public static boolean isValidLocation() {
		return validLocation;
	}
	public static void setValidLocation(boolean validLocation) {
		Session.validLocation = validLocation;
	}
	public static boolean isUsingGps() {
		return usingGps;
	}
	public static void setUsingGps(boolean usingGps) {
		Session.usingGps = usingGps;
	}
	public static long getLastestTimeStamp() {
		return lastestTimeStamp;
	}
	public static void setLastestTimeStamp(long lastestTimeStamp) {
		Session.lastestTimeStamp = lastestTimeStamp;
	}
	public static boolean isBoundToService() {
		return boundToService;
	}
	public static void setBoundToService(boolean boundToService) {
		Session.boundToService = boundToService;
	}
	public static String getLastError() {
		return lastError;
	}
	public static void setLastError(String lastError) {
		Session.lastError = lastError;
	}
	public static boolean isQuestionarioInicializado() {
		return questionarioInicializado;
	}
	public static void setQuestionarioInicializado(boolean questionarioInicializado) {
		Session.questionarioInicializado = questionarioInicializado;
	}
	public static boolean isNeedLocation() {
		return needLocation;
	}
	public static void setNeedLocation(boolean needLocation) {
		Session.needLocation = needLocation;
	}
	public static boolean isServiceGPSactived() {
		return isServiceGPSactived;
	}
	public static void setServiceGPSactived(boolean isServiceGPSactived) {
		Session.isServiceGPSactived = isServiceGPSactived;
	}

	public static boolean isResultadoProcessado() {
		return resultadoProcessado;
	}
	public static void setResultadoProcessado(boolean resultadoProcessado) {
		Session.resultadoProcessado = resultadoProcessado;
	}
	
	
	
}
