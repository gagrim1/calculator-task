package calculator.task;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);
}
