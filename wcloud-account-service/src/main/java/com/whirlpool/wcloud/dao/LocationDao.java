package com.whirlpool.wcloud.dao;

import java.util.List;

import com.whirlpool.wcloud.model.LocationModel;
import com.whirlpool.wcloud.model.UpdateModel;

public interface LocationDao {

	public void createLocation(LocationModel location);
	public void updateLocation(LocationModel location);
	public List<LocationModel> getLocationByAccountId(int accountId);
	public List<LocationModel> getLocationByLocationId(int locationId);
}
