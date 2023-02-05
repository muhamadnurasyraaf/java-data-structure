import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;

public class testApp {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        Customer cust;
        Registered cust1;
        NonRegistered cust2;
        Random rand = new Random();
        LinkedList custList = new LinkedList();
        Queue q = new Queue();
        Queue r = new Queue();
        int count = 0;
        try {
            FileReader fr = new FileReader("custData.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line,";");
                String ic = st.nextToken();
                String phone = st.nextToken();
                String gender = st.nextToken();
                int age = Integer.parseInt(st.nextToken());
                String address = st.nextToken();
                String name  = st.nextToken();
                String disease = st.nextToken();
                char input = st.nextToken().charAt(0);
                boolean insurance;
                if(input == 'Y'){
                    insurance = true;
                }
                else{
                    insurance = false;
                }
                input = st.nextToken().charAt(0);
                boolean registered;

                if(input == 'Y'){
                    registered = true;
                    cust = new Customer(ic,phone,gender,age,address,name,disease,insurance,registered);
                    custList.insertAtBack(cust);
                    String appoinmentDate = st.nextToken();
                    int registrationId = Integer.parseInt(st.nextToken());
                    registrationId = 1 + rand.nextInt(100);
                    cust1 = new Registered(ic,phone,gender,age,address,name,disease,insurance,registered,appoinmentDate,registrationId); 
                    //char priority = st.nextToken().charAt(0);
                    q.enqueue(cust1);
                    /*if(priority == 'L'){
                    custList.insertAtBack(cust1);
                    }
                    else if(priority == 'H'){
                    custList.insertAtFront(cust1);
                    }*/
                }
                else{
                    registered = false;
                    cust = new Customer(ic,phone,gender,age,address,name,disease,insurance,registered);
                    custList.insertAtBack(cust);
                    String registerDate = st.nextToken();
                    char regInput = st.nextToken().charAt(0);
                    String regType;
                    if(regInput == 'O'){
                        regType = "Online";
                    }
                    else{
                        regType = "Walk In";
                    }
                    cust2 = new NonRegistered(ic,phone,gender,age,address,name,disease,insurance,registered,registerDate,regType);
                    //char priority = st.nextToken().charAt(0);
                    r.enqueue(cust2);
                    /*if(priority == 'L'){
                    custList.insertAtBack(cust2);
                    }
                    else if(priority == 'H'){
                    custList.insertAtFront(cust2);
                    }*/
                }

                count++;
            }
            br.close();
        } 
        catch(FileNotFoundException fnfe){
            System.out.print(fnfe.getMessage());
        }
        catch(IOException io){
            System.out.print(io.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print(count);

        /*System.out.print(temp);
        Customer temp2 = custList.getNext();
        System.out.print(temp2);
         */

        //System.out.print(t.toString());
        //NonRegistered p = (NonRegistered)r.dequeue();
        //System.out.print(p.toString());
        /*int c = 0;
        while(temp!=null)
        {
        System.out.print("["+c+"]");
        System.out.println(temp.toString());
        temp = custList.getNext();

        c++;
        }
        count =0;
        while(!q.isEmpty())
        {
        Registered re = (Registered)q.dequeue();
        System.out.println("["+count+"]\n"+re.toString());
        t.enqueue(re);
        count++;
        }
        count =0;
        while(!r.isEmpty())
        {
        NonRegistered nre = (NonRegistered)r.dequeue();
        System.out.println("["+count+"]\n"+nre.toString());
        t.enqueue(nre);
        count++;
        }
         */
        Customer cus;
        Queue t = new Queue();
        Queue t2 = new Queue();
        char option = ' ';
        int choose = 0;
        count = 0;
        System.out.println("Welcome to Dermatology clinic!!!");
        while(option != 'N')
        {
            System.out.println("Please choose one of these function to proceed :\n[1] - List all of the data of customer\n[2] - Searching a customer details\n[3] - Delete a customer appointment\n[4] - Update a customer appointment\n[5] - Add a new customer details\n[6] - Calculate payment for treatment");
            choose = sc.nextInt();
            if(choose == 1)
            {
                System.out.println("Please select which type of customer do you want to list out : \n[1]-Registered Customer\n[2]-Non Registered Customer\n[Any Keys]-Return");
                choose = sc.nextInt();
                if(choose == 1)
                {
                    System.out.print("The list of all registered customer");
                    while(!q.isEmpty())
                    {
                        Registered re = (Registered)q.dequeue();
                        System.out.println("["+count+"]\n"+re.toString());
                        t.enqueue(re);
                        count++;
                    }
                    while(!t.isEmpty())
                    {
                        Registered re = (Registered)t.dequeue();
                        q.enqueue(re);
                    }
                }
                else if(choose == 2)
                {
                    System.out.print("The list of all non registered customer");
                    while(!r.isEmpty())
                    {
                        NonRegistered nre = (NonRegistered)r.dequeue();
                        System.out.println("["+count+"]\n"+nre.toString());
                        t.enqueue(nre);
                        count++;
                    }
                    while(!t.isEmpty())
                    {
                        Registered nre = (Registered)t.dequeue();
                        r.enqueue(nre);
                    }
                }
                else
                    System.out.println("return");
            }
            else if(choose == 2)
            {
                System.out.println("Please insert the customer ic number :");
                String ic = sc.next();
                Customer temp = custList.getFirst();
                boolean found = false;
                while(temp!=null)
                {
                    if(temp.getNoIc().equals(ic))
                    {

                        System.out.print("The detail of customer("+ic+") is : "+temp.toString());
                        found = true;

                    }
                    //else
                    //System.out.print("The customer("+ic+")is not exist");
                    temp = custList.getNext();

                }
                if(!found)
                    System.out.print("The customer("+ic+")is not exist\n\n");
            }
            else if(choose == 3)
            {
                System.out.print("The list of all registered customer : ");
                while(!q.isEmpty())
                {
                    Registered re = (Registered)q.dequeue();
                    System.out.println("["+count+"]\n"+re.toString());
                    t.enqueue(re);

                }
                while(!t.isEmpty())
                {
                    Registered re = (Registered)t.dequeue();
                    q.enqueue(re);
                }
                System.out.println("Please enter the ic number of the customer you want to delete");
                String ic = sc.next();
                //Queue
                while(!q.isEmpty())
                {   Registered re = (Registered)q.dequeue();
                    if(re.getNoIc().equals(ic))
                    {
                        t2.enqueue(re);
                    }
                    else
                    {
                        t.enqueue(re);
                    }
                }
                while(!t.isEmpty())
                {
                    Registered re = (Registered)t.dequeue();
                    q.enqueue(re);
                }
                //Linkedlist
                LinkedList temp = new LinkedList();
                LinkedList temp2 = new LinkedList();
                while(!custList.isEmpty())
                {
                    cus = (Customer)custList.removeFront();
                    if(cus.getNoIc().equals(ic))
                        temp2.insertAtBack(cus);
                    else
                        temp.insertAtBack(cus);

                }
                System.out.println("The list of the registered customer after delete : ");
                while(!q.isEmpty())
                {
                    Registered re = (Registered)q.dequeue();
                    System.out.println("["+count+"]\n"+re.toString());
                    t.enqueue(re);

                }
                while(!t.isEmpty())
                {
                    Registered re = (Registered)t.dequeue();
                    q.enqueue(re);
                }
            }
            else if(choose == 4)
            {
                count = 0;
                System.out.println("Which type do you want to update [1]-Registered [2]-NonRegister");
                choose = sc.nextInt();

                if(choose == 1)
                {
                    boolean found = false;
                    //display
                    System.out.print("The list of all registered customer");
                    while(!q.isEmpty())
                    {
                        Registered re = (Registered)q.dequeue();
                        System.out.println("["+count+"]\n"+re.toString());
                        t.enqueue(re);

                    }
                    while(!t.isEmpty())
                    {
                        Registered re = (Registered)t.dequeue();
                        q.enqueue(re);
                    }
                    //process
                    System.out.println("Please insert the ic number of customer that you want to edit");
                    String ic = sc.next();
                    while(!q.isEmpty())
                    {
                        Registered re = (Registered)q.dequeue();
                        if(re.getNoIc().equals(ic))
                        {
                            System.out.println("Please insert the new Appointment date: ");
                            String newDate = sc.next();
                            re.setAppDate(newDate);
                            found = true;
                        }
                        t.enqueue(re);

                    }
                    if(!found)
                        System.out.println("The ic number of the customer is not exist");
                    while(!t.isEmpty())
                    {
                        Registered re = (Registered)t.dequeue();
                        q.enqueue(re);
                    }
                    //display after update
                    if(found)
                    {
                        System.out.print("The list of all registered customer after update");
                        while(!q.isEmpty())
                        {
                            Registered re = (Registered)q.dequeue();
                            System.out.println("["+count+"]\n"+re.toString());
                            t.enqueue(re);

                        }
                        while(!t.isEmpty())
                        {
                            Registered re = (Registered)t.dequeue();
                            q.enqueue(re);
                        }
                    }
                }
                else if(choose == 2)
                {
                    boolean found = false;
                    //display
                    System.out.print("The list of all non registered customer");
                    while(!r.isEmpty())
                    {
                        NonRegistered nre = (NonRegistered)r.dequeue();
                        System.out.println("["+count+"]\n"+nre.toString());
                        t.enqueue(nre);
                        count++;
                    }
                    while(!t.isEmpty())
                    {
                        NonRegistered nre = (NonRegistered)t.dequeue();
                        r.enqueue(nre);
                    }
                    //process
                    System.out.println("Please insert the ic number of customer that you want to edit");
                    String ic = sc.next();
                    while(!r.isEmpty())
                    {
                        NonRegistered nre = (NonRegistered)r.dequeue();
                        if(nre.getNoIc().equals(ic))
                        {
                            System.out.println("Please insert the new Appointment date: ");
                            String newDate = sc.next();
                            nre.setRegDate(newDate);
                            found = true;
                        }
                        t.enqueue(nre);

                    }
                    if(!found)
                        System.out.println("The ic number of the customer is not exist");
                    while(!t.isEmpty())
                    {
                        NonRegistered nre = (NonRegistered)r.dequeue();
                        r.enqueue(nre);
                    }
                    if(found)
                    {
                        System.out.print("The list of all non registered customer after update");
                        while(!r.isEmpty())
                        {
                            NonRegistered nre = (NonRegistered)r.dequeue();
                            System.out.println("["+count+"]\n"+nre.toString());
                            t.enqueue(nre);
                            count++;
                        }
                        while(!t.isEmpty())
                        {
                            NonRegistered nre = (NonRegistered)t.dequeue();
                            r.enqueue(nre);
                        }
                    }
                }
            }
        }                    

    }
}