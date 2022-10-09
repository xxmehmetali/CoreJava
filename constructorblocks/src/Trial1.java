public class Trial1 {

    /*
        Constructor Blocks
        ----------------------------
       Constructor block'lar "Plain" ve "Static" olarak 2ye ayrılır.
       1-)Nesne üretilmeden class'ın static bir metodu veya static bir field'ı kullanıldığında sadece static constructor block'lar çalışır.
       2-)Nesne üretildiği durumda ise static ve plain constructor block'lar çalışır.

       Derleme sırasında 1 den fazla static constructor block var ise tek constructor block haline getirilir (bytecode (class) dosyasında).
       Plain constructor block'lar ise tüm constructor'lara kopyalanır.

     */

    static String var1 = "var1";
    static {
        System.out.println("------------------------------\nstatic block 1 starts\n");
        System.out.println("var1 block created.");
        System.out.println("var1 : " + var1); // var1
        var1="changedVar1";
        System.out.println("var1 : " + var1); // changedVar1
        System.out.println("------------------------------");
    }

    String var2 = "var2";
    {
        System.out.println("------------------------------\nplain starts\n");
        System.out.println("var2 : " + var2); // var2
        var2="changedVar2";
        System.out.println("var2 : " + var2); // changedVar2
        System.out.println("------------------------------");
    }

    String var3;
    {
        System.out.println("var3 : " + var3); //null
    }

    static String var4;
    static {
        System.out.println("var4 : " + var4); // null
    }

    public Trial1(){

    }
    public Trial1(String var1){

    }
    public Trial1(String var1, String var2){
        this.var1 = var1;
    }

    public Trial1(String var1, String var2, String var3){
        this.var3 = var3;
    }


}
