import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HomeWork {

    public static Random random = new Random();

    public static void main(String[] args)
    {
        ArrayList<Integer> pile = new ArrayList<>();
        getPile(pile);
        System.out.println(pile);

        Collections.sort(pile);
        System.out.println(pile);

        while (!hasWon(pile))
        {
            int n = pile.size();
            for (int i = 0; i < pile.size(); i++)
            {
                pile.set(i , pile.get(i) - 1);
            }
            pile.add(n);
            removeZeros(pile);
            Collections.sort(pile);

            System.out.println(pile);
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
        int num = 45;
        while (num > 0)
        {
            int n = random.nextInt(num) + 1;
            num = num - n;
            list.add(n);
        }
    }

}
