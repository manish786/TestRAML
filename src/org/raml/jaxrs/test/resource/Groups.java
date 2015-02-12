
package org.raml.jaxrs.test.resource;

import java.io.Reader;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("groups")
public interface Groups {


    /**
     * Get a list of all the groups
     * 
     */
    @GET
    Groups.GetGroupsResponse getGroups()
        throws Exception
    ;

    /**
     * Create a new group
     * 
     * @param entity
     *      e.g. {
     *       "name": "Cool people",
     *       "members": [1, 2, 3]
     *     }
     *     
     */
    @POST
    @Consumes("application/json")
    Groups.PostGroupsResponse postGroups(Reader entity)
        throws Exception
    ;

    /**
     * Get the details of a group, including the member list
     * 
     * @param groupId
     *     
     */
    @GET
    @Path("{groupId}")
    Groups.GetGroupsByGroupIdResponse getGroupsByGroupId(
        @PathParam("groupId")
        String groupId)
        throws Exception
    ;

    /**
     * Update the group, **optionally** supplying the new list of members (overwrites current list)
     * 
     * @param groupId
     *     
     * @param entity
     *      e.g. {
     *       "name": "Cool people",
     *       "members": [1, 2, 3]
     *     }
     *     
     */
    @PUT
    @Path("{groupId}")
    @Consumes("application/json")
    Groups.PutGroupsByGroupIdResponse putGroupsByGroupId(
        @PathParam("groupId")
        String groupId, Reader entity)
        throws Exception
    ;

    /**
     * Removes the group
     * 
     * @param groupId
     *     
     */
    @DELETE
    @Path("{groupId}")
    Groups.DeleteGroupsByGroupIdResponse deleteGroupsByGroupId(
        @PathParam("groupId")
        String groupId)
        throws Exception
    ;

    /**
     * Adds a user to a group
     * 
     * @param groupId
     *     
     * @param entity
     *      e.g. {
     *       "user_id": 4,
     *     }
     *     
     */
    @POST
    @Path("{groupId}/users")
    @Consumes("application/json")
    Groups.PostGroupsByGroupIdUsersResponse postGroupsByGroupIdUsers(
        @PathParam("groupId")
        String groupId, Reader entity)
        throws Exception
    ;

    /**
     * Removes a user from a group
     * 
     * @param groupId
     *     
     * @param userId
     *     
     */
    @DELETE
    @Path("{groupId}/users/{userId}")
    Groups.DeleteGroupsByGroupIdUsersByUserIdResponse deleteGroupsByGroupIdUsersByUserId(
        @PathParam("userId")
        String userId,
        @PathParam("groupId")
        String groupId)
        throws Exception
    ;

    public class DeleteGroupsByGroupIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private DeleteGroupsByGroupIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class DeleteGroupsByGroupIdUsersByUserIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private DeleteGroupsByGroupIdUsersByUserIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetGroupsByGroupIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetGroupsByGroupIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetGroupsResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetGroupsResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PostGroupsByGroupIdUsersResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PostGroupsByGroupIdUsersResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PostGroupsResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PostGroupsResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PutGroupsByGroupIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PutGroupsByGroupIdResponse(Response delegate) {
            super(delegate);
        }

    }

}
