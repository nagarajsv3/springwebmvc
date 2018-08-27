import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestApp {

    public static void main(String[] args) {

        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        String md5EncodedPassword = md5PasswordEncoder.encodePassword("admin", null);
        System.out.println("MD5 Encoded="+md5EncodedPassword);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String bcryptencoded = bCryptPasswordEncoder.encode("admin");
        System.out.println("BCrypt Encoded="+bcryptencoded);
        //$2a$10$cKSBEbhBtVjuUVvHra4Y9eGueyyR9llOEV8xFonM8UV3l41xLgBbq

    }
}
