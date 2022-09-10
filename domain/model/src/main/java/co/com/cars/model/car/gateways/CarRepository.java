package co.com.cars.model.car.gateways;

import co.com.cars.model.car.Car;

public interface CarRepository {

    Car retrieveCar(Integer id);

    Car createCar(Car car);
}
