class AccessTest{
    public static AccessTest publicTest(){
        System.out.println("Public Test");
        return new AccessTest();
    }
    private static AccessTest privateTest(){
        System.out.println("Private Test");
        return new AccessTest();
    }
    protected static AccessTest protectedTest(){
        System.out.println("Protected Test");
        return new AccessTest();
    }
    static AccessTest friendlyTest(){
        System.out.println("Friendly Test");
        return new AccessTest();
    }
}

class ProtectedTest{
    String s;
    ProtectedTest(String ss){
        s = ss;
    }
    protected static ProtectedTest constructor(String sss){
        return new ProtectedTest(sss);
    }

    void print(String str){
        System.out.println(str);
    }
}

public class Chapter5 {
    public static void main(String[] args) {
        /* First */
        AccessTest t1 = AccessTest.publicTest();
        //AccessTest t2 = AccessTest.privateTest();
        AccessTest t3 = AccessTest.protectedTest();
        AccessTest t4 = AccessTest.friendlyTest();

        /* Second */
        ProtectedTest t5 = ProtectedTest.constructor("Test5");
        ProtectedTest t6 = ProtectedTest.constructor("Test6");
        t6.print(t5.s); // expected "Test5

        /* Third */

        /* Forth */

    }
}
