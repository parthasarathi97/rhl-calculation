package RHL.calculation.controller;

import RHL.calculation.dto.response.VehicleDetailGetAllResponse;
import RHL.calculation.service.VehicleDetailGetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculation")
public class VehicleDetailGetAllController {
    @Autowired
    VehicleDetailGetAllService vehicleDetailGetAllService;

    @GetMapping("/get/all/vehicle/details")
    public VehicleDetailGetAllResponse getAllVehicles() {
        VehicleDetailGetAllResponse response = new VehicleDetailGetAllResponse();
        try {
            response = vehicleDetailGetAllService.getAllVehicles();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
