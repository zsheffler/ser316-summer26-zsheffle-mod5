import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int animalIdCounter = 1;
        AdoptionManagement adoptionManagement = new AdoptionManagement();

        // Collecting and storing preferences from adopters
        adoptionManagement.addAdopterPreferences(new AdopterPreferences("Dog", "medium", "puppy", "energetic"));
        adoptionManagement.addAdopterPreferences(new AdopterPreferences("Cat", "small", "adult", "calm"));
        
        ShelterManagement shelter = new ShelterManagement();
        // Adding staff members
        StaffMember veterinarian = new StaffMember("Dr. Smith", StaffRole.VETERINARIAN);
        shelter.addStaffMember(veterinarian);
        StaffMember technicion = new StaffMember("Alice Johnson", StaffRole.TECHNICIAN);
        shelter.addStaffMember(technicion);
        StaffMember counseler = new StaffMember("Bob Brown", StaffRole.COUNSELOR);
        shelter.addStaffMember(counseler);

        // Adding the core animals
        shelter.addPet(PetFactory.createPet("Dog", animalIdCounter++, "Bugger", 3, "Healthy", "SZ-001", IntakeType.STRAY));
        shelter.addPet(PetFactory.createPet("Cat", animalIdCounter++, "Jerry", 2, "Sick", "SZ-002", IntakeType.SURRENDER));
        shelter.addPet(PetFactory.createPet("Dog", animalIdCounter++, "Ralf", 5, "Healthy", "SZ-003", IntakeType.STRAY));
        shelter.addPet(PetFactory.createPet("Cat", animalIdCounter++, "George", 1, "Healthy", "SZ-001", IntakeType.TRANSFER));
        shelter.addPet(PetFactory.createPet("Rabbit", animalIdCounter++, "Hopper", 2, "Healthy", "SZ-002", IntakeType.SURRENDER));
        for (Pet pet : shelter.getPets()) {
            shelter.filterStaffByRole(StaffRole.TECHNICIAN).get(rand.nextInt(shelter.filterStaffByRole(StaffRole.TECHNICIAN).size())).performJob(pet);
            shelter.filterStaffByRole(StaffRole.VETERINARIAN).get(rand.nextInt(shelter.filterStaffByRole(StaffRole.VETERINARIAN).size())).performJob(pet);
        }

        // Allow for new animal arrivals
        shelter.addPet(PetFactory.createPet("Dog", animalIdCounter++, "Hey You", 3, "Healthy", "SZ-001", IntakeType.STRAY));
        shelter.addPet(PetFactory.createPet("Cat", animalIdCounter++, "Wizard", 2, "Sick", "SZ-002", IntakeType.SURRENDER));
        shelter.addPet(PetFactory.createPet("Rabbit", animalIdCounter++, "Dinner", 1, "Healthy", "SZ-003", IntakeType.TRANSFER));

        // Display all Pets
        shelter.displayPets();
        //attempt to adopt animals
        adoptionManagement.matchAdoptersToPets(shelter.filterStaffByRole(StaffRole.COUNSELOR).get(rand.nextInt(shelter.filterStaffByRole(StaffRole.COUNSELOR).size())), shelter.getPets());
    }
}