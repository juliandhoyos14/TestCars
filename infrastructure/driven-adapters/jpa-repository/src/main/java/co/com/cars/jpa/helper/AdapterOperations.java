package co.com.cars.jpa.helper;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.lang.reflect.ParameterizedType;
import java.util.function.Function;

public abstract class AdapterOperations<E, D, I, R extends CrudRepository<D, I> & QueryByExampleExecutor<D>> {
    protected R repository;
    private Class<D> dataClass;
    protected ObjectMapper mapper;
    private Function<D, E> toEntityFn;

    public AdapterOperations(R repository, ObjectMapper mapper, Function<D, E> toEntityFn) {
        this.repository = repository;
        this.mapper = mapper;
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.dataClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
        this.toEntityFn = toEntityFn;
    }

    protected D toData(E entity) {
        return mapper.map(entity, dataClass);
    }

    protected E toEntity(D data) {
        return data != null ? toEntityFn.apply(data) : null;
    }

    public E save(E entity) {
        D data = toData(entity);
        return toEntity(saveData(data));
    }

    protected D saveData(D data) {
        return repository.save(data);
    }

    public E findById(I id) {
        return toEntity(repository.findById(id).orElse(null));
    }
}
