package co.com.cars.usecase.car;

import co.com.cars.model.car.Car;
import co.com.cars.model.car.gateways.CarRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarUseCase {

    private final CarRepository carRepository;

    public Integer createCar(Car car) {
        Car result = carRepository.createCar(car);
        if (result != null) {
            return result.getId();
        } else {
            return null;
        }
    }

    public Car retrieveCar(Integer idCar) {
        return carRepository.retrieveCar(idCar);
    }
}
