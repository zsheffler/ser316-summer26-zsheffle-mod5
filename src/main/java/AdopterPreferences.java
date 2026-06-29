public class AdopterPreferences {
    private String species;      // Preferred species (e.g., dog, cat)
    private String size;         // Preferred size (e.g., small, medium, large)
    private String ageRange;     // Preferred age range (e.g., puppy, adult, senior)
    private String temperament;   // Preferred temperament (e.g., friendly, energetic, calm)

    /** Constructor */
    public AdopterPreferences(String species, String size, String ageRange, String temperament) {
        this.species = species;
        this.size = size;
        this.ageRange = ageRange;
        this.temperament = temperament;
    }

    /** Get Species*/
    public String getSpecies() {
        return species;
    }

    /** Get size*/
    public String getSize() {
        return size;
    }

    /** Get ageRange*/
    public String getAgeRange() {
        return ageRange;
    }

    /** Get temperament*/
    public String getTemperament() {
        return temperament;
    }

    @Override
    public String toString() {
        return "AdopterPreferences [Species=" + species + ", Size=" + size +
               ", Age Range=" + ageRange + ", Temperament=" + temperament + "]";
    }
}