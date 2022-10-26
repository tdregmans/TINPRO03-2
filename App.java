public class App {
    public static void main(String[] arg) {

        // De Linked List testen in de main methode
        LinkedList list = new LinkedList();

        Muppet Animal = new Muppet("Animal", 9);
        Muppet Beaker = new Muppet("Beaker", 4);
        Muppet Gonzo = new Muppet("Gonzo", 21);
        Muppet Kermit = new Muppet("Kermit", 1);
        Muppet Miss_Piggy = new Muppet("Miss_Piggy", 16);
        Muppet Swedish_Chef = new Muppet("Swedish_Chef", 7);

        list.pop();
        list.print();

        list.push(Animal,0);
        list.push(Beaker,1);
        list.push(Gonzo,2);
        list.push(Kermit,3);
        list.push(Miss_Piggy,4);
        list.push(Swedish_Chef,5);

        list.print();

        list.push(list.pop("Swedish_Chef"),0);

        list.print();

        // De stack testen
        Stack stack = new Stack();

        stack.pop();
        stack.print();

        stack.push(list.pop("Kermit"));
        stack.push(list.pop("Beaker"));
        stack.push(list.pop("Swedish_Chef"));

        list.print();
        stack.print();

        // De queue testen
        Queue queue = new Queue();

        queue.pop();
        queue.print();
        
        queue.push(list.pop("Gonzo"));
        queue.push(list.pop("Miss_Piggy"));
        queue.push(list.pop("Animal"));

        list.print();
        queue.print();

        list.push(queue.pop(), 0);
        list.push(queue.pop(), 0);
        list.push(queue.pop(), 0);

        list.push(stack.pop(), 0);
        list.push(stack.pop(), 0);
        list.push(stack.pop(), 0);
        // positie 1 is bij mij index 0

        System.out.println(list.size());

        list.print();
        
    }
}