package dados;

public enum CategoriaItem {
    ENTRADAS("Entradas"), PRATOS_PRINCIPAIS("Pratos Principais"),
    SOBREMESAS("Sobremesas"), BEBIDAS_ALCOOLICAS("Bebidas alcoolicas"),
    BEBIDAS_NAO_ALCOOLICAS("Bebidas não alcoolicas");

    private String categoriaItem;
    private CategoriaItem(String categoriaItem){
        this.categoriaItem = categoriaItem;
    }

    public String getCategoriaItem() {
        return categoriaItem;
    }
}