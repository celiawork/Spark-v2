package com.sparkies.spark.service;

public interface DistanceCalculator {
	public static String UNITE_NAUTICAL_MILES = "N";
	public static String UNITE_KM = "K";
	public static String UNITE_MILES = "M";
	double distance(double lat1, double lon1, double lat2, double lon2, String unit) ;
}
