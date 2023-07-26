import java.util.ArrayList;

public class Portfolio {
    private ArrayList <Project> projectos = new ArrayList<Project>();


    public Portfolio(){

    }

    public void setProjectos(Project projecto){
        this.projectos.add(projecto);
    }
    public ArrayList<Project> geProjects(){
        return this.projectos;
    }

    public double getPortfolioCost(){
        double totalCost = 0 ;

        for(int i = 0 ; i<projectos.size(); i++){
            totalCost += projectos.get(i).getInitialCost();
        }
        return totalCost;
    }

    public void showPortfolio(){
        for(int i = 0 ; i<projectos.size(); i++){
            System.out.println(this.projectos.get(i).elevatorPitch() + "  " + this.projectos.get(i).getInitialCost());
        }
    }



}
