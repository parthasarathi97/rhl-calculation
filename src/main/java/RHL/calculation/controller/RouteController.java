package RHL.calculation.controller;

import RHL.calculation.dto.request.RouteRequest;
import RHL.calculation.dto.response.RouteResponse;
import RHL.calculation.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculation")
public class RouteController {
    @Autowired
    RouteService routeService;

    @PostMapping("/route")
    public RouteResponse route(@RequestBody RouteRequest routeRequest) {
        RouteResponse response = new RouteResponse();
        try {
            response = routeService.route(routeRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
