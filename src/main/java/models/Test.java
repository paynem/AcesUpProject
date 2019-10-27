package models;

public class Test {
    public static void main(String[] args) {
        Game g = new Game();
        g.buildDeck();
        deckCheck(g);
        g.dealFour();
        dealCheck(g);
        g.dealFour();
        g.dealFour();
        g.dealFour();
        g.dealFour();
        g.dealFour();
        multipleDeals(g);
        deckCheck(g);
        

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


}