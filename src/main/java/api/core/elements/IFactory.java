package api.core.elements;

public interface IFactory<T> {
    T get();
    T get(String value);
}
