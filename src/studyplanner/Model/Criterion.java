package studyplanner.Model;
import java.util.ArrayList;

public class Criterion {

    private String name;             //Name of a criteria.
    private CriterionType type;       //Type of a criteria.
    private boolean isMet;           //Whether criteria is met or not.
    private double value;            //Value of a criteria.
    private String unitOfMeasure;    //Unit of measure for the criteria.

    /**
     * Default constructor for an instance of Criterion.
     */
    public Criterion(){
        //TODO put checks in place for unexpected behaviour - make error message shown in GUI and program not terminate
        this.name = null;
        this.type = null;
        this.isMet = false;
        this.value = 0.0;
        this.unitOfMeasure= null;
    }

    /**
     * @param t Task to update.
     */
    public void updateTask(Task t){
        //TODO update the task that a criteria has been completed - note: could potentially move this to Task class
        ArrayList<Criterion> criteria = t.getCriteria();

        for (Criterion c:
             criteria) {
            if(c.equals(this)) c.setMet(true);
        }
    }

    /*******************
     * GET/SET METHODS *
     *******************/

    /**
     *@return Criterion name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name for a criterion.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Criterion type.
     */
    public CriterionType getType() {
        return type;
    }

    /**
     * @param type Type for a criterion.
     */
    public void setType(CriterionType type) {
        this.type = type;
    }

    /**
     * @return Whether the criterion is met or not.
     */
    public boolean isMet() {
        return isMet;
    }

    /**
     * @param met Is the criterion met or not.
     */
    public void setMet(boolean met) {
        isMet = met;
    }

    /**
     * @return Criterion value.
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value Value for a criterion.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return Criterion unit of measure.
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * @param unitOfMeasure Unit of measure for a criterion.
     */
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
