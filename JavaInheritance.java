// TOPIC : Implementation of inheritance in java using domain - SocialMedia application
// AUTHOR : Suvajit Karmakar
// DATA : 22.11.23
// LABEXERCISE : 3

abstract class SocialMediaUser {
    String username;

    SocialMediaUser(String username) {
        this.username = username;
    }

    abstract void post(String content);

    void likePost() {
        System.out.println(username + " : LIKED THE POST.");
    }
}


class RegularUser extends SocialMediaUser {
    RegularUser(String username) {
        super(username);
    }

    
    void post(String content) {
        System.out.println(username + " POSTED : " + content);
    }
}


class AdminUser extends SocialMediaUser {
    AdminUser(String username) {
        super(username);
    }

    
    void post(String content) {
        System.out.println(username + " (Admin) POSTED : " + content);
    }

    
    void deletePost() {
        System.out.println(username + " : DELETED A POST.");
    }
}


final class FinalPost {
    private String content;

    FinalPost(String content) {
        this.content = content;
    }

    void display() {
        System.out.println("POST: " + content);
    }
}


public class JavaInheritance {
    public static void main(String[] args) {
        RegularUser regularUser = new RegularUser("SUVAJITKARMAKAR");
        AdminUser adminUser = new AdminUser("@hloSuvajit");

        regularUser.post("HEY THERE! I AM LEARNING JAVA");
        adminUser.post("IMPORTANT ANNOUNCEMENT");

        adminUser.deletePost(); // Only available in AdminUser

        regularUser.likePost();
        adminUser.likePost();

        FinalPost finalPost = new FinalPost("THIS IS THE FINAL POST.");
        finalPost.display();
    }
}
