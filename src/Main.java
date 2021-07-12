import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        FIRST TASK
        Map<String, Integer> map = new HashMap<>();
        map.put("Katya", 10);
        map.put("Serezha", 25);
        map.put("Vasiliy", 40);
        map.put("Ylyana", 15);
        map.put("Svyatoslav", 36);
        map.put("Sersh", 27);
        map.put("Nikita", 45);
        map.put("Artem", 8);
        map.put("Kostya", 38);
        map.put("Maksym", 36);

        Map<Integer, String> reverseMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

//        SECOND TASK
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> lineMap = new HashMap<>();
        String inputLine = "a";
        while (!inputLine.equals(" ")) {
            try {
                System.out.println("Please, print a line");
                inputLine = reader.readLine();
                if (inputLine.equals(" ")) {
                    break;
                } else if (lineMap.containsKey(inputLine)) {
                    lineMap.replace(inputLine, lineMap.get(inputLine) + 1);
                } else {
                    lineMap.put(inputLine, 1);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List list = findMax(lineMap.values());
        System.out.println(list.get(0) + " " + list.get(1));
        printMaxNumbers(lineMap, list);
    }


    public static List findMax(Collection<Integer> array) {
        List list = new ArrayList();
        int max = 0;
        int preMax = 0;
        for (Integer integer : array) {
            if (max < integer) {
                preMax = max;
                max = integer;
            }
        }
        list.add(preMax);
        list.add(max);
        return list;
    }

    public static void printMaxNumbers(Map<String, Integer> collection, List list) {
        for (Map.Entry<String, Integer> entry : collection.entrySet()) {
            if (list.get(1) == entry.getValue()) {
                System.out.println("Max line: '" + entry.getKey() + "' was written " + entry.getValue() + " times");
            }
        }
        for (Map.Entry<String, Integer> entry : collection.entrySet()) {
            if (list.get(0) == entry.getValue()) {
                System.out.println("The first PreMax line: '" + entry.getKey() + "' was written " + entry.getValue() + " times");
                break;
            }
        }
    }
}
