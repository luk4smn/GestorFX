package datatables.clientes.criterias;

public class ClientesDataTableCriteria {

    private String query;
    private String search;

    public String getQuery(String slug, String search){
        return slug.equals("index") ? (query = "SELECT id, nome, cnpj, cpf FROM clientes") :
               slug.equals("filter") ? (query = "SELECT id, nome, cnpj, cpf from clientes "
//                       + "inner join cidades on clientes.cidade_id = cidades.id "
//                       + "inner join estados on cidades.estado_id = estados.id "
                       + "where id ::text like '%" + search + "%' "
                       + "or nome ::text like '%" + search + "%' "
                       + "or cpf ::text like '%" + search + "%' "
                       + "or cnpj ::text like '%" + search + "%' "
               ) : null;
    }
}
