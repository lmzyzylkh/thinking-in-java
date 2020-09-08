/*
class Rodent{
    void f(){}
}

class Mouse extends Rodent{
    void f(){System.out.println("Mouse");}
}

class Gerbil extends Rodent{
    void f(){System.out.println("Gerbil");}
}

class Hamster extends Rodent{
    void f(){System.out.println("Hamster");}
}
*/
interface Rodent{
    void f();
}

class Mouse implements Rodent{
    public void f(){System.out.println("Mouse");}
}

class Gerbil implements Rodent{
    public void f(){System.out.println("Gerbil");}
}

class Hamster implements Rodent{
    public void f(){System.out.println("Hamster");}
}

public class Chapter7 {
    public static void main(String[] args) {
        //First & Second
        Rodent[] r = new Rodent[]{new Mouse(), new Gerbil(), new Hamster()};
        for(int i = 0; i < r.length; i++){r[i].f();}
    }
}
