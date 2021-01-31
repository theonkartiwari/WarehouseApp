package in.google.onkar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.google.onkar.model.ShipmentType;
import in.google.onkar.service.IShipmentTypeService;

@Controller
@RequestMapping("/st")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;

	@GetMapping("/register")
	public String showReg() {
		return "ShipmentTypeRegister";
	}

	@PostMapping("/save")
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		String message = "Shipment Type " + id + " Saved";
		model.addAttribute("message", message);
		return "ShipmentTypeRegister";

	}

	@GetMapping("/all")
	public String showAllShipmentTypes(Model model) {
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	@GetMapping("/delete")
	public String deleteShipmentType(@RequestParam("id") Integer id, Model model) {
		System.out.println(id);
		System.out.println(service.isShipmentTypeExist(id));
		if (service.isShipmentTypeExist(id)) {
			service.deleteShipmentType(id);
			// String message="Shipment type "+id+" Deleted";
			String message = new StringBuffer().append("Shipment Type '").append(id).append("' Deleted").toString();
			model.addAttribute("message", message);
		} else {
			model.addAttribute("message", id + " Not found ");
		}
		model.addAttribute("list", service.getAllShipmentType());
		return "ShipmentTypeData";
	}

}
