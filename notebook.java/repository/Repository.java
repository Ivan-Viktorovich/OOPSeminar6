package repository;

import java.util.List;
import java.util.Optional;

public interface Repository<E, I> {
    List<E> findAll();
    E create(E e);
    Optional<E> update(I id, E e);
    Optional<E> delete(E e, String id);
}
