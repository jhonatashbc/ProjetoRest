package br.com.tudo;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;


public class PessoaRecurso {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    int id;
    public PessoaRecurso(UriInfo uriInfo, Request request, int id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public pessoa getPessoa() {
        pessoa p = pessoaDAO.instance.buscarPessoa(id);
        if(p==null)
            throw new RuntimeException("Get: pessoa with " + id +  " not found");
        return p;
    }

    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public pessoa getPessoaHTML() {
    	pessoa p = pessoaDAO.instance.buscarPessoa(id);
        if(p==null)
            throw new RuntimeException("Get: pessoa with " + id +  " not found");
        return p;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putPessoa(JAXBElement<pessoa> p) {
        pessoa c = p.getValue();
        return putAndGetResponse(c);
    }

    @DELETE
    @Produces(MediaType.TEXT_XML)
    public pessoa deletePessoa() {
        pessoa c = pessoaDAO.instance.deletarPessoa(id);
        if(c == null){
            throw new RuntimeException("Erro ao deletar || Objeto não encontrado");
        }else{
        	return c;
        }
    }

    private Response putAndGetResponse(pessoa p) {
        Response res;
        if(pessoaDAO.instance.getModel().containsKey(p.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        pessoaDAO.instance.getModel().put(p.toString(), p);
        return res;
    }

}
