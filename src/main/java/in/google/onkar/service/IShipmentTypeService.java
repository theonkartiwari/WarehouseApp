package in.google.onkar.service;

import java.util.List;

import in.google.onkar.model.ShipmentType;

public interface IShipmentTypeService {
	
	Integer saveShipmentType(ShipmentType st);

	List<ShipmentType>getAllShipmentType();
	
	void deleteShipmentType(Integer id); 
	
	boolean isShipmentTypeExist(Integer id);

}
