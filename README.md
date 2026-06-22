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