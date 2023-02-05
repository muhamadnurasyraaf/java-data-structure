import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.StringTokenizer;
import java.io.*;

public class testApp2 {

    public static void main(String[] args){
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
                if(input == 'T'){
                    insurance = true;
                }
                else{
                    insurance = false;
                }
                input = st.nextToken().charAt(0);
                boolean registered;

                if(input == 'Y'){
                    registered = true;
                    /*cust = new Customer(ic,phone,gender,age,address,name,disease,insurance,registered);
                    custList.insertAtBack(cust);
                    */
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
                    //cust = new Customer(ic,phone,gender,age,address,name,disease,insurance,registered);
                    //custList.insertAtBack(cust);
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

        //Registered temp = (Registered)custList.getNext();
        /*System.out.print(temp);
        Customer temp2 = custList.getNext();
        System.out.print(temp2);
         */
        
        //NonRegistered p = (NonRegistered)r.dequeue();
        //System.out.print(r.toString());
        //int c = 0;
        /*while(!custList.isEmpty())
        {
            System.out.print("["+c+"]");
            System.out.println(temp.toString());
            temp = (Registered)custList.getNext();

            c++;
        }*/
        Queue temp1 = new Queue();
        while(!r.isEmpty())
        {
            NonRegistered n = (NonRegistered)r.dequeue();
            System.out.println(n.toString());
            temp1.enqueue(n);
        }
        Queue temp2 = new Queue();
        while(!q.isEmpty())
        {
            Registered re = (Registered)q.dequeue();
            System.out.println(re.toString());
            temp1.enqueue(re);
        }
    }
}