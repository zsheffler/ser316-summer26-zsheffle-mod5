import java.util.Random;
public class Main {
    //here per requirements
    public String debuggggs;
    /**
     * main an example
     * @param args
     */
    public static void main(String[] args) {
        final int MAGIC_AGE_1 = 1;
        final int MAGIC_AGE_2 = 2;
        final int MAGIC_AGE_3 = 3;
        final int MAGIC_AGE_5 = 5;
        Random rand = new Random();
        int animalIdCounter = 1;
        AdoptionManagement adoptionManagement = new AdoptionManagement();
        

        System.out.println("Collecting and storing preferences from adopters");
        adoptionManagement.addAdopterPreferences(new AdopterPreferences("Dog", "medium", "puppy", "energetic"));
        adoptionManagement.addAdopterPreferences(new AdopterPreferences("Cat", "small", "adult", "calm"));
        
        System.out.println("Creating shelter");
        ShelterManagement shelter = new ShelterManagement();
        System.out.println("Adding staff members");
        StaffMember veterinarian = new StaffMember("Dr. Smith", StaffRole.VETERINARIAN);
        shelter.addStaffMember(veterinarian);
        StaffMember technicion = new StaffMember("Alice Johnson", StaffRole.TECHNICIAN);
        shelter.addStaffMember(technicion);
        StaffMember counseler = new StaffMember("Bob Brown", StaffRole.COUNSELOR);
        shelter.addStaffMember(counseler);

        System.out.println("Adding the core animals");
        shelter.addPet(PetFactory.createPet("Dog", animalIdCounter++, "Bugger", 0,
            "Healthy", "SZ-001", IntakeType.STRAY));
        shelter.addPet(PetFactory.createPet("Cat", animalIdCounter++, "Jerry", MAGIC_AGE_5, 
            "Sick", "SZ-002", IntakeType.SURRENDER));
        shelter.addPet(PetFactory.createPet("Dog", animalIdCounter++, "Ralf", MAGIC_AGE_5, 
            "Healthy", "SZ-003", IntakeType.STRAY));
        shelter.addPet(PetFactory.createPet("Cat", animalIdCounter++, "George", MAGIC_AGE_1, 
            "Healthy", "SZ-001", IntakeType.TRANSFER));
        shelter.addPet(PetFactory.createPet("Rabbit", animalIdCounter++, "Hopper", MAGIC_AGE_2, 
            "Healthy", "SZ-002", IntakeType.SURRENDER));
        System.out.println("Changing core animals from intake to review to clear to avaiable");
        for (Pet pet : shelter.getPets()) {
            shelter.filterStaffByRole(StaffRole.TECHNICIAN).get(rand.nextInt(
                shelter.filterStaffByRole(StaffRole.TECHNICIAN).size())).performJob(pet);
            shelter.filterStaffByRole(StaffRole.VETERINARIAN).get(rand.nextInt(
                    shelter.filterStaffByRole(StaffRole.VETERINARIAN).size())).performJob(pet);
        }

        System.out.println("Allow for new animal arrivals");
        shelter.addPet(PetFactory.createPet("Dog", animalIdCounter++, "Hey You", MAGIC_AGE_3, 
            "Healthy", "SZ-001", IntakeType.STRAY));
        shelter.addPet(PetFactory.createPet("Cat", animalIdCounter++, "Wizard", MAGIC_AGE_2, 
            "Sick", "SZ-002", IntakeType.SURRENDER));
        shelter.addPet(PetFactory.createPet("Rabbit", animalIdCounter++, "Dinner", MAGIC_AGE_1, 
            "Healthy", "SZ-003", IntakeType.TRANSFER));

        System.out.println("Display all Pets");
        shelter.displayPets();
        System.out.println("Attempting to match animals");
        adoptionManagement.matchAdoptersToPets(shelter.filterStaffByRole(StaffRole.COUNSELOR).get(rand.nextInt(
            shelter.filterStaffByRole(StaffRole.COUNSELOR).size())), shelter.getPets());
        System.out.println("Display all Pets");
        shelter.displayPets();
    }
}