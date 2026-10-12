package p1;

import java.util.Arrays;
import java.util.function.Predicate;

public class Demo {
    public static void main(String[] args) {
        StudentBag bag = new StudentBag(10);
        Student s1 = new Student("M", 3.0);
        Student s2 = new Student("B", 2.0);
        Student s3 = new Student("N", 5.0);
        Student s4 = new Student("D", 8.0);
        Student s5 = new Student("E", 1.0);
        Student s6 = new Student("G", 2.0);

        bag.add(s1);
        bag.add(s2);
        bag.add(s3);
        bag.add(s4);
        bag.add(s5);
        bag.add(s6);
        bag.display();
        System.out.println();
       // Student[] a1 = bag.searchByName("K");
        Student[]a1 = bag.search(s -> s.getName().compareTo("K")>= 0 && s.getGpa()>= 2.5);


        System.out.println(Arrays.toString(a1));

        System.out.println();
        //Student[] a2 = bag.searchByGPA(2.5); //bag of students with gpa over 2.5
        Student[]a2 = bag.search(s->s.getGpa()>=2.5); //using a lambda
        //equivalent to
        //Student[] a3 = bag.search(new Predicate<Student>()); //predicate is an interface andthus has no constructor
        //use anon class
        Student[] a3 = bag.search(new Predicate<Student>(){
            public boolean test(Student t){
                return t.getGpa() >= 3.0;
            }
        });
        Student[] a4 = bag.search(t->t.getGpa()>=3.0);//if using lmabda, ensure interface(?) has only 1 method thats abstract


        System.out.println(Arrays.toString(a1));
    }



}
