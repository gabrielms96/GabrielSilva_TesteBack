package dao;

 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

 public class GenericDao {
    private Connection connection; 
 
    protected GenericDao() { 
  this.connection = ConnectionDataBase.getConnection(); 
    } 
 
    protected Connection getConnection() { 
        return connection; 
    } 

    
    protected void select(String selectSql) throws SQLException {
        PreparedStatement pstmt = getConnection().prepareStatement(selectSql);
        ResultSet rs;
        rs = pstmt.executeQuery(selectSql);
        while (rs.next()) {
            String media = rs.getString("MEDIA");
            System.out.println("A Média dos valores maiores que 560 entre "
                    + "os id_customer 1500 e 2700 é de " + media);
        }

    }

    protected void select2(String selectSql) throws SQLException {
        PreparedStatement pstmt = getConnection().prepareStatement(selectSql);
        ResultSet rs;
        rs = pstmt.executeQuery(selectSql);
        while (rs.next()) {
            String id = rs.getString("id_customer");
            String nm = rs.getString("nm_customer");
            String cpf = rs.getString("cpf_cnpj");
            String vl = rs.getString("MEDIA");
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            double val = Double.valueOf(vl);
            nf.format(val);
            System.out.println(id + "  " + nm + "  " + cpf + "  " + val);
        }

    }
    
}
