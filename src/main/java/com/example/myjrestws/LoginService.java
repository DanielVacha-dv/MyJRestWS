package com.example.myjrestws;

import com.example.models.User;
import org.jboss.resteasy.annotations.Form;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/servicelogin")
public class LoginService {

//    @POST
////    @Consumes("application/x-www-form-urlencoded")
//    public String login(@FormParam("email") String e, @FormParam("password") String p) {
//        return "Logged with " + e + " " + p;
//    }

//    @POST
//    public String login(@Form User form) {
//        return "Logged with form " + form.getEmail() + " " + form.getPassword();
//    }
    @POST
    public Response login(@Form User form) {
//        return "Logged with form " + form.getEmail() + " " + form.getPassword();
        Response.ResponseBuilder responseBuilder = Response.temporaryRedirect(URI.create("../bookservlet"));
        return   responseBuilder.build();

    }
}
