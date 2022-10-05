import java.util.HashMap;
import java.util.Map;

public class HashMap1 {
    public void doHashMap1(){

        Map<String, Integer> productCode_quantity = new HashMap<>();
        productCode_quantity.put("code1",100); // {code1=100}
        productCode_quantity.put("code2",200); // {code2=200, code1=100}
        productCode_quantity.put("code3",300); // {code3=300, code2=200, code1=100}
        productCode_quantity.put(null,null);    // {null=null, code3=300, code2=200, code1=100}
        productCode_quantity.put(null,999);     // üstüne yazar : {null=999, code3=300, code2=200, code1=100}

        System.out.println(productCode_quantity); // {null=999, code3=300, code2=200, code1=100}
        System.out.println(productCode_quantity.isEmpty()); // false
        System.out.println(productCode_quantity.size());    // 4
        System.out.println(productCode_quantity.containsKey("code1"));    // true
        System.out.println(productCode_quantity.containsValue(100));    // true
        System.out.println(productCode_quantity.get("code1"));    // 100

        productCode_quantity.putIfAbsent("xcode",1);
        System.out.println(productCode_quantity);    // {null=999, code3=300, code2=200, code1=100, x=1}
        // x zaten varolduğu için ekleme yapmayacak
        productCode_quantity.putIfAbsent("xcode",2);
        System.out.println(productCode_quantity);    // {null=999, code3=300, code2=200, code1=100, x=1}
        productCode_quantity.replace("code1",666);   // {null=999, code3=300, code2=200, code1=666, xcode=1}
        System.out.println(productCode_quantity);
//        System.out.println(productCode_quantity.getOrDefault("xcode",0));
//        productCode_quantity.getOrDefault()

    }
}
