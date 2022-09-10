package co.com.cars.api.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CreateCarResponse {

    private Integer id;
}
