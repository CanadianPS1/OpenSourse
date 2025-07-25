package csc180.roeback.lia;
public class person {
    private String phoneNumber;
    private String name;
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getName(){
        return name;
    }
    public boolean setPhoneNumber(String ph){
        if(ph.matches("\\d{3}-\\d{3}-\\d{4}")){
            phoneNumber = ph;
            System.out.println("Phone Number has been set to : " + ph);
            return true;
        }else{
            System.out.println("Invalid Phone Number");
            return false;
        }
    }
    public boolean setName(String n){
        if(n.matches("\\w+\\s\\w+\\s+\\w+") || n.matches("\\w+\\s+\\w+")){
            name = n;
            System.out.println("Name has been set to : " + name);
            return true;
        }else{
            System.out.println("Invalid Name");
            return false;
        }
    }
}
