//import javax.xml.crypto.Data;
import javafx.scene.chart.PieChart.Data;


public class Prof extends User {
	String Academic_year;
	String PHP;
	public Prof(String name, int ID, String password, String BD, String email,String authoruty,String Gnder,String academicYear,String php) {
		super(name, ID, password, BD, email, authoruty,Gnder);
		PHP=php;
		Academic_year=academicYear;
		// TODO Auto-generated constructor stub
	}
	public Prof(){
		this.Academic_year="";
		this.PHP="";
	}

}
