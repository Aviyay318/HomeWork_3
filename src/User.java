public class User {
    private String name;
    private String password;
    private String phoneNumber;
    private boolean isBroker;

    //O(1) - complexity
    public User(String name, String password, String phoneNumber, boolean isBroker) {
        this.name = name;
        if (passwordValidation(password)){
            this.password = password;
        }else {
            this.password = null;
        }
        if (phoneNumberValidation(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else {
            this.phoneNumber = null;
        }

        this.isBroker = isBroker;
    }
    //O(1) - complexity
    public String getPassword() {
        return password;
    }
    //O(1) - complexity
    public String getPhoneNumber() {
        return phoneNumber;
    }
    //O(1) - complexity
    public void setPassword(String password) {
        if (passwordValidation(password)){
            this.password = password;
        }else {
            this.password = null;
        }
    }
    //O(1) - complexity
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumberValidation(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else {
            this.phoneNumber = null;
        }
    }
    //O(1) - complexity
    public boolean getIsBroker() {
        return isBroker;
    }
    //O(1) - complexity
    public String getName() {
        return name;
    }
    //O(1) - complexity
    public String toString() {
        String output;
        output=  this.name +" " + this.phoneNumber  +
                "(" + getPrintTypeOfUser() + ")" ;
        return output;
    }
    //O(1) - complexity
    private String getPrintTypeOfUser(){
        String typeOfUser;
        if (this.isBroker){
            typeOfUser="Real estate broker";
        }else {
            typeOfUser="Regular user";
        }
        return typeOfUser;
    }
    //O(n) - complexity
    private boolean passwordValidation(String password){
        boolean isValid=true;
        String digits="0123456789";
        String necessaryChar ="$%_";
        if (password.length()<Constant.PASSWORD_VALIDATION_MINIMUM){
            isValid=false;
        }
        if (isValid){
            isValid=false;
            for (int i=0;i<password.length();i++){
                String currentChar =password.charAt(i)+"";
                if (digits.contains(currentChar)){
                    isValid=true;
                    break;
                }

            }
            if (isValid){
                isValid=false;
                for (int i=0;i<password.length();i++){
                    String currentChar =password.charAt(i)+"";
                    if (necessaryChar.contains(currentChar)){
                        isValid=true;
                        break;
                    }

                }
            }}
        return isValid;
    }
    //O(n) - complexity
    private boolean phoneNumberValidation(String phoneNumber) {
        boolean isValid=true;
        String digits="0123456789";
        if (phoneNumber.length()!=Constant.PHONE_NUMBER_VALIDATION){
            isValid = false;
        }
        else {
            String help = phoneNumber.substring(Constant.PREFIX_START,Constant.PREFIX_END);
            if (help.equals("05")){
                for (int i=2;i<phoneNumber.length();i++){
                    String helper=phoneNumber.charAt(i) +"";
                    if(!digits.contains(helper)){
                        isValid=false;
                        break;
                    }
                }
            }

        }
        return isValid;
    }


}
