import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static int countLine(String s) throws FileNotFoundException{
        FileReader r =new FileReader(s);
        Scanner sc=new Scanner(r);
        int count = 0;
        while(sc.hasNextLine()){
            sc.nextLine();
            count++;
        }
        sc.close();
        return count;
    }
    public static int countWords(String s) throws FileNotFoundException{
        FileReader r =new FileReader(s);
        Scanner sc=new Scanner(r);
        int length = 0;
        while(sc.hasNextLine()){
            String words[]=sc.nextLine().split(" ");
            length+=words.length;
        }
        sc.close();
        return length;
    }
    public static int countCharacters(String s) throws FileNotFoundException{
        FileReader r =new FileReader(s);
        Scanner sc=new Scanner(r);
        int length = 0;
        while(sc.hasNextLine()){
            String words[]=sc.nextLine().split(" ");
            for(int i=0;i<words.length;i++){
                length+=words[i].length();
            }
        }
        sc.close();
        return length;
    }
    public static void main(String[] args) throws IOException {
        String options=args[0];
        int start=Integer.MAX_VALUE;
        if(options.equals("-w")||options.equals("-l")||options.equals("-m")){
            start=1;
        }
        if(options.matches("(.*)txt")){
            start=0;
        }
        for(int i=start;i<args.length;i++){
            switch(options){
                case "-w":
                System.out.print(countLine(args[i])+" ");
                break;
                case "-l":
                System.out.print(countWords(args[i])+" ");
                break;
                case "-m":
                System.out.print(countCharacters(args[i])+" ");
                break;
                default:{
                    System.out.print(countLine(args[i])+" ");
                    System.out.print(countWords(args[i])+" ");
                    System.out.print(countCharacters(args[i])+" ");
                }
            }
            System.out.println(args[i]);
        }
    }
}