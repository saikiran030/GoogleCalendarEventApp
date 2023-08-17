# GoogleCalendarEventApp
GoogleCalendarEventApp
Google Calendar Integration

https://console.cloud.google.com/

Create application in google could platform
Enable google calendar api
how to configure consent page
Generate clientid, client secrate

Google cloud platform
select a project -- new project -- create project

APIs Services -- Library -- Select google calendar api -- overview page
overview page --navigate to crendential page -- create credentials  --oauth client id
Configure consent screen -- oauth consent screen -- select external -- create
Edit app registration page -- add app information --save and continue
Select scopes --auth/calendar scope, auth/calendar.events scope --update -- save and continue
Add test user saikiranakula030@gmail.com -- save and continue

*******************************************
OAuth consent screen
User type
External
App name
CalendarTestApp
Support email
saikiranakula030@gmail.com
App logo
Not provided
Application homepage link
Not provided
Application privacy policy link
Not provided
Application terms of service link
Not provided
Authorized domains
Not provided
Contact email addresses
saikiranakula030@gmail.com
Scopes
API
Scope
User-facing description
Google Calendar API	.../auth/calendar	See, edit, share, and permanently delete all the calendars you can access using Google Calendar
Google Calendar API	.../auth/calendar.events	View and edit events on all your calendars
Test users
1 user (1 test, 0 other) / 100 user cap
Filter
User information
saikiranakula030@gmail.com	

*******************************************
Create credentials 
Crendentials tab -- create credentials -- oauth client id -- select application type - web application , application name , redirect url -- create
86228744919-3jof3l362dt7d7o2mg6hf400oc4c4429.apps.googleusercontent.com
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
{"web":{"client_id":"86228744919-3jof3l362dt7d7o2mg6hf400oc4c4429.apps.googleusercontent.com","project_id":"annular-tempo-338006","auth_uri":"https://accounts.google.com/o/oauth2/auth","token_uri":"https://oauth2.googleapis.com/token","auth_provider_x509_cert_url":"https://www.googleapis.com/oauth2/v1/certs","client_secret":"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"}}


--------------------------------------------------
How to authenticate the user using oauth auth
How we can get the user consent
How to get access token and refresh token from user consent

API Documentation
https://developers.google.com/identity/protocols/oauth2

using http request to perform all the actions
Access token 
	-- identify the permissions required for our application	
	-- appln redirect the user to the google auth server with the permission our appln required -- user decide which permission need to grant and which permission  not to grant
	-- redirect back to our appln -- then we can get access token and refresh token 
Obtaining OAuth 2.0 access tokens
The list below quickly summarizes these steps:
	Your application identifies the permissions it needs.
	Your application redirects the user to Google along with the list of requested permissions.
	The user decides whether to grant the permissions to your application.
	Your application finds out what the user decided.
	If the user granted the requested permissions, your application retrieves tokens needed to make API requests on the user's behalf.


Reques --> /auth
code   <--  reponse

Request -->code  /token
access/ refresh token <-- response

Step 1: Set authorization parameters
Google's OAuth 2.0 endpoint is at https://accounts.google.com/o/oauth2/v2/auth.
client_id	Required
redirect_uri	Required
response_type	Required -- code
scope	Required  -- multiple scope separated with space
access_type -- Recommended offline/online 
state	Recommended --

https://accounts.google.com/o/oauth2/v2/auth?
 scope=https%3A//www.googleapis.com/auth/drive.metadata.readonly&
 access_type=offline&
 include_granted_scopes=true&
 response_type=code&
 state=state_parameter_passthrough_value&
 redirect_uri=https%3A//oauth2.example.com/code&
 client_id=client_id
 
Step 5: Exchange authorization code for refresh and access tokens -- post request
https://oauth2.googleapis.com/token
client_id	The client ID obtained from the API Console Credentials page.
client_secret	The client secret obtained from the API Console Credentials page.
code	The authorization code returned from the initial request.
grant_type	As defined in the OAuth 2.0 specification, this field's value must be set to authorization_code.
redirect_uri	One of the redirect URIs listed for your project in the API Console Credentials page for the given client_id.

**response**
access_token	The token that your application sends to authorize a Google API request.
expires_in	The remaining lifetime of the access token in seconds.
refresh_token	A token that you can use to obtain a new access token. Refresh tokens are valid until the user revokes access. Again, this field is only present in this response if you set the access_type parameter to offline in the initial request to Google's authorization server.
scope	The scopes of access granted by the access_token expressed as a list of space-delimited, case-sensitive strings.
token_type	The type of token returned. At this time, this field's value is always set to Bearer.

redirect url:http://localhost:8080/google/authorize

Imp!!!! - Verify the app


-----------------------------------------------------------------------------------------

Refresh And Revoke Access Token
Refreshing an access token (offline access)

access_type : offine -- mandatory to get refresh token
client_id	The client ID obtained from the API Console.
client_secret	The client secret obtained from the API Console.
grant_type	As defined in the OAuth 2.0 specification, this field's value must be set to refresh_token.
refresh_token	The refresh token returned from the authorization code exchange.

POST /token HTTP/1.1
Host: oauth2.googleapis.com
Content-Type: application/x-www-form-urlencoded

client_id=your_client_id&
client_secret=your_client_secret&
refresh_token=refresh_token&
grant_type=refresh_token


{
  "access_token": "1/fFAGRNJru1FTz70BzhT3Zg",
  "expires_in": 3920,
  "scope": "https://www.googleapis.com/auth/drive.metadata.readonly",
  "token_type": "Bearer"
}

appende refresh token and save the file --for future refrence


Revoking a token
https://oauth2.googleapis.com/revoke

curl -d -X -POST --header "Content-type:application/x-www-form-urlencoded" \
        https://oauth2.googleapis.com/revoke?token={token}
		
		
complete documentation : https://developers.google.com/identity/protocols/oauth2/web-server#httprest_1

-------------------------------------------------------------------------------------------------------------------
Create Google Calendar Event

https://developers.google.com/calendar/api/v3/reference/events

POST https://www.googleapis.com/calendar/v3/calendars/calendarId/events
calendarId	string	Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the "primary" keyword.
Primary keyword

Authorization
This request requires authorization with at least one of the following scopes:

Scope
https://www.googleapis.com/auth/calendar
https://www.googleapis.com/auth/calendar.events

Request body  -- end start
In the request body, supply an Events resource with the following properties:

Property name	Value	Description	Notes
Required Properties
end	nested object	The (exclusive) end time of the event. For a recurring event, this is the end time of the first instance.	
start	nested object	The (inclusive) start time of the event. For a recurring event, this is the start time of the first instance.

Generate API_KEY

API_KEY : AIzaSyB_9dyyOsbJajqBRgm-0wrWm0273z_WWJ8
Asia/Kolkata
-------------------------------------------------------------------------------------------------------------------
Events: get
GET https://www.googleapis.com/calendar/v3/calendars/calendarId/events/eventId

calendarId	string	Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the "primary" keyword.
eventId	string	Event identifier.
https://www.googleapis.com/auth/calendar.readonly
https://www.googleapis.com/auth/calendar
https://www.googleapis.com/auth/calendar.events.readonly
https://www.googleapis.com/auth/calendar.events


Events: list

GET https://www.googleapis.com/calendar/v3/calendars/calendarId/events

Response
If successful, this method returns a response body with the following structure:


{
  "kind": "calendar#events",
  "etag": etag,
  "summary": string,
  "description": string,
  "updated": datetime,
  "timeZone": string,
  "accessRole": string,
  "defaultReminders": [
    {
      "method": string,
      "minutes": integer
    }
  ],
  "nextPageToken": string,
  "nextSyncToken": string,
  "items": [
    events Resource
  ]
}

-------------------------------------------------------------------------------------------------------------------
