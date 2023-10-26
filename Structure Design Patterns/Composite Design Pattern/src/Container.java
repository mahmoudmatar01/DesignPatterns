import java.util.ArrayList;
import java.util.List;

public class Container extends Component{
    private List<Component>children;
    public Container(String title,List<Component>children) {
        super(title);
        this.children=children;
    }

    public void printChildren(){
        System.out.println("============= Container Component ==========");
        children.stream().forEach(component -> {
            if(component instanceof Container){
                ((Container) component).children.stream().forEach(component1 -> System.out.println(component1.title));
            } else{
                System.out.println(component.title);
            }
        });
    }
}
