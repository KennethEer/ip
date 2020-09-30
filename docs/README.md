# User Guide

## Getting Started

Ensure you have java 11 installed. Download the jar file.

Change into the directory containing the jar file and 
run the following commands:

`chcp 65001`

`java -Dfile.encoding=UTF-8 -jar IndividualProject.jar`

If the status icons show ? instead of ✘ or ✓, you can change the font in your terminal to NSimSun.

## Features 
* [Adding a todo task](#todotask)
* [Adding an event task](#eventtask)
* [Adding a deadline task](#deadlinetask)
* [Listing all tasks](#list)
* [Marking a task as done](#done)
* [Deleting a task](#delete)
* [Finding tasks](#find)
* [Exiting the program](#exit)

> Note: All commands are case-sensitive

<a name="todotask"></a>
### `todo` - Adding a todo task 
Adds a todo task to the list of tasks

Usage: `todo DESCRIPTION`

Example: `todo study`

Expected Outcome: 
```
______________________________________________________________________
Got it. I've added this task:
  [T][✘] study
Now you have 1 task in the list.
______________________________________________________________________

```

<a name="eventtask"></a>
### `event` - Adding an event task 
Adds an event task to the list of tasks

Usage: `event DESCRIPTION /at DATETIME`

Example: `event running /at 1 Jan 2020 11pm`

Expected Outcome: 
```
______________________________________________________________________
Got it. I've added this task:
  [E][✘] running (at: 1 Jan 2020 11pm)
Now you have 2 tasks in the list.
______________________________________________________________________

```

<a name="deadlinetask"></a>
### `deadline` - Adding a deadline task 
Adds a deadline task to the list of tasks

Usage: `deadline DESCRIPTION /by DATETIME`

Example: `deadline homework /by 12 Feb 2020 3pm`

Expected Outcome: 
```
______________________________________________________________________
Got it. I've added this task:
  [D][✘] homework (by: 12 Feb 2020 3pm)
Now you have 3 tasks in the list.
______________________________________________________________________

```

<a name="list"></a>
### `list` - Listing all tasks 
Displays all the tasks in the list

Usage: `list`

Example: `list`

Expected Outcome: 
```
______________________________________________________________________
Here are the tasks in your list:
1.[T][✘] study
2.[E][✘] running (at: 1 Jan 2020 11pm)
3.[D][✘] homework (by: 12 Feb 2020 3pm)
______________________________________________________________________

```

<a name="done"></a>
### `done` - Marking a task as done 
Marks the task as done

Usage: `done TASK_NUMBER`

Example: `done 1`

Expected Outcome: 
```
______________________________________________________________________
Nice! I've marked this task as done:
[T][✓] study
______________________________________________________________________

```

<a name="delete"></a>
### `delete` - Deleting a task 
Deletes the task from list of tasks

Usage: `delete TASK_NUMBER`

Example: `delete 2`

Expected Outcome: 
```
______________________________________________________________________
Noted. I've removed this task:
  [E][✘] running (at: 1 Jan 2020 11pm)
Now you have 2 tasks in the list.
______________________________________________________________________

```

<a name="find"></a>
### `find` - Finding tasks 
Finds all tasks with matching keyword

Usage: `find KEYWORD`

Example: `find homework`

Expected Outcome: 
```
______________________________________________________________________
Here are the matching tasks in your list:
1.[D][✘] homework (by: 12 Feb 2020 3pm)
2.[T][✘] school homework
______________________________________________________________________

```

<a name="exit"></a>
### `bye` - Exiting the program
Exits the program

Usage: `bye`

Example: `bye`

Expected Outcome: 
```
______________________________________________________________________
Bye. Hope to see you again soon!
______________________________________________________________________

```