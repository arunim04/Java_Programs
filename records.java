public class records {
    public static void main(String[] args){
        Student arunim=new Student(12,"Arunim",98);
        // arunim.rollno=10;
        // arunim.name="Arunim Sureka";
        // arunim.marks=90;
        System.out.println(arunim.rollno);
        System.out.println(arunim.name);
        System.out.println(arunim.marks); 
        Student random=new Student();  
        System.out.println(random.rollno); 
        System.out.println(random.name);
        System.out.println(random.marks);          
    }
}

class Student{
    int rollno;
    String name;
    float marks;

    Student(){
        this (15,"default person",70);
    }

    Student(Student other){
        this.rollno=other.rollno;
        this.name=other.name;
        this.marks=other.marks;
    }

    Student(int rollno,String name,float marks){
        this.rollno=rollno;
        this.name=name;
        this.marks=marks;
    }
}
