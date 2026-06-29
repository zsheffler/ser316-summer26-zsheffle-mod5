import java.util.ArrayList;
import java.util.List;

public class ShelterManagement {
    private static List<Pet> pets = new ArrayList<>();// Create a list to hold animals
    private static int animalIdCounter = 1; // To ensure unique IDs
    private List<StaffMember> staffMembers = new ArrayList<>();
    private int staffIdCounter = 1;

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
    public void displayPets() {
        System.out.println("Current Pet in Shelter:");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
        System.out.println();
    }
}



