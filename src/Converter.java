public class Converter {
    public static String firstCap(String s){
        String output = s.substring(0, 1).toUpperCase() + s.substring(1);
        return output;
    }
}
