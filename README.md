# Software Studio Assignment 6

## Requirement
Write a program to make users perceive the interaction between characters in the movie Star Wars for each episodes (in visualization or audiation). In this program, users expect to understand the network structure, such as the interaction of the two specified characters, in a format other than just texts.
  
  The data set was organized by Evelina Gabasova [1], in JSON format on Github.
  
  
##### Reference
  
[1] Date set: https://github.com/evelinag/StarWars-social-network

## Explanation of the Design

  
##### UML design
  
![UML](/pic/model.png)

  
##### Operation
  
+ Clicking on the button "Add All": users can add all the characters into network to be analyzed.
+ Clicking on the button "Clear": users can remove all the characters from network.
+ Hovering on the character: the name of the character will be revealed.
+ By dragging the little circle and drop it in the big circle, the character will be added to the network.
+ By pressing key 1~7 on the keyboard, users can switch between episodes.

  
##### Visualization
  
+ The width of each link is visualized based on the value of the link.
+ The little circle is animated while dragging / adding to network / deleting from network / auto-arranging in network

  
##### Add node
  
![Add node](/pic/Add.gif)

  
##### Delete node
  
![Delete node](/pic/Delete.gif)

  
##### Add all
  
![Add all](/pic/AddAll.gif)

  
##### Clear
  
![Clear](/pic/Clear.gif)

## Team member & Contribution

TA provided :
+ Main.java

Member 1 : Kuan-Yu Chang (102020009)
+ Component.java
+ DetectMouse.java
+ MainApplet.java
+ Network.java

Member 2 : Louis Huang (103062211)
+ Button.java
+ Node.java
+ NodeLabel.java
