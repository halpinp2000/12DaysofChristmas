import java.util.Scanner;


public class Day3
{
    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);
        System.out.println("Enter the battery #s: ");
        int total = 0;
   






 
 
        while (true)
        {
            String currSet = uInput.nextLine();
            if (currSet.equals("done"))
            {
                break;
            }
            int maxIndex = 0;
            int secondIndex = 1;
            for (int i = 0; i < currSet.length() - 1; i++)
            {
                if (currSet.charAt(maxIndex) - '0' < currSet.charAt(i) - '0')
                {
                    maxIndex = i;
                }
            }
            secondIndex = maxIndex + 1;
            for (int i = maxIndex + 1; i < currSet.length(); i++)
            {
                if (currSet.charAt(secondIndex) - '0' < currSet.charAt(i) - '0')
                {
                    secondIndex = i;
                }
            }
           
            int addition = (currSet.charAt(maxIndex) - '0')* 10 + (currSet.charAt(secondIndex) - '0');
            System.out.println("We're adding:" + addition);
            total += addition;


           
            System.out.println("!!!TOTAL: " + total);




        }
   
        uInput.close();
    }
}



