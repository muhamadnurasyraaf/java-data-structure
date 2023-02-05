public class Registered extends Customer{
    private String appoinmentDate;
    private int registrationId;

    public Registered(){
        super();
        appoinmentDate = "";
        registrationId = 0;
    }

    public Registered(String ic,String pNo,String g,int age,String add,String name,String d,boolean ins,boolean reg,String appDate,int rId){
        super(ic, pNo, g, age, add, name, d, ins,reg);
        appoinmentDate = appDate;
        registrationId =rId;
    }
    public void setAppDate(String newAppDate)
    {
        appoinmentDate = newAppDate;
    }

    public String getAppoinmentDate(){return appoinmentDate;}
    public int getRegistrationId(){return registrationId;}



    public double calcBill(){
        double total;
        double tax = (150 * 6) /100;
        if(super.getInsurance()){
            total = 0;
        }
        else{
            total = 150 + tax;
        }
        return total;
    }

    public String toString(){
        return super.toString() + 
        "\nAppoinment Date\t: " + appoinmentDate +
        "\nRegistration Id : " + registrationId +
        //"\nTotal Bill(incld taxes) : RM" + calcBill()+ 
        "\n";
    }
}
