import java.util.*;

class C8Gerbil{
    int gerbilNumber;
    C8Gerbil(int i){
        gerbilNumber = i;
    }
    public void hop(){
        if (gerbilNumber > 5) System.out.print(gerbilNumber);
    }
}


public class Chapter8 {
    public static void main(String[] args) {
        Random r = new Random();
        Vector glist = new Vector();
        for(int i = 0; i < 10; i++){
            glist.addElement(new C8Gerbil(r.nextInt(10)));
        }
        // #1
        for(int j = 0; j < glist.size(); j++){
            ((C8Gerbil)glist.elementAt(j)).hop();
        }

        System.out.println();
        // #2
        Enumeration e = glist.elements();
        while(e.hasMoreElements()){
            ((C8Gerbil)e.nextElement()).hop();
        }

        System.out.println();
        // #3
        // #4 书中的集合使用的都是Java1.0和1.1中的旧的类型，先不写了

    }

}
