// TOPIC : Implementation of inheritance in java using domain - SocialMedia application - HELLO APPLICATION.
// AUTHOR : Suvajit Karmakar
// DATA : 22.11.23
// LABEXERCISE : 3


abstract class SocialMediaUser {
    private String username;
    private String fullName;

    public SocialMediaUser(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
    }

    public void displayProfile() {
        System.out.println("USERNAME -> " + getUserName());
        System.out.println("FULLNAME ->  " + fullName);
    }

    public String getUserName() {
        return username;
    }

    public abstract void postContent(String content);
}


class Influencer extends SocialMediaUser {
    private int followers;

    public Influencer(String username, String fullName, int followers) {
        super(username, fullName);
        this.followers = followers;
    }

    
    @Override
    public void postContent(String content) {
        System.out.println("INFLUENCER " + super.getUserName() + " POSTED : " + content);
    }

    
    @Override
    public String getUserName() {
        return "INFLUENCER -> " + super.getUserName();
    }

    
    public void promote() {
        System.out.println(super.getUserName() + " IS PROMOTING THEIR CONTENT TO ->  " + followers + " FOLLOWERS.");
    }
}


final class RegularUser extends SocialMediaUser {
    private int friends;

    public RegularUser(String username, String fullName, int friends) {
        super(username, fullName);
        this.friends = friends;
    }

    
    @Override
    public void postContent(String content) {
        System.out.println("hloUSER " + super.getUserName() + " POSTED : " + content);
    }

    
    public void connectWithFriends() {
        System.out.println(super.getUserName() + " IS CONNECTING WITH " + friends + " FRIENDS.");
    }
}


class SocialMediaAdmin extends SocialMediaUser {
    private String adminRole;

    public SocialMediaAdmin(String username, String fullName, String adminRole) {
        super(username, fullName);
        this.adminRole = adminRole;
    }

    
    @Override
    public void postContent(String content) {
        System.out.println("hloADMIN " + super.getUserName() + " POSTED: " + content);
    }

    
    @Override
    public String getUserName() {
        return "hloADMIN -> " + super.getUserName();
    }

    
    public void manageContent() {
        System.out.println(super.getUserName() + " IS MANAGING HELLO APPLICATION AS IN " + adminRole);
    }
}

class MegaInfluencer extends Influencer {
    private String agency;

    public MegaInfluencer(String username, String fullName, int followers, String agency) {
        super(username, fullName, followers);
        this.agency = agency;
    }

    
    @Override
    public void promote() {
        System.out.println(getUserName() + " IS IN PROMOTION ZONE WITH THEIR AGENCY ->  " + agency);
    }
}

public class JavaInheritance {
    public static void main(String[] args) {
        //SINGLE INHERITANCE
        Influencer influencer = new Influencer("hloMarkZugerburg", "MarkZugerburg", 600000);
        influencer.displayProfile();
        influencer.postContent("CHECK OUT MY LATEST POST!");
        influencer.promote();

        System.out.println();

        //MULTILEVEL INHERITANCE
        MegaInfluencer megaInfluencer = new MegaInfluencer("hloHenryCavill", "HenryCavill", 1000000, "Jonathan dMac");
        megaInfluencer.displayProfile();
        megaInfluencer.postContent("REVISIT MY ACCOUNCEMENT!");
        megaInfluencer.promote();

        System.out.println();

        //HIRARCHICAL INHERITANCE
        SocialMediaAdmin admin = new SocialMediaAdmin("hloSuvajitKarmakar", "SuvajitKarmakar", "Application manager");
        admin.displayProfile();
        admin.postContent("CHECK OUT THE LATEST UPDATES IN HELLO!");
        admin.manageContent();

        System.out.println();

        //FINAL CLASS
        RegularUser regularUser = new RegularUser("hloSalini", "SaliniSatpati", 1367);
        regularUser.displayProfile();
        regularUser.postContent("JUST MY THOUGHTS AND A PICTURE !");
        regularUser.connectWithFriends();
    }
}
