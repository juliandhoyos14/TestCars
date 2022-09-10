package co.com.cars.jpa;

import co.com.cars.jpa.entity.CarEntity;
import co.com.cars.jpa.helper.AdapterOperations;
import co.com.cars.model.car.Car;
import co.com.cars.model.car.gateways.CarRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Car, CarEntity, Integer, JPARepository>
        implements CarRepository {

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Car.class));
    }

    @Override
    public Car retrieveCar(Integer id) {
        Car car = findById(id);
        return car;
    }

    @Override
    public Car createCar(Car car) {
        return save(car);
    }
}
