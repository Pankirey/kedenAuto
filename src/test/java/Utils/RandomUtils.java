package Utils;
import com.github.javafaker.Faker;
import java.util.Locale;

public class RandomUtils {
    static Faker fakerRu = new Faker(new Locale("ru"));
    public static String getRandomFirstName(){
        return fakerRu.name().firstName();
    }
    public static String getRandomEmail(){
        return fakerRu.internet().emailAddress();
    }
    public static String getRandomPhoneNumber(){
        return fakerRu.phoneNumber().cellPhone();
    }
}
