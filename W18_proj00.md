* (a) A game where the board starts covered randomly with different colors. The objective is to fill the board with one color.

* (b) As a player, I can input the board size, the number of colors, and select from three difficulties to generate a game board.
As a player, I can click buttons with label of color names so that consecutive blocks of the same color starting form the top left are flipped into the selected color.
As a player, I can click the "instructions" button to open a separate window containing a description of the rules of the game.

* (c) The game runs with no noticeable bugs. The user is able to play a complete game with custom parameters.

* (d) As a player, I want to be able to click on an actual square and have the program behave as though I clicked the button corresponding to the color of the selected square.
As a player, I want to be able to have a complete graphical interface without having to deal with command line.
As a player, I want to be presented with options after the game ends so that I can choose to exit or replay the game.

* (e) The README.md describes the game in a good way and includes final notes from the F17 contributors. Things that it lacks may include instructions for running the program and a picture to illustrate what the program looks like. The title for the game description may also need to be updated.

* (f) The project is based on Ant and in the build.xml there are descriptions for all of the targets. However there are some old JWS stuff that would need to be removed.

* (g) The issues add up to well above a 1000 points and we have some ideas of our own for the program so we don't think that will be a problem. From what we read in the issues it seems pretty clear on what's expected for each issue.

* (h) We haven't added any issues of our own yet, but we may do that later.

* (i) The code is functioning and the game is playable. The program consists of three classes: FloodItGUI, FloodItGrid and FloodItInstructGui. In general the code has plenty of comments and from what we've seen so far it's always pretty clear what the code is trying to do. With that said, FloodItGUI could use some refactoring to be a bit more reader friendly. In doing that we could probably get rid of some of the comments using good variable names and creating help methods, in line with the tips we got on refactoring from our guest lecturer.

The FloodItGrid class is a extension of JPanel and setting up the grid for the playing field. The FloodItInstructGui class is only for the instructions window you can pull up from the game window. All the actual code for how the game works is in FloodItGUI together with most of the code for graphics. This makes it quite long and uncomfortable to work with. We would rather have maybe a Controller class where the actual code for the game and how it works is written and then have a separate GUI class for all the graphical stuff.

* (j) There are no tests at all, so we have some work to do there.
