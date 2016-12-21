
import java.util.ArrayList;
import java.util.Scanner;


public class MCQ_Game implements GAME{

    String game_name="",game_desc="",game_subject="",question="",choice1="",choice2=""
            ,choice3="",choice4="",correct_answer="";
    int game_ID,numOfQues,answer,game_score = 0;
    static ArrayList <ArrayList<MCQ_Game>> total_mcq_arr = new ArrayList<>();

    
    @Override
    public void upload_game() {
    
        ArrayList<MCQ_Game> mcq_arr = new ArrayList<>();
        TrueFalse_Game mcq_g = new TrueFalse_Game();
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the game name : ");
        mcq_g.game_name = cin.nextLine();
        System.out.println("description : ");
        mcq_g.game_desc = cin.nextLine();
        System.out.println("Subject : ");
        mcq_g.game_subject = cin.nextLine();
        System.out.println("How many question would you like to add ?");
        numOfQues = cin.nextInt();
        cin.nextLine();
        for (int i=0 ; i<numOfQues ;i++)
        {
            MCQ_Game mcq2_g2 = new MCQ_Game();
            mcq2_g2.game_name = mcq_g.game_name;
            mcq2_g2.game_desc = mcq_g.game_desc;
            mcq2_g2.game_subject = mcq_g.game_subject;
            System.out.println("Enter the question # " + (i+1)+ " : ");
            mcq2_g2.question = cin.nextLine();
            System.out.println("Choice1 : ");
            mcq2_g2.choice1 = cin.nextLine();
            System.out.println("Choice2 : ");
            mcq2_g2.choice2 = cin.nextLine();
            System.out.println("Choice3 : ");
            mcq2_g2.choice3 = cin.nextLine();
            System.out.println("Choice4 : ");
            mcq2_g2.choice4 = cin.nextLine();
            System.out.println("The correct answer is : ");
            mcq2_g2.correct_answer = cin.nextLine();
            mcq2_g2.game_ID = total_mcq_arr.size();
            mcq_arr.add(mcq2_g2);
        }
        total_mcq_arr.add(mcq_arr);
        
        
        /*System.out.println("\n");
        for (int i = 0 ; i<total_mcq_arr.size() ;i++ )
        {
          for (int j = 0 ;j<total_mcq_arr.get(i).size() ;j++)
          {
              System.out.println(total_mcq_arr.get(i).get(j).game_name + "\n" +
                      total_mcq_arr.get(i).get(j).game_ID + "\n" +
                      total_mcq_arr.get(i).get(j).game_desc + "\n" +
                      total_mcq_arr.get(i).get(j).game_subject + "\n" +
                      total_mcq_arr.get(i).get(j).question + "\n" +
                      total_mcq_arr.get(i).get(j).choice1 + "\n" +
                      total_mcq_arr.get(i).get(j).choice2 + "\n" +
                      total_mcq_arr.get(i).get(j).choice3 + "\n" +
                      total_mcq_arr.get(i).get(j).choice4 + "\n" +
                      total_mcq_arr.get(i).get(j).correct_answer + "\n" );
          }
        }*/
        
    }
    
    @Override
    public int play_game(String game_name) {
        
        Scanner cin = new Scanner(System.in);
        String comp = "";
        for (int i = 0 ; i<total_mcq_arr.size() ;i++ )
        {
          for (int j = 0 ;j<total_mcq_arr.get(i).size() ;j++)
          {
              if (game_name.toUpperCase().equals(total_mcq_arr.get(i).get(j).game_name.toUpperCase()))
              {
                  System.out.println(total_mcq_arr.get(i).get(j).question);
                  System.out.println("1." +total_mcq_arr.get(i).get(j).choice1 + "    "
                  + "2." +total_mcq_arr.get(i).get(j).choice2 + "    " 
                  + "3." +total_mcq_arr.get(i).get(j).choice3 + "    " 
                  + "4." +total_mcq_arr.get(i).get(j).choice4);
                  System.out.println("Enter your choice number : ");
                  answer = cin.nextInt();
                  if (answer == 1)
                  {
                      comp = total_mcq_arr.get(i).get(j).choice1 ;
                  }
                  else if (answer == 2){
                      comp = total_mcq_arr.get(i).get(j).choice2 ;
                  }
                  else if (answer == 3){
                      comp = total_mcq_arr.get(i).get(j).choice3 ;
                  }
                  else if (answer == 4){
                      comp = total_mcq_arr.get(i).get(j).choice4 ;
                  }
                  else {System.out.println("Enter a valid choice.");}
                  if (comp.equals(total_mcq_arr.get(i).get(j).correct_answer))
                  {
                      game_score++;
                  }
                  
              }
          }
        }
        System.out.println("Your score : " + game_score);
        return game_score;
    }
    
    @Override
    public ArrayList get_games_arr() {
    return total_mcq_arr ;
    }
    
    @Override
    public void update_game (String game_name)
    {
        Scanner cin = new Scanner(System.in);
        int index = -1;
        for (int i = 0; i < total_mcq_arr.size(); i++) {
            for (int j = 0; j < total_mcq_arr.get(i).size(); j++) {
                if (game_name.toUpperCase().equals(total_mcq_arr.get(i).get(0).game_name.toUpperCase())) {
                    index = i;
                    System.out.println("Your current game has : ");
                    System.out.println("1.Name : " + total_mcq_arr.get(i).get(j).game_name);
                    System.out.println("2.descrirption : " + total_mcq_arr.get(i).get(j).game_desc);
                    System.out.println("3.Subject : " + total_mcq_arr.get(i).get(j).game_subject);
                    for (int y = 0; y < total_mcq_arr.get(i).size(); y++) {
                        System.out.println("4.question #" + (y+1) + " : " + total_mcq_arr.get(i).get(j).question);
                        System.out.println("Choice #1 : " + total_mcq_arr.get(i).get(j).choice1);
                        System.out.println("Choice #2 : " + total_mcq_arr.get(i).get(j).choice2);
                        System.out.println("Choice #3 : " + total_mcq_arr.get(i).get(j).choice3);
                        System.out.println("Choice #4 : " + total_mcq_arr.get(i).get(j).choice4);
                        System.out.println("corret answer : " + total_mcq_arr.get(i).get(j).correct_answer);
                    }
                    break;
                }
            }
        }
        int choice = -1;
        while (choice != 2) {
            System.out.println("IF you want to upate the game name press 1 ,description press 2 ,"
                    + "subject pres 3 ,question press 4 : ");
            choice = cin.nextInt();
            MCQ_Game mcq = new MCQ_Game();
            cin.nextLine();
            if (choice == 1) {
                System.out.println("Enter the new name : ");
                mcq.game_name = cin.nextLine();
            } else if (choice == 2) {
                System.out.println("Enter the description : ");
                mcq.game_desc = cin.nextLine();
            } else if (choice == 3) {
                System.out.println("Enter the subject : ");
                mcq.game_subject = cin.nextLine();
            } else if (choice == 4) {
                System.out.println("Enter the question number : ");
                choice = cin.nextInt();
                cin.nextLine();
                System.out.println("Enter the new question : ");
                mcq.question = cin.nextLine();
                System.out.println("Enter the choice #1 : ");
                mcq.choice1 = cin.nextLine();
                System.out.println("Enter the choice #2 : ");
                mcq.choice2 = cin.nextLine();
                System.out.println("Enter the choice #3 : ");
                mcq.choice3 = cin.nextLine();
                System.out.println("Enter the choice #4 : ");
                mcq.choice4 = cin.nextLine();
                System.out.println("Enter the correct answer : ");
                mcq.correct_answer = cin.nextLine();
            }
            for (int i = 0; i < total_mcq_arr.get(index).size(); i++) {
                if (!mcq.game_name.equals("")) {
                    total_mcq_arr.get(index).get(i).game_name = mcq.game_name;
                }
                if (!mcq.game_desc.equals("")) {
                    total_mcq_arr.get(index).get(i).game_desc = mcq.game_desc;
                }
                if (!mcq.game_subject.equals("")) {
                    total_mcq_arr.get(index).get(i).game_subject = mcq.game_subject;
                }
                if (!mcq.question.equals("")) {
                    total_mcq_arr.get(index).get(choice-1).question = mcq.question;
                    total_mcq_arr.get(index).get(choice-1).choice1 = mcq.choice1;
                    total_mcq_arr.get(index).get(choice-1).choice2 = mcq.choice2;
                    total_mcq_arr.get(index).get(choice-1).choice3 = mcq.choice3;
                    total_mcq_arr.get(index).get(choice-1).choice4 = mcq.choice4;
                    total_mcq_arr.get(index).get(choice-1).correct_answer = mcq.correct_answer;
                }
            }
            System.out.println("If you still need to update press 1 , Done press 2");
            choice = cin.nextInt();
            cin.nextLine();

        }
    }
    
    
    @Override
    public void delete_game(String game_name) {
        for (int i = 0; i < total_mcq_arr.size(); i++) {
            if (game_name.toUpperCase().equals(total_mcq_arr.get(i).get(0).game_name.toUpperCase())) {
                total_mcq_arr.remove(i);
            }
        }

    }

}
