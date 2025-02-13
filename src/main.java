import java.util.Scanner;

public class main {

    public static String GREEN_BACKGROUND = "\u001B[42m";
    public static String RESET = "\u001B[0m";
    public static void main(String[] args) {
//        decimalToBinary(120);
//        binaryToDecimal("1000011");
//        hexToDecimal("");
//        decimalToHex(573);

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("decimal to binary = db");
            System.out.println("binary to decimal = bd");
            System.out.println("hex to decimal    = hd");
            System.out.println("decimal to hex    = dh");
            System.out.println("exit              = exit");

            String userInput = scanner.next();

            if (userInput.equals("exit")) {
                break;
            } else if (userInput.startsWith("db")) {
                try {
                    int decimalNumber = Integer.parseInt(userInput.substring(2).trim());
                    decimalToBinary(decimalNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid decimal number.");
                }
            } else if (userInput.startsWith("bd")) {
                binaryToDecimal(userInput.substring(2).trim());
            } else if (userInput.startsWith("hd")) {
                try {
                    hexToDecimal(userInput.substring(2).trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid decimal number.");
                }
            } else if (userInput.startsWith("dh")) {
                try {
                    int decimalNumber = Integer.parseInt(userInput.substring(2).trim());
                    decimalToHex(decimalNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid decimal number.");
                }
            }
        }
    }

        public static void binaryToDecimal (String binary){
            int decimal = 0;
            int power = 0;
            System.out.println("Converting binary " + binary + " to decimal:");

            for (int i = binary.length() - 1; i >= 0; i--) {
                int bit = Character.getNumericValue(binary.charAt(i));
                int contribution = bit * (int) Math.pow(2, power);
                decimal += contribution;

                System.out.println("Bit: " + bit + " at position " + power +
                        " contributes: " + contribution);
                power++;
            }

            System.out.println("Final decimal result: " + GREEN_BACKGROUND + decimal + RESET);
        }

        public static void decimalToBinary ( int decimal){
            System.out.println("\nConverting decimal " + decimal + " to binary:");

            if (decimal == 0) {
                System.out.println("Result: 0");
                return;
            }

            StringBuilder binary = new StringBuilder();
            int originalDecimal = decimal;

            while (decimal > 0) {
                int remainder = decimal % 2;
                binary.insert(0, remainder);

                System.out.println(decimal + " ÷ 2 = " + (decimal / 2) + " remainder " + remainder);

                decimal /= 2;
            }

            System.out.println("Final binary result: " + GREEN_BACKGROUND + binary.toString() + RESET);
            System.out.println("Verification: " + originalDecimal + " (decimal) = " + binary.toString() + " (binary)");
        }

        public static void decimalToHex ( int decimal){
            System.out.println("\nConverting decimal " + decimal + " to hexadecimal:");

            if (decimal == 0) {
                System.out.println("Result: 0");
                return;
            }

            StringBuilder hex = new StringBuilder();
            int originalDecimal = decimal;
            String hexChars = "0123456789ABCDEF";

            while (decimal > 0) {
                int remainder = decimal % 16;
                hex.insert(0, hexChars.charAt(remainder));

                System.out.println(decimal + " ÷ 16 = " + (decimal / 16) + " remainder " + remainder +
                        " (hex digit: " + hexChars.charAt(remainder) + ")");

                decimal /= 16;
            }

            System.out.println("Final hexadecimal result: " + GREEN_BACKGROUND + hex.toString() + RESET);
            System.out.println("Verification: " + originalDecimal + " (decimal) = 0x" + hex.toString() + " (hexadecimal)");
        }

        public static void hexToDecimal (String hex) {
            System.out.println("\nConverting hexadecimal " + hex + " to decimal:");

            int decimal = 0;
            String hexChars = "0123456789ABCDEF";
            hex = hex.toUpperCase();

            for (int i = 0; i < hex.length(); i++) {
                char hexChar = hex.charAt(i);
                int digitValue = hexChars.indexOf(hexChar);

                if (digitValue == -1) {
                    System.out.println("Invalid hexadecimal digit: " + hexChar);
                    return;
                }

                int position = hex.length() - 1 - i;
                int contribution = digitValue * (int) Math.pow(16, position);
                decimal += contribution;

                System.out.println("Hex digit: " + hexChar +
                        " contributes: " + contribution);
            }

            System.out.println("Final decimal result: " + GREEN_BACKGROUND + decimal + RESET);
            System.out.println("Verification: 0x" + hex + " (hexadecimal) = " + decimal + " (decimal)");
        }
}
