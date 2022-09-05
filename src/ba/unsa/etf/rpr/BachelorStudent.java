package ba.unsa.etf.rpr;

public class BachelorStudent extends Student {
    public BachelorStudent(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        String rezultat = "Bachelor " + super.toString();
        return rezultat;
    }
}
