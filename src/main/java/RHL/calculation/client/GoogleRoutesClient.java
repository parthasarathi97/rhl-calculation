package RHL.calculation.client;

import RHL.calculation.client.request.RouteClientRequest;
import RHL.calculation.client.respnse.RouteClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "googleRoutesClient", url = "https://routes.googleapis.com")
public interface GoogleRoutesClient {
    @PostMapping(value = "/directions/v2:computeRoutes", consumes = "application/json")
    RouteClientResponse getRoute(@RequestParam("key") String apiKey, @RequestHeader("X-Goog-FieldMask") String fieldMask, @RequestBody RouteClientRequest request);
}
