package org.example.context;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ScenarioContext implements Context {

    private final Map<ContextKey, Object> data = new ConcurrentHashMap<>();

    @Override
    public void save(Object o, ContextKey key) {
        data.put(key, o);
    }

    @Override
    public Object get(ContextKey key) {
        return data.get(key);
    }

    @Override
    public void reset() {
        data.clear();
    }
}
