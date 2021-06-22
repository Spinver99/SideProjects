import os
import time

currentTime = time.localtime()
if currentTime.tm_hour < 4:
    print("Good morning! It is awfully early to be up, you might need sleep.")
elif currentTime.tm_hour < 10:
    print("Rise and Shine! It's time to make the doughnuts!")
elif currentTime.tm_hour < 12:
    print("Good morning!")
elif currentTime.tm_hour < 17:
    print("Good afternoon!")
else:
    print("Good evening!")
#Outputs MOTD depending on time of day!
print(time.ctime())
#Outputs time
x = 0
while x != 1: #Infinite loop
    choice = input("What is your purpose? ")
    choice = choice.lower()
    #Makes the user input all lower case
    #Long if/ifelse/else

    if choice == "school":
        os.startfile('Outlook')
        os.startfile('microsoft-edge:https://mail.google.com/mail/u/1/#inbox')
        os.startfile('microsoft-edge:https://keep.google.com/u/0/')
        os.startfile('microsoft-edge:https://blackboard.wichita.edu')

    elif choice == "fun":
        os.startfile('Outlook')

    elif choice == "program":
        os.startfile('PATH/TO/MY/IDE')

    elif choice == "end":
        choice = input("Are you sure? (y/n)")
        if choice == "y":
            os.system("shutdown /s /t 15")
        else:
            choice = "end"

    elif choice == "help":
        print("Commands:")
        print("     School")
        print("     Fun")
        print("     Program")
        print("     Help")
        print("     Close")
        print("     End")
        input("Press enter to continue. . .")
    elif choice == "close":
        exit(0)
    else:
        print("Sorry that command is not recognized. Try using \"help\"")
    print("Working. . .")
    time.sleep(2)