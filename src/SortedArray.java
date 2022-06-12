// this is a cut down version of the class specifically for the Remove test
// the complete version is in the Library folder on Moodle

public class SortedArray implements SortedADT {

    private Comparable[] objects;
    private Integer objectCount;
    // set up by find to allow remove to access
    // the array slot of the object being removed
    private Integer objectPosition;

    public SortedArray(Integer arraySize) {
        this.objects = new Comparable[arraySize];
        this.objectCount = 0;
    }

    public String toString() {
        String arrayDetails = new String();
        if (this.objectCount != 0) {
            for (Integer index = 0; index < this.objectCount; index++) {
                arrayDetails += objects[index] + "\n";
            }
        } else {
            arrayDetails += "array is empty";
        }
        return arrayDetails;
    }

    public void insert(Comparable object) {
        // cut down version, for this test objects are added in order
        this.objects[this.objectCount] = object;
        this.objectCount++;
    }

    public Comparable find(Comparable object) throws NotFoundException {
        /* algorithm
            if array empty then
                throw not found exception
            end if
            while object not found loop
                set current position to the midpoint of the array
                if object matches object at the current position then
                    object found
                else
                    if object is less than object at current position then
                        set the end point to the point immediately before the current position
                    else
                        set the start point to the point immediately after the current position
                    end if
                    if no more objects to check then
                        throw not found exception
                    end if
                end if
            end loop
         */
        // only start check if array is occupied
        if (this.objectCount == 0) {
            throw new NotFoundException();
        }
        Comparable foundObject = null;
        Integer startPosition = 0;
        Integer endPosition = this.objectCount - 1;
        Integer midPosition;
        while (foundObject == null) {
            midPosition = (endPosition + startPosition) / 2;
            if (object.compareTo(this.objects[midPosition]) == 0) {
                // object found
                foundObject = this.objects[midPosition];
                this.objectPosition = midPosition;
            } else {
                if (object.compareTo(this.objects[midPosition]) < 0) {
                    // discard upper half of array
                    endPosition = midPosition - 1;
                } else {
                    // discard lower half of array
                    startPosition = midPosition + 1;
                }
                if (startPosition > endPosition) {
                    // object can't be in the array
                    throw new NotFoundException();
                }
            }
        }
        return foundObject;
    }

    public Comparable remove(Comparable object) throws NotFoundException {
        /* algorithm
            find the object
            for each object from the next position to the end of the array loop
                copy from object position to the previous position in the array
            end loop
            remove the object at the last occupied slot
            decrement the object count
         */
        // add code here
        Comparable pos = find(object);
        for (int i = objectPosition + 1; i <= objects.length - 1; i++) {
            objects[i-1] = objects[i];
        }
        objects[objects.length - 1] = null;
        objectCount--;
        return pos;
    }
}
