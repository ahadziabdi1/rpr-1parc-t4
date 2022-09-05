package ba.unsa.etf.rpr;


public class Student extends Osoba implements Comparable<Student> {

    private int[] ocjene = new int[100];
    private String brojIndexa = "";
    private int brojOcjena = 0;
    public Student(String imePrezime) {
        super(imePrezime);
    }

    public int[] getOcjene() {
        return ocjene;
    }

    public void setOcjene(int[] ocjene) {
        this.ocjene = ocjene;
    }

    public String getBrojIndeksa() {
        return brojIndexa;
    }

    public void setBrojIndeksa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public int getBrojOcjena() {
        return brojOcjena;
    }

    public void setBrojOcjena(int brojOcjena) {
        this.brojOcjena = brojOcjena;
    }

    public void dodajOcjenu(int ocjena) throws IlegalnaOcjena {
            if(ocjena < 5 || ocjena > 10) {
                throw new IlegalnaOcjena("Ilegalna ocjena " + ocjena);
            }
            if(brojOcjena >= 100) {
                throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
            }
            ocjene[brojOcjena++] += ocjena;
    }

    public double prosjek() {
        if(brojOcjena == 0) return 0;
        double suma = 0;
        for(int i = 0; i < brojOcjena; i++)
            suma += ocjene[i];
        return suma/brojOcjena;
    }

    @Override
    public String toString() {
        String rezultat = "student " + getImePrezime() + " (" + brojIndexa + "), prosjek ocjena: ";
        double zaokruzi = Math.round(prosjek() * 10);
        zaokruzi /= 10;
        rezultat += zaokruzi;
        return rezultat;
    }

    @Override
    public int compareTo(Student student) {
        if(prosjek() > student.prosjek()) return -1;
        if(prosjek() < student.prosjek()) return 1;
        return 0;
    }
}
