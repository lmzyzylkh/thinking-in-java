//将方法play()由"重载"改为"覆盖"
class NoteX {
    public static final int MIDDLE_C = 0, C_SHARP = 1, C_FLAT = 2;
}

class InstrumentX {
    public void play(int NoteX) {
        System.out.println("InstrumentX.play()");
    }
}

class WindX extends InstrumentX { // OOPS! Changes the method interface:
    /* "重载"
     void play(NoteX n) {
        System.out.println("WindX.play(NoteX n)");
     */
    // "覆盖"
    public void play(int NoteX) {
        System.out.println("WindX.play()");
    }
}

public class C7WindError {
    public static void tune(InstrumentX i) { // ...
        i.play(NoteX.MIDDLE_C);
    }

    public static void main(String[] args) {
        WindX flute = new WindX();
        tune(flute); // Not the desired behavior!
    }
}
