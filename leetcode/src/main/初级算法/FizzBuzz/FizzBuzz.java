package FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> str = new ArrayList<>();
        if (n<=0) return str;
        for (int i = 1; i < n+1; i++) {
            if (i%15==0) {
                str.add("FizzBuzz");
                continue;
            }
            if (i%5==0) {
                str.add("Buzz");
                continue;
            }
            if (i%3==0) {
                str.add("Fizz");
                continue;
            }
            str.add(String.valueOf(i));
        }

        return str;
    }
}
