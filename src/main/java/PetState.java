import java.util.Random;
interface PetState {
    void intakePet(Pet pet);
    void reviewPet(Pet pet);
    void clearPet(Pet pet);
    void adoptPet(Pet pet);
    void fosterPet(Pet pet);
}

class IntakeState implements PetState {
    String[] temperments = {"friendly", "energetic", "calm", "cautious"};
    String[] sizes = {"toy", "small", "medium", "large", "extra-large"};
    @Override
    public void intakePet(Pet pet) {
        System.out.println(pet.name + " is in shelter " + pet.getShelterZoneCode() + "!");
    }

    @Override
    public void reviewPet(Pet pet) {
        System.out.println(pet.name + " is being examended.");
        Random rand = new Random();
        pet.setSize(sizes[rand.nextInt(sizes.length)]);
        pet.setTemperment(temperments[rand.nextInt(temperments.length)]);
        pet.setState(new UnderReviewState());
    }

    @Override
    public void clearPet(Pet pet) {
        System.out.println(pet.name + " has not been reviewed and cannot be adopted yet.");
    }

    @Override
    public void adoptPet(Pet pet) {
        System.out.println(pet.name + " has not been reviewed and cannot be adopted yet.");
    }

    @Override
    public void fosterPet(Pet pet) {
        System.out.println(pet.name + " has not been reviewed and cannot be fostered yet.");
    }

}

class UnderReviewState implements PetState {
    @Override
    public void intakePet(Pet pet) {
        System.out.println(pet.name + " is already in shelter " + pet.getShelterZoneCode() + "!");
    }

    @Override
    public void reviewPet(Pet pet) {
        System.out.println(pet.name + " is already under review.");
    }

    @Override
    public void clearPet(Pet pet) {
        System.out.println(pet.name + " has been reviewed and is ready to be adopted!");
        pet.setState(new AvailableState());
    }

    @Override
    public void adoptPet(Pet pet) {
        System.out.println(pet.name + " is under review and cannot be adopted yet.");
    }

    @Override
    public void fosterPet(Pet pet) {
        System.out.println(pet.name + " has not been reviewed and cannot be fostered yet.");
    }
}

class AvailableState implements PetState {
    @Override
    public void intakePet(Pet pet) {
        System.out.println(pet.name + " is already in shelter " + pet.getShelterZoneCode() + "!");
    }

    @Override
    public void reviewPet(Pet pet) {
        System.out.println(pet.name + " is under review!");
        pet.setState(new UnderReviewState());
    }

    @Override
    public void clearPet(Pet pet) {
        System.out.println(pet.name + " has not been reviewed and cannot be adopted yet.");
    }

    @Override
    public void adoptPet(Pet pet) {
        System.out.println(pet.name + " is now adopted!");
        pet.setState(new AdoptedState());
    }
    
    @Override
    public void fosterPet(Pet pet) {
        System.out.println(pet.name + " is now being fostered.");
        pet.setState(new FosterState());
    }
}

class FosterState implements PetState {
    @Override
    public void intakePet(Pet pet) {
        System.out.println("We are sorry your pet didn't work out.  " + pet.name + " is now in shelter "
            + pet.getShelterZoneCode() + "!");
        pet.setState(new IntakeState());
    }

    @Override
    public void reviewPet(Pet pet) {
        System.out.println(pet.name + " cannot be reviewed since it is fostereded.");
    }

    @Override
    public void clearPet(Pet pet) {
        System.out.println(pet.name + " is being fostered!");
    }

    @Override
    public void adoptPet(Pet pet) {
        System.out.println(pet.name + " is now adopted!");
        pet.setState(new AdoptedState());
    }

    @Override
    public void fosterPet(Pet pet) {
        System.out.println(pet.name + " is already fostered.");
    }

}

class AdoptedState implements PetState {
    @Override
    public void intakePet(Pet pet) {
        System.out.println("We are sorry your pet didn't work out.  " + pet.name + " is now in shelter "
            + pet.getShelterZoneCode() + "!");
        pet.setState(new IntakeState());
    }

    @Override
    public void reviewPet(Pet pet) {
        System.out.println(pet.name + " cannot be reviewed since it is adopted.");
    }

    @Override
    public void clearPet(Pet pet) {
        System.out.println(pet.name + " is already adopted!");
    }

    @Override
    public void adoptPet(Pet pet) {
        System.out.println(pet.name + " is already adopted!");
    }

    @Override
    public void fosterPet(Pet pet) {
        System.out.println(pet.name + " is already adopted!");
    }
}