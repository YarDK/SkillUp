public class LeanObject implements Cloneable{
    int i;


    public static void main(String[] args) throws CloneNotSupportedException{
        LeanObject obj1 = new LeanObject();
        obj1.i = 10;
        LeanObject obj2 = obj1;
        obj2.i = 30;
        System.out.println(obj1.i);

    }

    @Override
    protected LeanObject clone() throws CloneNotSupportedException {
        return (LeanObject) super.clone();
    }
}
