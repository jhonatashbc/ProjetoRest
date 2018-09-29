package br.com.tudo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public enum pessoaDAO {
	instance;

    private Map<String, pessoa> contentProvider = new HashMap<String, pessoa>();

    private pessoaDAO() {

    	pessoa p = new pessoa(1, "Alguem", 12323, 213213, 2312312);
        //p.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
        contentProvider.put("1", p);
        p = new pessoa(2, "Do something", 2131,123123,12312);
       // p.setDescription("Read complete http://www.vogella.com");
        contentProvider.put("2", p);

    }
    public Map<String, pessoa> getModel(){
        return contentProvider;
    }
    
    public ArrayList<pessoa> buscarPessoas(){
		ArrayList<pessoa> lista = new ArrayList<>();
		
		try {
			Connection con = conexaoJDBC.obterConexao();
			
			String queryInserir = "SELECT * FROM pessoa";
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
					
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
			pessoa nse = new pessoa();
				nse.setId(rSet.getInt(1));
				
				nse.setCpf(rSet.getInt(2));
				nse.setNome(rSet.getString(3));
				nse.setNumContato(rSet.getInt(4));
				nse.setRg(rSet.getInt(5));
				
				
				lista.add(nse);
			}
									
			con.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return lista;
	}
    
    public Boolean salvarPessoa(pessoa p){
try {
			
			Connection con = conexaoJDBC.obterConexao();
			
			String queryInserir = "INSERT INTO pessoa VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setInt(1, p.getId());
			ppStm.setInt(2, p.getCpf());
			ppStm.setString(3, p.getNome());
			ppStm.setInt(4, p.getNumContato());
			ppStm.setInt(5, p.getRg());
						
			ppStm.executeUpdate();
			
			con.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	return true;
    }
    
    public pessoa buscarPessoa(int id){
		pessoa nse = new pessoa();
		try {
			Connection con = conexaoJDBC.obterConexao();
			
			String queryInserir = "SELECT * FROM pessoa where id = ?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			ppStm.setInt(1, id);
					
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
			
				nse.setId(rSet.getInt(1));
				
				nse.setCpf(rSet.getInt(2));
				nse.setNome(rSet.getString(3));
				nse.setNumContato(rSet.getInt(4));
				nse.setRg(rSet.getInt(5));	
				
			}
									
			con.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return nse;
	}
    
    public pessoa deletarPessoa(int id){
    	pessoa p = new pessoa();
    	try{
    		Connection con = conexaoJDBC.obterConexao();
    		
    		String queryInserir = "SELECT * FROM pessoa where id = ?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			ppStm.setInt(1, id);
					
			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
			
				p.setId(rSet.getInt(1));
				
				p.setCpf(rSet.getInt(2));
				p.setNome(rSet.getString(3));
				p.setNumContato(rSet.getInt(4));
				p.setRg(rSet.getInt(5));	
				
			}
    		ppStm.clearBatch();
    		String queryDeletar = "DELETE FROM pessoa WHERE id = ?";
    		
    		ppStm =con.prepareStatement(queryDeletar);
    		ppStm.setInt(1, id);
    		
    		ppStm.executeUpdate();
    		con.close();
    		
    		return p;
    	}catch(Exception e){
    		e.printStackTrace();
    		return p;
    	}
    }

}
