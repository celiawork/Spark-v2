
package com.sparkies.spark.service.impl;

import org.springframework.stereotype.Service;

import com.sparkies.spark.service.DistanceCalculator;

@Service
class DistanceCalculatorImpl implements DistanceCalculator
{	
//	public static String UNITE_NAUTICAL_MILES = "N";
//	public static String UNITE_KM = "K";
//	public static String UNITE_MILES = "M";
//	public static void main (String[] args) throws java.lang.Exception
//	{
//		
//		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, UNITE_MILES) + " Miles\n");
//		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, UNITE_KM) + " Kilometers\n");
//		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, UNITE_NAUTICAL_MILES) + " Nautical Miles\n");
//	}

	public double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			
			if (unit.equals(UNITE_KM)) {
				dist = dist * 1.609344;
			} else {
				
				if (unit.equals(UNITE_NAUTICAL_MILES)) {
					dist = dist * 0.8684;
				}
			}
			return (dist);
		}
	}
}