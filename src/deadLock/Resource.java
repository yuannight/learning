package deadLock;

/**
 * Created by duyan on 2016/9/1.
 */
public class Resource {

    private String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
