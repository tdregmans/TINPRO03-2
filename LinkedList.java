public class LinkedList {
    private int size;
    private Muppet start;

    /** constructor 1
     */
    public LinkedList() {
        this.size = 0;
    }

    /** constructor 2
     * @param start Muppet wordt de eerste Muppet in de LinkedList
     */
    public LinkedList(Muppet start) {
        if(start != null) {
            this.size = 1;
            this.start = start;
        }
        else {
            System.out.println("De muppet die je probeert te pushen bestaat niet/is leeg!");
        }
    }

    /** print alle items
     */
    public void print() {
        System.out.print("Lijst bevat ");
        System.out.print(this.size);
        System.out.print(" Muppet(s)");
        if(this.size > 0) {
            System.out.print(". Hier zijn ze:");
        }
        System.out.println();
        Muppet volgende = this.start;
        for(int x = 0;x<this.size;x++) {
            volgende.print();
            volgende = volgende.getNext();
        }
    }

    /** schuif Muppet m naar index p
     * @param m Muppet wordt in de LinkedList geplaatst
     * @param p index waar m op de LinkedList wordt geplaatst
     */
    public void push(Muppet m, int p) {
        // muppet mag niet null zijn en index moet een geldige plaats zijn
        if(m == null || !(p >= 0 && p <= this.size)) {
            if(m == null) {
                System.out.println("De muppet die je probeert te pushen bestaat niet/is leeg!");
            }
            if(!(p >= 0 && p <= this.size)) {
                System.out.println("De plek waar je de muppet probeert te pushen is geen geldige plek!");
            }
        }
        else {
            // muppet is niet null en index is geldig
            Muppet volgende;
            if(this.start == null) {
                // als er nog geen muppet in de lijst staat, maak m de eerste
                this.start = m;
            }
            else {
                if(p == 0) {
                    // vervang eerste muppet
                    volgende = this.start;
                    this.start = m;
                    this.start.setNext(volgende);
                }
                else if(p > 0 && p < this.size-1){
                    // vervang een 'tussen' muppet
                    volgende = this.peek(p);
                    this.peek(p-1).setNext(m);
                    m.setNext(volgende);
                }
                else {
                    // voeg een extra muppet toe
                    this.peek(p-1).setNext(m);
                }
            }
            this.size++;
        }
    }

    /** verwijder alle muppets
     */
    public void pop() {
        while(this.size > 0) {
            this.pop(0);
        }
        System.out.println("De lijst is leeg");
    }

    /** verwijder en return Muppet van plek p
     * @param p index van Muppet die van de LinkedList verwijderd wordt
     * @return muppet die verwijderd is
     */
    public Muppet pop(int p) {
        Muppet returnMuppet = null;
        if(!(p >= 0 && p <= this.size-1)) {
            System.out.println("De plek waarvan je de muppet probeert te poppen is geen geldige plek!");
        }
        else {
            // index p is geldig
            returnMuppet = this.peek(p);
            if(returnMuppet == null) {
                System.out.println("Er is geen muppet om te verwijderen!");
            }
            else {
                Muppet volgende;
                if(p == 0) {
                    // verwijder en return eerste muppet
                    volgende = this.start.getNext();
                    this.start = volgende;
                }
                else if(p > 0 && p < this.size-1){
                    // verwijder en return een 'tussen' muppet
                    volgende = this.peek(p+1);
                    this.peek(p-1).setNext(volgende);
                }
                else {
                    // verwijder en return de laatste muppet
                    this.peek(p-1).setNext(null);
                }
                this.size--;
            }
        }
        return returnMuppet;
    }

    /** verwijder en return Muppet met naam s
     * @param s naam van de te verwijderen muppet
     * @return muppet die verwijderd is
     */
    public Muppet pop(String s) {
        Muppet returnMuppet = null;
        if(s == null) {
            System.out.println("De naam waarop je zoekt mag niet leeg zijn!");
        }
        else if(s.length() == 0) {
            System.out.println("De naam waarop je zoekt mag niet leeg zijn!");
        }
        else {
            // string s is een geldige zoekterm
            int p = this.peek(s);
            if(p == this.size) {
                // als zoekplek gelijk is aan size, dan is er geen Muppet gevonden met de naam s
                System.out.print("Er is geen muppet met de naam '");
                System.out.print(s);
                System.out.println("'!");
            }
            else {
                returnMuppet = this.pop(p);
            }
        }
        return returnMuppet;
    }

    /** zoek en return index van muppet met naam s
     * @param s naam van op te zoeken muppet
     * @return index van muppet
     * LET OP! >>> als return waarde gelijk is aan size dan bestaat er geen muppet met naam s
     */
    public int peek(String s) {
        int returnPointer = this.size;
        if(s == null) {
            System.out.println("De naam waarop is gezocht is leeg!");
        }
        else if(s.length() == 0) {
            System.out.println("De naam waarop is gezocht is leeg!");
        }
        else {
            // string s is een geldige zoekterm
            for(int x=0;x<this.size;x++) {
                if(s == this.peek(x).getNaam()) {
                    returnPointer = x;
                }
            }
            if(returnPointer == this.size) {
                // als return waarde gelijk is aan size dan bestaat er geen muppet met naam s
                System.out.print("De naam '");
                System.out.print(s);
                System.out.println("' komt niet voor!");
            }
        }
        return returnPointer;
    }

    /** return muppet op plek n
     * @param n index van op te zoeken mupppet
     * @return muppet
     */
    public Muppet peek(int n) {
        Muppet returnMuppet = null;
        if(!(n >= 0 && n <= this.size-1)) {
            System.out.println("De plek waarvan je de muppet probeert te zoeken is geen geldige plek!");
        }
        else {
            // plek n is een geldige plek
            Muppet volgende = this.start;
            for(int x=-1;x<n;x++) {
                returnMuppet = volgende;
                volgende = volgende.getNext();
            }
        }
        return returnMuppet;
    }

    /** return aantal plekken op list
     * @return hoeveelheid muppets in LinkedList
     */
    public int size() {
        return this.size;
    }
}