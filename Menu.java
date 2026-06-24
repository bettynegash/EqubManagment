import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    MemberService memberService = new MemberService();
    PaymentService paymentService = new PaymentService();
    Equb equb = new Equb("Community Equb");


    public Menu() {

        for (Member m : memberService.getMembers()) {

            equb.addMember(m);

        }

    }



    public void adminMenu() {

        int choice;


        do {

            System.out.println("\n========== ADMIN MENU ==========");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Search Member");
            System.out.println("4. Update Member");
            System.out.println("5. Delete Member");
            System.out.println("6. Select Winner");
            System.out.println("7. Total Contribution");
            System.out.println("0. Logout");


            System.out.print("Choose: ");
            choice = input.nextInt();



            switch(choice) {


                case 1:

                    input.nextLine();

                    int id;


                    while(true){

                        System.out.print("ID: ");

                        id = input.nextInt();


                        if(memberService.findMemberById(id) == null){

                            break;

                        }


                        System.out.println("❌ Registration Denied: Member ID already exists.");

                    }



                    input.nextLine();


                    System.out.print("Name: ");
                    String name = input.nextLine();


                    System.out.print("Phone: ");
                    String phone = input.nextLine();


                    System.out.print("National ID: ");
                    String nationalId = input.nextLine();


                    System.out.print("Nationality: ");
                    String nationality = input.nextLine();



                    System.out.println("Select Equb Type:");
                    System.out.println("1. Student Equb");
                    System.out.println("2. Worker Equb");
                    System.out.println("3. Merchant Equb");


                    System.out.print("Choice: ");

                    int typeChoice = input.nextInt();



                    String equbType = "Student";
                    double limit = 100;



                    if(typeChoice == 2){

                        equbType = "Worker";

                    }

                    else if(typeChoice == 3){

                        equbType = "Merchant";
                        limit = 1000;

                    }



                    double initialDeposit;


                    while(true){

                        System.out.print("Initial Deposit (Minimum " + limit + "): ");

                        initialDeposit = input.nextDouble();


                        if(initialDeposit >= limit){

                            break;

                        }


                        System.out.println("Invalid amount.");

                    }




                    Member member = new Member(
                            id,
                            name,
                            phone,
                            initialDeposit,
                            false,
                            nationalId,
                            nationality
                    );


                    member.setEqubType(equbType);


                    memberService.addMember(member);

                    equb.addMember(member);

                    DBconnection.addMember(member);



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



                    memberService.updateMember(updateId, newPhone);


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


                    Member winner = equb.selectWinner();



                    if(winner != null){


                        double prize = equb.calculateTotal();


                        winner.setPrizeWon(prize);



                        System.out.println("\n===== WINNER RESULT =====");

                        System.out.println("Winner Name: " + winner.getName());

                        System.out.println("Member ID: " + winner.getId());

                        System.out.println("Total Pool Value Won: " + prize + " Birr");


                    }


                    else{


                        System.out.println("No eligible members left.");

                    }


                    break;





                case 7:


                    System.out.println(
                            "Total Contribution: " + equb.calculateTotal()
                    );


                    break;





                case 0:


                    System.out.println("Logout.");

                    break;




                default:


                    System.out.println("Invalid choice.");

            }



        } while(choice != 0);



    }






    public void memberMenu(int id){


        Member member = memberService.findMemberById(id);



        if(member != null){


            System.out.println("\n===== YOUR INFORMATION =====");

            System.out.println(member);



            if(member.isWinner()){


                System.out.println("🎉 Congratulations! You won.");

                System.out.println("Total Received: "
                        + member.getPrizeWon()
                        + " Birr");


            }

            else{


                System.out.println("You did not win this round.");


            }



        }


        else{


            System.out.println("Member not found.");


        }



    }



}