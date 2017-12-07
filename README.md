# games-flood-it
==============
This game starts off with the initial grid of multi colored pixels with color selections on the bottom panel that match the colors in the grid. 

The purpose of the game is to, starting from the top left corner of the grid, connect the adjacent color cell by selecting one of the four colors on the bottom until the whole screen becomes one color in a specified number of moves. 

The grid is filled with random colors using one of 3 algorithms selected by difficulty, where easy gives fills the grid with some contiguous areas to begin with, medium fills the grid with a fully random distribution of colors, and hard fills the grid  in a manner that ensures that no cell will border a cell with the same color.

When a button is clicked, the top-left cell and any cells currently forming a contiguous region with its color will be repainted with that color and the amount of turns left will decrease by 1. 


# Final notes from F17

Currently almost all of the code lives in FloodItGUI.java. This could be refactored to make an object for the grid to make the code more readable and/or robust in the future.

Some known bugs/issues/areas for improvement:
* The message pane, which is used to display feedback on moves, can fill up after a lot of moves have been made. There was some work done to make the panel dynamically scrollable, but that feature is unfinished.
* The algorithm to decide the number of max turns needs work. For example, on high difficulty if there is a high number of colors selected the game will be pretty easy to win.
* There could be work done to add a graphical main menu; currently the menu is a text-based interface in the terminal.
* Test coverage

An example of the game 'Floodit' you can play can be found [here](http://unixpapa.com/floodit/)

project history
===============
```
 W14 | jcneally 4pm | krbriggs, christopherluo | A game where the goal is to get entire board to the same color
```
