import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
class Student{
	private int stuId;
	private String stuName;
	private String stuCourse;
	private double stuFee;
	private char stuGen;

	Student(int stuId,String stuName, String stuCourse, double stuFee, char stuGen){
		this.stuId=stuId;
		this.stuName=stuName;
		this.stuCourse=stuCourse;
		this.stuFee=stuFee;
		this.stuGen=stuGen;
	}

	public void setStuId(int stuId){
		this.stuId=stuId;
	}
	public int getStuId(){
		return stuId;
	}
	public void setStuName(String stuName){
		this.stuName=stuName;
	}
	public String getStuName(){
		return stuName;
	}
	public void setStuCourse(String stuCourse){
		this.stuCourse=stuCourse;
	}
	public String getStuCourse(){
		return stuCourse;
	}
	public void setStuFee(double stuFee){
		this.stuFee=stuFee;
	}
	public double getStuFee(){
		return stuFee;
	}
	public void setStuGen(char stuGen){
		this.stuGen=stuGen;
	}
	public char getStuGen(){
		return stuGen;
	}

	public String toString(){
		return stuId+", "+stuName+", "+stuCourse+", "+stuFee+", "+stuGen;
	}
}
class StudentManagment{
	public static ArrayList<Student> li=new ArrayList<Student>();
	public static int addNewStudentInfo(Student student){
		li.add(student);
		return 1;
	}

	public static ArrayList<Student> displayStudentDetails(){
		return li;
	} 

	public static Student searchStudentInfoById(int stuId){
		for(int i=0; i<li.size(); i++){
			if(stuId==li.get(i).getStuId()){
				return li.get(i);
			}
		}
		return null;                                
	}

	public static boolean removeStudentInfoById(int stuId){
		for(int i=0; i<li.size(); i++){
			if(stuId==li.get(i).getStuId()){
				li.remove(i);
				return true;
			}
		}
		return false;
	}

	public static void updateStudentInfoById(int stuId){
		Scanner s=new Scanner(System.in);
		boolean found=false;
		for(int i=0; i<li.size(); i++){
			if(stuId==li.get(i).getStuId()){
				found=true;
				System.out.print("\n1. Update total student information\n2. Update particular field only\n\nEnter your choice: ");
				int choice=s.nextInt();
				if(choice==1){
					System.out.print("\nEnter new Id: ");
					li.get(i).setStuId(s.nextInt());
					s.nextLine();
					System.out.print("Enter new Name: ");
					li.get(i).setStuName(s.nextLine());
					System.out.print("Enter new Course: ");
					li.get(i).setStuCourse(s.nextLine());
					System.out.print("Enter new Fee: ");
					li.get(i).setStuFee(s.nextDouble());
					s.nextLine();
					System.out.print("Enter new Gender: ");
					li.get(i).setStuGen(s.nextLine().charAt(0));
					System.out.println("\nStudent information updated successfully");
					break;
				}else if(choice==2){
					System.out.print("\n1. Update student Id\n2. Update student Name\n3. Update student Course\n4. Update student course fee\n5. Update student Gender\n\nEnter your choice: ");
					int choice2=s.nextInt();
					s.nextLine();
					if(choice2==1){
						System.out.print("\nEnter new Id: ");
						li.get(i).setStuId(s.nextInt());
						s.nextLine();
						System.out.println("\nStudent id updated successfully");
						break;
					}else if(choice2==2){
						System.out.print("Enter new Name: ");
						li.get(i).setStuName(s.nextLine());
						System.out.println("\nStudent name updated successfully");
						break;
					}else if(choice2==3){
						System.out.print("Enter new Course: ");
						li.get(i).setStuCourse(s.nextLine());
						System.out.println("\nStudent course updated successfully");
						break;
					}else if(choice2==4){
						System.out.print("Enter new Fee: ");
						li.get(i).setStuFee(s.nextDouble());
						s.nextLine();
						System.out.println("\nStudent course fee updated successfully");
						break;
					}else if(choice2==5){
						System.out.print("Enter new Gender: ");
						li.get(i).setStuGen(s.nextLine().charAt(0));
						System.out.println("\nStudent gender updated successfully");
						break;	
					}else{
						System.out.println("\nInvalid choice");
					}
				}else{
					System.out.println("\nInvalid choice");
					break;
				}

			}
		}
		if(found==false)
		System.out.println("\nId doesn't exist...!");
		
	}
}
class Main{
	public static void main(String[] args){
		java.util.Scanner s=new java.util.Scanner(System.in);
		ArrayList<Student> li=null;
		int choice;
		int stuId;
		String stuName;
		String stuCourse;
		double stuFee;
		char stuGen;
		System.out.println((char)3+" Student Managment Application "+(char)3);
		do{
			System.out.print("\n\n1. Enter new Student Details\n2. Display Student details\n3. Search student by Id\n4. Remove student by Id\n5. Update Student By Id\n\nEnter Your choice: ");		
			choice = s.nextInt();
			switch(choice){
			case 1:
				System.out.print("\nEnter new student Id: ");
				stuId=s.nextInt();
				s.nextLine();
				System.out.print("Enter new student Name: ");
				stuName=s.nextLine();
				System.out.print("Enter new student Course: ");
				stuCourse=s.nextLine();
				System.out.print("Enter new student course Fee: ");
				stuFee=s.nextDouble();
				s.nextLine();
				System.out.print("Enter new student Gender: ");
				stuGen=s.nextLine().charAt(0);

				Student student=new Student(stuId,stuName,stuCourse,stuFee,stuGen);
				int it=StudentManagment.addNewStudentInfo(student);

				if(it==1){
					System.out.println("\nStudent details added successfully...");
				}
				break;
			case 2:
				li=StudentManagment.displayStudentDetails();
				if(li.isEmpty()){
					System.out.println("\nDatabase is empty...");
				}else{
					Iterator itr=li.iterator();
					System.out.print("\nAll Students Information:\n");
					while(itr.hasNext()){
						System.out.print("\n"+itr.next());
					}
				}
				break;
			case 3:
				System.out.print("\nEnter student Id you want to search: ");
				stuId=s.nextInt();
				Student stu=StudentManagment.searchStudentInfoById(stuId);
				if(stu!=null){
					System.out.print("\nStudent Information: "+stu);
				}else{
					System.out.print("\nId "+stuId+" doesn't exist...!");
				}
				break;
			case 4:
				System.out.print("\nEnter student Id you want to remove: ");
				stuId=s.nextInt();
				boolean found=StudentManagment.removeStudentInfoById(stuId);
				if(found==true){
					System.out.println("\nStudent information deleted successfully");
				}else{
					System.out.println("\nId "+stuId+" doesn't exist...!");
				}
				break;
			case 5:
				System.out.print("\nEnter student Id you want to update: ");
				stuId=s.nextInt();
				StudentManagment.updateStudentInfoById(stuId);
				break;
				default:
					System.out.println("\nInvalid choice...!\nprocess can't be processed");
			}		
		}while(choice>=1 && choice<=5);
	}
}