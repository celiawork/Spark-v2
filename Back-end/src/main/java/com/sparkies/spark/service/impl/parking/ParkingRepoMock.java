package com.sparkies.spark.service.impl.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.sparkies.spark.model.Address;
import com.sparkies.spark.model.Parking;
import com.sparkies.spark.repository.ParkingRepo;

@Qualifier("parkingRepoMock")
@Service
public abstract class ParkingRepoMock implements ParkingRepo {
//
//	@Override
//	public <S extends Parking> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Parking> Iterable<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<Parking> findById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean existsById(String id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Iterable<Parking> findAll() {
//		List<Parking> parkings = new ArrayList<> ();
//		Parking parking=new Parking();
//		parking.setApiUrl("https://data.montpellier3m.fr/sites/default/files/ressources/FR_MTP_TRIA.xml");
//		Address ad=new Address();
//		ad.setLongitude(3.881844180000000);
//		ad.setLatitude(43.609233840000002);
//		parking.setParkingAddress(ad);
//
//
//		// TODO Auto-generated method stub
//		parkings.add(0, parking);
//
//		parking=new Address();
//		parking.setApiUrl("https://data.montpellier3m.fr/sites/default/files/ressources/FR_MTP_TRIA.xml");
//		ad=new Address();
//		ad.setLongitude(3.904817620000000);
//		ad.setLatitude(43.570809879999999);
//		Address(ad);
//		parkings.add(1, parking);
//		return parkings;
//	}
//
//	@Override
//	public Iterable<Parking> findAllById(Iterable<String> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void deleteById(String id) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void delete(Parking entity) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends String> ids) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Parking> entities) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//
//	}
//
//
}
