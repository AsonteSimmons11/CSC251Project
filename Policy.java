
public class Policy {

    // Static tracker tracking all active class instances in memory
    private static int policyCount = 0;

    private int policyNumber;
    private String providerName;
    
    // Aggregation: The Policy "has-a" PolicyHolder object nested inside
    private PolicyHolder policyHolder;

    /**
     * Default constructor initializing structural elements and incrementing the static class counter.
     */
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.policyHolder = new PolicyHolder();
        policyCount++;
    }

  
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        // Deep copy instantiation to maximize security boundaries (Step 5)
        this.policyHolder = new PolicyHolder(policyHolder);
        policyCount++;
    }

  
    public static int getPolicyCount() {
        return policyCount;
    }

    /**
     * Computes the final customized monetary premium rate.
     * @return The total processed insurance premium price.
     */
    public double getPrice() {
        double price = 600.00;

        if (policyHolder.getAge() > 50) {
            price += 75.00;
        }
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100.00;
        }
        
        double bmi = policyHolder.getBMI();
        if (bmi > 35.0) {
            price += (bmi - 35.0) * 20.0;
        }

        return price;
    }

 
    @Override
    public String toString() {
        return String.format(
            "Policy Number: %d\n" +
            "Provider Name: %s\n" +
            "%s\n" +
            "Policy Price: $%,.2f",
            policyNumber, providerName, policyHolder.toString(), getPrice()
        );
    }

    // Getters and Setters with mandatory Javadoc annotations

    /** @return Current policy identifier sequence. */
    public int getPolicyNumber() { return policyNumber; }
    /** @param policyNumber Updated policy numeric sequence. */
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    /** @return Corporate entity identity string. */
    public String getProviderName() { return providerName; }
    /** @param providerName Target underwriter firm assignment. */
    public void setProviderName(String providerName) { this.providerName = providerName; }

    /** * Safe Getter to prevent reference data leaks.
     * @return A deep copy clone of the internal policy holder instance. 
     */
    public PolicyHolder getPolicyHolder() { 
        return new PolicyHolder(this.policyHolder); 
    }
    
    /** * Safe Setter using deep copy logic.
     * @param policyHolder Target policyholder reference mapping. 
     */
    public void setPolicyHolder(PolicyHolder policyHolder) { 
        this.policyHolder = new PolicyHolder(policyHolder); 
    }
}