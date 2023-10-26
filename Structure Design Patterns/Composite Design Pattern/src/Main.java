
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Textview text1=new Textview("Name Text view");
        Textview text2=new Textview("Age Text view");
        ImageView profileImg=new ImageView("Profile Image");
        Container container=new Container("Container", List.of(
               text1,text2));
        Container nestedContainer=new Container(
                "Nested Container",List.of(
                        profileImg,container
        )
        );
       container.printChildren();
       nestedContainer.printChildren();
    }
}