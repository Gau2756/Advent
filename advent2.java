import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class advent2 
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        File newFile = new File("advent2.txt");
        

        Scanner scan = new Scanner(newFile);   
        ArrayList<String[]> stuff = new ArrayList<>();
        String level;
        String[] values;
        while(scan.hasNext()) 
        {
            level = scan.nextLine();
            values = level.split(" ");
            stuff.add(values);
        }
        String[] current;
        int Safe = 0; 
        
        for(int i = 0; i < stuff.size(); i++) {

            
            current = stuff.get(i);
            if(isSafe(current, 0) || isSafe(current, 1)) Safe++;


        }
        System.out.println(Safe);

    }
    private static boolean isSafe(String[] a, int offset) 
    {
        ArrayList<String> stuff = new ArrayList<String>();
        for(int i = 0; i < a.length; i++) stuff.add(a[i]);



        boolean dampener = false;
        boolean ascending = true; 
        boolean descending = true; 
        
        for(int i = 0; i < stuff.size()-1; i++) 
        {
            if(Integer.parseInt(stuff.get(i)) > Integer.parseInt(stuff.get(i+1))) 
            {
                dampener = true;
                stuff.remove(i+offset);
                break;
            }
        }
        if(dampener== true) 
        {
            for(int i = 0; i < stuff.size()-1; i++) 
            {
                if(Integer.parseInt(stuff.get(i)) > Integer.parseInt(stuff.get(i+1))) 
                {
                    ascending = false;
                    dampener = false;
                    stuff.clear();
                    for(int x = 0; x < a.length; x++) stuff.add(a[x]);

                    for(int f = 0; f < stuff.size()-1; f++) 
                    {
                        if(Integer.parseInt(stuff.get(f)) < Integer.parseInt(stuff.get(f+1))) 
                        {
                            dampener = true;
                            stuff.remove(f+offset);
                            break;
                        }
                    }
                    if(dampener = true) 
                    {
                        for(int f = 0; f < stuff.size()-1; f++) 
                        {
                            if(Integer.parseInt(stuff.get(f)) < Integer.parseInt(stuff.get(f+1))) 
                            {
                                return false; 
                            }
                        }
                    }

                }
            }


        }
        
        if(dampener) 
        {
            if(Gradual(stuff) != true) 
            {
                return false;
                
            }
            return true; 
        }
        //stuff.clear();
        //for(int i = 0; i < a.length; i++) stuff.add(a[i]);
        
        int differance; 
        for(int i = 0; i < stuff.size()-1; i++) 
        {
            differance = Math.abs(Integer.parseInt(stuff.get(i)) - Integer.parseInt(stuff.get(i+1)));
            if(differance < 1 || differance > 3) 
            {
                dampener = true; 
                stuff.remove(i+offset);
                break;
            }
        }
        if(dampener) 
        {
            for(int i = 0; i < stuff.size()-1; i++) 
            {
                differance = Math.abs(Integer.parseInt(stuff.get(i)) - Integer.parseInt(stuff.get(i+1)));
                if(differance < 1 || differance > 3) 
                {
                    return false; 

                }
            }
        }
        return true; 

    }
    
    private static boolean Ascending(String[] a) 
    {
        
        for(int i = 0; i < a.length-1; i++) 
        {
            if(Integer.parseInt(a[i]) > Integer.parseInt(a[i+1])) 
            {
                return false; 
            }
        }
        return true;
    }
    private static boolean Descending(String[] a) 
    {
        for(int i = 0; i < a.length-1; i++) 
        {
            if(Integer.parseInt(a[i]) < Integer.parseInt(a[i+1])) 
            {
                return false; 
            }
        }
        return true;
    }
    private static boolean Gradual(ArrayList<String> a) 
    {
        int differance; 
        for(int i = 0; i < a.size()-1; i++) 
        {
            differance = Math.abs(Integer.parseInt(a.get(i)) - Integer.parseInt(a.get(i+1)));
            if(differance < 1 || differance > 3) 
            {
                return false; 
            }
        }
        return true;
    }

}
