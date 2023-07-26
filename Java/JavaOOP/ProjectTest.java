public class ProjectTest {
    public static void main(String[] args) {
        
        Project projecto1 = new Project();
        Project projecto2 = new Project("Matemáticas");
        Project projecto3 = new Project("Historia", "El projecto se basa en la hitoria de la civilzación griega");
        

        projecto1.setNombre("Música");
        projecto1.setDescripcion("El projecto trata de crear una melodía");
        projecto1.setInitialCost(2);
        projecto2.setInitialCost(3);
        projecto3.setInitialCost(4);

        projecto2.setDescripcion("El projecto trata de Ecuaciones");
        System.out.println(projecto1.elevatorPitch());
        System.out.println(projecto2.elevatorPitch());
        System.out.println(projecto3.elevatorPitch());

        Portfolio portfolio = new Portfolio();
        portfolio.setProjectos(projecto1);
        portfolio.setProjectos(projecto2);
        portfolio.setProjectos(projecto3);
        System.out.println("El costo total es: "+portfolio.getPortfolioCost());
        portfolio.showPortfolio();
    }
}
