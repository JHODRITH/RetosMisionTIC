package model.vo;

public class ConsultaBD {
    private String seleccion;
    private String desde;
    private String donde;
    private String agrupar;
    private String ordenar;
    
    public ConsultaBD(String seleccion, String desde, String donde, String agrupar, String ordenar) {
        this.seleccion = seleccion;
        this.desde = desde;
        this.donde = donde;
        this.agrupar = agrupar;
        this.ordenar = ordenar;
    }
    public ConsultaBD(String seleccion, String desde, String donde, String agrupar) {
        this.seleccion = seleccion;
        this.desde = desde;
        this.donde = donde;
        this.agrupar = agrupar;
    }
    public ConsultaBD(String seleccion, String desde, String donde) {
        this.seleccion = seleccion;
        this.desde = desde;
        this.donde = donde;
    }
    public ConsultaBD(String seleccion, String desde) {
        this.seleccion = seleccion;
        this.desde = desde;
    }
    
    public ConsultaBD() {
    }
    public String getSeleccion() {
        return seleccion;
    }
    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }
    public String getDesde() {
        return desde;
    }
    public void setDesde(String desde) {
        this.desde = desde;
    }
    public String getDonde() {
        return donde;
    }
    public void setDonde(String donde) {
        this.donde = donde;
    }
    public String getAgrupar() {
        return agrupar;
    }
    public void setAgrupar(String agrupar) {
        this.agrupar = agrupar;
    }
    public String getOrdenar() {
        return ordenar;
    }
    public void setOrdenar(String ordenar) {
        this.ordenar = ordenar;
    }
    
}
