package RHL.calculation.controller;

import RHL.calculation.dto.request.VehicleDetailSaveRequest;
import RHL.calculation.dto.response.VehicleDetailSaveResponse;
import RHL.calculation.service.VehicleDetailsSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculation")
public class VehicleDetailsSaveController {
    @Autowired
    VehicleDetailsSaveService vehicleDetailsSaveService;

    @PostMapping("/save/vehicle")
    public VehicleDetailSaveResponse vehicleDetailSave(@RequestBody VehicleDetailSaveRequest request) {
        VehicleDetailSaveResponse response = new VehicleDetailSaveResponse();
        try {
            response = vehicleDetailsSaveService.vehicleDetailSave(request);
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
