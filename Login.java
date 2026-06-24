import java.util.Scanner;

public class Login {

    Scanner input = new Scanner(System.in);


    private User admin;
    private User collector;



    public Login() {

        admin = new User("admin", "1234", "Admin");

        collector = new User("collector", "5678", "Collector");

    }





    public boolean adminLogin() {


        System.out.print("Username: ");
        String username = input.nextLine();



        System.out.print("Password: ");
        String password = input.nextLine();




        if(username.equals(admin.getUsername())
                && password.equals(admin.getPassword())) {



            System.out.println("Admin login successful.");

            return true;

        }


        else {


            System.out.println("Wrong admin username or password.");

            return false;

        }

    }







    public boolean collectorLogin() {


        System.out.print("Username: ");
        String username = input.nextLine();



        System.out.print("Password: ");
        String password = input.nextLine();




        if(username.equals(collector.getUsername())
                && password.equals(collector.getPassword())) {



            System.out.println("Collector login successful.");

            return true;

        }


        else {


            System.out.println("Wrong collector username or password.");

            return false;
        }
    }
}
