import java.util.Scanner;
public class Policy {
   
   // CONSTANTS - Declared to avoid Major Grading Errors
   private static final double BASE_FEE = 600.0;
   private static final int AGE_THRESHOLD = 50;
   private static final double AGE_ADDITIONAL_FEE = 75.0;
   private static final double SMOKER_ADDITIONAL_FEE = 100.0;
   private static final double BMI_THRESHOLD = 35.0;
   private static final double BMI_ADDITIONAL_FEE_MULTIPLIER = 20.0;
   private static final double BMI_CONVERSION_FACTOR = 703.0;

   // Instance Fields
   private String policyNumber;
   private String providerName;
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus; // "smoker" or "non-smoker"
   private double height;        // in inches
   private double weight;        // in pounds

   public Policy() {
      this.policyNumber = "";
      this.providerName = "";
      this.firstName = "";
      this.lastName = "";
      this.age = 0;
      this.smokingStatus = "non-smoker";
      this.height = 0.0;
      this.weight = 0.0;
   }

    
   public Policy(String policyNumber, String providerName, String firstName, String lastName, 
                 int age, String smokingStatus, double height, double weight) {
      this.policyNumber = policyNumber;
      this.providerName = providerName;
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.smokingStatus = smokingStatus;
      this.height = height;
      this.weight = weight;
   }

   // Accessor and Mutator Methods (Getters and Setters)
   
   public String getPolicyNumber() { 
      return policyNumber; }
   public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

   public String getProviderName() { 
      return providerName; }
   public void setProviderName(String providerName) { this.providerName = providerName; }

   public String getFirstName() { 
      return firstName; }
   public void setFirstName(String firstName) { this.firstName = firstName; }

   public String getLastName() { 
      return lastName; }
   public void setLastName(String lastName) { this.lastName = lastName; }

   public int getAge() { 
      return age; }
   public void setAge(int age) { this.age = age; }

   public String getSmokingStatus() { 
      return smokingStatus; }
   public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

   public double getHeight() { 
      return height; }
   public void setHeight(double height) { this.height = height; }

   public double getWeight() { 
      return weight; }
   public void setWeight(double weight) { this.weight = weight; }

   /**
    * Calculates and returns the Body Mass Index (BMI).
    * Computed dynamically on request to completely avoid stale values.
    * * @return The calculated BMI value
    */
   public double getBMI() {
      if (height == 0) {
         return 0.0;
      }
      return (weight * BMI_CONVERSION_FACTOR) / (height * height);
   }

   /**
    * Calculates the total financial price of the insurance policy.
    * Accumulates fees according to risk calculations mapped directly from constants.
    * * @return The calculated policy price fee
    */
   public double getPrice() {
      double price = BASE_FEE;
   
      // Age verification fee addition
      if (age > AGE_THRESHOLD) {
         price += AGE_ADDITIONAL_FEE;
      }
   
      // Smoking assessment fee addition
      if (smokingStatus.equalsIgnoreCase("smoker")) {
         price += SMOKER_ADDITIONAL_FEE;
      }
   
      // High BMI assessment fee addition
      double bmi = getBMI();
      if (bmi > BMI_THRESHOLD) {
         price += (bmi - BMI_THRESHOLD) * BMI_ADDITIONAL_FEE_MULTIPLIER;
      }
   
      return price;
   }
}