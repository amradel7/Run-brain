
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Amr Adel
 */
public class TrueFalse_Game implements GAME {

    String game_name = "", game_desc = "", game_subject = "", question = "", answer = "", correct_answer = "";
    int game_ID, numOfQues, game_score = 0;
    static ArrayList<ArrayList<TrueFalse_Game>> total_tf_arr = new ArrayList<>();

    @Override
    public void upload_game() {

        ArrayList<TrueFalse_Game> tf_arr = new ArrayList<>();
        TrueFalse_Game tf_g = new TrueFalse_Game();
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the game name : ");
        tf_g.game_name = cin.nextLine();
        System.out.println("description : ");
        tf_g.game_desc = cin.nextLine();
        System.out.println("Subject : ");
        tf_g.game_subject = cin.nextLine();
        System.out.println("How many question would you like to add ?");
        numOfQues = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < numOfQues; i++) {
            TrueFalse_Game tf_g2 = new TrueFalse_Game();
            tf_g2.game_name = tf_g.game_name;
            tf_g2.game_desc = tf_g.game_desc;
            tf_g2.game_subject = tf_g.game_subject;
            System.out.println("Enter the question # " + (i + 1) + " : ");
            tf_g2.question = cin.nextLine();
            System.out.println("The correct answer is : ");
            tf_g2.correct_answer = cin.nextLine();
            tf_g2.game_ID = total_tf_arr.size();
            tf_arr.add(tf_g2);
        }
        total_tf_arr.add(tf_arr);

        /*System.out.println("\n");
         for (int i = 0 ; i<total_tf_arr.size() ;i++ )
         {
         for (int j = 0 ;j<total_tf_arr.get(i).size() ;j++)
         {
         System.out.println(total_tf_arr.get(i).get(j).game_name + "\n" +
         total_tf_arr.get(i).get(j).game_ID + "\n" +
         total_tf_arr.get(i).get(j).game_desc + "\n" +
         total_tf_arr.get(i).get(j).game_subject + "\n" +
         total_tf_arr.get(i).get(j).question + "\n" +
         total_tf_arr.get(i).get(j).correct_answer + "\n" );
         }
         }*/
    }

    @Override
    public int play_game(String game_name) {
        Scanner cin = new Scanner(System.in);
        for (int i = 0; i < total_tf_arr.size(); i++) {
            for (int j = 0; j < total_tf_arr.get(i).size(); j++) {
                if (game_name.toUpperCase().equals(total_tf_arr.get(i).get(j).game_name.toUpperCase())) {
                    System.out.println(total_tf_arr.get(i).get(j).question);
                    System.out.println("T or F : ");
                    answer = cin.nextLine();
                    if (answer.toUpperCase().equals(total_tf_arr.get(i).get(j).correct_answer.toUpperCase())) {
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
        return total_tf_arr;
    }

    @Override
    public void update_game(String game_name) {
        Scanner cin = new Scanner(System.in);
        int index = -1;
        for (int i = 0; i < total_tf_arr.size(); i++) {
            for (int j = 0; j < total_tf_arr.get(i).size(); j++) {
                if (game_name.toUpperCase().equals(total_tf_arr.get(i).get(0).game_name.toUpperCase())) {
                    index = i;
                    System.out.println("Your current game has : ");
                    System.out.println("1.Name : " + total_tf_arr.get(i).get(j).game_name);
                    System.out.println("2.descrirption : " + total_tf_arr.get(i).get(j).game_desc);
                    System.out.println("3.Subject : " + total_tf_arr.get(i).get(j).game_subject);
                    for (int y = 0; y < total_tf_arr.get(i).size(); y++) {
                        System.out.println("4.question #" + (y+1) + " : " + total_tf_arr.get(i).get(j).question);
                        System.out.println("corret answer : " + total_tf_arr.get(i).get(j).correct_answer);
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
            TrueFalse_Game tf = new TrueFalse_Game();
            cin.nextLine();
            if (choice == 1) {
                System.out.println("Enter the new name : ");
                tf.game_name = cin.nextLine();
            } else if (choice == 2) {
                System.out.println("Enter the description : ");
                tf.game_desc = cin.nextLine();
            } else if (choice == 3) {
                System.out.println("Enter the subject : ");
                tf.game_subject = cin.nextLine();
            } else if (choice == 4) {
                System.out.println("Enter the question number : ");
                choice = cin.nextInt();
                cin.nextLine();
                System.out.println("Enter the new question : ");
                tf.question = cin.nextLine();
                System.out.println("Enter the correct answer : ");
                tf.correct_answer = cin.nextLine();
            }
            for (int i = 0; i < total_tf_arr.get(index).size(); i++) {
                if (!tf.game_name.equals("")) {
                    total_tf_arr.get(index).get(i).game_name = tf.game_name;
                }
                if (!tf.game_desc.equals("")) {
                    total_tf_arr.get(index).get(i).game_desc = tf.game_desc;
                }
                if (!tf.game_subject.equals("")) {
                    total_tf_arr.get(index).get(i).game_subject = tf.game_subject;
                }
                if (!tf.question.equals("")) {
                    total_tf_arr.get(index).get(choice-1).question = tf.question;
                    total_tf_arr.get(index).get(choice-1).correct_answer = tf.correct_answer;
                }
            }
            System.out.println("If you still need to update press 1 , Done press 2");
            choice = cin.nextInt();
            cin.nextLine();

        }

    }

    @Override
    public void delete_game(String game_name) {
        for (int i = 0; i < total_tf_arr.size(); i++) {
            if (game_name.toUpperCase().equals(total_tf_arr.get(i).get(0).game_name.toUpperCase())) {
                total_tf_arr.remove(i);
            }
        }

    }
}
