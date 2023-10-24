import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // proxy design pattern : Provider a surrogate or placeholder for another
        //                        object to control access to it " Like a gateway for an object "


        List<String> sites= Arrays.asList(
                "youtube",
                "linkedin",
                "porno",
                "udemy",
                "facebook",
                "instagram"
        );
        InternetServices internet =new InternetServicesProxy();
        for (String site:sites){
            System.out.println(internet.serviceSite(site));
        }
    }
}