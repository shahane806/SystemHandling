package SystemHandling.SignupSystem;
import java.io.*;
interface SignupUser {
public boolean registerData(String name,String phoneNumber,String address,String pan,String aadhaar,String new_password,String confirm_password,String old_password,String vehicle_model,String vehicle_number);
}

public class Signup implements SignupUser{
    @Override
    public boolean registerData(String name, String phoneNumber, String address, String pan, String aadhaar,
            String new_password, String confirm_password, String old_password, String vehicle_model,
            String vehicle_number) {
       try {
            FileOutputStream RegisterData = new FileOutputStream("DataRegister.txt");
            String data = name+"\n"+phoneNumber+"\n"+address+"\n"+pan+"\n"+aadhaar+"\n"+new_password+"\n"+confirm_password+"\n"+old_password+"\n"+vehicle_model+"\n"+vehicle_number+"\n";
            for(int i = 0;i<data.length();i++){
                RegisterData.write(data.charAt(i));
            }
            RegisterData.close();
            return true;
           
       } catch (Exception e) {
        e.printStackTrace();
       }
      return false;
        
    }
}
