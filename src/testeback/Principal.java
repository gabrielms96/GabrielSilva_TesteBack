/*Sistema batch em Java, serão gerados registros aleatórios e depois inseridos 
*em uma tabela no Banco de Dados. 
*
*@author Gabriel Silva
*/

package testeback;

import controller.CustomerController;
import static dao.ConnectionDataBase.getConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import model.Customer;


public class Principal {

    public static void main(String[] args) throws SQLException, ParseException {
        
        /* Objeto Custumer para os Getters e Setters,
        Objeto controle para gerar os dados aleatórios para Insert */
        
        CustomerController controle = new CustomerController();
        Customer customer = new Customer();
        
        // Conexão para fazer os inserts.
        
        String insertSql = "INSERT INTO tb_customer_account(cpf_cnpj, "
                + "nm_customer, is_active, vl_total) VALUES(?,?,?,?)";
        PreparedStatement pstmt = getConnection().prepareStatement(insertSql);
        
        // Variável para definir quantas linhas serão inseridas.
        
        int quantidadeInserts = 3000;
                
        // Loop para fazer os inserts no banco.
        
        for (int i = 0; i < quantidadeInserts; i++) {
            
            // Gerando e Settando informações aleatórias. 
            
            customer.setCpf_cnpj(controle.gerarCpfCnpj());
            customer.setNm_customer(controle.gerarNomes());
            customer.setIs_active(controle.gerarAtivo());
            customer.setVl_total(Double.parseDouble(controle.gerarValor()));
            
            // Guardando todos os inserts na Batch.
            
            pstmt.setString(1, customer.getCpf_cnpj());
            pstmt.setString(2, customer.getNm_customer());
            pstmt.setInt(3, customer.getIs_active());
            pstmt.setDouble(4, customer.getVl_total());
            pstmt.addBatch();

        }
        
        /* Ao término do Loop executa a Batch, realiza as duas consultas 
        e fecha conexão com o Banco de Dados */
        
        pstmt.executeBatch();
        controle.gerarResultado();
        controle.gerarMedia();
        pstmt.close();

    }

}
