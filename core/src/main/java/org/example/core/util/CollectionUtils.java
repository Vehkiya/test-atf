package org.example.core.util;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;

public final class CollectionUtils {

    public static <T> Optional<T> getRandomElement(Collection<T> collection) {
        return collection.stream()
                .skip(new Random().nextInt(collection.size()))
                .findFirst();
    }
}
