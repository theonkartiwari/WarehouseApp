package in.google.onkar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.google.onkar.model.ShipmentType;
import in.google.onkar.repo.ShipmentTypeRepo;
import in.google.onkar.service.IShipmentTypeService;

@Service
public  class ShipmentTypeServieImpl implements IShipmentTypeService {
	
	
	@Autowired
	private ShipmentTypeRepo repo; //HAS-A Relationship

	@Override
	public Integer saveShipmentType(ShipmentType st) {
        st=repo.save(st);
        Integer id=st.getId();
		return id;
	}

	@Override
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType>list=repo.findAll();
		return list;
	}

	@Override
	public void deleteShipmentType(Integer id) {
				repo.deleteById(id);
	}

	@Override
	public boolean isShipmentTypeExist(Integer id) {
		return repo.existsById(id);
	}
	
	

}
