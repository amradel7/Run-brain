
import javafx.scene.chart.PieChart.Data;


public class User {
    String User_name;
		int User_ID;
		private String Password;
		String BrithData;
		String Email;
		String Authoruty;
		String Gender;
		public User (String name,int  ID,String password,String BD, String email,String authoruty,String Gnder){
			User_name=name;
			User_ID=ID ;
			Password=password ;
			BrithData=BD;
			Email=email;
			Authoruty=authoruty;
                        Gender=Gnder;
		}
		public User(){
			this.User_name=null;
			this.User_ID=0;
			this.Password=null;
			this.BrithData="";
			this.Email=null;
			this.Authoruty=null;
		}
		public String getPassword() {
			return Password;
		}
		
		public void setPassword(String password) {
			this.Password = password;
		}
		
		

}
