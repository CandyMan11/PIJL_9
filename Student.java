package Assignment_9;

public class Student 
{
    private String prn;
    private String name;
    private String dob;
    private float marks;

    //constructor
    public Student(String prn, String name, String dob, float marks){
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    //getters 
    public String getPrn(){ 
        return prn; 
    }

    public String getName(){ 
        return name; 
    }

    public String getDob(){ 
        return dob; 
    }

    public float getMarks(){ 
        return marks; 
    }

    //setters
    public void setName(String name){ 
        this.name = name; 
    }

    public void setDob(String dob){ 
        this.dob = dob; 
    }

    public void setMarks(float marks){
        this.marks = marks; 
    }

    //display method
    public void display(){
        System.out.println("PRN: " + prn + ", Name: " + name + ", DoB: " + dob + ", Marks: " + marks);
    }
}
