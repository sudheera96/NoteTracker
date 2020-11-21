## App Name: NoteTracker
## App Logo:
![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/App%20Icon.jpeg)
## Team Members 

<table>
<td align="center"><a href="https://github.com/sudheera96"><img src="https://avatars3.githubusercontent.com/u/22390581?s=460&u=e2a3ccb663ae34048a4c2233bb9a530d2de29a9c&v=4" width="100px;" alt=""/><br /><sub><b>Sri Sudheera Chitipolu</b></sub></a><br /><a href="https://github.com/sudheera96/NoteTracker/blob/master/docs/Sudheeracommits.md">Commits</a></td>
    
<td align="center"><a href="https://github.com/KHARIKA17"><img src="https://avatars2.githubusercontent.com/u/60010885?s=400&v=4" width="100px;" alt=""/><br /><sub><b>Harika Kulkarni</b></sub></a><br />
<a href="https://github.com/sudheera96/NoteTracker/blob/master/docs/Harika_Commits.md">Commits<a/></td>

<td align="center"><a href="https://github.com/Saikrishna1545"><img src="https://avatars1.githubusercontent.com/u/60013018?s=460&u=4687be0646ecbb59bd281276c302eba966ff5f64&v=4" width="100px;" alt=""/><br /><sub><b>Sai Krishna Emmadishetty</b></sub></a><br /></td>

<td align="center"><a href="https://github.com/Rajeshwari-Rudra"><img src="https://avatars1.githubusercontent.com/u/60014358?s=460&u=b6e1e1ffa7551e5140b5a565a73ba572c362addc&v=4" width="100px;" alt=""/><br /><sub><b>Rajeshwari Rudravaram</b></sub></a><br /><a href="https://github.com/sudheera96/NoteTracker/blob/master/docs/RajeshwariCommits.md">Commits</a></td>
  
</table>

## Note Tracker Application Work flow

![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/workflow.png)

We can create assignments logs when we open the app. For doing those assignments at a particular time, we can add alarm. So when we get the alarm remainder and we can also track th time taken to complete that particular assignment. Also, After creating an assignment log, we can even add due date and due time and priority.

## Note Tracker Application user stories

1. As a user, I want to open application.
1. As a user, I want to create assignment log, after opening application.
1. As a user, I want to add submission date and time, after creating assignment log. 
1. As a user, I want to set alarm for start doing the assignment, after adding submission date and time.
1. As a user, I want to  see notification of alarm on screen.
1. As a user, I want to start the timer for doing the assignment, after getting remainder of alarm.
1. As a user, I want to pause the timer.
1. As a user, I want to stop the timer.
1. As a user, I want to prioritize the assignment log as High(l), Medium(ll), Low(lll)
1. As a user, I want to move back to first activity of app from second activity
1. As a user, I want to add more assignment logs.
1. As a user, I want to see all my assignment logs without due date and time, alarm, priority and with due date and time, alarm, priority.
1. As a user, I want to delete my assignment log.

## Risks:
In this Note Tracker android application we are not using any outside API.

## FireBase:
We are using Firebase as database for our android App.Firebase is a real time database and open source.We are using Firebase to store our TodoList items,due dates, due times, priorities, alarm, and timer.

## Instructions to use this App: 

After opening the app, user has to enter the his/her todo list work. Then user need to click on add item for displaying that todolist as a list. If the user wants to remove the added item, then user has to give long press on that item for deleting. After deletion a toast message will be display that item had deleted. For giving the due date and due time, alarm, priority for that item,user has to click on the item,it will redirect to second activity. In the second activity, user will be able to see the created item name, for that selected item, user can set due date by clicking on due date and time icon.Also user can set alarm by clicking alarm icon. For selecting the priority to any item , user has to select either |, || or |||. To check whether item has dates, priority, alarm user has to clcik on back arrow in second activity for going into first activity. So after reaching the first activity user can see the ltem along with due dates,priority. When user gets alarm notification,user will be able to see notification with the item name on screen. Then user can open the app again to start working on that item. Also user can keep track of time how long the work took to compelete by clicking on the timer. Here user can stop and pause and play the timer according to their convenience.


## Note Tracker Activities 

User has to click on the icon of Notetracker app if he/she wants to get into the app on any android device 

![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/App%20on%20Phone%20Screen.jpeg)

### Activity 1

- If a user creates an activity in to-do list of Note Tracker then the following layouts of this app are displayed.
- After entering the list of activities into list, the assignment log will display as

  ![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/itemlist.png)
  
   
- If a user deletes a list from an activity then a message will be displayed as "Item is removed."


 ![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/After%20Delete.jpeg)
 
 
- After creating a item in to-do list of Note Tracker then user can click on that item for moving into next activity

 
### Activity 2 

After going into an Activity 2 of the respective created item, the user can select due date and due time 


![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/SetDue%20Date%20Screen.jpeg)


![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/SetDue%20Time%20Screen.jpeg)


Then user can even set an alarm of that particular task by selecting date and time.


![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/SetAlarm%20Date%20Screen.jpeg)


![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/SetAlarm%20Time%20Screen.jpeg)


Also user can assign priority to the item.


![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/Alarm%20Screen.jpeg)


As we can see from above image, there is timer where user can use the timer to track his/her time of that item.


After setting alarm, user can able to see his/her notification of alarm on screen


![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/Alarm%20Screen.jpeg)


If a user wants to check whether the item had due date, due time, set alarm, priority he/she can go to the first activity,where priority, alarm due date and time will be displayed.

![](https://raw.githubusercontent.com/sudheera96/NoteTracker/master/docs/Home%20Screen.jpeg)


## Instructions to run this app on your local machine

- Get fresh code.
- Pull fresh code. (Fork & clone if this is the first time.)

### Steps for cloning repository using command line

- On GitHub, navigate to the main page of the repository
- Click "Code" on main page repository which is above the list of files.
- Here we can clone using HTTPS and SSH.Click the respective tabs and copy the URL provided.
- Now open Git Bash.(necessary tools should be installed)
- Change the current working directory to the location where we want the cloned directory.
- Type "git clone", and then paste the URL copied earlier.
- Press "Enter" to create your local clone.
- Then open this folder using "Android Studio" and then run this app using emulator.

## Supported Devices

- It works on all android devices
- Android 5.0(Lollipop) and above versions
- Minimum SDK version is 21 and target SDK version 29

## References
[Timer](https://www.youtube.com/watch?v=3G_dsFv2n6M)

[Back Arrow](https://www.youtube.com/watch?v=IrJ8Hzuz2LU)

[Datepicker and Timepicker](https://www.youtube.com/watch?v=hwe1abDO2Ag)

[App icon](https://www.youtube.com/watch?v=DQ8HDL-X9rM)

[Firebase](https://www.youtube.com/watch?v=wa8OrQ_e76M)


