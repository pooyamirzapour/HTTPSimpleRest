import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.http.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/")
public class Controller {

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getBooks() throws JsonProcessingException {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("java", "me"));
        bookList.add(new Book("GO", "me"));
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(bookList);
        return Response.status(200).entity(writeValueAsString).build();

    }
}
