
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        String user_name = "", password = "", birth_date = "", gender = "",
                Email = "", authority = "", game_name = "", subject = "";
        boolean validation;
        int choice = -1;

        while (choice != 2) {

            Prof pr = new Prof();
            Student s = new Student();
            GAME tf = new TrueFalse_Game();
            GAME mcq = new MCQ_Game();
            Controller cont = new Controller();

            Scanner cin = new Scanner(System.in);
            System.out.println("If you want to sign up press 1 , sign in press 2 : ");
            choice = cin.nextInt();
            cin.nextLine();
            if (choice == 2) {
                System.out.println("Enter your name : ");
                user_name = cin.nextLine();
                System.out.println("Password : ");
                password = cin.nextLine();
                authority = cont.check_authority(user_name, password);
                validation = cont.check_signIn(user_name, password, authority);
                while (validation == false) {
                    System.out.println("Enter your name : ");
                    user_name = cin.nextLine();
                    System.out.println("Password : ");
                    password = cin.nextLine();
                    authority = cont.check_authority(user_name, password);
                   validation = cont.check_signIn(user_name, password, authority);
                }
                
            } else if (choice == 1) {
                System.out.println("Enter your name : ");
                user_name = cin.nextLine();
                System.out.println("Password : ");
                password = cin.nextLine();
                System.out.println("Birth date : ");
                birth_date = cin.nextLine();
                System.out.println("Gender : ");
                gender = cin.nextLine();
                System.out.println("E-mail : ");
                Email = cin.nextLine();
                System.out.println("Enter your authority (prof or student) : ");
                authority = cin.nextLine();
                cont.Registeration(user_name, password, birth_date, gender, Email, authority);

            }

            if (authority.equals("student")) {
                System.out.println("If you want to list all games press 1 , Choose game press 2 ,skip press 3 , update user data press 0: ");
                choice = cin.nextInt();
                cin.nextLine();
                if (choice == 1) {
                    System.out.println("Enter the game subject : ");
                    subject = cin.nextLine();
                    cont.list_games(subject);
                }
                if (choice == 1 || choice == 2) {
                    cont.choose_game();
                }
if(choice==0){

DB db =new DB();
db.Updata_Userdata();
}
            }
            if (authority.equals("prof")) {
                System.out.println("If you want to list all games press 1 , Choose game press 2 "
                        + ",uploade game press 3 , update game press 4 , delete game 5 ,update your data press 0 : ");
                choice = cin.nextInt();
                if (choice == 1) {
                    System.out.println("Enter the game subject : ");
                    subject = cin.nextLine();
                    cont.list_games(subject);
                } else if (choice == 2) {
                    cont.choose_game();
                } else if (choice == 3) {
                    System.out.println("for MCQ game press 1 , true/false press 2 : ");
                    choice = cin.nextInt();
                    cin.nextLine();
                    if (choice == 1) {
                        mcq.upload_game();
                    } else if (choice == 2) {
                        tf.upload_game();
                    }
                } else if (choice == 4) {
                    System.out.println("for MCQ game press 1 , true/false press 2 : ");
                    choice = cin.nextInt();
                    cin.nextLine();
                    System.out.println("Enter the game name you wish to update : ");
                    game_name = cin.nextLine();
                    if (choice == 1) {
                        mcq.update_game(game_name);
                    } else if (choice == 2) {
                        tf.update_game(game_name);
                    }
                } else if (choice == 5) {
                    System.out.println("for MCQ game press 1 , true/false press 2 : ");
                    choice = cin.nextInt();
                    cin.nextLine();
                    System.out.println("Enter the game name you wish to delete : ");
                    game_name = cin.nextLine();
                    if (choice == 1) {
                        mcq.delete_game(game_name);
                    } else if (choice == 2) {
                        tf.delete_game(game_name);
                    }

                    
                }
                if(choice==0){

DB db =new DB();
db.Updata_Userdata();
}
            }
            System.out.println("If you want to sign out press 1 , Quit press 2 : ");
            choice = cin.nextInt();
            cin.nextLine();
        }
    }

}
