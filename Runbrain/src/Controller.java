
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    User user1 = new User();
    String Game_type, Game_subject;
    static ArrayList<Student> userData_arr = new ArrayList<>();
    static ArrayList<Prof> userData_arr2 = new ArrayList<>();
    GAME mcq_game = new MCQ_Game();
    GAME tf_game = new TrueFalse_Game();
    ArrayList<ArrayList<TrueFalse_Game>> total_tf_arr = new ArrayList<>();
    ArrayList<ArrayList<MCQ_Game>> total_mcq_arr = new ArrayList<>();

    void list_games(String Game_subject) {

        total_mcq_arr = mcq_game.get_games_arr();
        total_tf_arr = tf_game.get_games_arr();

        for (int t = 0; t < total_mcq_arr.size(); t++) {
            if (Game_subject.toUpperCase().equals(total_mcq_arr.get(t).get(0).game_subject.toUpperCase())) {

                System.out.println(total_mcq_arr.get(t).get(0).game_name + "     : MCQ game");
            }

        }
        for (int t = 0; t < total_tf_arr.size(); t++) {
            if (Game_subject.toUpperCase().equals(total_tf_arr.get(t).get(0).game_subject.toUpperCase())) {

                System.out.println(total_tf_arr.get(t).get(0).game_name + "      : True/False game ");
            }
        }

    }

    String check_authority(String user_name, String pass) {
        String auth = "null";
        
        for (int t = 0; t < userData_arr.size(); t++) {
            if (user_name == userData_arr.get(t).User_name && pass == userData_arr.get(t).getPassword()) {
                auth = userData_arr.get(t).Authoruty;
                return auth;

            }
        }for (int t = 0; t < userData_arr2.size(); t++) {
            if (user_name.equals( userData_arr2.get(t).User_name) && pass.equals(userData_arr2.get(t).getPassword())) {
                auth = userData_arr2.get(t).Authoruty;
                return auth;
            }
        }
        
        return auth;
    }

    void choose_game() {

        total_mcq_arr = mcq_game.get_games_arr();
        total_tf_arr = tf_game.get_games_arr();
        Scanner cin = new Scanner(System.in);

        String game_name;

        System.out.println("for MCQ enter 1 ,");
        System.out.println("for True/False enter 2 : ");

        Game_type = cin.nextLine();
        System.out.println("Enter the game name : ");
        game_name = cin.nextLine();
        int index = -1;
        if ("1".equals(Game_type)) {

            for (int t = 0; t < total_mcq_arr.size(); t++) {
                if (game_name.toUpperCase().equals(total_mcq_arr.get(t).get(0).game_name.toUpperCase())) {
                    index = t;

                }

            }
            if (index != -1) {
                mcq_game.play_game(game_name);

            }
        }

        if ("2".equals(Game_type)) {
            for (int t = 0; t < total_tf_arr.size(); t++) {
                if (game_name.toUpperCase().equals(total_tf_arr.get(t).get(0).game_name.toUpperCase())) {
                    index = t;

                }

            }
            if (index != -1) {
                tf_game.play_game(game_name);

            }
        }

    }

    boolean check_Email(String Email) {
        int c = 0;
        for (int i = 0; i < userData_arr.size(); i++) {

            if (Email == userData_arr.get(i).Email) {
                c++;

            }

        }
        if (c == 0) {
            return true;
        } else {
            return false;
        }
    }

    void Registeration(String user_name, String password, String birth_date, String gender, String Email, String authority) {

        if ("prof".equals(authority)) {
            String phd, Academic_year;

            Prof Prof = new Prof();
            //object from user 
            Prof.User_name = user_name;
            Prof.setPassword(password);
            Prof.BrithData = birth_date;
            Prof.Gender = gender;
            Prof.Email = Email;
            Prof.Authoruty = authority;
            Scanner cin = new Scanner(System.in);
            System.out.println("Enter phd : ");
            phd = cin.nextLine();
            System.out.println("Enter acadimic year : ");
            Academic_year = cin.nextLine();
            Prof.Academic_year = Academic_year;
            Prof.PHP = phd;

            while (true) {
                boolean o = check_Email(Email);
                if (o == true) {
                    userData_arr2.add(Prof);
                    break;
                } else {

                    System.out.println("used Email ,");
                    System.out.println("Enter new E-mail : ");
                    Prof.Email = cin.nextLine();

                }

            }
        }
        if ("student".equals(authority)) {
            String year_level;
            String Department;
            float GPA;

            Student s = new Student();
            //object from user 
            s.User_name = user_name;
            s.setPassword(password);
            s.BrithData = birth_date;
            s.Gender = gender;
            s.Email = Email;
            s.Authoruty = authority;
            Scanner cin = new Scanner(System.in);
            System.out.println("Enter level : ");
            year_level = cin.nextLine();
            System.out.println("Enter DEP : ");
            Department = cin.nextLine();
            System.out.println("Enter GPA : ");
            GPA = cin.nextFloat();
            s.year_level = year_level;
            s.GPA = GPA;
            s.Department = Department;

            while (true) {
                boolean o = check_Email(Email);
                if (o == true) {
                    userData_arr.add(s);
                    break;
                } else {

                    System.out.println("used Email ,");
                    System.out.println("Enter nw E-mail : ");
                    s.Email = cin.nextLine();

                }

            }
        }
    }

    boolean check_signIn(String name, String password, String authority) {
        int c = 0;
        if (authority.equals("student")) {
            for (int i = 0; i < userData_arr.size(); i++) {

                if (name.equals(userData_arr.get(i).User_name) && password.equals(userData_arr.get(i).getPassword())) {
                    c++;
                    System.out.println("you signed in succefully");
                    return true;
                }
            }
        }
           else if (authority.equals("prof")) {
                for (int i = 0; i < userData_arr2.size(); i++) {

                    if (name.equals(userData_arr2.get(i).User_name) && password.equals(userData_arr2.get(i).getPassword())) {
                        c++;
                        System.out.println("you signed in succefully");
                        return true;
                    }
                }
            }
            if (c == 0)
            {
                System.out.println("Invalid user name or password");
                return false;
            }
            else {
                return true;
            }
    }

    Controller() {
        Game_type = "";
        Game_subject = "";
    }

    Controller(String Game_type, String Game_subject) {
        this.Game_type = Game_type;
        this.Game_subject = Game_subject;

    }

    public ArrayList get_user_arr1() 
    {
        return userData_arr;
    }
 public ArrayList get_user_arr2() 
    {
        return userData_arr2;
    }

}
