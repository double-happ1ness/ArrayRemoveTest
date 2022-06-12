public class ArrayRemoveTest {
    public static void main(String[] args){
        SortedADT sorted = new SortedArray(5);
        sorted.insert(3);
        sorted.insert(5);
        sorted.insert(6);
        sorted.insert(7);
        sorted.insert(8);
        System.out.println(sorted);
        Integer value;
        do{
            value = Input.getInteger("value: ");
            try {
                sorted.remove(value);
                System.out.println("removed");
            } catch (SortedADT.NotFoundException e) {
                System.out.println("remove invalid - value not found");
            }
            System.out.println(sorted);
        }while(Repeat.repeat());
    }
}
