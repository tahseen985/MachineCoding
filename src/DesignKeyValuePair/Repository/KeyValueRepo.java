package DesignKeyValuePair.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyValueRepo {
    Map<String, Map<String, Object>> map = new ConcurrentHashMap<>();

    public Map<String, Map<String, Object>> getMap() {
        return map;
    }

    public void setMap(Map<String, Map<String, Object>> map) {
        this.map = map;
    }
}
