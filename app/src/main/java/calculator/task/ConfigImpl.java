package calculator.task;

import org.reflections.Reflections;

import java.util.Set;

public class ConfigImpl implements Config {
    private Reflections scanner;

    public ConfigImpl(String packageToScan) {
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        Set<Class<? extends  T>> classes = scanner.getSubTypesOf(ifc);
        if (classes.size() != 1) {
            throw new BeanException(ifc + " has to many or zero implementations!");
        }
        return classes.iterator().next() ;
    }
}
