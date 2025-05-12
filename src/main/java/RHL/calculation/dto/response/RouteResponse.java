package RHL.calculation.dto.response;

import RHL.calculation.client.respnse.RouteClientResponse;
import lombok.Data;

@Data
public class RouteResponse {
    private int statusCode;
    private String message;
    private RouteClientResponse data;
}
