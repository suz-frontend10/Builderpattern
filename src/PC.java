/**
 * PC class representing the Product in the Builder Design Pattern.
 * 
 * Demonstrates how to create complex objects step-by-step with required
 * and optional components.
 */
public class PC {

    // Required components
    private final String processor;
    private final int ram;          // in GB
    private final int storage;      // in GB

    // Optional components
    private final String graphicsCard;
    private final String coolingSystem;

    /**
     * Private constructor to enforce object creation exclusively 
     * through the nested Builder class.
     * 
     * @param builder The Builder object containing specified configuration settings.
     */
    private PC(Builder builder) {
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.coolingSystem = builder.coolingSystem;
    }

    /**
     * Displays all components of the PC configuration clearly.
     * If an optional component was not specified, displays "Not selected".
     */
    public void displayConfiguration() {
        System.out.println("----------------------------------------------");
        System.out.println("             PC CONFIGURATION DETAIL          ");
        System.out.println("----------------------------------------------");
        System.out.println(" Processor     : " + processor);
        System.out.println(" RAM           : " + ram + " GB");
        System.out.println(" Storage       : " + storage + " GB SSD");
        System.out.println(" Graphics Card : " + (graphicsCard != null && !graphicsCard.isEmpty() ? graphicsCard : "Not selected"));
        System.out.println(" Cooling System: " + (coolingSystem != null && !coolingSystem.isEmpty() ? coolingSystem : "Not selected"));
        System.out.println("----------------------------------------------\n");
    }

    // Getters for PC components
    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    /**
     * Static nested Builder class responsible for constructing the PC object step by step.
     */
    public static class Builder {

        // Required parameters
        private final String processor;
        private final int ram;
        private final int storage;

        // Optional parameters initialized to default values
        private String graphicsCard;
        private String coolingSystem;

        /**
         * Builder constructor requiring mandatory PC components.
         * 
         * @param processor The CPU specification (e.g., "Intel i7")
         * @param ram RAM capacity in GB (e.g., 16)
         * @param storage Storage capacity in GB (e.g., 512)
         */
        public Builder(String processor, int ram, int storage) {
            this.processor = processor;
            this.ram = ram;
            this.storage = storage;
        }

        /**
         * Optional parameter setter for Graphics Card.
         * Returns 'this' to support method chaining (fluent interface).
         */
        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        /**
         * Optional parameter setter for Cooling System.
         * Returns 'this' to support method chaining (fluent interface).
         */
        public Builder coolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        /**
         * Builds and returns the final immutable PC object.
         * 
         * @return A fully constructed PC instance.
         */
        public PC build() {
            return new PC(this);
        }
    }
}
