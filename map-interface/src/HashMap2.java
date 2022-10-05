import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap2 {

    public void doHashMap2(){
        Map<String, Integer> productCode_quantity = new HashMap<>();
        productCode_quantity.put("code1", 100);
        productCode_quantity.put("code2", 200);
        productCode_quantity.put("code3", 300);

        Set<String> keys =  productCode_quantity.keySet();
        System.out.println(keys); // [code3, code2, code1]

        Collection<Integer> values = productCode_quantity.values();
        System.out.println(values); // [300, 200, 100]

        for (Map.Entry<String, Integer> entry : productCode_quantity.entrySet())
            System.out.print("key => " + entry.getKey()+ " | value => "+entry.getValue()+"\n");

        productCode_quantity.forEach((s, integer) -> System.out.print("key => " + s + " | value => "+integer+"\n"));



    }
}
