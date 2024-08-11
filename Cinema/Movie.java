package Cinema;

public class Movie {
    String name;
    int id;
    
    
    Movie(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return id + ". " + name;
    }
}
