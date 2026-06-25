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

                    Member member = memberService.findMemberById(memberId);

                    if(member != null) {
                        // Dynamically look up the safety rules based on profile types
                        double limit = 100.0;
                        if (member.getEqubType() != null && member.getEqubType().equalsIgnoreCase("Merchant")) {
                            limit = 1000.0;
                        }

                        // Enforced transaction loop to prevent low values
                        double amount = 0;
                        while (true) {
                            System.out.print("Amount (" + member.getEqubType() + " Min Requirement is " + limit + " Birr): ");
                            amount = input.nextDouble();
                            input.nextLine(); // Clear buffer

                            if (amount >= limit) {
                                break;
                            }
                            System.out.println("❌ Deposit Rejected: Amount is lower than the mandatory base minimum of " + limit + " Birr.");
                        }

                        System.out.print("Date: ");
                        String date = input.nextLine();

                        Payment payment = new Payment(
                                paymentId,
                                memberId,
                                amount,
                                date
                        );

                        System.out.println("Payment collected by collector successfully.");
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
        } while(choice != 0);
    }
}
