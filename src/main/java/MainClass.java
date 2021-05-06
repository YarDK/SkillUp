import hashmapskills.StringClass;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        //collectionsSkill();
        //hashMapSkill();
    }



    public static void collectionsSkill(){

        String[] planets_arr = {"Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун"};
        ArrayList<String> solarSystem = new ArrayList<>(Arrays.asList(planets_arr));
        // Сортировка
        Collections.sort(solarSystem);
        // Развернуть список
        Collections.reverse(solarSystem);
        System.out.println(solarSystem);

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        // Максимальное значение в списке
        System.out.println(Collections.max(numbers));
        // Минимальное значение в списке
        System.out.println(Collections.min(numbers));

        // Перемешать значения в списке
        Collections.shuffle(numbers);
        System.out.println(numbers);

        // Сделать список не изменяемым
        List<Integer> numbers_unmodifiable = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        try{
            numbers_unmodifiable.add(8);
        } catch (Exception e){
            System.out.println(numbers_unmodifiable);
            e.printStackTrace();
        }

        // Переставить значения местами
        Collections.swap(numbers, numbers.indexOf(5), numbers.indexOf(7)); // indexOf определяет индекс конкретного объекта
        System.out.println(numbers);

        // Проверка соответствия списков. Если НЕ соответсвтует, будет равно true
        System.out.println(Collections.disjoint(numbers, numbers_unmodifiable));
    }

    public static void hashMapSkill(){
        HashMap<Integer, String> passportsAndNames = new HashMap<>();

        passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
        passportsAndNames.put(162348, "Иван Михайлович Серебряков");
        passportsAndNames.put(8082771, "Дональд Джон Трамп");

        // Получение списка всех ключей и значений
        Set<Integer> keys = passportsAndNames.keySet();
        System.out.println("Ключи: " + keys);

        ArrayList<String> values = new ArrayList<>(passportsAndNames.values());
        System.out.println("Значения: " + values);

        for (Map.Entry entry: passportsAndNames.entrySet()) {
            System.out.println(entry);
        }

        passportsAndNames.entrySet().forEach(System.out::println);

        Map<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("0", "zero");
        hashmap.put(null, null);
        hashmap.put("idx", "two");
        System.out.println("\n" + hashmap);

        // Итераторы
        // 1.
        for (Map.Entry<String, String> entry: hashmap.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());

        // 2.
        for (String key: hashmap.keySet())
            System.out.println(hashmap.get(key));

        // 3.
        Iterator<Map.Entry<String, String>> itr = hashmap.entrySet().iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }


}
