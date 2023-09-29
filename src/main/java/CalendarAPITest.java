import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;

public class CalendarAPITest {
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        // use Google's authorized HTTP transport
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        CalendarAPIAccess dataAccess = new CalendarAPIAccess("Calendar API Test", HTTP_TRANSPORT);
        Calendar service = dataAccess.getCalendar();

        // get up to 3 of the next events from the calendar
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("primary")
                .setMaxResults(3)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();

        // list out the events
        List<Event> items = events.getItems();

        // case if there are no events
        if (items.isEmpty()){
            System.out.println("You have no upcoming events");
        }
        else{
            // otherwise iterate through each event
            for(Event event: items){
                // get start day
                DateTime start = event.getStart().getDate();
                // show event in console
                System.out.printf("You have: %s on %s", event.getSummary(), start);
            }
        }

    }
}
