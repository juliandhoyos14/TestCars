package co.com.cars.jpa;

import co.com.cars.jpa.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<CarEntity, Integer>, QueryByExampleExecutor<CarEntity> {
}
