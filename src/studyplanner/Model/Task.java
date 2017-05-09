package studyplanner.Model;

import java.util.ArrayList;
import java.util.Date;

public class Task extends Objective{
    private String type;
    private ArrayList<Criterion> criteria;
    private ArrayList<Activity> activityHistory;
    private ArrayList<Task> dependentOn;
    
    public Task(){
        
    }
    public Task(String type, ArrayList<Criterion> criteria, 
            ArrayList<Activity> activityHistory, ArrayList <Task> dependentOn,
                            String name, String description,Date start, Date end){
        
        super(name, description, start, end);
        this.type = type;
        this.criteria = criteria;
        this.activityHistory = activityHistory;
        this.dependentOn = dependentOn;
        
    }

    /*******************
     * GET/SET METHODS *
     *******************/
    
    /**
     * @return 
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return 
     */
    public ArrayList<Criterion> getCriteria() {
        return criteria;
    }

    /**
     * @param criteria 
     */
    public void setCriteria(ArrayList<Criterion> criteria) {
        this.criteria = criteria;
    }

    /**
     * @return 
     */
    public ArrayList<Activity> getActivityHistory() {
        return activityHistory;
    }

    /**
     * @param activityHistory 
     */
    public void setActivityHistory(ArrayList<Activity> activityHistory) {
        this.activityHistory = activityHistory;
    }

    /**
     * @return 
     */
    public ArrayList<Task> getDependentOn() {
        return dependentOn;
    }
}
