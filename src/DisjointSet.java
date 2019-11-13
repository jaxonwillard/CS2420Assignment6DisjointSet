import java.util.ArrayList;

public class DisjointSet<E> {
    //    ArrayList<E> array;
    Set[] nodes;

    public DisjointSet(int size) {
//        array = new ArrayList<>(size);
        nodes = new Set[size];
    }

    public void addToArray(E e, int index) {
        this.nodes[index] = new Set(e);
    }


    private class Set<E> {
        //        private SetNode root;
        private int parent;
        private E element;
        private ArrayList<Set> children;

        private Set(E e) {
            this.parent = -1;
            this.element = e;
            this.children = new ArrayList<>(0);
        }

        public String toString(Set node, String toReturn, String recLevel) {
            recLevel = recLevel + " ";
            toReturn = toReturn + recLevel + node.nodeToString() + recLevel + "\n";
            for (int i = 0; i < node.children.size(); i++) {
                toReturn = toReturn + toString((Set) this.children.get(i), toReturn, recLevel);
            }
            return toReturn;
        }

        public String toString() {
            return toString(this, "", "");
        }

        public String nodeToString() {
            return "Element: " + element.toString() + " Parent: " + parent;
        }


    }

//    private class SetNode{
//        private int parent;
//        private E element;
//        private ArrayList<SetNode> children;
//        private SetNode(E e){
//            this.element = e;
//            this.parent = -1;
//            SetNode something = children.get(0);
//        }
//        public String toString(){
//            return "Element: " + element.toString() + "Parent: " + parent;
//        }


//    }

    public static void main(String[] args) {
        int size = 10;
        DisjointSet<Integer> ds = new DisjointSet<>(size);
        for (int i = 0; i < size; i++) {
            ds.addToArray(i, i);
        }
        System.out.println(ds.nodes.length);
        for (int i = 0; i < size; i++) {
            System.out.println(ds.nodes[i].toString());
        }

    }


}
