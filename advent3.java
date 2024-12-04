import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class advent3 
{
    public static void main(String[] args) throws FileNotFoundException {
        
        File newFile = new File("advent3.txt");
        

        Scanner scan = new Scanner(newFile);
        char[] letters;
        String line;
        ArrayList<char[]> stuff = new ArrayList<>();
        while(scan.hasNext()) 
        {
            line = scan.next();
            letters = line.toCharArray();
            stuff.add(letters);
            
        }
    }   
}
