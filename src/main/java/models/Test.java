package models;
// Go ahead and use this to test your code, guys.
public class Test {
    public static void main(String[] args) {
    
        Game g = new Game();
        g.dealFour();
        g.dealFour();
        g.dealFour();
        g.dealFour();
        System.out.println(g.a1.getCard(0));
        System.out.println(g.a1.getCard(1));
        System.out.println(g.a1.getCard(2));
        System.out.println(g.a1.getCard(3));
        System.out.println(g.a1.numCards());
        System.out.println(g.dealPile.numCards());

    }
    
}
