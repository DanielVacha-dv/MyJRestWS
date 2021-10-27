package com.example.myjrestws;

import com.example.db.MyDBFake;
import com.example.models.Book;
import com.example.models.Library;
import org.jboss.resteasy.annotations.providers.jackson.Formatted;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/json")
public class MyXmlResource {

    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    @Formatted
    public Response  hello() {
        Library dbFake = MyDBFake.getDbFake();
        int size = dbFake.getContent().size();
        Book n = new Book();
        n.setPages(size + 1);
        dbFake.getContent().add(n);
        return Response.status(200).entity(dbFake).build();
    }
}