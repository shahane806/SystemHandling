package SystemHandling.ForgetPasswordSystem;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import SystemHandling.LoginSystem.*;

interface forget{
   public boolean checkRegisterMobileNumber(String phoneNumber,String dbPhoneNumber);
   public char[] generateOTP();
   public char[] generatedPassword();
   public void savePassword(String paString) throws FileNotFoundException;
   public boolean checkOTP(int userOTP,String generateOTP);
   public boolean checkUserNewPassword(String new_password,String confirm_password,String db_old_password);
   public boolean changePassword(String new_password,String db_new_password);
}
public class ForgetPassword  implements forget{
    public LoginUser l;
    @Override 
    public boolean checkRegisterMobileNumber(String phoneNumber,String dbPhoneNumber){
        l = new LoginUser();
        if(l.checkInputPhoneNumber(dbPhoneNumber)){
            if(phoneNumber.equals(dbPhoneNumber)){
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
    @Override
    public char[] generateOTP(){
        String numbeString = "0123456789";
        Random r = new Random();
        char[] otp = new char[6];
        for(int i = 0;i<6;i++){
          otp[i] = numbeString.charAt(r.nextInt(numbeString.length()));
        }
        return otp;
    }
    @Override
    public char[] generatedPassword(){
        String pass = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_-+=/-*,./;:\'\"{}[]";
        Random r = new Random();
        char [] newpassword = new char[100];
        for(int i = 0;i<100;i++){
            newpassword[i] = pass.charAt(r.nextInt(pass.length()));
        }
        return newpassword;
    }
    @Override
    public boolean checkOTP(int userOTP, String genotp) {
       if(String.valueOf(userOTP).equals(genotp)){
        return true;
       }
       else{
        return false;
       }
    }
    @Override
    public boolean checkUserNewPassword(String new_password, String confirm_password, String db_old_password) {
        if(new_password.equals(confirm_password)){
            if(new_password.equals(db_old_password)){
                System.out.println("This is match with your last password. Try new password");
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    @Override
    public boolean changePassword(String new_password,String db_new_password) {
        if(new_password.equals(db_new_password)){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public void savePassword(String passwoString) throws FileNotFoundException {
        FileOutputStream savePass = new FileOutputStream("savePass.txt");
        for(int i = 0;i<passwoString.length();i++){
            try {
                savePass.write(passwoString.charAt(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
