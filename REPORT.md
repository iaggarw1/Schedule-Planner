# Mewtwo Assignment Planner

**Team Members:**
Felipe Martinez, James  Nicholas, Sage Lee, Ishaan Aggarwal
**Project Objectives:**
For college students, We provide a free semester planner program, so that students can plan out their semester with classes, breaks, extra curriculars, and adding their own events.

### Project Design:

**Team Goals:**
- Computer application
- Manual input of assignments
- Drop down list of classes, list of assignments, date its due (with time)
- Clubs and activities should be add-able as well
- Repeatable events
- Essentially a calendar app
- Color organization
- Set icons to select from (to differentiate between types of classes (music, math, science, etc))
- A view that shows all of the classes (displayed in a calendar view), with the ability to select a specific class and only see those assignments
- Also display when going to class as well
- Add an indicator that shows what days there are assignments due (a dot of a specific color)

**Stories: 39 stories for 132 points**

----------------------------------------------------------------------------------------------------------------------------
### Implementation Details:
**Programming languages used:**
Java
Libraries/tools used
Java SDK 8+
Eclipse v2021+
Gradle 7.4.2
JavaFX 18 x64

#### **Challenges and Solutions**
    Challenge #1: FXMLs not properly loading
        Solution: Create a loader, then load the FXML, then set the scene in main.
    Challenge #2: Click registration for the calendar was specific
        Solution: Populated the calendar with rectangles that could be clicked instead of just having to click on the numbers.
    Challenge #3: Having controllers interact and send information to each other
        Solution: Create getters and setters within each controller that interacted with each other and set a specific object stored to a controller
    Challenge #4: Linking assignments to their specific classes
        Solution: Implementing unique ID’s for each class and assignment to identify objects easier.
----------------------------------------------------------------------------------------------------------------------------
## Testing

**Testing Plan and Strategies:**
        We tested our product through traditional methods (using application normally), gradle and 
        JUnit testing to verify functionality. Gradle tested that libraries were working, while JUnit tests 
        targeted specific functions in a more isolated environment. We also tested our code using 
        system.out.println() while running the code to see more easily what the issues were and how 
        to fix them. 

## Test Cases:

**Story #/Name: #3 / Display  Empty Calendar**
    **Tester’s Name: Ishaan**
    **Description of Acceptance Criteria to be followed or Acceptance Test to Perform:**
        Displays a grid of boxes with numbers with days of the week displayed above it
    **Assumptions one needs to make:**
        There are no variations for input, but rather just seeing if the calendar is displayed when the
    program is run.

| Variations     | Expected Results | Comments     | Done     |
| :---        |    :----:   |    :----:   |          ---: |
| Program run      |Grid Printed with numbers and days of the week above       | Displayed calendar, meets criteria   | Y   |

**Story #/Name:Color Picker - Story #8**
**Tester’s Name: Sage**
**Description of Acceptance Criteria to be followed or Acceptance:**
    Color hex code is displayed in console
**Test to Perform:**
    Testing custom colors
**Assumptions one needs to make:**
    Color picker properly opens
    Console not cleared or overridden

| Variations     | Expected Results | Comments     | Done     |
| :---        |    :----:   |    :----:   |          ---: |
| Picking white (top left) through color-picker box      |0xffffffff printed in console above       | Prints correctly   | Y   |
| Entering black (#111111) in Web box      |#111111 printed in console       |0x111111ff, which is the same result | Y   |
| Entering an invalid color (#osvald)      |No output       |Non hex characters not allowed | Y   |

**Story #/Name: #16 / Drop Down List of Icons **
**Tester’s Name: Felipe**
**Description of Acceptance Criteria to be followed or Acceptance:**
    The drop down list should start off with no icon displayed in the down down list selection box.   
    Once a selection is made, the index should be printed in the console and the icon should be 
    displayed in the drop down list selection box. 
**Assumptions one needs to make:**
    Drop down list should start with no selection, displaying no icon. The user should be able to  
    change the selection of icons.

| Variations     | Expected Results | Comments     | Done     |
| :---        |    :----:   |    :----:   |          ---: |
| Select Math Icon                    |Print index 1 console + icon display     | Display + prints correctly | Y   |
| Select Computer Science Icon    |Print index 6 console + icon display     |Display + prints correctly  | Y   |
| Select Art Icon                 |Print index 2 console + icon display    |Display + prints correctly | Y   |

**Story #/Name: #12/ Be able to create Classes**
**Tester’s Name: Ishaan **
**Description of Acceptance Criteria to be followed or Acceptance Test to Perform:**
    Name of classes are displayed in dropdown list on main screen under calendar
**Assumptions one needs to make:**
    Input is Name, Icon, Meeting Time, Duration, Location, Color(Web)
| Variations     | Expected Results | Comments     | Done     |
| :---        |    :----:   |    :----:   |          ---: |
| Math, Math Icon, Monday 4/18/2022 10:00-11:15 AM, 1:15, CTC 113, 0xffffff      |Printed name of Class “Math” as an option in dropdown  | Displayed correctly | Y   |

**Story #/Name: #7 / Make circles that are part of each day we can turn on or off in the future**
**Tester’s Name: Ishaan**
**Description of Acceptance Criteria to be followed or Acceptance Test to Perform:**
    Circles are displayed on calendar when clicking on a day on the calendar.
    Circles are removed when Delete Button is Clicked
    Circles are not removed on memory level, and can be displayed once again through the Draw button

| Variations     | Expected Results | Comments     | Done     |
| :---        |    :----:   |    :----:   |          ---: |
| Clicking on the box of the Calendar  | Cannot invoke "java.lang.Integer.intValue()" because the return value of "javafx.scene.layout.GridPane.getColumnIndex(javafx.scene.Node)" is null Missed the box |Clicking anywhere on the box is finicky, failed the test on adding Circle to calendar   | Y   |
Clicking on border of box on the Calendar | Cannot invoke "java.lang.Integer.intValue()" because the return value of "javafx.scene.layout.GridPane.getColumnIndex(javafx.scene.Node)" is null Missed the box| Clicking on the border drawn for the box gives an error, failed to meet criteria on adding Circle to Calendar|Y

**Story #/Name: Drop Down List of Current Classes - Story #21**
**Tester’s Name: Felipe**
**Description of Acceptance Criteria to be followed or Acceptance Test:**
    The drop down list should start off with no class name displayed in the drop down list selection 
    box. It should not display any classes if no classes have yet been made. Once a class is created 
    and a selection has been made, the name of the class should be printed in the console and the   
    name of the class should be displayed in the drop down list selection box.
**Assumptions one needs to make:**
    Drop down list should start with no selection, displaying no course name. The user should be
    able to change the selection of icons. Once a class is created, all current created classes 
    should be listed in the drop down list.
    
| Variations     | Expected Results | Comments     | Done     |
| :---        |    :----:   |    :----:   |          ---: |
| Select Math course  |Prints math in console + displays course in drop-down| Displayed name of class + printed correctly| Y   |
| Select Computer Science  |Prints computer science in console + displays course in drop-down| Displayed name of class + printed correctly| Y   |
| No classes created  |User should not be able to make a selection, no print in console| Works correctly | Y   |
------------------------------------------------------------------------------------------------------------------------
### Project Highlights:
-The class creation tab within the project seemed daunting at first. New classes, countless dropdown tabs and scene changes needed to be made for it to work properly. Thankfully, we were able to create a product that we were proud of by the end. 
-Figuring out how to allow controllers to communicate with each other was a difficult challenge to overcome. However, after committing some time to research and test a solution, we were able to implement a flexible solution that was applicable to many functions. 
-No one in the group had worked with Javafx or Javafx Scenebuilder before. However, every member was able to research and implement it with relative speed, filling each other’s gaps in understanding when necessary. 

## Things To Be Improved
**Parts of the software that you would improve:**
- Clean up the UI so buttons aren’t smashed together
- Color coding of the application is just basic
- Add more months available to the user

**Parts of your teamwork/process that you would improve on in the future:**
- Weekly meetings were implemented a bit late in the process. If we set a schedule and met more often, it would help us stay accountable and resolve any potential issues.
- Work was being done towards the end of the sprint instead of when we started the sprint. The amount of stories completed were vastly lower than the potential amount of stories that could have been completed.
- Providing more assistance through meetings instead of just through text. If we met through meetings more often, problems could have been resolved faster and we could have a better understanding of what the issue is.

## Lessons Learned
- Have a plan to make the best use of your time with the customer. Have one person assigned to keeping track of notes, and ask as many questions as you need. In addition, creating visuals to demonstrate your understanding of the project is highly recommended, as it will verify the vision for both parties. 
- When working on each part of the project (each issue) make sure to implement it all the way across. That is to say, make sure that each thing you implement can be seen and used by the customer at the end of each sprint

