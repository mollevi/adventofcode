import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        int ribbon = 0;
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            String regex = "^([0-9]*?)x([0-9]*?)x([0-9]*?)$";
            Pattern pattern = Pattern.compile(regex);
            while (scanner.hasNext()) {
                String string = scanner.next();
                Matcher matcher = pattern.matcher(string);
                if (matcher.find()) {
                    int l = Integer.parseInt(matcher.group(1)),
                            w = Integer.parseInt(matcher.group(2)),
                            h = Integer.parseInt(matcher.group(3));
                    int minSideArea = (l < w || l < h)? (w < h)? l*w : l*h : h*w;
                    int minSidePerimeter = (l < w || l < h)? (w < h)? (l+w)*2 : (l+h)*2 : (h+w)*2;
                    total += 2 * l * w + 2 * w * h + 2 * h * l + minSideArea;
                    ribbon += w*h*l + minSidePerimeter;
                }
            }
            System.out.println("Total: "+total+"\nRibbon needed: "+ribbon);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
