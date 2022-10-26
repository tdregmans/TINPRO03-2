public class Muppet {
    private String naam;
    private int leeftijd;
    private Muppet next;

    public Muppet(String naam) {
        setNaam(naam);
        setLeeftijd(leeftijd);
    }

    public Muppet(String naam, int leeftijd) {
        setNaam(naam);
        setLeeftijd(leeftijd);
    }

    public Muppet(String naam, int leeftijd, Muppet next) {
        setNaam(naam);
        setLeeftijd(leeftijd);
        setNext(next);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String s) {
        if(s != null) {
            if(s.length() > 0) {
                this.naam = s;
            }
            else {
                System.out.println("gegeven naam is een lege string");
            }
        }
        else {
            System.out.println("gegeven naam is null");
        }
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int i) {
        if(i<0) {
            this.leeftijd = i;
        }
        else {
            System.out.println("gegeven leeftijd is negatief, en dat kan niet");
        }
    }

    public Muppet getNext() {
        return next;
    }

    public void setNext(Muppet m) {
        this.next = m;
    }

    public void print() {
        System.out.print("Ik ben ");
        System.out.print(this.getNaam());
        System.out.print(" en ik ben ");
        System.out.print(this.getLeeftijd());
        System.out.println(" jaar oud.");
    }
}