## AndroidStudioAPIProject:
School project to consume an API and persist something using the API.  It will use the Volley library to parse the JSON that it gets back from the api.

This project is a joke app that will call out to a joke api and get back a programmer joke.
It will keep track of how many times the api is called and display that as a toast using shared preferences.

## How it works:
When you open the app it will ask you if you wanna hear a joke while displaying a picture of Sans from Undertale because it is fitting for the app.
There will be a yes button and no button.  If you click the yes button it will switch to the yesButton textview which will display another picture of Sans with
the joke as if Sans is the one telling the joke.
If you click no then a picture of an angry Papyrus (another character from Undertale) will pop up asking you why you are here (as in on the textview) 
because the purpose of the app is for jokes from the api.
There will also be a refresh button on the textview that displays when you click yes in case you want a new joke or just don't think the joke it got from the api
was funny enough. this will call the joke function again and display the same textview.

## Known bugs/malfunctions:
So far I'm not sure why but I am missing some files that got lost on the 1st merge so it won't work/let me test it so to run it you will have to pull 
the project files into a working project and run it.
Another thing so far is the text view in the linear layout doesn't change to the other text views when they are called and when you click buttons they don't call the textviews at all.
It gives rendering errors and errors when running it so again you need to pull it into a working project.

## Required tech.:
A working prject to pull it into to run it
Your sanity
Android Studio
Patience
A sense of humor 

## FAQ:
Q: Why does this project require my sanity?
A: Because you're gonna need it to deal with the non-working parts of this project.

Q: How could a project require a sense of humor?
A: Because if you don't have one you won't find the jokes funny or want to use the api

Q: What was your insiration to use Android Studio for this project?
A: Well you see, in terms of inspiration, there is no inspriation.  I used it because of class because it is powerful and good for native android development
but the AVD emulator is the bane of my existence and I had no inspiration from it.

Q: What did you learn from this project?
A: I learned that I hate using the emulator because it doesn't always refresh right and if you lose even 1 file it all breaks and doesn't work right.

## Copywright:
This project isn't copywrighted because I don't know how to copywright something and have no desire to copywright anything I make with Android Studio

## Test Case Instructions:
Open app
Display the textwiew that ask if you wanna hear a joke, a picture of Sans, and the yes and no buttons
Click on one of the buttons
If yes buton clicked:
Grab a joke from the joke api and parse it
go to textview with another picture of Sans and the parsed joke diplayed in it
display refresh button
If refresh button clicked:
Invoke the joke() funtion again for another joke refreshing the textview with a different joke to display
If no button is clicked:
Go to textview of angry Papyrus asking why you are there 

This readme will be updated before being turned in

