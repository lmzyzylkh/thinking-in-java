import java.util.*;

class HelloWorld {
    static void printHelloWorld(){
        System.out.println("Hello, World");
    }
}

/** this is a note */
class GetParameter {
    static void getParameter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input first parameter");
        String p1 = sc.nextLine();
        System.out.println("input second parameter");
        String p2 = sc.nextLine();
        System.out.println("input third parameter");
        String p3 = sc.nextLine();
        System.out.println(p1 + "," + p2 + "," + p3);
    }
}

public class Chapter2 {
    public static void main(String[] args) {
        HelloWorld.printHelloWorld();
        GetParameter.getParameter();
    }
}
