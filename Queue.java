public class Queue {
    private int size;
    private Muppet start;

    // een Queue werkt volgens een f.i.f.o principe
    // First In, First Out

    /** constructor
     */
    public Queue() {
        this.size = 0;
    }

    /** plaats muppet m in de Queue
     * @param m Muppet wordt in de Queue geplaatst
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

    /** verwijder eerste muppet van de Queue en return
     * @return eerste muppet
     */
    public Muppet pop() {
        Muppet returnMuppet;
        if(this.size > 0) {
            returnMuppet = this.start;
            // maak de tweede muppet de eerste
            this.start = this.start.getNext();
            this.size--;
        }
        else {
            System.out.println("De queue is leeg");
            returnMuppet = null;
        }
        return returnMuppet;
    }

    /** print alle muppets in de Queue
    */
    public void print() {
        System.out.print("Queue bevat ");
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

    /** return de hoeveelheid muppets op de Queue
     * @return size
     */
    public int size() {
        return this.size;
    }
}
