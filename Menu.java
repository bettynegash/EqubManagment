import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);


    MemberService memberService = new MemberService();
    PaymentService paymentService = new PaymentService();
    Equb equb = new Equb("Community Equb");



    public void adminMenu() {


        int choice;


        do {


            System.out.println("\n========== ADMIN MENU ==========");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Search Member");
            System.out.println("4. Update Member");
            System.out.println("5. Delete Member");
            System.out.println("6. Record Payment");
            System.out.println("7. View Payments");
            System.out.println("8. Select Winner");
            System.out.println("9. Total Contribution");
            System.out.println("0. Logout");


            System.out.print("Choose: ");

            choice = input.nextInt();



            switch(choice) {



                case 1:

                    input.nextLine();


                    System.out.print("ID: ");
                    int id = input.nextInt();

                    input.nextLine();


                    System.out.print("Name: ");
                    String name = input.nextLine();


                    System.out.print("Phone: ");
                    String phone = input.nextLine();



                    Member member =
                            new Member(id,name,phone,0,false);



                    memberService.addMember(member);
                    equb.addMember(member);



                    System.out.println("Member added successfully.");

                    break;




                case 2:

                    memberService.viewMembers();

                    break;




                case 3:

                    System.out.print("Enter ID: ");

                    int searchId = input.nextInt();

                    memberService.searchMember(searchId);

                    break;




                case 4:

                    System.out.print("Member ID: ");

                    int updateId = input.nextInt();

                    input.nextLine();


                    System.out.print("New Phone: ");

                    String newPhone = input.nextLine();


                    memberService.updateMember(updateId,newPhone);


                    System.out.println("Member updated.");

                    break;




                case 5:

                    System.out.print("Member ID: ");

                    int deleteId = input.nextInt();


                    memberService.deleteMember(deleteId);
                    equb.removeMember(deleteId);


                    System.out.println("Member deleted.");

                    break;



                case 6:

                    System.out.print("Payment ID: ");
                    int paymentId = input.nextInt();


                    System.out.print("Member ID: ");
                    int memberId = input.nextInt();


                    System.out.print("Amount: ");
                    double amount = input.nextDouble();


                    input.nextLine();


                    System.out.print("Date: ");
                    String date = input.nextLine();



                    Payment payment =
                            new Payment(paymentId, memberId, amount, date);



                    Member paymentMember =
                            memberService.findMemberById(memberId);



                    if(paymentMember != null){

                        paymentService.recordPayment(payment, paymentMember);

                    }
                    else{

                        System.out.println("Member not found.");

                    }


                    break;




                case 7:

                    paymentService.viewPayments();

                    break;




                case 8:

                    Member winner = equb.selectWinner();


                    if(winner != null){

                        System.out.println("Winner:");
                        System.out.println(winner);

                    }

                    else{

                        System.out.println("No members.");

                    }


                    break;




                case 9:

                    System.out.println(
                            "Total Contribution: "
                            + equb.calculateTotal()
                    );


                    break;




                case 0:

                    System.out.println("Logout.");

                    break;



                default:

                    System.out.println("Invalid choice.");

            }



        }while(choice != 0);



    }






    public void memberMenu(int id) {


        Member member = memberService.findMemberById(id);


        if(member != null){

            System.out.println(member);

        }

        else{

            System.out.println("Member not found.");

        }

    }

}
