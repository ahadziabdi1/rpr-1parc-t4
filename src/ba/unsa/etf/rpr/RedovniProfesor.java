package ba.unsa.etf.rpr;

public class RedovniProfesor extends Nastavnik {
    public RedovniProfesor(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        String rezultat = "R. prof. dr " + getImePrezime();
        return rezultat;
    }
}
