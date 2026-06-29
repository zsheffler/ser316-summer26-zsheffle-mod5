import java.util.ArrayList;
import java.util.List;

class ShelterStaffManagement {
    private List<StaffMember> staffMembers = new ArrayList<>();
    private int staffIdCounter = 1; // To ensure unique IDs

    public void addStaffMember(String name, StaffRole role) {
        StaffMember staffMember = new StaffMember(staffIdCounter++, name, role);
        staffMembers.add(staffMember);
        System.out.println(name + " added to staff as " + role);
    }

    public void displayStaffMembers() {
        System.out.println("Current Staff Members:");
        for (StaffMember staff : staffMembers) {
            System.out.println(staff);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ShelterStaffManagement staffManagement = new ShelterStaffManagement();
        
        // Adding staff members
        staffManagement.addStaffMember("Dr. Smith", StaffRole.VETERINARIAN);
        staffManagement.addStaffMember("Alice Johnson", StaffRole.TECHNICIAN);
        staffManagement.addStaffMember("Bob Brown", StaffRole.COUNSELOR);
        
        // Display staff members
        staffManagement.displayStaffMembers();
    }
}