import java.util.Scanner;

public class CollectorMenu {

    Scanner input = new Scanner(System.in);

    PaymentService paymentService;
    MemberService memberService;


    public CollectorMenu(MemberService memberService, PaymentService paymentService) {

        this.memberService = memberService;
        this.paymentService = paymentService;

    }


    public void showCollectorMenu() {

        int choice;


        do {

            System.out.println("\n========== COLLECTOR MENU ==========");
            System.out.println("1. Record Payment");
            System.out.println("2. View Payments");
            System.out.println("3. Check Member Contribution");
            System.out.println("0. Logout");


            System.out.print("Choose: ");

            choice = input.nextInt();



            switch(choice) {


                case 1:

                    System.out.print("Payment ID: ");
                    int paymentId = input.nextInt();


                    System.out.print("Member ID: ");
                    int memberId = input.nextInt();


                    System.out.print("Amount: ");
                    double amount = input.nextDouble();


                    input.nextLine();


                    System.out.print("Date: ");
                    String date = input.nextLine();



                    Member member =
                            memberService.findMemberById(memberId);



                    if(member != null) {


                        Payment payment =
                                new Payment(
                                        paymentId,
                                        memberId,
                                        amount,
                                        date
                                );


                        Collector collector =
                                new Collector(
                                        1,
                                        "Collector",
                                        "0000",
                                        "C001"
                                );


                        collector.collectPayment();


                        paymentService.recordPayment(payment, member);


                    }
                    else {

                        System.out.println("Member not found.");

                    }


                    break;



                case 2:

                    paymentService.viewPayments();

                    break;



                case 3:

                    System.out.print("Member ID: ");

                    int id = input.nextInt();


                    System.out.println(
                            "Contribution: "
                            + paymentService.calculateContribution(id)
                    );


                    break;



                case 0:

                    System.out.println("Collector logout.");

                    break;



                default:

                    System.out.println("Invalid choice.");

            }


        }while(choice != 0);

    }

}