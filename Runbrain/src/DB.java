import java.util.ArrayList;
import java.util.Scanner;


public class DB {

	ArrayList<User> U_arr = new ArrayList();
	ArrayList<Student> SU_arr = new ArrayList(); 
	ArrayList<Prof> PU_arr = new ArrayList();
	ArrayList<MCQ_Game> total_mcq_arr = new ArrayList();
	public void Updata_Userdata(){
		Controller GH = new Controller();
		SU_arr=GH.get_user_arr1();
               	PU_arr=GH.get_user_arr2();
                
		
		String authoruty;
		String User_name="";
		String Password;
		String update;
		float updatef;
		int c=0;
		int k=0;
		int items=0;
		String FirstChar;
		System.out.println("you are Student Or Prof ?");
		Scanner n =new Scanner(System.in);
		authoruty=n.nextLine();
		System.out.println("Enter your user Name:");
		User_name=n.nextLine();
		if (authoruty.equals("student")){
		for(int i=0;i<SU_arr.size();i++){
			if (SU_arr.get(i).User_name.equals(User_name)){
				System.out.println("Enter your Password");
				Password =n.nextLine();
				if (SU_arr.get(i).getPassword().equals(Password)){
					System.out.println("How many items you need to update ?");
					items=n.nextInt();
					//System.out.println("Enter First Char in the items u want to update:");
					while (k!=items){
						System.out.println("Enter First Char in the items u want to update:");
						FirstChar=n.nextLine();
					

							if (FirstChar.equals("N")||FirstChar.equals("n")){
								System.out.println("Enter new UserName:");
								update=n.nextLine();
								SU_arr.get(i).User_name=update;
							}
							else if (FirstChar.equals("P")||FirstChar.equals("p")){
								System.out.println("Enter new Password:");
								update=n.nextLine();
								SU_arr.get(i).setPassword(update);
							}
							else if (FirstChar.equals("B")||FirstChar.equals("b")){
								System.out.println("Enter Your Birthdata:");
								update=n.nextLine();
								SU_arr.get(i).BrithData=update;
							}
							else if (FirstChar.equals("E")||FirstChar.equals("e")){
								System.out.println("Enter new Email:");
								update=n.nextLine();
								SU_arr.get(i).Email=update;
							}
							else if (FirstChar.equals("Y")||FirstChar.equals("y")){
								System.out.println("Enter your year level:");
								update=n.nextLine();
								SU_arr.get(i).year_level=update;
							}
							else if (FirstChar.equals("D")||FirstChar.equals("d")){
								System.out.println("Enter Your Department:");
								update=n.nextLine();
								SU_arr.get(i).Department=update;
							}
							else if (FirstChar.equals("G")||FirstChar.equals("g")){
								System.out.println("Enter Your GPA:");
								updatef=n.nextFloat();
								SU_arr.get(i).GPA=updatef;
							}
							else {
								System.out.println("ERROR!!");
								k--;
							}
							k++;
						}
				
				c++;
					}
				else {
					System.out.println("Your PassWord is Wrong!");
					c+=2;
				}
				}

			
			}}
		else if (authoruty.equals("prof")) {
			for(int i=0;i<PU_arr.size();i++){
				if (PU_arr.get(i).User_name.equals(User_name)){
					System.out.println("Enter your Password");
					Password =n.nextLine();
					if (PU_arr.get(i).getPassword().equals(Password)){
						System.out.println("How many items you need to update ?");
						items=n.nextInt();
						for(int item=0;item<items;item++){
							System.out.println("Enter First Char in the items u want to update:");
							FirstChar=n.nextLine();
							if (FirstChar.equals("N")||FirstChar.equals("n")){
								System.out.println("Enter new UserName:");
								update=n.nextLine();
								PU_arr.get(i).User_name=update;
							}
							else if (FirstChar.equals("P")||FirstChar.equals("p")){
								System.out.println("Enter new Password:");
								update=n.nextLine();
								PU_arr.get(i).setPassword(update);
							}
							else if (FirstChar.equals("B")||FirstChar.equals("b")){
								System.out.println("Enter Your Birthdata:");
								update=n.nextLine();
								PU_arr.get(i).BrithData=update;
							}
							else if (FirstChar.equals("E")||FirstChar.equals("e")){
								System.out.println("Enter new Email:");
								update=n.nextLine();
								PU_arr.get(i).Email=update;
							}
							else if (FirstChar.equals("D")||FirstChar.equals("d")){
								System.out.println("Enter Your Academic_year:");
								update=n.nextLine();
								PU_arr.get(i).Academic_year=update;
							}
							else if (FirstChar.equals("G")||FirstChar.equals("g")){
								System.out.println("Enter Your PHP:");
								update=n.nextLine();
								PU_arr.get(i).PHP=update;
							}
							else {
								System.out.println("ERROR!!");
								item--;
							}
							}
					c++;
						}
					else {
						System.out.println("Your PassWord is Wrong!");
					c+=2;
					}
					}
				
				}}
		if (c==0){
			System.out.println("UserName DOESN'T EXIST!");
		}
		else if (c==1){
			System.out.println("DONE!");
		
		}
		
	}
	
	
}
	
