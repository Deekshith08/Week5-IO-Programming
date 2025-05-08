
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}


public class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        // Validate the username against @MaxLength
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username != null && username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value());
                }
            }
            this.username = username;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe"); // OK
            System.out.println("User1 created: " + user1.getUsername());

            User user2 = new User("LongUsername123"); // Should throw exception
            System.out.println("User2 created: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
