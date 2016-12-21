
import java.util.ArrayList;


public interface GAME {
    
    void upload_game ( );
    
    int play_game(String game_name);

    ArrayList get_games_arr ();
    
    void update_game (String game_name);
    
    void delete_game (String game_name);
    
    
}
