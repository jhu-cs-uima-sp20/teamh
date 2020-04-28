# teamh

Our app currently includes the following features:
Users are able to
- Create pinsets and pins
- Navigate between login page, browse page, saved pinsets page, create/view screens for pins and pinsets,
 and a profile settings page.
- Display the user entered location of a pin (as a string)
- Name pin sets/pins
- Add descriptions to their pins and pinsets
- Have a default picture for pin sets/pins

Sprint 2 Notes:

General Info:
API Key: AIzaSyC4Kk1-uikWbHWvcltTrCSG9q8Zv8qjzzk
(Please insert this value into “API_KEY” in @strings)

Ayden: For this Sprint, I implemented the swipe to delete functionality and changed the swipe to mark visited to a button to mark visited as well as implementing that. I also added an undo snackbar for the deletions instead of a confirmation dialog. I added two tabs to the nav bar, since we decided to separate the user’s own pinsets vs their followed pinsets, and then another tab for the maps. I migrated the project to a min SDK of 18 and target of 28 so that it would be able to run on older platforms. I updated various miscellaneous stuff like drawables and wording.

Anthony/AJ: For this sprint, I implemented our followed fragments page, and also separated pins from saved/followed based on if they are owned by the current user. I also cleaned up several basic functions that were hardcoded for our first sprint, like displaying number of pins on the recyclerview. Lots of bug fixing.

Michael:
For this sprint, I was focused on implementing the geolocation and map functionality of our app. I used the Google Places API to grab the coordinates from any location that the user searches up and saved these to the corresponding pin. I then used the Google Maps API to display the pins (of one pinset at a time) for the user. 

Adam: 
For this sprint I was working on firebase and local data storage to track user logins and to keep pin and pinset info. It took me longer than expected to figure out how to interface the java and the SQL but these features are expected to be implemented in the near future. 

Sprint 2 Meeting Notes:
4/13: Assigned individual tasks for sprint two. Michael was assigned to implementing the map functionality, Ayden to deleting and marking pins/pinsets as viewed, AJ to implementing the search function/browsing public pinsets tab, Adam to implementing Firebase functionality
4/15: (Meeting with Sadie)
4/20: Checking in on progress with everyone. We helped each other with a few technical issues that came up throughout the week.
4/22: (Meeting with Sadie) 
4/27: Finished debugging our sprint two implementation. Recorded our class presentation.
