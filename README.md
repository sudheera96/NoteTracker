## NoteTracker

## Note Tracker Application Work flow

![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/workflow.png)

We can create assignments logs when we open the app. For doing those assignments at a particular time, we can add a remainder alert with the message and also with sound (advanced feature). Even we can share our assignment log with someone. So when we get the remainder alert, we can start the timer to check how long the assignment takes time to complete. Also, After creating an assignment log, we can even add submission date and time. 

## Note Tracker Application user stories

1. As a user, I want to open application.
1. As a user, I want to create assignment log, after opening application.
1. As a user, I want to add submission date and time, after creating assignment log. 
1. As a user, I want to set alert for start doing the assignment, after adding submission date and time.
1. As a user, I want to provide message, for displaying alert with sound and message on screen.
1. As a user, I want to start the timer for doing the assignment, after getting remainder of alert.
1. As a user, I want to pause the timer.
1. As a user, I want to stop the timer.
1. As a user, I want to prioritize the assignment log as High, Medium, Low
1. As a user, I want to share my assignment log.
1. As a user, I want to move back to first activity of app from creating assignment log.
1. As a user, I want to add more assignment logs.
1. As a user, I want to see all my assigment logs.
1. As a user, I want to delete my assignment log.

## Risks:
In this Note Tracker android application we are not using any outside API as of now.

## FireBase:
We are using Firebase as database for our android App.Firebase is a real time database and open source.We are using Firebase to store our TodoList items.

## Note Tracker Activities 

User has to click on the icon of Notetracker app if he/she wants to get into the app on any android device 

![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/App%20on%20Phone%20Screen.jpeg)

### Activity 1

- If a user creates an activity in to-do list of Note Tracker then the following layouts of this app are displayed.
- After entering the list of activities into list, the assignment log will display as

  ![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/itemlist.png)
  
   
- If a user delets a list from an activity then a message will be displayed as "Item is removed."


 ![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/After%20Delete.jpeg)
 
 
- After creating a item in to-do list of Note Tracker then user can click on that item for moving into next activity

 
### Activity 2 

After going into an Activity 2 of the respective created item, the user can select due date and due time 


![](https://github.com/sudheera96/NoteTracker/blob/master/docs/SetDue%20Date%20Screen.jpeg)


![](https://github.com/sudheera96/NoteTracker/blob/master/docs/SetDue%20Time%20Screen.jpeg)


Then user can even set an alarm of that particular task by selecting date and time.


![](https://github.com/sudheera96/NoteTracker/blob/master/docs/SetAlarm%20Date%20Screen.jpeg)


![](https://github.com/sudheera96/NoteTracker/blob/master/docs/SetAlarm%20Time%20Screen.jpeg)


Also user can assign priority to the item.


![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/Alarm%20Screen.jpeg)


As we can see from above image, there is timer where user can use the timer to track his/her time of that item.


After getting alarm noftifaction 


![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/Alarm%20Screen.jpeg)


If a user wants to check whether the item had due date,due time, set alarm, priority he/she can go to the first acitvity,where priority, alarm due date and time will be displayed.

![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/Home%20Screen.jpeg)





