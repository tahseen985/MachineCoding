package DesignKeyValuePair.Service;

import DesignKeyValuePair.Repository.KeyValueRepo;

import java.util.*;

public class Service {
    KeyValueRepo keyValueRepo;
    List<String > dataType;

    public Service(KeyValueRepo keyValueRepo) {
        this.keyValueRepo = keyValueRepo;
        this.dataType = new ArrayList<>();
    }
    public synchronized void put(String[] splited) throws Exception {
        Map<String, Object> value = new HashMap<>();
        List<String > dataList = new ArrayList<>();
        String key = splited[1];
        for(int i=2; i< splited.length; i=i+2) {
            String attributeKey = splited[i];
            String attributeValue = splited[i+1];
            value.put(attributeKey, attributeValue);
            dataList.add(checkDataType(attributeValue));
        }

        if(this.dataType.size() == 0) {
            this.dataType = dataList;
        } else {
            for(int i=0; i<this.dataType.size(); i++) {
                if(!this.dataType.get(i).equalsIgnoreCase(dataList.get(i))) {
                    throw new Exception("Data Type Error");
                }
            }
        }

        keyValueRepo.getMap().put(key, value);
    }
    public synchronized void get(String[] splited) {
        String key = splited[1];
        if(!keyValueRepo.getMap().containsKey(key)) {
            System.out.println("Invalid Key");
            return;
        }
        List<String> attributeStrings = new ArrayList<>();
        for (Map.Entry<String, Object> entry : keyValueRepo.getMap().get(key).entrySet()) {
            attributeStrings.add(entry.getKey() + ": " + entry.getValue().toString());
        }
        System.out.println(String.join(", ", attributeStrings));
    }
    public synchronized void delete(String[] splited) {
        String key = splited[1];
        if(!keyValueRepo.getMap().containsKey(key)) {
            System.out.println("Invalid Key");
            return;
        }
        keyValueRepo.getMap().remove(key);
    }
    public synchronized void search(String[] splited) {
        String attributedKey = splited[1];
        String attributedValue = splited[2];
        List<String> list = new ArrayList<>();

        for(Map.Entry<String, Map<String, Object >> m : keyValueRepo.getMap().entrySet()){
            Map<String, Object > map = m.getValue();
            if(!map.containsKey(attributedKey)) {
                System.out.println("Invalid Input");
                return;
            }
            if(map.get(attributedKey).toString().equalsIgnoreCase(attributedValue)) {
                list.add(m.getKey());
            }
        }
        Collections.sort(list);
        System.out.println(String.join(",", list));
    }
    public synchronized void getKeys() {
        List<String> keys = new ArrayList<>(keyValueRepo.getMap().keySet());
        System.out.println(String.join(",", keys));
    }

    private String checkDataType(String str) {

        try {
            Integer integerValue = Integer.parseInt(str);
            return "Integer";
        } catch (NumberFormatException e) { }

        try {
            double doubleValue = Double.parseDouble(str);
            return "Double";
        } catch (NumberFormatException e) { }

        try {
            if(str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false")) {
                return "Boolean";
            }
        } catch (NumberFormatException e) { }

        return "String";
    }
}
