public class NonRegistered extends Customer{
    private String registerDate;
    private String registrationType; //Online/Walkin

    public NonRegistered(){
        super();
        registerDate = null;
        registrationType = " ";
    }
    public NonRegistered(String ic,String pNo,String g,int age,String add,String name,String d,boolean ins,boolean reg,String rDate,String rType){
        super(ic, pNo, g, age, add, name, d, ins,reg);
        registerDate = rDate;
        registrationType = rType;
    }
    public void setRegDate(String newRegDate)
    {
        registerDate = newRegDate;
    }
    public String getRegistrationDate(){return registerDate;}
    public String getRegistrationType(){return registrationType;} 

    public double calcBill(){
        double total;
        double tax = (150 * 6) /100;
        double registrationFee = 20.00;
        if(super.getInsurance()){
            total = registrationFee;
        }
        else{
            total = 150 + tax;
        }
        return total;
    }

    public String toString(){
        return super.toString() +
        "\nRegistration Date : " + registerDate +
        "\nRegistration Type : " + registrationType + 
        //"\nTotal Bill(incld taxes) : RM" + calcBill()+ 
        "\n";
    }
}
