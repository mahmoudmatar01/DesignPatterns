import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class InternetServicesProxy implements InternetServices{

    List<String> blockedSites= Arrays.asList(
      "porno","facebook","twitter","instagram"
    );

    @Override
    public String serviceSite(String url) {
        if(blockedSites.contains(url)){
            return "this site is blocked, return to work!!!!";
        }
        return new Etisalat().serviceSite(url);
    }

    public void login(String url){
        System.out.printf("[%d] %s %n ",System.currentTimeMillis(),url);
    }
}
