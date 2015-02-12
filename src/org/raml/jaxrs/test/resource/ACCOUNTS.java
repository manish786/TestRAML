
package org.raml.jaxrs.test.resource;

import java.io.Reader;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


/**
 * This is the top level description for /account.
 * * One
 * * Two
 * * Three
 * 
 * 
 */
@Path("account")
public interface ACCOUNTS {


    /**
     * Creates a new account. Some **bold** text here. More text. Need to fill the line, so make it longer still. Hooray!
     * Line two
     * 
     * Paragraph two
     * 
     * 
     * @param entity
     *      e.g. {
     *       "email": "john@example.com",
     *       "password": "super_secret",
     *       "name": "John Doe"
     *     }
     *     
     */
    @POST
    @Consumes("application/json")
    ACCOUNTS.PostAccountResponse postAccount(Reader entity)
        throws Exception
    ;

    /**
     * 
     * @param id
     *     account identifier
     * @param authorization
     *     Basic authentication header e.g. Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
     *     
     */
    @GET
    @Path("{id}")
    ACCOUNTS.GetAccountByIdResponse getAccountById(
        @PathParam("id")
        String id,
        @HeaderParam("Authorization")
        String authorization)
        throws Exception
    ;

    /**
     * Update the account
     * 
     * @param id
     *     account identifier
     * @param name
     *     name on account e.g. Naruto Uzumaki
     * @param gender
     *     
     */
    @PUT
    @Path("{id}")
    @Consumes("application/x-www-form-urlencoded")
    ACCOUNTS.PutAccountByIdResponse putAccountById(
        @PathParam("id")
        String id,
        @FormParam("name")
        String name,
        @FormParam("gender")
        ACCOUNTS.Gender gender)
        throws Exception
    ;

    /**
     * Delete the account
     * 
     * @param id
     *     account identifier
     */
    @DELETE
    @Path("{id}")
    ACCOUNTS.DeleteAccountByIdResponse deleteAccountById(
        @PathParam("id")
        String id)
        throws Exception
    ;

    /**
     * find an account
     * 
     * @param name
     *     name on account e.g. Naruto Uzumaki
     * @param gender
     *     
     * @param number
     *     
     */
    @GET
    @Path("find")
    ACCOUNTS.GetAccountFindResponse getAccountFind(
        @QueryParam("name")
        String name,
        @QueryParam("gender")
        ACCOUNTS.Gender gender,
        @QueryParam("number")
        @DefaultValue("44")
        long number)
        throws Exception
    ;

    /**
     * Sends an email to the user with a link to set a new password
     * 
     * @param entity
     *      e.g. {
     *       "email": "john@example.com"
     *     }
     *     
     */
    @POST
    @Path("forgot")
    @Consumes("application/json")
    ACCOUNTS.PostAccountForgotResponse postAccountForgot(Reader entity)
        throws Exception
    ;

    /**
     * Login with email and password
     * 
     * @param entity
     *      e.g. {
     *       "email": "john@example.com",
     *       "password": "super_secret"
     *     }
     *     
     */
    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces({
        "text/xml"
    })
    ACCOUNTS.PostAccountLoginResponse postAccountLogin(Reader entity)
        throws Exception
    ;

    /**
     * Gets the sessions
     * 
     */
    @GET
    @Path("session")
    ACCOUNTS.GetAccountSessionResponse getAccountSession()
        throws Exception
    ;

    /**
     * Deletes the session, logging out the user
     * 
     */
    @DELETE
    @Path("session")
    ACCOUNTS.DeleteAccountSessionResponse deleteAccountSession()
        throws Exception
    ;

    public class DeleteAccountByIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private DeleteAccountByIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class DeleteAccountSessionResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private DeleteAccountSessionResponse(Response delegate) {
            super(delegate);
        }

    }

    public enum Gender {

        male,
        female;

    }

    public class GetAccountByIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetAccountByIdResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetAccountFindResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetAccountFindResponse(Response delegate) {
            super(delegate);
        }

    }

    public class GetAccountSessionResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private GetAccountSessionResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PostAccountForgotResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PostAccountForgotResponse(Response delegate) {
            super(delegate);
        }

    }

    public class PostAccountLoginResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PostAccountLoginResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Login was correct e.g. <test>This is a test</test>
         * 
         * 
         * @param entity
         *     <test>This is a test</test>
         *     
         */
        public static ACCOUNTS.PostAccountLoginResponse xmlOK(String entity) {
            Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "text/xml");
            responseBuilder.entity(entity);
            return new ACCOUNTS.PostAccountLoginResponse(responseBuilder.build());
        }

        /**
         * Login was incorrect, please try again
         * 
         */
        public static ACCOUNTS.PostAccountLoginResponse badRequest() {
            Response.ResponseBuilder responseBuilder = Response.status(400);
            return new ACCOUNTS.PostAccountLoginResponse(responseBuilder.build());
        }

        /**
         * Not authorized
         * 
         * @param wWWAuthenticate
         *     user was not authorized e.g. WWW-Authenticate: Basic realm="raml2html"
         *     
         */
        public static ACCOUNTS.PostAccountLoginResponse unauthorized(String wWWAuthenticate) {
            Response.ResponseBuilder responseBuilder = Response.status(401).header("WWW-Authenticate", wWWAuthenticate);
            return new ACCOUNTS.PostAccountLoginResponse(responseBuilder.build());
        }

    }

    public class PostAccountResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PostAccountResponse(Response delegate) {
            super(delegate);
        }

        /**
         * Account was created and user is now logged in
         * 
         */
        public static ACCOUNTS.PostAccountResponse oK() {
            Response.ResponseBuilder responseBuilder = Response.status(200);
            return new ACCOUNTS.PostAccountResponse(responseBuilder.build());
        }

    }

    public class PutAccountByIdResponse
        extends org.raml.jaxrs.test.support.ResponseWrapper
    {


        private PutAccountByIdResponse(Response delegate) {
            super(delegate);
        }

    }

}
