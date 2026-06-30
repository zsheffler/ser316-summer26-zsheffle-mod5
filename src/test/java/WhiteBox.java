import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * White-Box tests
 *
 */
public class WhiteBox {
        private static final int MAGIC_AGE_3 = 3;
        private static final int MAGIC_ID_1 = 1;
        /**
         * TEST 1: Creating a Pet
         */
        @DisplayName("T1: Creating a Pet")
        @Test
        public void testCreatingAPet() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                assertEquals(pet.getSpecies(), "Dog");
                assertEquals(pet.getSize(), "?");
                assertEquals(pet.getTemperament(), "?");                
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'IntakeState'");
                assertEquals(pet.getAge(), MAGIC_AGE_3);
                assertEquals(pet.getAgeRange(), "young");
                assertEquals(pet.getHealthStatus(), "Healthy");
                assertEquals(pet.getShelterZoneCode(), "SZ-001");
                assertEquals(pet.getIntakeType(), IntakeType.STRAY);
                assertEquals(pet.getName(), "Bugger");
        }
        /**
         * TEST 2: Cycle through Pet normal State
         */
        @DisplayName("T2: Cycling through normal Pet States")
        @Test
        public void testCyclingThroughNormalPetStates() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                pet.review();
                assertEquals(pet.getState().getClass(), UnderReviewState.class, 
                        "Created Pet expected to be in 'UnderReviewState'");
                assertNotEquals(pet.getSize(), "?");//values randomly assigned
                assertNotEquals(pet.getTemperament(), "?");//values randomly assigned
                pet.clear();
                assertEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet expected to be in 'AvailableState'");
                pet.adopt();
                assertEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet expected to be in 'AdoptedState'");
        }

        /**
         * TEST 3: Cycle through a fostered Pet State
         */
        @DisplayName("T3: Cycling through fostered Pet States")
        @Test
        public void testCyclingThroughFosterPetStates() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                pet.review();
                pet.clear();
                pet.foster();
                assertEquals(pet.getState().getClass(), FosterState.class, 
                        "Created Pet expected to be in 'FosterState'");
                pet.adopt();
                assertEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet expected to be in 'AdoptedState'");
        }

        /**
         * TEST 4: Returning an adopted Pet 
         */
        @DisplayName("T4: Returning an adopted Pet")
        @Test
        public void testReturningAnAdoptedPetStates() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                pet.review();
                pet.clear();
                pet.adopt();
                pet.intake();
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'IntakeState'");
        }

        /**
         * TEST 5: Returning a fostered Pet State
         */
        @DisplayName("T5: Returning a fostered Pet")
        @Test
        public void testReturningAFosterPetStates() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                pet.review();
                pet.clear();
                pet.foster();
                pet.intake();
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'IntakeState'");
        }
        /**
         * TEST 6: Pet age ranges
         */
        @DisplayName("T6: Changing Pet age ranges")
        @Test
        public void testChangingPetAgeRanges() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", 0, "Healthy",
                         "SZ-001", IntakeType.STRAY);
                assertEquals(pet.getAgeRange(), "puppy");
                pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", Dog.YOUNG + 1, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                assertEquals(pet.getAgeRange(), "young");
                pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", Dog.ADULT + 1, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                assertEquals(pet.getAgeRange(), "adult");
                pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", Dog.SENIOR + 1, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                assertEquals(pet.getAgeRange(), "senior");
                pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", Dog.ANCIENT + 1, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                assertEquals(pet.getAgeRange(), "ancient");
        }

        /**
         * TEST 7: Changing a pets health
         */
        @DisplayName("T6: Changing a pet's health")
        @Test
        public void testChangingPetsHealth() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                pet.setHealthStatus("Dead");
                assertEquals(pet.getHealthStatus(), "Dead");
        }

        /**
         * TEST 8: Incorrect Cycle through an intake Pet States
         */
        @DisplayName("T8: Incorrect Cycle through an intake Pet States")
        @Test
        public void testIncorrectCycleThroughAnIntakePetStates() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                pet.intake();
                assertNotEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet not expected to be in 'UnderReviewState'");
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'IntakeState'");
                pet.clear();
                assertNotEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet not expected to be in 'AvailableState'");
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'IntakeState'");
                pet.adopt();
                assertNotEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet not expected to be in 'AdoptedState'");
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'IntakeState'");
                pet.foster();
                assertNotEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet not expected to be in 'FosterState'");
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'IntakeState'");
        }

        /**
         * TEST 9: Incorrect Cycle through a review Pet States
         */
        @DisplayName("T9: Incorrect Cycle through a review Pet States")
        @Test
        public void testIncorrectCycleThroughAReviewPetStates() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                pet.adopt();
                assertNotEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet not expected to be in 'AdoptedState'");
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'UnderReviewState'");
                pet.foster();
                assertNotEquals(pet.getState().getClass(), FosterState.class, 
                        "Created Pet not expected to be in 'FosterState'");
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'UnderReviewState'");
                pet.intake();
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'UnderReviewState'");
        }

        /**
         * TEST 10: Incorrect Cycle through a clear Pet States
         */
        @DisplayName("T10: Incorrect Cycle through a clear Pet States")
        @Test
        public void testIncorrectCycleThroughAClearPetStates() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                pet.review();
                pet.clear();
                pet.intake();
                assertNotEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet not expected to be in 'IntakeState'");
                assertEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet expected to be in 'AvailableState'");
                pet.review();
                assertNotEquals(pet.getState().getClass(), UnderReviewState.class, 
                        "Created Pet not expected to be in 'UnderReviewState'");
                assertEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet expected to be in 'AvailableState'");
        }

        /**
         * TEST 11: Incorrect Cycle through a fosted Pet States
         */
        @DisplayName("T11: Incorrect Cycle through a fostered Pet States")
        @Test
        public void testIncorrectCycleThroughAFosteredPetStates() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                pet.review();
                pet.clear();
                pet.foster();
                pet.clear();
                assertNotEquals(pet.getState().getClass(), AvailableState.class,
                        "Created Pet not expected to be in 'AvailableState'");
                assertEquals(pet.getState().getClass(), FosterState.class, 
                        "Created Pet expected to be in 'FosterState'");
                pet.review();
                assertNotEquals(pet.getState().getClass(), UnderReviewState.class, 
                        "Created Pet not expected to be in 'UnderReviewState'");
                assertEquals(pet.getState().getClass(), FosterState.class, 
                        "Created Pet expected to be in 'FosterState'");
        }

        /**
         * TEST 12: Incorrect Cycle through an adopted Pet States
         */
        @DisplayName("T12: Incorrect Cycle through an adopted Pet States")
        @Test
        public void testIncorrectCycleThroughAnAdoptedPetStates() {
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                pet.review();
                pet.clear();
                pet.adopt();
                pet.clear();
                assertNotEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet not expected to be in 'AvailableState'");
                assertEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet expected to be in 'AdoptedState'");
                pet.review();
                assertNotEquals(pet.getState().getClass(), UnderReviewState.class, 
                        "Created Pet not expected to be in 'UnderReviewState'");
                assertEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet expected to be in 'AdoptedState'");
                pet.foster();
                assertNotEquals(pet.getState().getClass(), FosterState.class, 
                        "Created Pet not expected to be in 'FosterState'");
                assertEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet expected to be in 'AdoptedState'");

        }

        /**
         * TEST 13: Creating Staff members
         */
        @DisplayName("T13: Creating Staff members")
        @Test public void testCreatingStaffmembers() {
                StaffMember staff = new StaffMember("Dr. Smith", StaffRole.VETERINARIAN);
                assertEquals(staff.getName(), "Dr. Smith");
                assertEquals(staff.getRole(), StaffRole.VETERINARIAN);
        }

        /**
         * TEST 14: VETERINARIAN doing their job
         */
        @DisplayName("T14: VETERINARIAN doing their job")
        @Test public void testveterinarianDoingJob() {
                StaffMember staff = new StaffMember("Dr. Smith", StaffRole.VETERINARIAN);
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                pet.review();
                //clear
                staff.performJob(pet);
                assertEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet expected to be in 'AvailableState'");
                assertEquals(pet.getHealthStatus(), "Healthy");
        }
        /**
         * TEST 15: VETERINARIAN not doing their job
         */
        @DisplayName("T15: VETERINARIAN not doing their job")
        @Test public void testveterinarianNotDoingJob() {
                StaffMember staff = new StaffMember("Dr. Smith", StaffRole.VETERINARIAN);
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                
                //review
                staff.performJob(pet);
                assertNotEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet not expected to be in 'AvailableState'");
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'IntakeState'");
                
                pet.review();
                pet.clear();
                
                //adopt
                staff.performJob(pet);
                assertNotEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet not expected to be in 'AdoptedState'");
                assertEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet expected to be in 'AvailableState'");

                pet.adopt();

                //intake
                staff.performJob(pet);
                assertNotEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet not expected to be in 'IntakeState'");
                assertEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet expected to be in 'AdoptedState'");
                
        }

        /**
         * TEST 16: TECHNICIAN doing their job
         */
        @DisplayName("T16: TECHNICIAN doing their job")
        @Test public void testTechnicianDoingJob() {
                StaffMember staff = new StaffMember("Alice Johnson", StaffRole.TECHNICIAN);
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                //review
                staff.performJob(pet);
                assertEquals(pet.getState().getClass(), UnderReviewState.class, 
                        "Created Pet expected to be in 'UnderReviewState'");
                assertEquals(pet.getHealthStatus(), "Well-fed and clean");

        }
        /**
         * TEST 17: TECHNICIAN not doing their job
         */
        @DisplayName("T17: TECHNICIAN not doing their job")
        @Test public void testTechnicianNotDoingJob() {
                StaffMember staff = new StaffMember("Alice Johnson", StaffRole.TECHNICIAN);
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
               
                pet.review();
                
                //clear
                staff.performJob(pet);
                assertNotEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet not expected to be in 'AvailableState'");
                assertEquals(pet.getState().getClass(), UnderReviewState.class, 
                        "Created Pet expected to be in 'UnderReviewState'");

                pet.clear();
                
                //adopt
                staff.performJob(pet);
                assertNotEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet not expected to be in 'AdoptedState'");
                assertEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet expected to be in 'AvailableState'");

                pet.adopt();

                //intake
                staff.performJob(pet);
                assertNotEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet not expected to be in 'IntakeState'");
                assertEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet expected to be in 'AdoptedState'");

        }
        /**
         * TEST 18: COUNSELOR doing their job
         */
        @DisplayName("T18: COUNSELOR doing their job")
        @Test public void testCounslorDoingJob() {
                StaffMember staff = new StaffMember("Bob Brown", StaffRole.COUNSELOR);
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                pet.review();
                pet.clear();
                //adopt
                staff.performJob(pet);
                assertEquals(pet.getState().getClass(), AdoptedState.class, 
                        "Created Pet expected to be in 'AdoptedState'");
        }
        /**
         * TEST 19: COUNSELOR not doing their job
         */
        @DisplayName("T19: COUNSELOR not doing their job")
        @Test public void testCounslorNotDoingJob() {
                StaffMember staff = new StaffMember("Bob Brown", StaffRole.COUNSELOR);
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
               
                //review
                staff.performJob(pet);
                assertNotEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet not expected to be in 'AvailableState'");
                assertEquals(pet.getState().getClass(), IntakeState.class, 
                        "Created Pet expected to be in 'IntakeState'");

                pet.review();
                
                //clear
                staff.performJob(pet);
                assertNotEquals(pet.getState().getClass(), AvailableState.class, 
                        "Created Pet not expected to be in 'AvailableState'");
                assertEquals(pet.getState().getClass(), UnderReviewState.class, 
                        "Created Pet expected to be in 'UnderReviewState'");
        }

        /**
         * TEST 20: Shealter Management adding pets
         */
        @DisplayName("T20: Shealter Management adding pets")
        @Test public void testShealterManagementAddingPets() {
                ShelterManagement shelter = new ShelterManagement();
                shelter.addPet(PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", MAGIC_AGE_3, "Healthy", 
                        "SZ-001", IntakeType.STRAY));
                for (Pet pet: shelter.getPets()) {
                        assertEquals(pet.getClass(), Dog.class);
                }
        }

        /**
         * TEST 21: Shealter Management adding staff
         */
        @DisplayName("T21: Shealter Management adding staff")
        @Test public void testShealterManagementAddingStaff() {
                ShelterManagement shelter = new ShelterManagement();
                shelter.addStaffMember(new StaffMember("Bob Brown", StaffRole.COUNSELOR));
                for (StaffMember staff: shelter.filterStaffByRole(StaffRole.COUNSELOR)) {
                        assertEquals(staff.getClass(), StaffMember.class);
                }
        }
        /**
         * TEST 22: Creating Adopter Preferences
         */
        @DisplayName("T22: Creating Adopter Preferences")
        @Test public void testCreatingAdopterPreferences() {
                AdopterPreferences preferences = new AdopterPreferences("Dog", "medium", "puppy", 
                        "energetic");

                assertEquals(preferences.getAgeRange(), "puppy");
                assertEquals(preferences.getSize(), "medium");
                assertEquals(preferences.getSpecies(), "Dog");
                assertEquals(preferences.getTemperament(), "energetic");
        }
        /**
         * TEST 23: Matching a pet to an Adopter
         */
        @DisplayName("T23: Matching a pet to an Adopter")
        @Test public void testMatchingPetToAdopter() {
                //create desires
                AdoptionManagement adoptionManagement = new AdoptionManagement();
                adoptionManagement.addAdopterPreferences(new AdopterPreferences("Dog", "medium", "puppy", 
                        "energetic"));
                //create pet
                Pet pet = PetFactory.createPet("Dog", 1, "Bugger", 0, "Healthy",
                         "SZ-001", IntakeType.STRAY);
                pet.review();
                pet.clear();
                pet.setTemperment("energetic");
                pet.setSize("medium");
                List<Pet> pets = new ArrayList<>();
                pets.add(pet);
                //try to match
                adoptionManagement.matchAdoptersToPets(new StaffMember("Bob Brown", StaffRole.COUNSELOR), pets);
                assertEquals(pet.getState().getClass(), AdoptedState.class);
        }
        /**
         * TEST 23: Not Matching a pet to an Adopter
         */
        @DisplayName("T23: Matching a pet to an Adopter")
        @Test public void testNotMatchingPetToAdopter() {
                //create desires
                AdoptionManagement adoptionManagement = new AdoptionManagement();
                adoptionManagement.addAdopterPreferences(new AdopterPreferences("Dog", "medium", "puppy", 
                        "energetic"));
                //create pet
                Pet pet = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", 0, "Healthy", 
                        "SZ-001", IntakeType.STRAY);
                pet.review();
                pet.clear();
                pet.setTemperment("lazy");
                pet.setSize("large");
                List<Pet> pets = new ArrayList<>();
                pets.add(pet);
                //try to match
                adoptionManagement.matchAdoptersToPets(new StaffMember("Bob Brown", StaffRole.COUNSELOR), pets);
                assertNotEquals(pet.getState().getClass(), AdoptedState.class);
        }
        /**
         * TEST 24: adopting a pet through a shelter
         */
        @DisplayName("T24: Adopting a pet through a shelter")
        @Test public void testAdoptingPetThroughShelter() {
                //creating desires
                AdoptionManagement adoptionManagement = new AdoptionManagement();
                adoptionManagement.addAdopterPreferences(new AdopterPreferences("Dog", "medium", "puppy", 
                        "energetic"));

                //Creating shelter
                ShelterManagement shelter = new ShelterManagement();
                // Adding staff members
                shelter.addStaffMember(new StaffMember("Dr. Smith", StaffRole.VETERINARIAN));
                shelter.addStaffMember(new StaffMember("Alice Johnson", StaffRole.TECHNICIAN));
                shelter.addStaffMember(new StaffMember("Bob Brown", StaffRole.COUNSELOR));

                // Adding the pet to addopt
                Pet pet1 = PetFactory.createPet("Dog", MAGIC_ID_1, "Bugger", 0, "Sick", 
                        "SZ-001", IntakeType.STRAY);
                shelter.addPet(pet1);
                Pet pet2 = PetFactory.createPet("Cat", MAGIC_ID_1 + 1, "Jerry", MAGIC_AGE_3, "Healthy", 
                        "SZ-002", IntakeType.SURRENDER);
                shelter.addPet(pet2);

                //take care of pet1
                shelter.filterStaffByRole(StaffRole.TECHNICIAN).get(0).performJob(pet1);
                shelter.filterStaffByRole(StaffRole.VETERINARIAN).get(0).performJob(pet1);

                //simulating perfect pet1
                pet1.setSize("medium");
                pet1.setTemperment("energetic");

                //attempt to adopt pet1
                adoptionManagement.matchAdoptersToPets(shelter.filterStaffByRole(StaffRole.COUNSELOR).get(0), 
                        shelter.getPets());
                assertEquals(pet1.getState().getClass(), AdoptedState.class);
                assertNotEquals(pet2.getState().getClass(), AdoptedState.class);
        }
}
