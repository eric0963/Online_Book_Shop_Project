package utility;

public class GetNumber {
	
    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
        }
        return defaultValue;
    }

}
