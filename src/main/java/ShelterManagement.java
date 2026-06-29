import java.util.ArrayList;
import java.util.List;

public class ShelterManagement {
    private static List<Pet> pets = new ArrayList<>();// Create a list to hold animals
    private static int animalIdCounter = 1; // To ensure unique IDs
    private List<StaffMember> staffMembers = new ArrayList<>();
    private int staffIdCounter = 1;

    /**
     * main
     * an example code
     * @param args
     */
    public static void main(String[] args) {
        final int MAGIC_AGE_3 = 3;
        final int MAGIC_AGE_2 = 2;
        final int MAGIC_AGE_1 = 1;
        ShelterManagement shelter = new ShelterManagement();
        // Adding the core animals
        initializeCoreAnimals();

        // Allow for new animal arrivals
        addPet("Dog", "Hey You", MAGIC_AGE_3, "Healthy", "SZ-001", IntakeType.STRAY);
        addPet("Cat", "Wizard", MAGIC_AGE_2, "Sick", "SZ-002", IntakeType.SURRENDER);
        addPet("Rabbit", "Dinner", MAGIC_AGE_1, "Healthy", "SZ-003", IntakeType.TRANSFER);

        // Adding staff members
        shelter.addStaffMember("Dr. Smith", StaffRole.VETERINARIAN);
        shelter.addStaffMember("Alice Johnson", StaffRole.TECHNICIAN);
        shelter.addStaffMember("Bob Brown", StaffRole.COUNSELOR);

        // Perform staff jobs
        shelter.performStaffJobs();
        // Display all Pets
        shelter.displayPet();
    }
    /**
     * addStaffMember
     * creates a list of staff
     * overloaded
     * @param name
     * @param role
     */
    public void addStaffMember(String name, StaffRole role) {
        staffMembers.add(new StaffMember(staffIdCounter++, name, role));
        System.out.println(name + " added to staff as " + role);
    }
    /**
     * addStaffMember
     * creates a list of staff
     * overloaded
     * @param member
     */
    public void addStaffMember(StaffMember member) {
        staffMembers.add(member);
        System.out.println(member.getName() + " added to staff as " + member.getRole());
    }

    /**
     * performStaffJobs
     * a sample of how to do jobs
     */
    public void performStaffJobs() {
        for (StaffMember staff : staffMembers) {
            for (Pet pet : pets) {
                staff.performJob(pet);
            }
        }
    }

    /**
     * filterStaffByRole
     * @param role
     * @return List<StaffMember>
     */
    public List<StaffMember> filterStaffByRole(StaffRole role) {
        List<StaffMember> staff = new ArrayList<>();
        for (StaffMember member : this.staffMembers) {
            if (member.getRole() == role) {
                staff.add(member);
            }
        }
        return staff;
    }

    /**
     * getPets
     * @return List<Pet>
     */
    public List<Pet> getPets() {
        return pets;
    }

    /**
     * initializeCoreAnimals
     * an example
     */
    private static void initializeCoreAnimals() {
        final int MAGIC_AGE_5 = 5;
        final int MAGIC_AGE_3 = 3;
        final int MAGIC_AGE_2 = 2;
        final int MAGIC_AGE_1 = 1;
        Pet dog1 = PetFactory.createPet("Dog", animalIdCounter++, "Bugger", MAGIC_AGE_3, "Healthy",
            "SZ-001", IntakeType.STRAY);
        dog1.review();
        dog1.clear();
        pets.add(dog1);
        Pet cat1 = PetFactory.createPet("Cat", animalIdCounter++, "Jerry", MAGIC_AGE_2, "Sick",
            "SZ-002", IntakeType.SURRENDER);
        cat1.review();
        cat1.clear();
        pets.add(cat1);
        Pet dog2 = PetFactory.createPet("Dog", animalIdCounter++, "Ralf", MAGIC_AGE_5, "Healthy", 
            "SZ-003", IntakeType.STRAY);
        dog2.review();
        dog2.clear();
        pets.add(dog2);
        Pet cat2 = PetFactory.createPet("Cat", animalIdCounter++, "George", MAGIC_AGE_1, "Healthy", 
            "SZ-001", IntakeType.TRANSFER);
        cat2.review();
        cat2.clear();
        pets.add(cat2);
        Pet rabbit1 = PetFactory.createPet("Rabbit", animalIdCounter++, "Hopper", MAGIC_AGE_2, "Healthy", 
            "SZ-002", IntakeType.SURRENDER);
        rabbit1.review();
        rabbit1.clear();
        pets.add(rabbit1);
    }
    
    /**
     * addPet
     * adds and creates pets to a list
     * overloaded
     * @param species
     * @param name
     * @param age
     * @param healthStatus
     * @param shelterZoneCode
     * @param intakeType
     */
    public static void addPet(String species, String name, int age, String healthStatus, 
            String shelterZoneCode, IntakeType intakeType) {
        pets.add(PetFactory.createPet(species, animalIdCounter++, name, age, healthStatus, 
            shelterZoneCode, intakeType));
        System.out.println(species + " added to the shelter as a " + intakeType);
    }
    /**
     * addPet
     * adds and creates pets to a list
     * overloaded
     * @param pet
    */
    public void addPet(Pet pet) {
        pets.add(pet);
        System.out.println(pet.getSpecies() + " added to the shelter as a " + pet.getIntakeType());
    }

    /**
     * displayPet
     * prints out the pets in list
     */
    public void displayPet() {
        System.out.println("Current Pet in Shelter:");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
        System.out.println();
    }
}



