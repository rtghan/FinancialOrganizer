# Calendar Organizer
A calendar organization tool built with Google's Calendar API 
(documentation @ https://developers.google.com/calendar/api/v3/reference)

## To run the test:
1. Install Gradle at https://gradle.org/
2. At https://console.cloud.google.com/, create a new project, go to APIs & Services, click `Enable APIs and Services`,
find the Google Calendar API, enable it, then click `Create Credentials`, and follow the instructions.
3. On your Google Project page, navigate to the OAuth consent screen and add your email as a test user.
2. Download the JSON file, and rename it to `credentials.json`.
3. After cloning this repo, replace the `CREDENTIAL_FILE_HERE.json` file in `src/main/resources` with your actual credential
file.
4. Then run `gradle run` in the terminal, and authenticate with Google.
5. You can now run the CalendarAPITest class.
