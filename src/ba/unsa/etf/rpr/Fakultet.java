package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class Fakultet {

    private List<Osoba> list = new ArrayList<>();
    public void dodajOsobu(Osoba o) {
        list.add(o);
    }

    public Set<Student> studenti() {
        TreeSet<Student> rezultat = new TreeSet<>();
        for(Osoba o : list)
            if(o instanceof  Student)
                rezultat.add((Student) o);
        return rezultat;
    }

    public List<Osoba> filtriraj(Function<Osoba, Boolean> f) {
        ArrayList<Osoba> rezultat = new ArrayList<>();
        for(Osoba o : list)
            if(f.apply(o)) rezultat.add(o);
        return rezultat;
    }

    public List<BachelorStudent> topBachelor() {
        List list = filtriraj((Osoba o) -> { return (o instanceof BachelorStudent && ((BachelorStudent) o).prosjek() >= 8);});
        return list;
    }

    public List<Mladi> mladi() {
        List<Mladi> rezultat = new ArrayList<>();
        for(Osoba o : list)
            if(o instanceof MasterStudent || o instanceof Docent)
                rezultat.add((Mladi) o);
        return rezultat;
    }

    @Override
    public String toString() {
        String rezultat = "";
        for(Osoba o : list)
            rezultat += o + "\n";
        return rezultat;
    }
}
