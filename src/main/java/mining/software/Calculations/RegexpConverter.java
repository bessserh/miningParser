package mining.software.Calculations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpConverter {

    public static Double doubleConverter(String input) {
        double result = 0;
        Pattern pattern = Pattern.compile("[0-9]{1,}[,.][0-9]{1,}"); //double
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            result = Double.parseDouble(matcher.group());
        }
        return result;
    }

    public static int intConverter(String input) {
        int result = 0;
        Pattern pattern = Pattern.compile("\\s\\d{1,3}?([W])"); //int Watt
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            result = Integer.parseInt(matcher.group().replace("W", "").trim());
        }

        return result;
    }

    public static String measurement(String input) {
        String result = "no data";

        Pattern pattern = Pattern.compile("[M,h,k]{1,}\\/[s]"); //hasrate
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            result = matcher.group();
        }
        return result;
    }

    public static String algorithm(String input) {
        String result = "no data";

        Pattern pattern = Pattern.compile("\\b\\w{4,}"); //algorithm
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            result = matcher.group();
        }
        return result;
    }
}
