import java.util.ArrayList;

public class DisjointSet {
    //    ArrayList<E> array;
    Set[] nodes;

    public DisjointSet(int size) {
//        array = new ArrayList<>(size);
        nodes = new Set[size];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Set s : this.nodes) {
            sb.append(s.toString());
        }
        return sb.toString();
    }

    public void addToArray(int index) {
        this.nodes[index] = new Set(index);
    }

    public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (Math.abs(this.nodes[aRoot].element) >= Math.abs(this.nodes[bRoot].element)){
            this.nodes[aRoot].element += this.nodes[bRoot].element;
            this.nodes[bRoot].element = aRoot;
            pathCompress(b, aRoot);
        }
        else{
            this.nodes[bRoot].element += this.nodes[aRoot].element;
            this.nodes[aRoot].element = bRoot;
            pathCompress(a, bRoot);
        }
    }
    public void pathCompress(int x, int root){
        if (this.nodes[x].element >= 0){
            pathCompress(this.nodes[x].element, root);
            this.nodes[x].element = root;
        }
    }




    public int find(int index) {
        if (this.nodes[index].element >= 0) {
//            this.nodes[index].element = find(this.nodes[index].element);
            return find(this.nodes[index].element);
        } else if (this.nodes[index].element == 0) {
            System.out.println("element = 0, no good");
        }
        return index;

    }


    private class Set {
        //        private SetNode root;
        private int index;
        private int element;

        private Set(int index) {
            this.element = -1;
            this.index = index;
        }

        public String toString() {
            return index + " : " + element + "\n";
//            else return element + " | " + setSize * -1;
        }
    }


    public static void main(String[] args) {
        int size = 11;
        DisjointSet ds = new DisjointSet(size);
        for (int i = 0; i < size; i++) {
            ds.addToArray(i);
        }
        ds.union(0, 1);
        ds.union(5, 6);
        ds.union(4, 6);
        ds.union(7, 4);
        ds.union(1, 6);
        ds.union(2, 3);
        ds.union(9, 2);
        ds.union(9, 10);
        ds.union(1,9);


        System.out.println(ds.toString());
//        for (Set s : ds.nodes){
//            System.out.println(s.setSize);
//        }

    }


}
