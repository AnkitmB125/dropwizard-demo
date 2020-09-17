package org.ankit.resources;

import com.codahale.metrics.annotation.Timed;
import org.ankit.data.Person;
import org.ankit.persistence.PersonDB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
public class PersonService {

    public PersonService() {
    }

    @GET
    @Timed
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPerson() {
        return PersonDB.getAll();
    }

    @GET
    @Timed
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("id") int id) {
        return PersonDB.getById(id);
    }

    @POST
    @Timed
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String savePerson(Person person) {
        return PersonDB.save(person);
    }

    @DELETE
    @Timed
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePerson(@PathParam("id") int id) {
        return PersonDB.delete(id);
    }

}
