import io.restassured.http.ContentType;
import org.junit.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class MailboxAPITests {

    @Test
    public void listMessageUID23() {
        get("http://localhost:4567/v1/messages/23")
                .then()
                .statusCode(200)
                .assertThat()
                .body("sender", containsString("Virgina Woolf"));
    }

    @Test
    public void listAllMessages() {
        get("http://localhost:4567/v1/messages")
                .then()
                .statusCode(200);
    }

    @Test
    public void listMessageUID999 () {
        get("http://localhost:4567/v1/messages/23")
                .then()
                .statusCode(404);
    }

    @Test
    public void archiveMessageUID23 () {
        given().contentType(ContentType.JSON)
                .body("{read: true}")
                .patch("http://localhost:4567/v1/messages/23").then().statusCode(200);
    }


    @Test
    public void listAllArchivedMessages () {
        get("http://localhost:4567/v1/messages?archived=true")
                .then()
                .statusCode(200);
    }











}

