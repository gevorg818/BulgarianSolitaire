import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BulgarianSolitaire {

    public static Random random = new Random(); //To generate Random Numbers

    public static void main(String[] args)
    {
        ArrayList<Integer> pile = new ArrayList<>(); //To hold the number of cards in a pile and number of piles as the size
        getPile(pile);      //Create piles
        System.out.println(pile);       //Print initial piles

        while (!hasWon(pile))   //Keep playing until the triangular number has been arranged in increasing order
        {
            int n = pile.size();    //New pile to add by removing one card we are adding the whole size as a new pile
            for (int i = 0; i < pile.size(); i++)
            {
                pile.set(i , pile.get(i) - 1);
            }
            pile.add(n);
            removeZeros(pile);//Remove all zeros
            Collections.sort(pile);//sort

            System.out.println(pile);//print
        }
    }

    public static boolean hasWon(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i)!= (i+1))
            {
                return false;
            }
        }
        return true;
    }

    public static void removeZeros(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) == 0)
            {
                list.remove(i);
                i--;
            }
        }
    }

    public static void getPile(ArrayList<Integer> list)
    {
        int numOfCards = 45;
        while (numOfCards > 0)
        {
            int n = random.nextInt(numOfCards) + 1;
            numOfCards -= n;
            list.add(n);
        }
    }

}