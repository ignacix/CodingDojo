
class Project{

    private String nombre;
    private String descripcion;
    private double initialCost;
    
    
    public Project(){
    }
    
    public Project(String name){
        this.nombre = name;
    }
    
    public Project(String name, String description){
        this.nombre = name;
        this.descripcion = description;
    }
    
    public String elevatorPitch(){
        
        return String.format("%s (%,.2f) : %s",this.nombre, this.initialCost, this.descripcion);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getInitialCost() {
        return initialCost;
    }
    
    public void setInitialCost(double initialCost) {
        this.initialCost = initialCost;
    }
}