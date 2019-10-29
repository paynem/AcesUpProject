package models;
// Go ahead and use this to test your code, guys.
public class Test {
    public static void main(String[] args) {
    
        testMichaelsStuff();
        testJaspreetsStuff();

    }
    static void deckCheck(Game g) {
        for (int i = 0; i < g.deck.size(); i++) {
            System.out.print("Card " + (i+1) + ": ");
            System.out.print(g.deck.get(i).toString());
            System.out.print("\n");
        }
    }
    static void dealCheck(Game g) {
        for (int i = 0; i < 4; i++){
            System.out.print("Column " + i + " card: ");
            System.out.print(g.cols.get(i).toString());
            System.out.print(" ");
        }
        System.out.print("\n");
    }
    static void multipleDeals(Game g){
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < g.cols.get(i).size(); j++)
            {
                System.out.print("Column " + i + " card " + j + ": ");
                System.out.print(g.cols.get(i).get(j).toString());
                System.out.print("\n");
            }
        }

    }
    static void testMichaelsStuff(){
        Game g = new Game();
        System.out.print("Building deck ...\n");
        // duplicating process of ApplicationController.Java
        g.buildDeck();
        g.shuffle();
        g.dealFour(); 
        System.out.print("Now checking to see if 4 cards were dealt at game start.\n");
        multipleDeals(g);
        System.out.print("Now checking to see if multiple deals work correctly.\n");
        System.out.print("First let's check contents of deck.\n");
        deckCheck(g);
        System.out.print("Now dealing 4 times.\n");
        g.dealFour();
        g.dealFour();
        g.dealFour();
        g.dealFour();
        System.out.print("Checking contents of columns (each should have 5 cards).\n");
        multipleDeals(g);
        System.out.print("Checking to see if deck is updated.\n");
        deckCheck(g);
        System.out.print("Now, let's check to see if shuffle is actually working.  Going to generate multiple decks and then check their contents.\n");
        Game a = new Game();
        Game b = new Game();
        Game c = new Game();
        Game d = new Game();
        Game e = new Game();
        a.shuffle();
        b.shuffle();
        c.shuffle();
        d.shuffle();
        e.shuffle();
        System.out.print("Let's check contents of each deck now.\n");
        deckCheck(a);
        deckCheck(b);
        deckCheck(c);
        deckCheck(d);
        deckCheck(e);
    }
    

    static void testJaspreetsStuff(){


        // Set "PRIVATE  boolean columnHasCards(int columnNumber)" to "PUBLIC boolean columnHasCards(int columnNumber)" for execution in Game.java to test

                //      Tests columnHasCards        //
        /*
        System.out.print("\n\nTesting Remove & columnHasCards (Jaspreet)\n");

        Game k = new Game();
        boolean temp1 = k.columnHasCards(0);
        System.out.println("\nExperimenal: Column 0 has cards: " + temp1);
        System.out.println("Expected: Column 0 has cards: FALSE");
        System.out.print("\nBuilding deck ...\n");
        // duplicating process of ApplicationController.Java
        k.buildDeck();
        k.shuffle();
        System.out.print("Now dealing 2 times.\n");
        k.dealFour();
        k.dealFour();

        System.out.print("Checking contents of columns (each should have 2 cards).\n");
        multipleDeals(k);
        boolean temp2 = k.columnHasCards(0);
        System.out.println("\nExperimental: Column 0 has cards: " + temp2);
        System.out.println("Expected: Column 0 has cards: TRUE\n");
        */

        Game g = new Game();
        System.out.print("Building deck ...\n");
        // duplicating process of ApplicationController.Java
        
        g.buildDeck();
        g.dealFour();
        System.out.print("Contents of deck\n");
        multipleDeals(g);
        System.out.print("Attempting to remove column 0 (should WORK)\n");
        g.remove(0);
        System.out.print("Contents after attempting to remove\n");
        multipleDeals(g);
        System.out.print("Attempting to remove column 3 (should FAIL)\n");
        g.remove(3);
        System.out.print("Contents after attempting to remove\n");
        multipleDeals(g);
    }
}
