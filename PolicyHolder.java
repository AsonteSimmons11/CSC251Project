
public class PolicyHolder {

   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus; // "smoker" or "non-smoker"
   private double height;        // In inches
   private double weight;        // In pounds

 
   public PolicyHolder() {
      this.firstName = "";
      this.lastName = "";
      this.age = 0;
      this.smokingStatus = "non-smoker";
      this.height = 0.0;
      this.weight = 0.0;
   }

   public PolicyHolder(String firstName, String lastName, int age, 
                       String smokingStatus, double height, double weight) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.smokingStatus = smokingStatus;
      this.height = height;
      this.weight = weight;
   }

   /**
    * Copy constructor to mitigate reference visibility security holes.
    * Performs a clean deep duplication copy of an existing holder reference.
    * @param object2 The original PolicyHolder instance to duplicate.
    */
   public PolicyHolder(PolicyHolder object2) {
      if (object2 != null) {
         this.firstName = object2.firstName;
         this.lastName = object2.lastName;
         this.age = object2.age;
         this.smokingStatus = object2.smokingStatus;
         this.height = object2.height;
         this.weight = object2.weight;
      }
   }

   /**
    * Derives individual Body Mass Index utilizing physical metrics.
    * @return The calculated BMI value.
    */
   public double getBMI() {
      if (height == 0) 
         return 0.0;
      return (weight * 703) / (height * height);
   }

   /**
    * Serializes the policyholder's details into a clean text block format.
    * @return A formatted multi-line summary of the policyholder.
    */
   @Override
   public String toString() {
      return String.format(
         "Policyholder's First Name: %s\n" +
         "Policyholder's Last Name: %s\n" +
         "Policyholder's Age: %d\n" +
         "Policyholder's Smoking Status (Y/N): %s\n" +
         "Policyholder's Height: %.1f inches\n" +
         "Policyholder's Weight: %.1f pounds\n" +
         "Policyholder's BMI: %.2f",
         firstName, lastName, age, smokingStatus, height, weight, getBMI()
         );
   }

   // Encapsulated Getters and Setters with Javadoc comments

   /** @return Legal given name. */
   public String getFirstName() { 
      return firstName; }
   /** @param firstName Target individual first name. */
   public void setFirstName(String firstName) { this.firstName = firstName; }

   /** @return Family identity surname. */
   public String getLastName() { 
      return lastName; }
   /** @param lastName Target family legacy assignment. */
   public void setLastName(String lastName) { this.lastName = lastName; }

   /** @return Current age value. */
   public int getAge() { 
      return age; }
   /** @param age Updated chronological age configuration. */
   public void setAge(int age) { this.age = age; }

   /** @return Status designation metadata label string. */
   public String getSmokingStatus() { 
      return smokingStatus; }
   /** @param smokingStatus Target category configuration. */
   public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

   /** @return Target standard height measurement. */
   public double getHeight() { 
      return height; }
   /** @param height Transferred precise height metrics. */
   public void setHeight(double height) { this.height = height; }

   /** @return Target physical mass configuration. */
   public double getWeight() { 
      return weight; }
   /** @param weight Transferred precise weight metrics. */
   public void setWeight(double weight) { this.weight = weight; }
}