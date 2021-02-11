package org.example.context;

/**
 * Entity used to save or retrieve data between different steps of a test
 */
public interface Context {

    /**
     * Save the provided {@link Object} and associate it with provided {@link ContextKey}
     */
    void save(Object o, ContextKey key);

    /**
     * Retrieve the {@link Object} associated with provided {@link ContextKey} discriminator
     *
     * @return
     */
    Object get(ContextKey key);

    /**
     * Delete all data currently contained in the org.example.context
     */
    void reset();

    /**
     * Marker interface to be used as discriminator for saving or retrieving data
     */
    interface ContextKey {

    }

}
