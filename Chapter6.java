class A{
    A(String ssa){
        System.out.println("A" + ssa);
    }
}

class B{
    B(String ssb){
        System.out.println("B" + ssb);
    }
}

class C extends A{
    C(String ssc){
        super(ssc);
        System.out.println("C" + ssc);
    };
    B btest = new B("StrB");
}

public class Chapter6 {
    public static void main(String[] args) {
        C ctest = new C("StrC");
    }
}
