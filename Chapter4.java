class ConstructorTest{
    ConstructorTest(){
        System.out.println("Constructor Test");
    }

    ConstructorTest(String ss){
        System.out.println(ss);
    }

}

//Garbage.java似乎书中的版本与当前版本不一致，运行结果不正确

public class Chapter4 {
    public static void main(String[] args) {
        ConstructorTest ct1 = new ConstructorTest();
        ConstructorTest ct2 = new ConstructorTest("overloading");
        ConstructorTest[] ctlist = new ConstructorTest[3];
        //print arraylist
        for(int i = 0; i < ctlist.length; i++){
            System.out.print(ctlist[i] + "  ");
        }
        System.out.println();
        //print arraylist end
        for(int i = 0; i < ctlist.length; i++){
            ctlist[i] = new ConstructorTest(String.valueOf(i));
        }
        //print arraylist
        for(int i = 0; i < ctlist.length; i++){
            System.out.print(ctlist[i] + "  ");
        }
        System.out.println();
        //print arraylist end
    }
}
