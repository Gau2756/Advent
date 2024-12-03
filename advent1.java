import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class advent1 
{

    public static void main(String args []) throws FileNotFoundException 
    {
        File newFile = new File("advent1.txt");
        

        Scanner scan = new Scanner(newFile);
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        String[] values;
        while(scan.hasNextLine()) 
        {
            String input = scan.nextLine();
            values = input.split("   ");
            arr1.add(Integer.parseInt(values[0]));
            arr2.add(Integer.parseInt(values[1]));
        }

        
        arr1.sort(null);
        arr2.sort(null);

        
        int difference = 0; 
        for(int i = 0; i < arr1.size(); i++) {
            difference += Math.abs(arr1.get(i) - arr2.get(i));
        }
        
        int similarity = 0; 
        Hashtable<Integer, Integer> stuff = new Hashtable<>();
        for(int i = 0; i < arr1.size(); i++) 
        {
            if(stuff.containsKey(arr2.get(i))) 
            {
                stuff.put(arr2.get(i), stuff.get(arr2.get(i))+1);
            }
            else {
                stuff.put(arr2.get(i), 1);
            }
            
        }
        for(int i = 0; i < arr1.size(); i++) {
            if(stuff.get(arr1.get(i)) == null) similarity += arr1.get(i) * 0;
            else {
                similarity += arr1.get(i) * stuff.get(arr1.get(i));
            }
            System.err.println(arr1.get(i));
        }
        System.out.println(similarity);
    }
    
}
