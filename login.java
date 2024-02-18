import SystemHandling.LoginSystem.*;
import SystemHandling.SignupSystem.*;
import SystemHandling.ForgetPasswordSystem.*;
import java.io.*;
import java.util.Scanner;
public class login {
    public static void main(String[] args){
        LoginUser l = new LoginUser();
        Scanner scanner = new Scanner(System.in);

        ForgetPassword f = new ForgetPassword();
        System.out.println(l.checkInputName("xxxx xx xxxx"));
        System.out.println(l.checkInputPhoneNumber("+91xxxxxxxxxx"));
        System.out.println(l.checkInputPan("XXXX1234X"));
        System.out.println(l.checkInputAadhaar("XXXX XXXX XXXX"));
        System.out.println(l.checkPassword("pass@123"));
        System.out.println(l.loggedIn("XX", "XX", "XX", "XX"));
        Signup s = new Signup();
        boolean r = false;
        if(l.checkInputName("XX XX XX")){
            r = s.registerData("XX XX XX", "+91XXXXXXXXXX", "XX", "XXX1234X", "XXXX XXXX XXXX","Pass@123","Pass@123","Pass@1234","XUV-700","MH16T3423");
      
        }
        if(r){
            System.out.println("Register Successful");
        }
        else{
            System.err.println("No user Found, Want to Register");
        }

        String userPhoneNumber =  scanner.nextLine();

        if(l.checkInputPhoneNumber(userPhoneNumber)){
            f.checkRegisterMobileNumber(userPhoneNumber, "+91XXXXXXXXXX");
            char[] generatedOTP = f.generateOTP();
        System.out.println(generatedOTP);
        int otp = scanner.nextInt();
        String genotp;
        genotp = String.valueOf(generatedOTP);
        System.out.println(f.checkOTP(otp, genotp));
        }
        else{
            System.err.println("NOT Match with regex");
        }
        
        System.err.println(f.generatedPassword());
        try {
            char[] p = f.generatedPassword();
            String p1 = String.valueOf(p);
            System.err.println(p1);
            f.savePassword(p1);
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
        
    }
}
