package negocio;
import dados.*;

public class ReservaPassagem {
    private Cidade[] listaDeCidades = new Cidade[100];
    private Cliente[] listaDeClientes = new Cliente[100];

    private int quantCidades = 0;
    private int quantClientes = 0;

    public int getQuantCidades() {
        return quantCidades;
    }
    public int getQuantClientes() {
        return quantClientes;
    }

    public Cidade[] getListaDeCidades() {
        return this.listaDeCidades;
    }

    public Cliente[] getListaDeClientes() {
        return this.listaDeClientes;
    }

    public boolean cadastrarCidade(Cidade cidade){
        if(quantCidades < listaDeCidades.length){
            listaDeCidades[quantCidades] = cidade;
            quantCidades++;
            return true;
        }
        return false;
    }

    public boolean cadastrarClientes(Cliente cliente){
        if(quantClientes < listaDeClientes.length){
            listaDeClientes[quantClientes] = cliente;
            quantClientes++;
            return true;
        }
        return false;
    }

    public boolean reservarIda(Cliente cliente, Reserva reserva){
        return cliente.reservarIda(reserva);
    }

    public boolean reservarVolta(Cliente cliente, Reserva ida, Reserva volta){
        return cliente.reservarVolta(ida, volta);
    }


    public Reserva[] mostrarReservas(String cpfCliente){
        for(int i = 0;i < quantClientes;i++){
            if(listaDeClientes[i].getCpf().equals(cpfCliente)){
                return listaDeClientes[i].getReservas();
            }
        }        
        return null;
    }

    public Cliente[] mostrarClientes(){
        return listaDeClientes;
    }

    public Cidade[] mostrarCidades(){
        return listaDeCidades;
    }



}
