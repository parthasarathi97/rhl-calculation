package RHL.calculation.controller;

import RHL.calculation.dto.request.VehicleDetailsGetRequest;
import RHL.calculation.dto.response.VehicleDetailsGetResponse;
import RHL.calculation.service.VehicleDetailsGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculation")
public class VehicleDetailsGetController {
    @Autowired
    VehicleDetailsGetService vehicleDetailsGetService;

    @PostMapping("/get/vehicle")
    public VehicleDetailsGetResponse vehicleDetailsGet(@RequestBody VehicleDetailsGetRequest request) {
        VehicleDetailsGetResponse response = new VehicleDetailsGetResponse();
        try {
            response = vehicleDetailsGetService.vehicleDetailsGet(request);
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
