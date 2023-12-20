import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int where = 0, counter = 0;
        boolean first = true;
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            String regex = "[()]";
            while(scanner.hasNext()){
                String string = scanner.next();
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(string);
                while(matcher.find()){
                    if(matcher.group().equals("(")){
                        where++;
                    } else if (matcher.group().equals(")")) {
                        where--;
                    }
                    if(first){
                        counter++;
                        if(where == -1){
                            System.out.println("First basement after "+counter+" moves");
                            first = false;
                        }
                    }
                }
            }
            System.out.println("Destination: "+where);
        }catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}
