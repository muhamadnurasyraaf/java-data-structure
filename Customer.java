public class Customer{
    private String custIc;
    private String phoneNo;
    private String gender;
    private int age;
    private String address;
    private String custName;
    private String disease;
    private boolean insurance;
    private boolean registered;

    public Customer(){
        custIc = null;
        phoneNo = null;
        gender = null;
        age = 0;
        address = null;
        custName ="";
        disease = "";
        insurance = false;
        registered = false;
    }


    public Customer(String ic,String pNo,String g,int age,String add,String name,String d,boolean ins,boolean reg){
        custIc =ic;
        phoneNo = pNo;
        gender = g;
        this.age = age;
        address = add;
        custName = name;
        disease = d;
        insurance = ins;
        registered = reg;
    }

    public String getNoIc(){return custIc;}
    public String getPhoneNo(){return phoneNo;}
    public String getGender(){return gender;}
    public int getAge(){return age;}
    public String getAddress(){return address;}
    public String getName(){return custName;}
    public String getDisease(){return disease;}
    public boolean getInsurance(){return insurance;}
    public boolean getRegistered(){return registered;}

    //public abstract double calcBill();

    public String toString(){
        return "\nCustomer Details -->" +
        "\nIc Number\t: " + custIc + 
        "\nPhone Number\t: " + phoneNo + 
        "\nGender\t\t: " + gender +
        "\nAge\t\t: " +  age + 
        "\nAddress\t\t: " + address +
        "\nName\t\t: " + custName +
        "\nDisease\t\t: " + disease +
        "\nGet Insured\t: " + insurance +
        "\nRegistered\t: " + registered;
    }

    
}