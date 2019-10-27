package models;
// Go ahead and use this to test your code, guys.
public class Test {
    public static void main(String[] args) {
    
        testMichaelsStuff();

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
            for (int j = 0; j < g.cols.get(0).size(); j++)
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


}
