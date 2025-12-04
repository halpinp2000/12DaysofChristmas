import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static ArrayList<ArrayList<Character>> map = new ArrayList<>(); 
    public static int removedRolls; 
    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);
        removedRolls = 0;
        //ArrayList<ArrayList<Character>> map = new ArrayList<>();
        System.out.println("Please Enter the map: ");
        
        
        while (true)
        {
            String newLine = uInput.nextLine();
            if (newLine.equals("done"))
            {
                break;
            }
            ArrayList<Character> currLine = new ArrayList<Character>();
            for(int i = 0; i < newLine.length(); i++)
            {
                currLine.add(newLine.charAt(i));
            }
            map.add(currLine);
        }
        uInput.close();

        while (true)
        {
            boolean changed = getLoners();
            if (changed == false)
            {
                break;
            }
        }

        //System.out.println("We got: " + getLoners(map) + " loners to take care of.");
        System.out.println("Total Removed Loners:" + removedRolls + ". Have a pleasent day.");
    }

    public static boolean getLoners()
    {
        int loners = 0;
        boolean isDiff = false;

        for(int i = 0; i < map.size(); i++)
        {
            int neighbors = 0;
            for(int j = 0; j < map.get(i).size(); j++)
            {
                if (map.get(i).get(j) == '.')
                {
                    continue;
                }
                if(i > 0)
                {
                    if(j > 0 && map.get(i-1).get(j-1) != '.')
                    {
                        neighbors += 1;
                    }
                    if(map.get(i-1).get(j) != '.')
                    {
                        neighbors += 1;

                    }
                    if(j < map.get(i-1).size() - 1 && map.get(i-1).get(j+1) != '.')
                    {
                        neighbors += 1;

                    }
                }
                if(j > 0 && map.get(i).get(j-1) != '.')
                {
                    neighbors += 1;
                }
                if(j < map.get(i).size() - 1 && map.get(i).get(j+1) != '.')
                {
                    neighbors += 1;

                }
                if(i < map.size() -1)
                {
                    if(j > 0 && map.get(i+1).get(j-1) != '.')
                    {
                        neighbors += 1;
                    }
                    if(map.get(i+1).get(j) != '.')
                    {
                        neighbors += 1;
                    }
                    if(j < map.get(i+1).size() - 1 && map.get(i+1).get(j+1) != '.')
                    {
                        neighbors += 1;
                    }
                }
                if (neighbors < 4)
                {
                    loners += 1;
                    map.get(i).set(j, 'X'); 
                    isDiff = true;
                    fillPeriods();
                }
                neighbors = 0;
            }

        }

        printList();

        System.out.println("We have removed " + loners + " loners this time.");
        removedRolls += loners;
        return isDiff;
    }

    public static void printList()
    {
        for(int i = 0; i < map.size(); i++)
        {
            for(int j = 0; j < map.get(i).size(); j++)
            {
                System.out.print(map.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static void fillPeriods()
    {
        for(int i = 0; i < map.size(); i++)
        {
            for(int j = 0; j < map.get(i).size(); j++)
            {
                if (map.get(i).get(j) == 'X')
                {
                    map.get(i).set(j, '.');
                }
                
            }
            System.out.println();
        }
    }
}
