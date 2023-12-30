/**
 * Poject goal -> Choose better driver and Compare both F1 and normal driver
 * 
 * Author: AL AMIN
 * 
 **/
import java.util.Scanner;

abstract class Driver {
    String driver_name;
    int driver_age;
    int driver_experience;
    String driving_route;
    private boolean police_panalties;
    boolean getPanalties(){
        return police_panalties;
    }
    Driver() {
    }

    Driver(String driver_name, int driver_age, int driver_experience, String driving_route, boolean police_panalties) {
        this.driver_name = driver_name;
        this.driver_age = driver_age;
        this.driver_experience = driver_experience;
        this.driving_route = driving_route;
        this.police_panalties = police_panalties;
    }
    
    abstract void finding_better_driver(Driver obj[]);
    abstract void finding_better_driver(Driver obj[], Driver obj1[]);

    
    void showing_details_driver(Driver select) {
        System.out.println("Driver name is = " + select.driver_name);
        System.out.println("Driver age is = " + select.driver_age);
        System.out.println("Driver driver experience is = " + select.driver_experience);
        System.out.println("Driver driving route is = " + select.driving_route);
        if (select.police_panalties) {
            System.out.println("This driver have police panalties");
        } else {
            System.out.println("This drive don't have any police panalties");
        }
    }

}

class choosing_driver extends Driver {
    choosing_driver() {

    }

    choosing_driver(String driver_name, int driver_age, int driver_experience, String driving_route,
            boolean police_panalties) {
        super(driver_name, driver_age, driver_experience, driving_route, police_panalties);
    }

    void finding_better_driver(Driver obj[]) {
        int max_exp =-1;
        for (int i = 0; i < obj.length; i++) {
            if ((obj[i].driver_experience >= max_exp) && (!obj[i].getPanalties())) {
                max_exp = i;
            }
        }
        if (max_exp == -1) {
            System.out.println("You must give opportunity for driver");
            return ;
        }
        System.out.println("\n----------WE HAVE FIND BETTER DRIVER------------------\n");
        System.out.println("So " + (max_exp + 1) + "th driver don't have any police panalties and have max experience");
        showing_details_driver(obj[max_exp]);
    }
   void finding_better_driver(Driver obj[], Driver obj1[]) {
        int index_f1 = 0, index_driv = 0;
        int x = obj.length;
        int max_f1 = -1;
        int max_driver = -1;
        for (int i = 0; i < x; i++) {
            if (obj[i].getPanalties() && obj[i].driver_experience >= max_f1) {
                index_f1 = i;
                max_f1 = obj[i].driver_experience;
            }
            if (obj1[i].getPanalties()  && obj1[i].driver_experience >= max_driver) {
                index_driv = i;
                max_driver = obj1[i].driver_experience;
            }
        }
        System.out.println("The "+(index_driv+1)+" th driver has qualification");
        System.out.println("The "+(index_f1+1)+" th f1 driver has qualification");
        if(max_driver>max_f1){
            System.out.println("\nThis normal Driver can be suitable\n");
            showing_details_driver(obj1[index_driv]);
        }
        else{
            System.out.println("\n This f1 driver have qualification \n");
            showing_details_driver(obj[index_f1]);
        }

    }
}

class F1_driver extends choosing_driver {
    private int height;
    F1_driver() {
    }

    F1_driver(String driver_name, int driver_age, int driver_experience, String driving_route,
            boolean police_panalties) {
        super(driver_name, driver_age, driver_experience, driving_route, police_panalties);
    }
    void setHeight(int x){
        height=x;
    }
    int getHeight(){
        return height;
    }
}

class Choose_better_Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Driver do you want to take as candidates");
        int x = sc.nextInt();
        choosing_driver[] o1 = new choosing_driver[x];
        String driver_name;
        int driver_age;
        int driver_experience;
        String driving_route;
        boolean police_panalties;
        for (int i = 0; i < x; i++) {
            System.out.println("Enter Diver name");
            driver_name = sc.next();
            System.out.println("Enter Driver age");
            driver_age = sc.nextInt();
            System.out.println("Enter driver-experience");
            driver_experience = sc.nextInt();
            System.out.println("Enter driver route");
            driving_route = sc.next();
            System.out.println("Is there any police panalties. If yes press y else n");
            char ch = sc.next().charAt(0);
            if (ch == 'y') {
                police_panalties = true;
            } else {
                police_panalties = false;
            }
            choosing_driver o2 = new choosing_driver(driver_name, driver_age, driver_experience, driving_route,
                    police_panalties);
            o1[i] = o2;
        }
        choosing_driver o3 = new choosing_driver();
        o3.finding_better_driver(o1);
        System.out.println("Do you want to choose f1 drivers. If yes press y else n");
        char ch=sc.next().charAt(0);
        if(ch=='y'){
            F1_driver obj3[]=new F1_driver[x];
            for (int i = 0; i < x; i++) {
            System.out.println("Enter Diver name");
            driver_name = sc.next();
            System.out.println("Enter Driver age");
            driver_age = sc.nextInt();
            System.out.println("Enter driver-experience");
            driver_experience = sc.nextInt();
            System.out.println("Enter driver route");
            driving_route = sc.next();
            System.out.println("Is there any police panalties. If yes press y else n");
            char cha = sc.next().charAt(0);
            if (ch == 'y') {
                police_panalties = true;
            } else {
                police_panalties = false;
            }
            F1_driver o4 = new F1_driver(driver_name, driver_age, driver_experience, driving_route,
                    police_panalties);
            obj3[i] = o4;
        }
        F1_driver obj5=new F1_driver();
        obj5.finding_better_driver(obj3,o1);
        }
    }
}