import java.util.HashMap;
import java.util.Set;

public class MapaDeHashmatique{
    public static void main(String[] args) {
        
        HashMap<String, String> trakList = new HashMap<String, String>();
        trakList.put("Glipmse of Us","she'd take the world off my shoulders");
        trakList.put("Ew", "When it's lovely , I believe in anything");
        trakList.put("Your Man", "Have you ever loved?");
        trakList.put("777","I don't need strings , no , no lies");

        Set<String> keys = trakList.keySet();
        for(String key : keys){
            System.out.println(String.format("Title: %s    Lyric: %s", key, trakList.get(key)));
        }
    }
}