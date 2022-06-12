// this is a cut down version of the interface specifically for the Remove test
// the complete version is in the Library folder on Moodle


public abstract interface SortedADT {
    
    public class NotFoundException extends Exception{}

    public abstract void insert (Comparable object);
    
    // returns the object found
    public abstract Comparable remove(Comparable object) throws NotFoundException;

    // returns the object removed
    public abstract Comparable find(Comparable object) throws NotFoundException;
}
