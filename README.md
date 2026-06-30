Project Overview: Pet Shelter
The Pet Shelter project is designed to manage the intake, care, and adoption of animals in a shelter environment. The focus is to create an efficient system for tracking animal information, managing staff responsibilities, and facilitating the adoption process. This system will ensure that animals receive the proper care they need and that adopters can find suitable pets based on their preferences.


Planned Design Patterns
Factory Pattern:
Reason for Implementation: The Factory Pattern will help in creating objects without specifying the exact class of object that will be created. This is particularly useful for creating different types of pets (e.g., dogs, cats) or user roles (e.g., staff, volunteers) in the system. By using a factory, one can encapsulate the instantiation logic and make it easier to manage and extend in the future.

State Pattern:
Reason for Implementation: The State Pattern allows an object to alter its behavior when its internal state changes. In the context of the Pet Shelter, this could be applied to the adoption process where a pet can be in different states (e.g., available, under review, adopted). This pattern will help manage the transitions between these states cleanly and maintain the logic associated with each state.


Integration Strategy
Factory Pattern Integration:
Create a PetFactory class that will handle the creation of different pet types. For example, when a new pet is added, the factory can instantiate a Dog or Cat object based on the input parameters.

State Pattern Integration:
Implement a PetState interface with concrete classes like AvailableState, UnderReviewState, and AdoptedState. The Pet class will have a reference to a PetState object, and it will delegate state-specific behavior to this object. When the state changes (e.g., when a pet is adopted), the Pet object will switch to the appropriate state.

Benefits of Using Factory and State Patterns

Decoupling: Both patterns promote loose coupling in code. The Factory Pattern decouples the creation of objects from their usage, while the State Pattern decouples the behavior of an object from its state.

Maintainability: Changes in the creation logic or state management can be made independently, making your system easier to maintain and extend.

Clarity: The use of these patterns can make your code more readable and understandable, as the responsibilities are clearly defined.


Requirements Focus:

R1. Core Animals and Intake:
R1.1: Animal Management
R1.1.1: Start with at least 5 core animals.
Each animal will have the following attributes:
ID (unique integer for each animal)
Species (e.g., dog, cat)
Age (in years, integer)
Health Status (string, e.g., healthy, sick)
Shelter Zone Code (format: SZ-XXX, where XXX is a three-digit number, allowing for clear grouping and identification within the shelter)
Adaptation: The Shelter Zone Code helps staff easily locate animals within the shelter, enhancing operational efficiency.

R1.2: Intake Process
R1.2.1: Allow for new animal arrivals during the simulation:
Types of intake:
Stray (found animals)
Surrender (owner relinquishing the animal)
Transfer (from another shelter)
Adaptation: This flexibility allows the shelter to respond dynamically to the needs of the community and ensures they can adjust to changing animal populations effectively.

R1.3: Animal Status Tracking
R1.3.1: Maintain a simple status for each animal:
Status options:
Intake
Available
Pending
Adopted
Adaptation: This clear status tracking allows for better management of animal care and facilitates smoother interactions when assessing animals for potential adopters.

R2. People and Assignments:
R2.1: Staff Management
R2.1.1: Define at least two staff roles:
Veterinarian (responsible for animal health)
Technician (supports medical and care tasks)
Counselor (handles adoptions and interactions)
Adaptation: Specifying these roles ensures clear accountability within the organization, helping improve adoption rates and animal welfare.

R3. Adoption and Matching:
R3.1: Adopter Preferences
R3.1.1: Collect and store basic preferences from adopters:
Species, Size, Age Range, Temperament.
Adaptation: Gathering preferences helps create a tailored experience for adopters, improving satisfaction and increasing the likelihood of successful adoptions.

R3.2: Matching Process
R3.2.1: Develop a matching system that compares adopter preferences with available animals.
R3.2.2: Update adoption status:
When a match occurs, update the animal status to "pending" and further to "adopted" upon successful adoption.
Adaptation: This automated matching system streamlines the adoption process, ensuring that suitable pets are paired with potential adopters efficiently.

R3.3: Adoption Outcomes
R3.3.1: Handle outcomes of the adoption:
Record the outcome as successful or failed (returned animals).
Adaptation: Capturing these outcomes allows for better analysis of adoption trends and helps identify areas for improvement in the adoption process.


Concerns/Questions:
How much of this is to be working for delB?







Documentation


Code Coverage 65%
R1. Core Animals and Intake:
R1.1: Animal Management
    Compleated through concreat Class Pet, and PetStatte
R1.1.1: Start with at least 5 core animals.
    Compleated through class Main in function main under comment "Adding the core animals"
Each animal will have the following attributes:
ID (unique integer for each animal)
    Compleated through pet.id, when construction occurs in pet.petFactory recived through Main.main.animalIdCounter.  It is used in the call to assign the uniqe id by post incrementing
Species (e.g., dog, cat)
    Compleated through pet.petFactory creating the concreate Pet class through the petType passed in.  the function is defined in the concreate classes.
Age (in years, integer)
    Compleated through pet.age, when construction occurs in pet.petFactory recived through Main.main.constants
Health Status (string, e.g., healthy, sick)
    Compleated through pet.healthStatus, when construction occurs in pet.petFactory recived through Main.main.Strings
Shelter Zone Code (format: SZ-XXX, where XXX is a three-digit number, allowing for clear grouping and identification within the shelter)
    Compleated through pet.shelterZoneCode, when construction occurs in pet.petFactory recived through Main.main.Strings

R1.2: Intake Process
R1.2.1: Allow for new animal arrivals during the simulation:
    Compleated through pet.intakeType, when construction occurs in pet.petFactory recived through Main.main enum IntakeType

R1.3: Animal Status Tracking
R1.3.1: Maintain a simple status for each animal:
    Compleated through pet.state, when construction occurs in pet.petFactory recived through Main.main, the defult state is intake.  It changes when the approte transistor is called in the correct state.

R2. People and Assignments:
R2.1: Staff Management
    Compleated through class ShelterManagement.
R2.1.1: Define at least two staff roles:
    Compleated through class StaffMember.StaffRole.enum

R3. Adoption and Matching:
R3.1: Adopter Preferences
    Compleated through class AdoptionManagement.AdopterPreferences.AdopterPreferences
R3.1.1: Collect and store basic preferences from adopters:
    Compleated through class AdoptionManagement.AdopterPreferences.AdopterPreferences when construction occurrs in Main.main.variables

R3.2: Matching Process
R3.2.1: Develop a matching system that compares adopter preferences with available animals.
    Compleated through AdoptionManagement.matchAdoptersToPets which compares supplied prefferances to a list of Pets
R3.2.2: Update adoption status:
    Compleated through AdoptionManagement.matchAdoptersToPets which a staff memeber handles the adoption.

R3.3: Adoption Outcomes
R3.3.1: Handle outcomes of the adoption:
    Compleated through pet.intake when the addoption or fostering fails.

– You must clearly document in your PDF/README which requirements
you fulfilled and how
Functional and Active Simulation:
Include an unused String variable named ’debuggggs’ in your simulation runner class.
– Your project must include a functioning simulation
    Compleated through Main.debuggggs
– Objects must interact dynamically based on requirements
    Random assignments are made during creating, so running the program multipule times may provide different results
– Data in Motion: Create and manipulate objects over time
    Done through PetState
– Events and Actions: Involve events that change system state
    Done through PetState
– Cycle-Based Logic: Use cycles/time intervals to show progression
    Done through PetState state
– Clear Output: Use System.out.println or logging to show:
    Changed comments in Main.main to print out
∗ Current cycle/time step
    Printed out begining with 'Cycle'
∗ When key events occur
    Printed out begining with 'EVENT: '
∗ Status of important objects and state transitions
∗ How design patterns are being utilized (e.g., "Factory creating new X")– Main must run fully automated- we will not have time to interact
during grading

Code Quality (10 points):
• Adhere to coding standards as defined in your Checkstyle configuration
    only 1 code standard not followed becasue this came from your provided examples.
    [ant:checkstyle] [WARN] C:\Users\Owner\OneDrive\Documents\SER 316\repo\ser316-summer26-zsheffle-mod5\src\test\java\WhiteBox.java:7:47: Using the '.*' form of import should be avoided - org.junit.jupiter.api.Assertions.*. [AvoidStarImport]
• Resolve SpotBugs warnings or provide justification for any that remain
    2 remain 
    The first involves random, and the scale from 0 to x is reset, and the bug complains about that.  Becasue 'x' changes i need to discard after one use.
    The second involves allowing access the the pet list.  I could not think of another way to do this in the time I had remaining.  I did not feel it warnted change due to this not being used in the real world.
    
    Bad practice 1 bugs (1/0/0/0)
    Dubious method invocation 1 bugs (1/0/0/0)
    Random object created and used only once ( DMI_RANDOM_USED_ONLY_ONCE ) 1 bugs (1/0/0/0)
    IntakeState since first historized release unspecified
    In class IntakeState
    In method IntakeState.reviewPet(Pet)
    Called method java.util.Random.nextInt(int)
    At PetState.java:[line 22]
    Another occurrence at PetState.java:[line 23]
    Random object created and used only once in IntakeState.reviewPet(Pet)
    This code creates a java.util.Random object, uses it to generate one random number, and then discards the Random object. This produces mediocre quality random numbers and is inefficient. If possible, rewrite the code so that the Random object is created once and saved, and each time a new random number is required invoke a method on the existing Random object to obtain it.

    If it is important that the generated Random numbers not be guessable, you must not create a new Random for each random number; the values are too easily guessable. You should strongly consider using a java.security.SecureRandom instead (and avoid allocating a new SecureRandom for each random number needed).

    Malicious code vulnerability 1 bugs (0/1/0/0)
    Method returning array may expose internal representation 1 bugs (0/1/0/0)
    May expose internal representation by returning reference to mutable object ( EI_EXPOSE_REP ) 1 bugs (0/1/0/0)
    ShelterManagement since first historized release unspecified
    In class ShelterManagement
    In method ShelterManagement.getPets()
    Field ShelterManagement.pets
    At ShelterManagement.java:[line 52]
    ShelterManagement.getPets() may expose internal representation by returning pets
    Returning a reference to a mutable object value stored in one of the object's fields exposes the internal representation of the object.  If instances are accessed by untrusted code, and unchecked changes to the mutable object would compromise security or other important properties, you will need to do something different. Returning a new copy of the object is better approach in many situations.

• Code should be clean, readable, and well-organized
    I believe it is.
Complete README Documentation (4 points):
• Build on your Deliverable A README and add: link to screencast(in repo under Demo.mp4), brief ex
planations of each pattern in your own words

 Design Justification and Process Documentation (16 points):
AI include a very verbose description of each.
• This must be included either in a separate PDF or as a detailed section in your
README
• Include the following sections:
Pattern Selection Rationale (4 points):
– Explain WHY you chose each of the two design patterns
    The Factory Pattern is ideal for creating objects without exposing the instantiation logic to the client. It provides a way to encapsulate object creation in a single place, making the code more flexible and maintainable.
    The State Pattern allows an object to change its behavior when its internal state changes. This is particularly useful in contexts where an object must behave differently based on its current state.
– What problem does each pattern solve in your system?
    Encapsulation of Object Creation: Within an adoption system, different types of animals (e.g., dogs, cats, rabbits) may have different attributes and initialization logic. The Factory Pattern allows for the creation of these objects in a centralized manner, thereby avoiding duplication of object creation code across the application.  
    Mitigation of Code Duplication: By using a factory, we avoid repeatedly writing the instantiation code for each animal type throughout the system, leading to cleaner and more maintainable code.
    Dynamic Behavior Change: In the adoption system, an animal can be in different states (e.g., AVAILABLE, PENDING, ADOPTED, RETURNED). The State Pattern enables these different behaviors (like how an animal’s status affects actions such as adoption or return) to be encapsulated within specific state classes, promoting clear separation of logic.
    Simplifies Complex State Management: Using the State Pattern simplifies the management of state transitions. Instead of having extensive conditional statements scattered across the codebase, the state-specific behavior is self-contained in each state class.
– Why are these patterns a good fit for your specific domain?
    In an animal adoption system, where new animal types or breeds may be added over time, the Factory Pattern makes it easy to incorporate these changes. When a new animal type is introduced (e.g., "Bird"), the factory can easily be updated to accommodate this without affecting existing code. This flexibility is especially useful in a domain where requirements can evolve, allowing new animals to be added with minimal impact on the rest of the system.
    The State Pattern is particularly well-suited to the animal adoption domain where the lifecycle of an animal can involve multiple states. For example, an animal may move from “AVAILABLE” to “PENDING” when matched and further to “ADOPTED” or back to “AVAILABLE” if returned. The State Pattern ensures that the transition logic and behavior associated with each state are cleanly managed, making it easy to maintain and extend the system as additional requirements arise.
Trade-off Analysis (4 points):
– For each pattern, discuss at least one alternative pattern you considered
    In considering design patterns for an animal adoption system, I will conduct a trade-off analysis between the Factory Pattern and an alternative pattern, the Builder Pattern, as well as between the State Pattern and the Strategy Pattern.
– Compare the pros and cons of your chosen pattern vs. the alternative
    Factory Pattern
    Pros:
    Encapsulation of Object Creation: The Factory Pattern centralizes the object creation process, minimizing redundancy in the codebase.
    Flexibility: Making it easy to introduce new product types (e.g., new animal types) without changing the existing codebase.
    Simplified Client Code: Clients do not need to worry about the specifics of how the objects are created.
    Cons:
    Less Control: Clients have less control over the instantiation process since it delegates the creation to the factory.
    Potential for Overhead: Creating a factory class may introduce unnecessary complexity if object creation logic is minimal.
    Builder Pattern
    Pros:
    Step-by-Step Construction: The Builder Pattern provides a way to construct a complex object incrementally.
    Greater Control: It allows for more control over the final object, especially if it has multiple optional parameters.
    Cons:
    More Complex Code: Implementing the Builder Pattern can lead to more complex code, particularly for simpler objects.
    Initialization Time: It may require more time to build an object since the process is broken down into steps.

    State Pattern
    Pros:
    Behavioral Change: The State Pattern allows an object to change its behavior based on its internal state without cluttering the class with state management logic.
    Encapsulation: Each state can be encapsulated within its own class, providing a clear structure and reducing complex conditional statements.
    Cons:
    Overhead of Managing States: The introduction of multiple state classes can lead to increased complexity if the states are numerous and intricate.
    State Transition Complexity: Managing transitions between states may result in additional complexity.
    Strategy Pattern
    Pros:
    Behavior Variability: The Strategy Pattern allows different algorithms to be selected at runtime, which is useful when diverse behaviors are necessary.
    Simple Implementation: It is straightforward to implement and provides flexibility in defining how behaviors are selected and executed.
    Cons:
    Not State Specific: The Strategy Pattern focuses on varying behaviors rather than states. It isn’t designed to manage transitions, making it less suited for scenarios with lifecycle states.
    Potential Redundancy: If the behaviors need to manage shared states, it can lead to redundancy in code as they may need to check the context or state externally.
– Explain why you ultimately chose your selected pattern
    I ultimately chose the Factory Pattern because the primary goal of the animal adoption system is to create different types of animal objects quickly and efficiently without the overhead of dealing with complex instantiation processes. The primary use case does not demand the incremental building of complex objects, so the simplicity and streamlined approach of the Factory Pattern are more beneficial in this context.
    I ultimately chose the State Pattern because, in an animal adoption system, the different states (e.g., AVAILABLE, ADOPTED, RETURNED) are integral to the lifecycle of an animal. The State Pattern accommodates the need for changing behavior based on the animal’s current status, offering a clear and maintainable way to manage state transitions without cluttering the existing classes with numerous conditions.
Design Evolution and Process (4 points):
– Compare your initial design plan (from Deliverable A) to your final implementation
    Initial Design Plan Elements:
    The plan included a simple linear architecture with basic classes for Animal, Adoption, and User.
    The Factory Pattern was proposed to generate various animal types, while the State Pattern was intended to manage the lifecycle states of the animals.
    The design focused on straightforward methods for adopting and returning animals, with minimal consideration for notifications or updates to the users.
    Final Implementation:
    The User was reduced to the class AdoptionManagement and AdopterPreferences.  The Adoption became part of the state machine.  Finially the Animal/Pet class grew to handle most things.
– What changed as you implemented the system? Why?
    Complex State Management: Implementing additional states like "IN FOSTER CARE" added complexity and necessitated improvements in how states transitioned, diverging from the initial focus on just three states.
    User Experience Focus: More user interaction features such as profile management and search filters were integrated, reflecting a shift towards user-centered design and enhancing usability.
– What was the most challenging aspect of making the patterns work together?
    The most challenging aspect of integrating the Factory and State Patterns was ensuring that the state transitions were accurately handled while maintaining the instantiation logic of animals via the factory. Specific challenges included:
        State Initialization: Each state needed to be aware of the animal's current context (like if it can transition to another state), which required deep integration with the Factory's output.
        Behavior Encapsulation: Ensuring that each state class could operate autonomously while still allowing the Animal class to reference and manage these states without becoming overly complex resulted in intricate dependencies that were difficult to manage initially.
– If you could start over, what would you do differently?
    Conduct More Thorough Requirement Analysis: Gathering comprehensive requirements early could have led to a more robust initial design that anticipated the need for user notifications and advanced search features.
    Iterative Prototyping: Instead of defining fixed patterns initially, I would adopt an iterative prototyping approach, allowing for quick adjustments based on user feedback during testing phases.
    Documentation and Planning: I would place greater emphasis on documenting design decisions and drawing diagrams depicting class interactions and state transitions right from the start, which would aid in visualizing the architecture better.
– Include any sketches, diagrams, or notes from your planning process
    I wrote things on the fly.
Resources Used (2 points):
– List resources you used to implement the Design Patterns (beyond slides and lecture videos)
    Google search for how to do bla in Java.
– Explain how these resources influenced your implementation decisions
    I know how to do most things in embedded C.  Writing things in Objects is challaging for me.
– Be specific about what you learned from each resource
Challenges Faced (2 points):
– Describe specific difficulties you encountered
    I was sick for a week, so I only had two days to write this project.
– Explain how you overcame them– Be honest- this shows learning and problem-solving skills!
    Caffine.  Caffine.  and chocolate.  Helped me quickly read through the web search pages on how to do things.
