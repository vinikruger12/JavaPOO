package dados;

public enum StatusReserva {
    PENDENTE("Pendente"), CONFIRMADA("Confirmada"),
    EM_ANDAMENTO("Em andamento"), FINALIZADA("Finalizada"),
    CANCELADA("Cancelada");

    private String statusReserva;
    private StatusReserva(String statusReserva){
        this.statusReserva = statusReserva;
    }

    public String getStatusReserva() {
        return statusReserva;
    }
}