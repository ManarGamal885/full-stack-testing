package chapter3AutomatedFunctionalTesting;

import com.intuit.karate.junit5.Karate;
import org.testng.annotations.Test;

public class test {
    @Test
    public Karate testGetPost() {
        return Karate.run("get-post").relativeTo(getClass());
    }
}
