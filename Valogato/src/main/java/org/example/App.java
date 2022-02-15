package org.example;

/**
 * Hello world!
 *
 */
public class App 
{

    private static void printGoodUniversityCitizen(PersonChecker[] citizens) {
        for (PersonChecker citizen : citizens) {
            if (citizen.isOk()) {
                System.out.println(citizen);
            }
        }
    }

    public static void main( String[] args )
    {
        PersonChecker[] citizens = new PersonChecker[6];
        citizens[0] = new Student("student 1", 22, 2,3.4F );
        citizens[1] = new Teacher("teacher 1", 45, 200);
        citizens[2] = new Student("student 2", 27, 0,4.4F );
        citizens[3] = new Student("student 3", 23, 2,2.4F );
        citizens[4] = new Teacher("student 2", 67, 20 );
        citizens[5] = new Student("student 4", 25, 2,4.1F );

        printGoodUniversityCitizen(citizens);
        
    }
}
