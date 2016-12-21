
import javafx.scene.chart.PieChart.Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amr Adel
 */
public class Student extends User{
    String year_level;
	String Department;
	float GPA;
	public Student(String name, int ID, String password, String BD, String email, String authoruty ,String Gnder,String yearLevel,String department,float gpa) {
		super(name, ID, password, BD, email, authoruty,Gnder);
		year_level=yearLevel ;
		GPA=gpa;
		Department=department;
		// TODO Auto-generated constructor stub
	}
	public Student(){
		this.GPA=0;
		this.Department=null;
		this.year_level=null;
		}

}
