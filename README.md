# Solo Quest: The Climb
**`Quest giver: Elder Blodwyn`**
>Walking... walking... always walking... never efficient.  Need efficiency to keep making these deliveries.  Can you help me with determining what is the best pathway I should be taking over this mountain range?  Save me this time, and I will make deliveries for you as often as you need for free.  

## Quest Overview
This quest has us determine the best pathways through a mountain range.  We must have multiple routes depending on if we want to go forward or forward and back.  It will involve reading data into a 2D array and then calculating the various needs.  There are 403,200 integers representing a 480 row by 844 col grid in our data file.  Each integer is the average elevation in meters of each cell, which will help us achieve our pathfinding ability.

Our pathfinding ability will behave in the following manner as an example.  We begin at the edge of the map (col 0) and proceed forward by taking a step into one of the 3 adjacent cells in the next column over (col 1).  As we are honing our ability we assume that we will choose the cell whose elevation is closest to the elevation of the cell we are standing in (this may mean we are walking uphill or downhill).

If there is a tie with the next step we should always choose to go straight.  If there is a tie between two non-forward locations, we should flip a coin (random number) to choose where to go.

## Objectives Required to complete
### Objective 1 - Designing a Plan
Our design plan should outline the steps being accomplished in each method of our program.  The [design example](designexample.txt) displays a design plan to base the one needed for this project.  When creating a design plan for this project it could be done in either a text file or as a comment on the top of a code file.  Remember design plans should be pushed and requested for approval before coding.

### Objective 2 - Cloning
- Clone this project into IntelliJ
    - remember to place it into a correct folder

### Objective 3 - Branching from the main
- Click on the word "Git" in the bottom left corner of IntelliJ
    - Right-click on the word "main"
    - Choose "New branch from selected"
- On the popup name the branch `dev`
    - Leave the checkmark in "Checkout Branch"
    - Click "Create"

Now we have our `dev` branch, we double-check the bottom right corner it should say `dev`, not main.

We can now work on this `dev` branch.

## Quest Requirements
The bullet points in this section are the bare minimum needed.  There are often times when exact details are missing as it would give away the answer.  Therefore, we should realize that some more work and logic are required with certain steps.

In order to calculate the pathways needed to successfully complete the quest there are 5 parts to complete:

| Part Number      | Description                                              |
| ---------------  | :------------------------------------------------------: |
| Part 1           | Read the data into a 2D array                              |
| Part 2           | Find the min, max, and other calculations needed         |
| Part 3           | Find the lowest elevation change route                   |
| Part 4           | Find the lowest elevation change route from a random row |
| Part 5           | Find the way back route using the correct rules           |

### Objective 1 - TheMountain Class
We will need to create an appropriate class for this lab that will help us with our choice simulation.

- Create a class called `TheMountain`
    - make the class in the following location (-> denotes going to a sub-folder)
        - `src` -> `main` -> `java`
- Create instance variables
    - a 2D array of ints representing the map data
    - other instance variables needed
- Create a constructor that takes three parameters
    - String `filename` of the  dat file with our path data
    - int `rows` for our 2D array
    - int `cols` for our 2D array
    - read in all the data from the dat file and fill up the 2D array appropriately
        - there are no line breaks in the file so reading in an entire line could provide some difficulty depending on how you handle the data
        - looking into using a `Scanner` for reading in the data with `nextInt()` could be beneficial
- Once this constructor is finished it should be debug using the debugger and checked against the original data or friend to make sure the data has been read into the 2D array correctly

The following methods will need implementation in this class:

```Java
int findMin()
```
- return the smallest value in the entire 2D array

```Java
int findMax()
```
- return the largest value in the entire 2D array

```Java
int[] singlyPathway(int row)
```
- return the pathway through the mountain starting at the given row

```Java
int[] doublyPathway(int row, int movement)
```
- return the pathway through the mountain once you reach the end you need to find another pathway back through the mountain
- we are not allowed to take the same pathway back through the mountain
- we need to randomly decide if we move up or down the movement number and then once we have a new starting place we move backward through the mountain following the same rules


```Java
int minRowIndex(int col)
```
- given a column number find the index with the minimum elevation return the row number

```Java
int lowestElevPathway(int row)
```
- return the total elevation change from the
- we should use Math.abs() to get the absolute value for the difference between two elevations
- Since we will be using this going uphill 10 meters is the same as going downhill 10 meters.  This means the running total this returns will be a non-decreasing pretty large positive number


```Java
int lowestElevPathwayIndex()
```
- return the row index of the overall lowest elevation change pathway
- this will need to use the above method for help
- having a loop to generate every outcome from row 0 to 480 should help

**NOTE: if we need a sanity check for this show me you have it working with some output and I will provide you additional information to verify**

### Objective 2 - TheClimb Class
Have this be the Runner class with a main method.  Write some interaction for a user to retrieve various outputs from the methods written in TheMountain class

### Objective 3 - TheMountainTest Class
- Write a minimum of three test cases for three methods in TheMountain class

### Objective 4 - Merging to the main branch and Pushing
- Click on the word "Git" in the bottom left corner of IntelliJ
- Select "main" (it should only say main)
    - Right-click and select "Checkout"
- It should now say "main" in the bottom right corner
- main should also have the checkout tag on it in this "Git" window
- Select the "dev" branch in this Git window
    - Right-click and select "Merge Selected into Current"
- Put a checkmark in the `dev` option
    - The checkmark might not be an option, if it is not that is acceptable
    - Only select the `dev` branch with no other words as this is our local version
- Click the merge button

### Objective 5 - Pushing back to GitHub
- Push all your commits to GitHub on both the main, dev, and any other branches you make
    - It does not hurt to do a final "add and commit" before pushing to verify the latest version is up on GitHub

The committing and pushing process does not change for different branches it is always the same.  If you are confused or struggling with this process please reach out and let me know.

**Note:** Only the code on the main branch will be graded.  It is important to make sure you are happy with your main branch.  You can check if your code is only GitHub by logging in, finding your repo based on the assignment, and checking the commit messages on the page that loads.  These are in the middle column of the little box at the top.  You should see your most recent commit message next to whatever files/folder you pushed.

#### Grading
|   Points     |   Requirement                               |
| :----------: |:------------------------------------------- |
| 5            | design plan                                 |
|10            | data read in from text file correctly       |
| 5            | min() and max() method return correctly     |
|10            | singlyPathway() method correct              |
|10            | doublyPathway() method correct              |
| 5            | minRowIndex() method correct                |
|15            | lowestElevPathway() method correct          |
|15            | lowestElevPathwayIndex() method correct     |
| 5            | unit tests made and working                 |
| 2            | dev branch/more than a single commit made   |