package com.example.myjrestws;


import com.example.db.MyDBFake;
import com.example.models.Book;
import com.example.models.Library;
import org.jboss.resteasy.annotations.providers.jackson.Formatted;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/xml")
public class MyXmlService {

    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    @Produces("application/xml")
    @Formatted
    public Library  hello() {
        Library dbFake = MyDBFake.getDbFake();
        int size = dbFake.getContent().size();
        Book n = new Book();
        n.setBookPages(size + 1);
        dbFake.getContent().add(n);
        return dbFake;
    }
}

