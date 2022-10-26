public class Stack {
    private int size;
    private Muppet start;

    // een stack werkt volgens een l.i.f.o principe
    // Last In, First Out

    /** constructor
     */
    public Stack() {
        this.size = 0;
    }

    /** plaats muppet m op de stack
     * @param m Muppet wordt in de Stack geplaatst
     */
    public void push(Muppet m) {
        if(m == null) {
            System.out.println("De muppet die je probeert te pushen bestaat niet/is leeg!");
        }
        else {
            if(m.getNaam() == null) {
                System.out.println("De muppet die je probeert te pushen bestaat niet/is leeg!");
            }
            else {
                // m is een geldige muppet
                if(this.size == 0) {
                    this.start = m;
                }
                else {
                    // navigeer naar de volgende plek
                    Muppet laatste = this.start;
                    for(int x = 1;x<this.size;x++) {
                        laatste = laatste.getNext();
                    }
                    // zet de pointer van de laatste naar m
                    laatste.setNext(m);
                }
                this.size++;
            }
        }
    }

    /** return laatste muppet en verwijder van de stack
     * @return de laatste muppet van de stack
     */
    public Muppet pop() {
        Muppet returnMuppet;
        if(this.size == 1) {
            returnMuppet = this.start;
            this.start = null;
            this.size--;
        }
        else if(this.size > 1) {
            // neem laatste en maak die returnMuppet
            Muppet laatste = this.start;
            for(int x = 1;x<this.size;x++) {
                laatste = laatste.getNext();
            }
            returnMuppet = laatste;
            // neem laatste -1 en verwijder pointer naar laatste
            Muppet opEenNaLaatste = this.start;
            for(int x = 1;x<this.size-1;x++) {
                opEenNaLaatste = opEenNaLaatste.getNext();
            }
            opEenNaLaatste.setNext(null);
            this.size--;
        }
        else {
            System.out.println("De stack is leeg");
            returnMuppet = null;
        }
        return returnMuppet;
    }

    /** print alle muppets op de stack
     */
    public void print() {
        System.out.print("Stack bevat ");
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

    /** return de hoeveelheid muppets op de stack
     * @return size
     */
    public int size() {
        return this.size;
    }
}
