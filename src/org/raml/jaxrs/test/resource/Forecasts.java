
package org.raml.jaxrs.test.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.raml.jaxrs.test.support.ResponseWrapper;


/**
 * The very top resource - displays OK
 * 
 */
@Path("forecasts")
public interface Forecasts {


    /**
     * Provides an overview of the available data - display OK
     * 
     * @param geoposition
     *     A geoposition aquired by calling /geoposition/search - displays OK
     */
    @GET
    @Path("{geoposition}")
    Forecasts.GetForecastsByGeopositionResponse getForecastsByGeoposition(
        @PathParam("geoposition")
        String geoposition)
        throws Exception
    ;

    public class GetForecastsByGeopositionResponse
        extends ResponseWrapper
    {


        private GetForecastsByGeopositionResponse(Response delegate) {
            super(delegate);
        }

    }

}
