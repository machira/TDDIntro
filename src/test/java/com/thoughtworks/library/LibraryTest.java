package com.thoughtworks.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    PrintStream printStream;
    DateTimeFormatter dateTimeFormatter;
    List<String> books;
    Library library;

    @Before
    public void setUp(){
        books = new ArrayList<>();
        String title = "Book Title";
        books.add(title);
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        library = new Library(books, printStream, dateTimeFormatter);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        library.listBooks();
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Library library = new Library(new ArrayList<String>(0),printStream,null);
        library.listBooks();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        books.add("Second Book");
        library.listBooks();
        verify(printStream, times(2)).println(anyString());
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldDisplayFormattedTime() {
        DateTime time = new DateTime();
        when(dateTimeFormatter.print(time)).thenReturn("FormattedTimeString");
        library.welcome(time);
        verify(dateTimeFormatter).print(time);
    }

    @Test
    public void shouldDisplayFormattedTimeWhenItIsAnEmptyString() {

        // implement me
    }
}