package bank.BankMF;

import java.sql.SQLException;
import java.util.Date;

import bank.BankMF.dao.ClientDao;
import bank.BankMF.dao.CompteDao;
import bank.BankMF.metier.Client;
import bank.BankMF.metier.Compte;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    //http://localhost:8083/Mariem/webapi/myresource/identifiant/222
    @GET
    @Path("identifiant/{code}")
    @Produces("application/json")
    public Client findClient(@PathParam("code") int code) throws SQLException{
    ClientDao pdao=new ClientDao();
    System.out.println("code");
        return pdao.findById(code) ;
       
        }
    //http://localhost:8083/Mariem/webapi/myresource/create?code=147&nom=abc&prenom=cdef&email=abc
    @POST
    @Path("create")
    @Produces("application/json")
    public void ajouterclient(@QueryParam("code") int code,
            @QueryParam("nom") String nom,
            @QueryParam("prenom") String prenom,
            @QueryParam("email") String email ) {
    Client c =new Client(code, nom, prenom, email);
    ClientDao pdao=new ClientDao();
     pdao.ajouterclient(c);
    //System.out.println(c);

    }
    //http://localhost:8083/Mariem/webapi/myresource/remove/233
    @DELETE
    @Path("remove/{id}")
    public boolean SupprimerClient(@PathParam("code") int code)
    {
    	ClientDao pdao=new ClientDao();
       
      return  pdao.SupprimerClient(code);
}
  //http://localhost:8083/Mariem/webapi/myresource/modify/233?email=mariemght@gmail.com
    @PUT
    @Path("modify/{code}")
    @Produces("application/json")
    public Boolean updateclient(@PathParam("code") int code ,@QueryParam("email") String email
    )
    {
    Client p =new Client(code,email);
    ClientDao pdao=new ClientDao();
    return pdao.updateclient(p);
    }
  //http://localhost:8083/Mariem/webapi/myresource/new?codeCompte=125&dateCreation=2018-12-12&solde=400&Client=148
    @POST
    @Path("new")
    @Produces("application/json")
    public void ajoutercompte(@QueryParam("codeCompte") int codeCompte,
            @QueryParam("dateCreation") Date dateCreation,
            @QueryParam("solde") Double solde,
            @QueryParam("Client") Client Client ) {
    Compte c =new Compte(codeCompte, dateCreation, solde, Client);
    CompteDao pdao1=new CompteDao();
     pdao1.ouvrirCompte(c);
    //System.out.println(c);

    }
}
