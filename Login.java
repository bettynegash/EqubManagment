import java.util.Scanner;

public class Login {

    Scanner input = new Scanner(System.in);


    private User admin;


    public Login() {

        admin = new User("admin", "1234", "Admin");

    }



    public boolean adminLogin() {


        System.out.print("Username: ");
        String username = input.nextLine();



        System.out.print("Password: ");
        String password = input.nextLine();



        if(username.equals(admin.getUsername())
                && password.equals(admin.getPassword())) {


            System.out.println("Login successful.");

            return true;

        }


        else {


            System.out.println("Wrong username or password.");

            return false;

        }

    }

}