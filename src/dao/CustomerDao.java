package dao;

 
import java.sql.SQLException; 

public class CustomerDao extends GenericDao {
 
    public void selectMedia() throws SQLException {
        String select = "SELECT CAST((AVG(vl_total)) AS DECIMAL(10, 2)) "
                + "MEDIA FROM tb_customer_account WHERE vl_total > 560 "
                + "AND id_customer BETWEEN 1500 AND 2700 ";
        select(select);
    }
    
        public void selectResutado() throws SQLException {
        String select = "SELECT id_customer, nm_customer, cpf_cnpj, vl_total "
                + "MEDIA FROM tb_customer_account WHERE vl_total > 560 "
                + "AND id_customer BETWEEN 1500 and 2700 GROUP BY MEDIA DESC";
        select2(select);
    }
}