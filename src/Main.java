import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Login login = new Login();

        Menu menu = new Menu();

        CollectorMenu collectorMenu = new CollectorMenu(
                menu.memberService,
                menu.paymentService
        );


        int choice;


        do {

            System.out.println("\n==============================");
            System.out.println("   EQUB MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Admin Login");
            System.out.println("2. Member Login");
            System.out.println("3. Collector Login");
            System.out.println("0. Exit");


            System.out.print("Choose: ");
            choice = input.nextInt();


            switch(choice) {


                case 1:

                    input.nextLine();

                    boolean success = login.adminLogin();

                    if(success){

                        menu.adminMenu();

                    }

                    break;



                case 2:

                    System.out.print("Enter Member ID: ");

                    int id = input.nextInt();

                    menu.memberMenu(id);

                    break;



                case 3:

                    input.nextLine();

                    boolean collectorSuccess = login.collectorLogin();

                    if(collectorSuccess){

                        collectorMenu.showCollectorMenu();

                    }

                    break;



                case 0:

                    System.out.println("System closed.");

                    break;



                default:

                    System.out.println("Invalid choice.");

            }


        } while(choice != 0);


    }

}
