import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = reader.readLine();

        FileInputStream inputStream = new FileInputStream("src/main/resources/test.txt");
        Map<Integer, Integer> map_byte = new HashMap<>();

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            if(!map_byte.containsKey(data)){
                map_byte.put(data, 1);
            } else {
                map_byte.put(data, map_byte.get(data) + 1);
            }

        }

        inputStream.close(); // закрываем поток
        reader.close();

        int maxValue = Collections.min(map_byte.values());
        String result = "";
        for (Map.Entry<Integer, Integer> entry: map_byte.entrySet()){
            if(entry.getValue() == maxValue){
                result += entry.getKey() + " ";            }
        }
        System.out.println(result.trim());

    }
}
