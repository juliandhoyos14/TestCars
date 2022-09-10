package co.com.cars.api;
import co.com.cars.api.utils.CarDto;
import co.com.cars.api.utils.CreateCarResponse;
import co.com.cars.api.utils.ModelMapper;
import co.com.cars.model.car.Car;
import co.com.cars.usecase.car.CarUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final CarUseCase carUseCase;
    private final ModelMapper modelMapper;

    @GetMapping(path = "/cars/{idCar}")
    public ResponseEntity<CarDto> commandName(@PathVariable Integer idCar) {

        Car car = carUseCase.retrieveCar(idCar);
        CarDto response;
        if(car != null) {
            response = modelMapper.getResponseRetrieve(car);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(path = "/cars")
    public ResponseEntity<CreateCarResponse> commandName(@RequestBody CarDto carToCreate) {

        Integer idCar = carUseCase.createCar(modelMapper.transformRequestToModel(carToCreate));
        CreateCarResponse response;
        if(idCar != null) {
            response = modelMapper.getResponseCreate(idCar);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
