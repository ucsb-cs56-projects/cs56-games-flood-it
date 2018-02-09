(a) (20 pts) A brief description of the project. Here, I’m looking for a short description: probably 1 sentence, 2-3 at most.

A game where the board starts covered randomly with different colors. The objective is to fill the board with one color.

(b) (20 pts) a set of user stories (as a X I can Y so that Z) that describe what the current software in its current state can do.
First, review how User Stories are supposed to be written.

As a player, I can input the board size, the number of colors, and select from three difficulties to generate a game board.
As a player, I can click buttons with label of color names so that consecutive blocks of the same color starting form the top left are flipped into the selected color.
As a player, I can click the "instructions" button to open a separate window containing a description of the rules of the game.

(c) (20 pts) a brief assessment of whether the software runs or not. If it runs, briefly describe what it does,

It runs perfectly with no noticeable bugs. The user is able to play a complete game with custom parameters.

(d) (20 pts) a set of user stories (at least 2, but you are encouraged to write up to 4 or more if you can, as many as you think is reasonable) about features that COULD be added to the software to make it more useful, fun, better, etc.

As a player, I want to be able to click on an actual square and have the program behave as though I clicked the button corresponding to the color of the selected square.
As a player, I want to be able to have a complete graphical interface without having to deal with command line.
As a player, I want to be presented with options after the game ends so that I can choose to exit or replay the game.

Again, review the preferred way to write User Stories.
(e) (20 pts) An assessment of the current quality of the README.md. What information could be added to make it easier for the next generation of folks maintaining this code to use the software, and/or maintain the software?

The README.md describes the game in a good way and includes final notes from the F17 contributors. Things that it lacks may include instructions for running the program and a picture to illustrate what the program looks like. The title for the game description may also need to be updated.

(f) (20 pts) An assessment of the current state of the build.xml file if applicable, or if the project has been converted to Maven or Gradle, note this.
  If it’s based on Ant, Are there targets that need descriptions? Is there old legacy JWS stuff that needs to be removed? (More on this below).
  It it’s based on Maven or Gradle, is there sufficient documentation in the README.md that someone new to those tools has the information they need to get started?

The project is based on Ant and there are descriptions for all of the targets. However there are some old JWS stuff that would need to be removed.


(g) (20 pts) An assessment of the current “issues”. Are there enough issues that you could earn 1000 points by working on this project? Are the issues clear in terms of what the expectations are?

The issues add up to well above a 1000 points and we have some ideas of our own for the program so we don't think that will be a problem. From what we read in the issues it seems pretty clear on what's expected for each issue.

(h) (20 pts) A list of additional issues that you may have added, if any. For each, a link to the issue is good enough.

We haven't added any issues of our own yet, but we may do that later.

(i) (100 pts) Most important: an assessment of the actual code. Write a bit about how the code is organized. Are the purposes of the classes, and their methods clear? Is it obvious how the classes relate to one another? Is the code easy to read and understand? If you had to give someone else that was going to work on the code just “one screenful of text” to help that programmer get up to speed quickly, what information would you convey?

The code is functioning and the game is playable. The program consists of three classes: FloodItGUI, FloodItGrid and FloodItInstructGui. Overall the code has plenty of comments and from what we've seen so far it's always pretty clear what the code is trying to do. With that said, FloodItGUI could use some refactoring to be a bit more reader friendly. In doing that we could probably get rid of some of the comments using good variable names and creating help methods.

FloodItGrid is a extension of JPanel and setting up the grid for the playing field. The FloodItInstructGui is only for the instructions window you can pull up from the game window. All the actual code for how the game works is in FloodItGUI and this makes it quite long and uncomfortable to work with. We would rather have maybe a Controller class where the actual code for the game and how it works is written and then have a separate GUI class for all the graphical stuff.

(j) (40 pts) Related to code quality, but factored out into a separate issue because it is so important: how is the test coverage? Are there JUnit tests at all? If so, how much of the project is covered by testing? Are there opportunities to expand test coverage, and if so, how would you go about it?

There are no tests at all, so we have some work to do there.
