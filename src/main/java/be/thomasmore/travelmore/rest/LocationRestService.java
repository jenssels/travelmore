package be.thomasmore.travelmore.rest;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/locations")
public class LocationRestService {

    @Inject
    private LocatieService locatieService;

    @GET
    @Path("/getlocation")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Locatie> findAllLocations() {
        return locatieService.findAllLocaties();
    }

    /* public Locatie getLocationById(@QueryParam("id") int id) {
        return locationService.findLocationById(id);
    }*/

    @POST
    @Path("/addlocation")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addLocation(Locatie locatie) {
        if (null != locatieService.findLocationById(locatie.getId())) {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity("location id should not be set.").build();
        }

        locatieService.insert(locatie);
        return Response.status(Response.Status.CREATED).entity(locatie).build();
    }
}