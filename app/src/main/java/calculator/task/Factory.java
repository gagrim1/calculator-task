package calculator.task;

import lombok.SneakyThrows;

public class Factory {
    private static Factory instance = new Factory();
    private Config config = new ConfigImpl("calculator.task");

    public static Factory getInstance() {
        return instance;

    }

    private Factory() {
    }

    @SneakyThrows
    public <T> T create(Class<T> type) {
        Class<? extends T> implClass = type;
        if (implClass.isInterface()) {
            implClass = config.getImplClass(type);
        }
        return implClass.getDeclaredConstructor().newInstance();
    }
}
