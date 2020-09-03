public class Chapter3 {
    public static class PrintNumbers{
        static void printNumbers(int n){
            for(int i = 1; i <= n; i++){
                System.out.print(String.valueOf(i) + " ");
            }
        }
    }

    public static class BreakNumbers{
        static void breakNumbers(int n, int b){
            for(int i = 1; i <= n; i++){
                //if (i == b) break;
                if (i == b) return;
                System.out.print(String.valueOf(i) + " ");
            }
        }
    }

    public static class SwitchTest{
        static void switchTest(){
            for(int i = 0; i < 5; i++){
                switch(i){
                    case 0: System.out.println("Number 0"); break;
                    case 1: System.out.println("Number 1"); break;
                    case 2: System.out.println("Number 2"); break;
                    case 3: System.out.println("Number 3"); break;
                    default: System.out.println("Number 4");
                }
            }
        }
    }

    public static class SwitchTestNoBreak{
        static void switchTest(){
            for(int i = 0; i < 5; i++){
                switch(i){
                    case 0: System.out.println("Number 0");
                    case 1: System.out.println("Number 1");
                    case 2: System.out.println("Number 2");
                    case 3: System.out.println("Number 3"); break;
                    default: System.out.println("Number 4");
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintNumbers.printNumbers(100);
        System.out.println();
        BreakNumbers.breakNumbers(100, 47);
        System.out.println();
        SwitchTest.switchTest();
        SwitchTestNoBreak.switchTest();
    }
}
