package wiki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author btk16xmu
 */
public class Category {

    String name = "test Category";
    ArrayList<String> list = new ArrayList<>(Arrays.asList("xyz", "abc"));

    public Category() {

    }

    public String getName() {
        return name;
    }
}
