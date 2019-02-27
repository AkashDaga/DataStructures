import java.util.Scanner;

public class Test {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        boolean isPalindrome = checkForPalindrome(input);

        if(isPalindrome){
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }

    }

    private static boolean checkForPalindrome(String input) {
        StringBuilder builder = new StringBuilder(input);
        System.out.println(builder.toString());
        return new StringBuilder(input).reverse().toString().equals(input);
    }
}

