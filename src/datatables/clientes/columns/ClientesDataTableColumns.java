package datatables.clientes.columns;

public class ClientesDataTableColumns {

    private String[] colunas;

    public String[] columns(){
        return colunas = new String[]{"COD.", "Cliente", "CNPJ", "CPF"};
    }
}
