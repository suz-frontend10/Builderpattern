/**
 * Client class containing the main method to demonstrate the Builder Design Pattern.
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   BUILDER DESIGN PATTERN DEMO - CUSTOM PC BUILD  ");
        System.out.println("==================================================\n");

        // Example 1: Gaming PC (All components specified - required & optional)
        System.out.println("Building Example 1: Gaming PC...");
        PC gamingPC = new PC.Builder("Intel i7", 16, 512)
                .graphicsCard("NVIDIA RTX 4060")
                .coolingSystem("Liquid Cooling")
                .build();

        // Display configuration for Gaming PC
        gamingPC.displayConfiguration();

        // Example 2: Basic PC (Only required components specified)
        System.out.println("Building Example 2: Basic PC...");
        PC basicPC = new PC.Builder("Intel i5", 8, 256)
                .build();

        // Display configuration for Basic PC
        basicPC.displayConfiguration();

        System.out.println("==================================================");
        System.out.println("   BUILD DEMONSTRATION COMPLETED SUCCESSFULLY     ");
        System.out.println("==================================================");
    }
}
