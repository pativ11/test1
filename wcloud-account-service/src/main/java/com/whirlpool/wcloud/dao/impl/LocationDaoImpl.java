package com.whirlpool.wcloud.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.whirlpool.wcloud.common.utils.LoggerUtil;
import com.whirlpool.wcloud.dao.LocationDao;
import com.whirlpool.wcloud.db.dashdb.dao.impl.DashDbGenericDaoImpl;
import com.whirlpool.wcloud.model.LocationModel;
import com.whirlpool.wcloud.model.UpdateModel;

@Service
@Component
@Configuration
@ComponentScan(basePackages = { "com.whirlpool.wcloud" })
public class LocationDaoImpl extends DashDbGenericDaoImpl implements LocationDao {

	@Override
	public void createLocation(LocationModel location) {
		// TODO Auto-generated method stub
		insert(INSERT_LOCATION,
				new Object[] { location.getCity(), location.getAccountId(), location.getState(),
						location.getPostalCode(), location.getCreatedAt(), location.getUpdatedAt(),
						location.getElevation(), location.getLatitude(), location.getLocaleId(),
						location.isSmartEnergy(), location.getLocationName(),
						location.getLongitude(), location.getLoyaltyId(), location.getRatePlanCode(),
						location.getRatePlanId(), location.getStatus(), location.getStreet(),
						location.getSecondLineAddress(), location.getUtilityName(), location.getUtilityId() });
	}

	@Override
	public void updateLocation(LocationModel location) {
		// TODO Auto-generated method stub
	update(UPDATE_LOCATION,new Object[] { location.getCity(),location.getState(),location.getPostalCode(),
			location.getCreatedAt(),location.getUpdatedAt(),location.getElevation(),location.getLatitude(),
			location.isSmartEnergy(),location.getLocationName(),location.getLongitude(),
			location.getRatePlanCode(),location.getRatePlanId(),location.getStatus(),
			location.getStreet(),location.getSecondLineAddress(),location.getUtilityName(),location.getUtilityId(),
			location.getLocationId()});
																																																																																								
	
	
	}

	@Override
	public List<LocationModel> getLocationByAccountId(int accountId) {
	
		List<LocationModel> list = get(SELECT_LOCATION_BY_ACC_ID,new Object[]{accountId});
	
		return list;
		
	}

	@Override
	public List<LocationModel> getLocationByLocationId(int locationId) {

		List<LocationModel> list = get(SELECT_LOCATION_BY_LOC_ID,new Object[]{locationId});
		
		return list;
	}
	


}