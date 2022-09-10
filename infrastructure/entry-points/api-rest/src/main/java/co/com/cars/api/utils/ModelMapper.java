package co.com.cars.api.utils;

import co.com.cars.model.car.Car;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public CarDto getResponseRetrieve(Car car) {
        return CarDto.builder()
                .year(car.getYear())
                .model(car.getModel())
                .build();
    }

    public CreateCarResponse getResponseCreate(Integer idCar) {
        return CreateCarResponse.builder()
                .id(idCar)
                .build();
    }

    public Car transformRequestToModel(CarDto carDto) {
        return Car.builder()
                .year(carDto.getYear())
                .model(carDto.getModel())
                .build();
    }
}
