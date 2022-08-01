import java.util.ArrayList;
import java.util.List;

public class lambda {


    public static void main(String[] args) {
        ArrayList<Object> objectArrayList = new ArrayList<Object>();
        objectArrayList.forEach(System.out::println );
    }
}
