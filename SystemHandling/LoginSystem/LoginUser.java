package SystemHandling.LoginSystem;

interface userName{
    public boolean checkInputName(String name);
    public boolean checkInputPhoneNumber(String phoneNumber);
    public boolean checkInputPan(String pan);
    public boolean checkInputAadhaar(String aadhaar);
}
interface password extends userName{
    public boolean checkPassword(String password);
}
interface login extends password{
    public boolean loggedIn(String userName, String password, String dbUserName, String dbPassword);
}
public class LoginUser implements login{

   @Override
   public boolean checkInputName(String name){
    String regex = "^[a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+$";
    /* 
    ^ used for starting the line
    $ used for ending the line
    [a-zA-Z] used for word contain a-z or A-Z alphabets in it
    +<space> used for spacing the words
    example Shahane Om Prashant
    as <surname> <firstname> <middlename>
    */
        if (name.matches(regex)) {

            return true;
        }
        else{
            return false;
        }
   }
   @Override
   public boolean checkInputPhoneNumber(String phoneNumber){
    String regex = "^((\\+){1}91){1}[1-9]{1}[0-9]{9}$";
    if(phoneNumber.matches(regex)){
        return true;
    }
    else{
        return false;
    }
   }

   @Override
   public boolean checkInputPan(String pan){
    String regex = "^[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}$";
    /*
     * [A-Za-z]{5} : ensures lower and upper case alphabet and 5 chars are acceptable. If upper case only, define as [A-Z{5}]
     * [0-9]{4} : numeric values with 4 chars allowed
     * [A-Za-z]{1} : same explanation as first syntax
     * 
     */ 

     if(pan.matches(regex)){
        return true;
    }
    else{
        return false;
    }
   }
   @Override
   public boolean checkInputAadhaar(String aadhaar){
    String regex = "^[0-9]{4}+ [0-9]{4}+ [0-9]{4}$";
    /* 
     * ^  and $ is used for start line and end line respectively
     * [0-9]{4} allowed 4 numeric characters
     */
    if(aadhaar.matches(regex)){
        return true;
    }else{
        return false;
    }
   }
   @Override 
   public boolean checkPassword(String password){
    String regex = "(?=^.{6,255}$)((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))^.*";
      /* 
       *  The complex password filter matching 3 of 4 char categories
       *  1. at least 1 upper case character
       *  2. at least 1 lower case character
       *  3. at least 1 numerical character
       *  4. at least 1 specal character it also enforces a min and max length and work for .Net and script Reges implementation
       */
    if(password.matches(regex)){
        return true;
    }
    else{
        return false;
    }
   }
    @Override
    public boolean loggedIn(String userName, String password,String dbUserName, String dbPassword) {
        if(userName.equals(dbUserName))
        {
            if(password.equals(dbPassword)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
   
   
}
