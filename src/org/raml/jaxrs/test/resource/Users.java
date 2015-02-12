
package org.raml.jaxrs.test.resource;

import java.io.Reader;
import java.math.BigDecimal;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("users")
public interface Users {


    /**
     * Get a list of all users
     * 
     * @param page
     *     The page to return
     * @param pageSize
     *     The number of items per page
     * @param from
     *     Limit results to those created after from. e.g. 2014-12-31T00:00:00.000Z
     */
    @GET
    Users.GetUsersResponse getUsers(
        @QueryParam("from")
        String from,
        @QueryParam("page_size")
        @DefaultValue("20")
        BigDecimal pageSize,
        @QueryParam("page")
        @DefaultValue("0")
        BigDecimal page)
        throws Exception
    ;

    /**
     * Creates a new user
     * 
     * @param entity
     *      e.g. {
     *       "email": "john@example.com",
     *       "name": "John Doe",
     *     }
     *     
     */
    @POST
    @Consumes("application/json")
    Users.PostUsersResponse postUsers(Reader entity)
        throws Exception
    ;

    /**
     * Get the details of a user including a list of groups he belongs to
     * 
     * @param userId
     *     
     */
    @GET
    @Path("{userId}")
    Users.GetUsersByUserIdResponse getUsersByUserId(
        @PathParam("userId")
        String userId)
        throws Exception
    ;

    /**
     * Update a user
     * 
     * @param userId
     *     
     */
    @PUT
    @Path("{userId}")
    Users.PutUsersByUserIdResponse putUsersByUserId(
        @PathParam("userId")
        String userId)
        throws Exception
    ;

    /**
     * Deletes a user
     * 
     * @param userId
     *     
     */
    @DELETE
    @Path("{userId}")
    Users.DeleteUsersByUserIdResponse deleteUsersByUserId(
        @PathParam("userId")
        String userId)
        throws Exception
    ;

    public class DeleteUsersByUserIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private DeleteUsersByUserIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetUsersByUserIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetUsersByUserIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetUsersResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetUsersResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PostUsersResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PostUsersResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PutUsersByUserIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PutUsersByUserIdResponse(Response delegate) {
            super(delegate);
        }

    }

}
