package Cinema;

public class User {
    String name;
    int id;

        User(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "User ID=" + id + ", name='" + name;
        }
}
