package hashmapskills;

import java.util.*;

public class StringClass {

    String name;

    public StringClass(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringClass that = (StringClass) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(name);
        return 1;
    }

    public static void main(String[] args) {
        hashSetSkill();
        //hashMapSkill();
        //hashCodAndEqualSkill();
    }

    public static void hashMapSkill(){
        Map<StringClass, String> hashmap = new HashMap<>();

        StringClass obj = new StringClass("4");

        hashmap.put(new StringClass("1"), "Лидия Аркадьевна Бубликова");
        hashmap.put(new StringClass("2"), "Иван Михайлович Серебряков");
        hashmap.put(new StringClass("3"), "Дональд Джон Трамп");
        hashmap.put(obj, "Ебать Колотить Петрович");

        for (Map.Entry<StringClass, String> entry: hashmap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
            System.out.println("hashCode: " + (Object) entry.getKey().hashCode());
            System.out.println("");
        }

        for(int i=0; i<10; i++ ){
            System.out.println(hashmap.get(obj));
        }

    }

    public static void hashSetSkill(){
        Set<StringClass> hashSet = new HashSet<>();

        for(int i=0; i<10; i++ ){
            hashSet.add(new StringClass("" + i));
        }



        System.out.println("\nЭксперементы =)\n");

        StringClass obj1 = hashSet.iterator().next();

        for(StringClass obj : hashSet){
            System.out.println("Hash code obj1: " + obj1.hashCode() + ", hash code obj: " + obj.hashCode());
            System.out.println(obj1.equals(obj));
        }

        //System.out.println(hashSet.iterator().next().equals(hashSet.iterator().next()));
    }

    public static void hashCodAndEqualSkill(){
        StringClass text1 = new StringClass("1234");
        StringClass text2 = new StringClass("1234");
        StringClass text3 = new StringClass("5678");
        StringClass text4 = new StringClass("9101");

        System.out.println((Object) text1.name.hashCode());
        System.out.println((Object) text2.name.hashCode());

        System.out.println((Object) text1.hashCode());
        System.out.println((Object) text2.hashCode());
        System.out.println((Object) text4.hashCode());
        System.out.println((Object) text4.hashCode());

        System.out.println(text1 == text2);
        System.out.println(text1.equals(text2));
        System.out.println(text3 == text4);
        System.out.println(text3.equals(text4));

    }
}
