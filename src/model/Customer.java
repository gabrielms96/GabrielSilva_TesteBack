package model;

public class Customer {
    private String cpf_cnpj;
    private String nm_customer;
    private int is_active;
    private double vl_total;
    
    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNm_customer() {
        return nm_customer;
    }

    public void setNm_customer(String nm_customer) {
        this.nm_customer = nm_customer;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public double getVl_total() {
        return vl_total;
    }

    public void setVl_total(double vl_total) {
        this.vl_total = vl_total;
    }
}
