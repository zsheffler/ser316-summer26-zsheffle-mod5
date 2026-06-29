
// Base Pet Class
abstract class Pet {
    private int id; // Unique identifier for the animal
    protected String name;
    protected int age;
    private String size;         // e.g., Small, Medium, Large
    private String temperament;   // e.g., Friendly, Energetic, Calm
    protected String healthStatus;
    private PetState state;
    private String shelterZoneCode; // Shelter Zone Code (format: SZ-XXX)
    private IntakeType intakeType; // Type of intake

    public Pet(int id, String name, int age, String healthStatus, String shelterZoneCode, IntakeType intakeType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.size = "?";
        this.temperament = "?";
        this.healthStatus = healthStatus;
        this.state = new IntakeState(); // Initial state
        this.shelterZoneCode = shelterZoneCode;
        this.intakeType = intakeType;
    }

    // Getter methods
    /**
     * Get Size
     * @return size
     */
    public String getSize() {
        return size;
    }
    /**
     * Get temperament
     * @return temperament
     */
    public String getTemperament() {
        return temperament;
    }
    /**
     * Get state
     * @return state
     */
    public PetState getState() {
        return state;
    }
    /**
     * Get id
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Get age
     * @return age
     */
    public int getAge() {
        return age;
    }
    /**
     * Get healthStatus
     * @return healthStatus
     */
    public String getHealthStatus() {
        return healthStatus;
    }
    /**
     * Get shelterZoneCode
     * @return shelterZoneCode
     */
    public String getShelterZoneCode() {
        return shelterZoneCode;
    }
    /**
     * Get intakeType
     * @return intakeType
     */
    public IntakeType getIntakeType() {
        return intakeType;
    }

    //setters
    /**
     * Set size
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
        System.out.println("Size of " + name + " updated to: " + size);
    }
    /**
     * Set temperament
     * @param temperament
     */
    public void setTemperment(String attitude) {
        this.temperament = attitude;
        System.out.println(name + "has been determined to have a " + attitude + " temperment.");
    }
    /**
     * Set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Set healthStatus
     * @param healthStatus
     */
    public void setHealthStatus(String newHealthStatus) {
        this.healthStatus = newHealthStatus;
        System.out.println("Health status of " + getSpecies() + " updated to: " + newHealthStatus);
    }
    /**
     * Set state
     * @param state
     */
    public void setState(PetState state) {
        this.state = state;
    }
    /**
     * Set intake
     * @param
     */
    public void intake() {
        state.intakePet(this); 
    }
    /**
     * Set review
     * @param 
     */
    public void review() {
        state.reviewPet(this);
    }
    /**
     * Set clear
     * @param 
     */
    public void clear() {
        state.clearPet(this);
    }
    /**
     * Set adopt
     * @param 
     */
    public void adopt() {
        state.adoptPet(this);
    }


    @Override
    public String toString() {
        return "Pet [ID=" + id + ", Species=" + getSpecies() + ", Age=" + age + 
                ", Health Status=" + healthStatus + ", Shelter Zone Code=" + 
                shelterZoneCode + ", Intake Type=" + intakeType + "]";
    }
    //abstract methods
    /**
     * get AgeRange to be set in concreate class
     * @return AgeRange
     */
    public abstract String getAgeRange();
    /**
     * get Species to be set in concreate class
     * @return Species
     */
    public abstract String getSpecies();
}

// Dog Class
class Dog extends Pet {
    public static final int ANCIENT = 17;
    public static final int SENIOR = 7;
    public static final int ADULT = 4;
    public static final int YOUNG = 1;

    public Dog(int id, String name, int age, String healthStatus, String shelterZoneCode, IntakeType intakeType) {
        super(id, name, age, healthStatus, shelterZoneCode, intakeType);
    }

    @Override
    public String getAgeRange() {
        if (age > ANCIENT) {
            return "ancient";
        } else if (age > SENIOR) {
            return "senior";
        } else if (age > ADULT) {
            return "adult";
        } else if (age > YOUNG) {
            return "young";
        } else {
            return "puppy";
        }
    }

    @Override
    public String getSpecies() {
        return "Dog";
    }
}

// Cat Class
class Cat extends Pet {
    public static final int ANCIENT = 20;
    public static final int SENIOR = 10;
    public static final int ADULT = 5;
    public static final int YOUNG = 2;

    public Cat(int id, String name, int age, String healthStatus, String shelterZoneCode, IntakeType intakeType) {
        super(id, name, age, healthStatus, shelterZoneCode,intakeType);
    }

    @Override
    public String getAgeRange() {
        if (age > ANCIENT) {
            return "ancient";
        } else if (age > SENIOR) {
            return "senior";
        } else if (age > ADULT) {
            return "adult";
        } else if (age > YOUNG) {
            return "young";
        } else {
            return "kitten";
        }
    }

    @Override
    public String getSpecies() {
        return "Cat";
    }
}

// Rabbit Class
class Rabbit extends Pet {
    public static final int ANCIENT = 12;
    public static final int SENIOR = 5;
    public static final int ADULT = 2;
    public static final int YOUNG = 1;
    public Rabbit(int id, String name, int age, String healthStatus, String shelterZoneCode, IntakeType intakeType) {
        super(id, name, age, healthStatus, shelterZoneCode, intakeType);
    }
    @Override
    public String getAgeRange() {
        if (age > ANCIENT) {
            return "ancient";
        } else if (age > SENIOR) {
            return "senior";
        } else if (age > ADULT) {
            return "adult";
        } else if (age > YOUNG) {
            return "young";
        } else {
            return "kit";
        }
    }

    @Override
    public String getSpecies() {
        return "Rabbit";
    }
}
// PetFactory Class
class PetFactory {
    public static Pet createPet(String petType, int id, String name, int age, 
            String healthStatus, String shelterZoneCode, IntakeType intakeType) {
        if (petType.equalsIgnoreCase("dog")) {
            return new Dog(id, name, age, healthStatus, shelterZoneCode, intakeType);
        } else if (petType.equalsIgnoreCase("cat")) {
            return new Cat(id, name, age, healthStatus, shelterZoneCode, intakeType);
        } else {
            throw new IllegalArgumentException("Unknown pet type.");
        }
    }
}



