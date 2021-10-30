package com.example.myjrestws;

import com.example.db.MyDBFake;
import com.example.models.Book;
import com.example.models.Library;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.jboss.resteasy.annotations.providers.jackson.Formatted;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bookService")
public class BookService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Formatted
    @Path("/addBook")
    public Response insertBook(@FormParam("bookName") final String bookName, @FormParam("pages") final int pages) {
        Library dbFake = MyDBFake.getDbFake();
        Book n = new Book();
        n.setId(dbFake.getNewId());
        n.setPages(pages);
        n.setName(bookName);
        dbFake.getContent().add(n);
        return Response.status(200).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Formatted
    @Path("/deleteBook")
    public Response deleteBook(@QueryParam("idToDelete") final int id) {
        Library dbFake = MyDBFake.getDbFake();
        Book b = dbFake.getContent().stream().filter(el -> el.getId() == id).findFirst().orElse(null);
        if (b != null) {
            dbFake.getContent().remove(b);
        }
        return Response.status(200).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Formatted
    @Path("/getAllBook")
    public Response getAllBook() {
        Library dbFake = MyDBFake.getDbFake();
        return Response.status(200).entity(dbFake).build();
    }
}
