import java.util.ArrayList;
import java.util.List;

public class Container extends Component{
    private List<Component>children;
    public Container(String title,List<Component>children) {
        super(title);
        this.children=children;
    }

    public void printChildren(){
        children.stream().forEach(component -> System.out.println(component.title));
    }
}
