package coursePlayerDesktop;

public abstract class Person {
    private String name;
    private String status;
    private String username;

    public Person() {
    }

    public Person(String name, String status, String username) {
        this.name = name;
        this.status = status;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
