package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    //    public static Integer increaseValue (int count){
//        count = count++;
//        return count;
//    }
/*    public static HashMap<Object, Integer> sortByValue(Map<Object, Set<Object>> input) {
        HashMap<Object, Integer> tempDataStructure = new HashMap<>();
        for (Map.Entry<Object, Set<Object>> output : input.entrySet()) {
            Object object = output.getKey();
            Integer number = output.getValue().size();
            tempDataStructure.put(object, number);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Object, Integer>> list =
                new LinkedList<Map.Entry<Object, Integer>>(tempDataStructure.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Object, Integer>>() {
            public int compare(Map.Entry<Object, Integer> o1,
                               Map.Entry<Object, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Collections.reverse(list);
        // put data from sorted list to hashmap
        HashMap<Object, Integer> temp = new LinkedHashMap<Object, Integer>();
        for (Map.Entry<Object, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }*/

    public static HashMap<Object, Integer>
    sortByValue(Map<Object, Set<Object>> input) {
        HashMap<Object, Integer> tempDataStructure = new HashMap<>();
        for (Map.Entry<Object, Set<Object>> output : input.entrySet()) {
            Object object = output.getKey();
            Integer number = output.getValue().size();
            tempDataStructure.put(object, number);
        }
        HashMap<Object, Integer> temp
                = tempDataStructure.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i2.getValue().compareTo(
                        i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return temp;
    }

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();

        boolean firstTime = true;
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        File file = new File("src/main/java/org/example/drakvuf-trace.log");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();


        if (line.indexOf('}') == -1) {
            Map<Object, Object> employee = objectMapper.readValue(file, new TypeReference<>() {
            });
            String indented = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
            System.out.println(indented);
        } else
        {

            //Map<Object, HashMap<Object, Integer>> result = new HashMap<Object, HashMap<Object, Integer>>();
            Map<Object, Set<Object>> result = new HashMap<>();


            while (scanner.hasNextLine()) {
                if (!firstTime) {
                    line = scanner.nextLine();
                }


                Map<Object, Object> jsonObject = objectMapper.readValue(line, new TypeReference<>() {
                });


                /*if (jsonObject.containsKey("FileName")) {
                    Object temp = jsonObject.get("FileName");
                    if (result.containsKey(temp)) {
                        result.put(temp, result.get(temp) + 1);
                    } else {
                        result.put(temp, 0);
                    }
                }*/
                /*Integer n = 1;
                Iterator<Map.Entry<Object, Object>> itr = jsonObject.entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry<Object, Object> entry = itr.next();
                    // get key
                    Object key = entry.getKey();
                    // get value
                    Object value = entry.getValue();

                    if (result.containsKey(key)) {
                        if (!result.containsValue(value)) {
                            result.put(key, new HashMap<>());

                            result.get(key).put(value, increaseValue(n));

                        }
                    } else {
                        result.put(key, new HashMap<>());
                        result.get(key).put(value, n);
                    }
                }*/

                Iterator<Map.Entry<Object, Object>> itr = jsonObject.entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry<Object, Object> entry = itr.next();
                    // get key
                    Object key = entry.getKey();
                    // get value
                    Object value = entry.getValue();

                    if (result.containsKey(key)) {

                        result.get(key).add(value);

                        //result.get(key).put(value, increaseValue(n));


                    } else {
                        result.put(key, new HashSet<>());
                        result.get(key).add(value);
                    }
                }


                // String indented = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
                //System.out.println(indented);
                firstTime = false;


            }
            /*for (Map.Entry<Object, HashMap<Object, Integer>> employeeEntrySet : result.entrySet()) {
                //Map<Object, Integer> valueMap = employeeEntrySet.getValue();
                //System.out.println(valueMap.entrySet());
                System.out.println(result.keySet());
            }*/
//            for (Map.Entry<Object, Set<Object>> output : result.entrySet()) {
//                //Map<Object, Integer> valueMap = employeeEntrySet.getValue();
//                //System.out.println(valueMap.entrySet());
//                Object object = output.getKey();
//                Integer number = output.getValue().size();
//                System.out.println(object + " : " + number);
//            }
            HashMap<Object, Integer> output = sortByValue(result);
            //System.out.println(output.entrySet());
            for (Map.Entry<Object, Integer> temp : output.entrySet()) {
                Object object = temp.getKey();
                Integer number = temp.getValue();
                System.out.println(object + " : " + number);
            }


            //System.out.println(result.keySet());
            //System.out.println(result.keySet());
            long finish = System.nanoTime();
            long elapsed = finish - start;
            double seconds = (double) elapsed / 1_000_000_000.0;
            System.out.println("Прошло времени, сек: " + seconds);
        }


    }
    //System.out.println(employee.entrySet());


}