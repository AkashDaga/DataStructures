import java.util.LinkedHashMap;

public class Example {
    public static void main(String args[]){
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();

        map.put(1,10);
        map.put(1,11);

        System.out.println(map.size()+"  "+map.get(1));
    }
}
