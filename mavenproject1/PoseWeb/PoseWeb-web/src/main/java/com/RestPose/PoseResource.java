package com.RestPose;

import com.google.gson.Gson;
import com.service.PoseBeanLocal;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Raph
 */
@Path("Pose")
@RequestScoped
public class PoseResource {

    com.service.PoseBeanLocal poseBean = lookupPoseBeanLocal();
    @Context
    private UriInfo context;
    private Gson gson;

    /**
     * Creates a new instance of PoseResource
     */
    public PoseResource() {
        this.gson = new Gson();
        this.poseBean = this.lookupPoseBeanLocal();
    }

    /**
     * Retrieves representation of an instance of com.RestPose.PoseResource
     * @return an instance of java.lang.String
     * http://localhost:8080/PoseWeb-web/webresources/Pose/
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return this.poseBean.getPosition(0).toString();
        //this.gson.toJson(this.poseBean.get)
     //   String h = "here";
       // return (h);
    }
    
    /**
     * Retrieves representation of an instance of com.RestPose.PoseResource
     * @return an instance of java.lang.String
     * http://localhost:8080/PoseWeb-web/webresources/Pose/0
     */
    @GET
    @Path("{idPose}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("idPose") String idPose) {
        return this.gson.toJson(this.poseBean.getPosition(Integer.parseInt(idPose)));
    }
    
    /**
     * Renvoie la représentation JSON d'un pose Pour l'appeler on doit utiliser l'URL :
     * http://localhost:8080/PoseWeb-web/webresources/Pose/?idEquipePoseur=2
    *
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(@QueryParam("idEquipePoseur") String idEquipePoseur) {
        if ((idEquipePoseur == null) || (idEquipePoseur.isEmpty())) {
            idEquipePoseur = "1";
        }
        return this.gson.toJson(this.poseBean.ajouterPos(parseInt(idEquipePoseur)));
    }

    /**
     * PUT method for updating or creating an instance of PoseResource
     * http://localhost:8080/PoseWeb-web/webresources/Pose/0?etat=termine
     */
    @PUT
    @Path("{idCompte}")
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(@PathParam("idPose") String idPose, @QueryParam("etat") String etat) {
        int idcpt = Integer.parseInt(idPose);
        this.poseBean.setEtatPose(etat, idcpt);
        return this.gson.toJson(this.poseBean.getPosition(Integer.parseInt(idPose)));
    }

    private com.service.PoseBeanLocal lookupPoseBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (com.service.PoseBeanLocal) c.lookup("java:global/PoseWeb-ear/PoseWeb-ejb-1.0-SNAPSHOT/PoseBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
