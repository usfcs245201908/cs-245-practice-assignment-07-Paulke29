public class ArrayList<T> implements List<T>{


    // default size;
    public static final int DEFAULT_SIZE=10;
    // default Object array;
    private Object[] elements=null;

    // dafault size of array;
    private int capacity;
    // current Index;
    private int current;
    public ArrayList(){
        this(DEFAULT_SIZE);
    }

    public ArrayList(int size){
        if (size<0){
            throw new RuntimeException();
        }else {
            this.elements=new Object[size];
            this.current=0;
            capacity=size;
        }
    }
    @Override
    public void add(Object item) {
        confirmSize();
        this.elements[current]= item;
        this.current++;
    }

    @Override
    public void add(int pos, Object item) {

        confirmSize();
        for (int i = 0; i <elements.length ; i++) {
            if (i>=pos&&i+2<elements.length){
                elements[i]=item;
                elements[i+1]=elements[i+2];
            }
        }
        this.current++;

    }

    @Override
    public T get(int pos) {
        confirmIndex(pos);
        return (T) this.elements[pos];

    }

    @Override
    public T remove(int pos) {
        // move everything behind this index forward
//        confirmIndex(pos);
//        for (int i = pos;i<elements.length;i++){
//            if (i+1<elements.length){
//                elements[i]=elements[i+1];
//            }
//        }
        this.current--;
        return (T)this.elements[pos];
    }

    @Override
    public int size() {
        return this.current;
    }

    // checking the size of the array
    private void confirmSize(){
        if (this.current==this.capacity){
            this.capacity = this.capacity + this.DEFAULT_SIZE;
            Object[] newElements = new Object[this.capacity];
            for (int i = 0; i <this.elements.length ; i++) {
                newElements[i]=this.elements[i];
            }
            this.elements=newElements;
        }
    }
    //checking index
    private void confirmIndex(int index){
        if (index>capacity||index<0){
            throw  new RuntimeException("下标越界");
        }
    }
}
