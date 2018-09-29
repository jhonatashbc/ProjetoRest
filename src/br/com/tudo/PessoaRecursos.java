package br.com.tudo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

//Mapeia o recurso no serviço web com o seguinte caminho URL/pessoas
@Path("/pessoas")
public class PessoaRecursos {
	// Permite transferir infomações na classe
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Utilizando o metodo GET do protocolo http, quando é feita uma requisição xml, nesta caso, retorna ma lista de objetos da classe pessoa
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<pessoa> getPessoasBrowser() {
        List<pessoa> pessoas = new ArrayList<pessoa>();
        //pessoas.addAll(pessoaDAO.instance.getModel().values());
        pessoas = pessoaDAO.instance.buscarPessoas();
        return pessoas;
    }

    // Utilizando o metodo GET do protocolo http, quando é feita uma requisição xml ou json, nesta caso, retorna ma lista de objetos da classe pessoa
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<pessoa> getPessoas() {
        List<pessoa> pessoas = new ArrayList<pessoa>();
        //pessoas.addAll(pessoaDAO.instance.getModel().values());
        pessoas = pessoaDAO.instance.buscarPessoas();
        return pessoas;
    }

    // Através do metodo GET do protocolo HTTP, é consumido quando faz uma requisição no caminho URL/pessoas/count
    // sendo assim, de acordo com o método, retornando o numero de objetos recuperados do banco
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = pessoaDAO.instance.buscarPessoas().size();
        return String.valueOf(count);
    }
    
    //Através do método POST do protocolo HTTP, é consumido quando faz uma requisição enviando os parametros necessários para a operação
    //descrita no método, recuperando os valores através da anotação @FormParam, neste caso é consumido quando requisitado através do MIME-TYPE html
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newPessoa(@FormParam("id") int id,
			            @FormParam("nome") String nome,
			            @FormParam("cpf") int cpf,
			            @FormParam("rg") int rg,
			            @FormParam("numContato")int numContato,
			            @Context HttpServletResponse servletResponse) throws IOException {
        pessoa p = new pessoa(id, nome, cpf, rg, numContato);
        pessoaDAO.instance.salvarPessoa(p);

        servletResponse.sendRedirect("../webapp/index.html");
    }
    
    @Path("remover")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public pessoa deletarPessoa(@FormParam("id") int id){
    	pessoa c = pessoaDAO.instance.deletarPessoa(id);
        if(c == null){
            throw new RuntimeException("Erro ao deletar || Objeto não encontrado");
        }else{
        	return c;
        }
    }

    //Permite indicar como proximo caminho para ser consumido após URL/pessoas ficando como URL/pessoas/1 por exemplo
    //no caso o metodo descrito chama a classe tudoRecurso e envia como parametro as informacoes da uri, o request e a id indicada no parametro
    @Path("{id}")
    public PessoaRecurso getPessoa(@PathParam("id") int id) {
        return new PessoaRecurso(uriInfo, request, id);
    }
}
