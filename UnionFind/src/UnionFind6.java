public class UnionFind6 implements UF {

    private int[] parent;
    private int[] rank;//根节点为i的高度

    public UnionFind6(int size) {

        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;

        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    private int find(int p){
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        if (p != parent[p])
            parent[p] = find(parent[p]);
        return parent[p];
    }

    //查看元素p和q是否所属一个集合
    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        }
        else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        }
        else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }


}
