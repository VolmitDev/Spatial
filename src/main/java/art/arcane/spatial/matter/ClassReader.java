package art.arcane.spatial.matter;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClassReader {
    private static final Set<ClassLoader> loaders = ConcurrentHashMap.newKeySet();

    public static void add(ClassLoader loader) {
        loaders.add(loader);
    }

    public static Class<?> find(String name) throws ClassNotFoundException {
        for (ClassLoader loader : loaders) {
            try {
                return Class.forName(name, true, loader);
            } catch (Throwable ignored) {}
        }
        throw new ClassNotFoundException(name);
    }
}
