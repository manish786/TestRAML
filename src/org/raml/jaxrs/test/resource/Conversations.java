
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


/**
 * This is the top level description for /conversations.
 * 
 */
@Path("conversations")
public interface Conversations {


    /**
     * Get a list of conversation for the current user
     * 
     */
    @GET
    Conversations.GetConversationsResponse getConversations()
        throws Exception
    ;

    /**
     * Create a new conversions. The currently logged in user doesn't need to be supplied in the members list, it's implied.
     * 
     * @param entity
     *      e.g. {
     *       "content": "My message!",
     *       "members": [1, 2, 3]
     *     }
     *     
     */
    @POST
    @Consumes("application/json")
    Conversations.PostConversationsResponse postConversations(Reader entity)
        throws Exception
    ;

    /**
     * Get a single conversation including its messages
     * 
     * @param convId
     *     
     */
    @GET
    @Path("{convId}")
    Conversations.GetConversationsByConvIdResponse getConversationsByConvId(
        @PathParam("convId")
        String convId)
        throws Exception
    ;

    /**
     * Update a conversation (change members)
     * 
     * @param convId
     *     
     */
    @PUT
    @Path("{convId}")
    Conversations.PutConversationsByConvIdResponse putConversationsByConvId(
        @PathParam("convId")
        String convId)
        throws Exception
    ;

    /**
     * Get the messages for the conversation
     * 
     * @param page
     *     The page to return
     * @param convId
     *     
     * @param pageSize
     *     The number of items per page
     */
    @GET
    @Path("{convId}/messages")
    Conversations.GetConversationsByConvIdMessagesResponse getConversationsByConvIdMessages(
        @PathParam("convId")
        String convId,
        @QueryParam("page_size")
        @DefaultValue("20")
        BigDecimal pageSize,
        @QueryParam("page")
        @DefaultValue("0")
        BigDecimal page)
        throws Exception
    ;

    /**
     * Add a new message to a conversation
     * 
     * @param convId
     *     
     */
    @POST
    @Path("{convId}/messages")
    Conversations.PostConversationsByConvIdMessagesResponse postConversationsByConvIdMessages(
        @PathParam("convId")
        String convId)
        throws Exception
    ;

    /**
     * Update the message
     * 
     * @param convId
     *     
     * @param messageId
     *     
     */
    @PUT
    @Path("{convId}/messages/{messageId}")
    Conversations.PutConversationsByConvIdMessagesByMessageIdResponse putConversationsByConvIdMessagesByMessageId(
        @PathParam("messageId")
        String messageId,
        @PathParam("convId")
        String convId)
        throws Exception
    ;

    /**
     * Delete the message
     * 
     * @param convId
     *     
     * @param messageId
     *     
     */
    @DELETE
    @Path("{convId}/messages/{messageId}")
    Conversations.DeleteConversationsByConvIdMessagesByMessageIdResponse deleteConversationsByConvIdMessagesByMessageId(
        @PathParam("messageId")
        String messageId,
        @PathParam("convId")
        String convId)
        throws Exception
    ;

    public class DeleteConversationsByConvIdMessagesByMessageIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private DeleteConversationsByConvIdMessagesByMessageIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetConversationsByConvIdMessagesResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetConversationsByConvIdMessagesResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetConversationsByConvIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetConversationsByConvIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetConversationsResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetConversationsResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PostConversationsByConvIdMessagesResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PostConversationsByConvIdMessagesResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PostConversationsResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PostConversationsResponse(Response delegate) {
            super(delegate);
        }

        /**
         * A conversation with these members already existed, the message was added to that one
         * 
         */
        public static Conversations.PostConversationsResponse oK() {
            Response.ResponseBuilder responseBuilder = Response.status(200);
            return new Conversations.PostConversationsResponse(responseBuilder.build());
        }

        /**
         * The conversation was created and the message added to it
         * 
         */
        public static Conversations.PostConversationsResponse created() {
            Response.ResponseBuilder responseBuilder = Response.status(201);
            return new Conversations.PostConversationsResponse(responseBuilder.build());
        }

    }

    public class PutConversationsByConvIdMessagesByMessageIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PutConversationsByConvIdMessagesByMessageIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PutConversationsByConvIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PutConversationsByConvIdResponse(Response delegate) {
            super(delegate);
        }

    }

}
