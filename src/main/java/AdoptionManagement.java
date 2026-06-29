import java.util.ArrayList;
import java.util.List;

public class AdoptionManagement {
    private List<AdopterPreferences> adopterPreferencesList = new ArrayList<>();

    /**
     * Groups the addoptors
     * @param preferences
     */
    public void addAdopterPreferences(AdopterPreferences preferences) {
        adopterPreferencesList.add(preferences);
        System.out.println("Adopter preferences added: " + preferences);
    }

    /**Uses Staffmeber to access their class actions, and a list of pets to filter matches */
    public void matchAdoptersToPets(StaffMember staff, List<Pet> pets) {
        for (AdopterPreferences preferences : adopterPreferencesList) {
            for (Pet pet : pets) {
                if (pet.getState().getClass() == AvailableState.class && 
                    petMatchesPreference(pet, preferences)) {
                    System.out.println("Match found: " + pet.getSpecies() + " for " + preferences.getSpecies());
                    staff.performJob(pet);
                }
            }
        }
    }
    /** a helper function for matchAdopters to Pets */
    private boolean petMatchesPreference(Pet pet, AdopterPreferences preferences) {
        return pet.getSpecies().equalsIgnoreCase(preferences.getSpecies()) &&
                pet.getSize().equalsIgnoreCase(preferences.getSize()) &&
                pet.getAgeRange().equalsIgnoreCase(preferences.getAgeRange()) &&
                pet.getTemperament().equalsIgnoreCase(preferences.getTemperament());
    }
}