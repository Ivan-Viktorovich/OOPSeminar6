package view.notmap;

public interface Mapper<E, T> {
    T toInput(E e);
    E toOutput(T t);
}
