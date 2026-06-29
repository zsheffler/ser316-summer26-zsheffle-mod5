class StaffMember {
    private String name;
    private StaffRole role;
    private int id; // Unique identifier for each staff member
    private int idcnt = 1;
    // Constructor
    public StaffMember(int id, String name, StaffRole role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public StaffMember(String name, StaffRole role) {
        this.id = idcnt++;
        this.name = name;
        this.role = role;
    }
    
    public void performJob(Pet pet) {
        switch (role) {
            case VETERINARIAN:
                examineAnimal(pet);
                break;
            case TECHNICIAN:
                assistAnimalCare(pet);
                break;
            case COUNSELOR:
                if (pet.getState().getClass() == AvailableState.class) {
                    handleAdoption(pet);
                } else {
                    handleIntake(pet);
                }
                break;
            default:
                System.out.println("Role not recognized.");
        }
    }
    private void examineAnimal(Pet pet) {
        System.out.println(name + " (Veterinarian) is examining " + pet.getSpecies());
        // Simulate a health check
        pet.clear();
        pet.setHealthStatus("Healthy");
    }

    private void assistAnimalCare(Pet pet) {
        System.out.println(name + " (Technician) is assisting with care for " + pet.getSpecies());
        // Simulate routine care
        pet.review();
        pet.setHealthStatus("Well-fed and clean");
    }

    private void handleAdoption(Pet pet) {
        System.out.println(name + " (Counselor) is handling adoption for " + pet.getSpecies());
        // Simulate the adoption process
        pet.adopt();
    }

    private void handleIntake(Pet pet) {
        System.out.println(name + " (Counselor) is handling intake for " + pet.getSpecies());
        pet.intake();
    }


    // Getters
    public String getName() {
        return name;
    }

    public StaffRole getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StaffMember [ID=" + id + ", Name=" + name + ", Role=" + role + "]";
    }
}