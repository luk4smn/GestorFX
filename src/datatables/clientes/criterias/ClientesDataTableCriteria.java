package datatables.clientes.criterias;

public class ClientesDataTableCriteria {

    private String query;

    public String getQuery(String slug){
        return slug.equals("index") ? (query = "SELECT id, nome, cnpj, cpf FROM clientes") :
               slug.equals("filter") ? (query = "SELECT id, nome, cnpj, cpf FROM clientes") : null;
    }
}
