package BinaryTree;
import java.util.*; 
public class BinaryTrees {
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null; 
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        public static void PreOrder (Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            PreOrder(root.left);
            PreOrder(root.right);
        }

        public static void InOrder (Node root){
            if(root == null){
                return;
            }
            InOrder(root.left);
            System.out.print(root.data+" ");
            InOrder(root.right);
        }

        public static void PostOrder (Node root){
            if(root == null){
                return;
            }
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data+" ");
        }
        public static void LevelOrder (Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        static class Info{
            Node node;
            int hd;

            public Info(Node node,int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        public static void TopView(Node root){
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer,Node> mp = new HashMap<>();
            int min=0,max=0;
            q.add(new Info(root, 0));
            q.add(null);
            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    if(!mp.containsKey(curr.hd)){
                        mp.put(curr.hd, curr.node);
                    }
                    if(curr.node.left!=null){
                        q.add(new Info(curr.node.left, curr.hd-1));
                        min = Math.min(min, curr.hd-1);
                    }
                    if (curr.node.right!=null) {
                        q.add(new Info(curr.node.right,curr.hd+1));
                        max= Math.max(max, curr.hd+1);
                    }
                }
                
            }
            for(int i=min;i<=max;i++){
                System.out.print(mp.get(i).data+" ");
            }
            
            System.out.println();
        }
        public static int height (Node root){
            if(root == null){
                return 0;
            }
            int rh = height(root.left);
            int lh = height(root.right);
            return Math.max(rh, lh)+1;
        }
        public static int numOfNodes (Node root){
            if(root == null){
                return 0;
            }
            int rcnt = numOfNodes(root.left);
            int lcnt = numOfNodes(root.right);
            return rcnt+lcnt+1;
        }
        public static int sumOfNodes (Node root){
            if(root == null){
                return 0;
            }
            int rsubtree = sumOfNodes(root.left);
            int lsubtree = sumOfNodes(root.right);
            return rsubtree+lsubtree+root.data;
        }
        public static int diameter2 (Node root){
            if(root == null){
                return 0;
            }
            int ld = diameter2(root.left);
            int rd = diameter2(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            int selfdiameter = lh + rh + 1;
            return Math.max(selfdiameter,Math.max(ld, rd));
        }
        // static class Info{
        //     int ht;
        //     int dia;

        //     public Info(int ht,int dia){
        //         this.ht = ht;
        //         this.dia = dia;
        //     }
        // }
        // public static Info diameter (Node root){
        //     if(root == null){
        //         return new Info(0,0);
        //     }
        //     Info rightInfo = diameter(root.left);
        //     Info leftInfo = diameter(root.right);

        //     int diam =Math.max(Math.max(leftInfo.dia, rightInfo.dia),leftInfo.ht+rightInfo.ht+1);
        //     int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

        //     return new Info(ht,diam);
        // }
        public static boolean isIdentical(Node root, Node subRoot){
            if(root == null && subRoot == null){
                return true;
            }
            else if(root == null || subRoot == null || root.data != subRoot.data){
                return false;
            }
            if(!isIdentical(root.left, subRoot.left)){
                return false;
            }
            if(!isIdentical(root.right, subRoot.right)){
                return false;
            }
            return true;
        }
        public static boolean isSubTree(Node root, Node subRoot){
            if(root == null){
                return false;
            }
            if(root.data == subRoot.data){
                if(isIdentical(root,subRoot)){
                    return true;
                }
            }
            return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot);
        }

        public static void kthLevel(Node root,int k, int level){
            if(root == null){
                return;
            }
            if(level == k){
                System.out.print(root.data+" ");
                return;
            }
            kthLevel(root.left, k, level+1);
            kthLevel(root.right, k, level+1);
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> Path){
            if(root == null){
                return false; 
            }
            Path.add(root);

            if(root.data == n){
                return true;
            }
            if(getPath(root.left, n, Path) || getPath(root.right, n, Path)) return true;

            Path.remove(Path.size()-1);
            return false;
        }

        public static Node lca(Node root, int n1, int n2){        //O(n)
            ArrayList<Node> Path1 = new ArrayList<>();
            ArrayList<Node> Path2 = new ArrayList<>();
            getPath (root,n1,Path1);
            getPath (root,n2,Path2);

            //lowest Common Ancester
            int i=0;
            for(; i<Path1.size() && i<Path2.size(); i++){
                if(Path1.get(i) != Path2.get(i)){
                    break;
                }
            }

            //last equal node -> (i-1)th Node
            Node lca = Path1.get(i-1);
            return lca;
        }

        public static Node lca2(Node root, int n1, int n2){
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }
            Node lflca = lca2(root.left, n1, n2);
            Node rtlca = lca2(root.right, n1, n2);

            if(lflca == null){
                return rtlca;
            }
            if(rtlca == null){
                return lflca;
            }
            return root;
        }
        public static int lcaDist(Node root, int n){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }

            int lfDist = lcaDist(root.left, n);
            int rtDist = lcaDist(root.right,n);

            if(lfDist == -1 && rtDist ==-1){
                return -1;
            }
            else if(lfDist == -1){
                return rtDist + 1;
            }
            else{
                return lfDist + 1;
            }
        }
        public static int minDist (Node root, int n1, int n2){
            Node lca = lca2(root, n1, n2);
            int dist1 = lcaDist(lca , n1);
            int dist2 = lcaDist(lca , n2);

            return dist1 + dist2;
        }
        public static int kthAncestors(Node root, int n, int k){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }
            int rtDist = kthAncestors(root.right, n, k);
            int lfDist = kthAncestors(root.left, n, k);

            if(rtDist == -1 && lfDist == -1){
                return -1;
            }
            int max = Math.max(rtDist,lfDist);
            if(max+1 == k){
                System.out.println(root.data);
            }
            return max+1;
        }

        public static int transform (Node root){
            if(root == null){
                return 0;
            }
            int lfchild = transform(root.left);
            int rtchild = transform(root.right);
            int leftdata = root.left == null ? 0 : root.left.data;
            int rightdata = root.right == null ? 0 : root.right.data;
            int data = root.data;
            root.data = leftdata +lfchild + rightdata + rtchild;
            return data;
        }

        public static Node BSTInsertion (Node root,int val){
            if(root == null){
                root = new Node(val);
                return root;
            }
            if(root.data > val){
                root.left = BSTInsertion(root.left, val);
            }
            else{
                root.right = BSTInsertion(root.right, val);
            }
            return root;
        }

        public static boolean BSTSearch(Node root, int key){
            if(root == null){
                return false;
            }
            if(root.data == key){
                return true;
            }
            if(root.data > key){
                return BSTSearch(root.left, key);
            }
            else{
                return BSTSearch(root.right, key);
            }
        }

        public static Node findInorderSuccessor(Node root){
            while(root.left!=null){
                root=root.left;
            }
            return root;
        }

        public static Node BSTdelete(Node root, int val){
            if(root.data<val){
                root.right = BSTdelete(root.right, val);
            }
            else if(root.data>val){
                root.left = BSTdelete(root.left, val);
            }
            else{
                //Case-1   No Child
                if(root.left==null && root.right==null){
                    return null;
                }
                //Case-2   One Child
                if(root.right==null){
                    return root.left;
                }
                else if(root.left == null){
                    return root.right;
                }
                //Case-3   Two Child
                Node IS = findInorderSuccessor(root.right);
                root.data=IS.data;
                root.right = BSTdelete(root.right,IS.data);
            }
            return root;
        }

        public static void printInRange(Node root,int k1,int k2){
            if(root == null){
                return ;
            }
            //Case-1     root is in the Range
            if(root.data >= k1 && root.data <= k2){
                printInRange(root.left, k1, k2);
                System.out.print(root.data + " ");
                printInRange(root.right, k1, k2);
            }
            //Case-2     Range Is less than root
            else if(root.data < k1){
                printInRange(root.left, k1, k2);
            }
            else{
                printInRange(root.right, k1, k2);
            }

        }

        public static void printPath(ArrayList<Integer> Path){
            for(int i=0;i<Path.size();i++){
                System.out.print(Path.get(i)+"->");
            }
            System.out.println("NULL");
        }
        
        public static void printRoot2Leaf(Node root, ArrayList<Integer> Path){
            if(root==null){
                return;
            }
            Path.add(root.data);
            if(root.left == null && root.right == null){
                printPath(Path);
            }
            printRoot2Leaf(root.left, Path);
            printRoot2Leaf(root.right, Path);
            Path.remove(Path.size()-1);
        }

        public static boolean isValidBST (Node root, Node min, Node max){
            if(root==null){
                return true;
            }
            if(min != null && root.data <= min.data){
                return false;
            }
            if(max != null && root.data >= max.data){
                return false;
            }
            return isValidBST(root.left,min,root) && isValidBST(root.right, root, max);
        }

        public static Node BSTmirror (Node root){
            if(root == null){
                return null;
            }
            Node leftMirror = BSTmirror(root.left);
            Node rightMirror = BSTmirror(root.right);
            root.left = rightMirror;
            root.right = leftMirror;
            return root;
        }
    }
    

    public static void main(String[] args) {
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.LevelOrder(root);
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        // System.out.println("Height Of Tree: " + BinaryTree.height(root));
        // System.out.println("Number Of Node: " + BinaryTree.numOfNodes(root));
        // System.out.println("Sum Of Nodes: " + BinaryTree.sumOfNodes(root));
        // BinaryTree.Info treeInfo = BinaryTree.diameter(root);
        // System.out.println("Diameter of tree: " + treeInfo.dia);

        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

        // BinaryTree.TopView(root);
        // BinaryTree.kthLevel(root,3,1);
        // System.out.println(BinaryTree.minDist(root, 6,4));
        // BinaryTree.kthAncestors(root, 7, 1);
        // BinaryTree.transform(root);
        // BinaryTree.PreOrder(root);

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(BinaryTree.isSubTree(root,subRoot));




        //Binary Search Tree

        int val[] = {3,2,1,4,5};
        Node root = null;
        for(int i=0;i<val.length;i++){
            root = BinaryTree.BSTInsertion(root,val[i]);
        }
        BinaryTree.BSTmirror(root);
        BinaryTree.PreOrder(root);
        // if(BinaryTree.isValidBST(root, null, null)){
        //     System.out.println("Valid");
        // }
        // else{
        //     System.out.println("Not Valid");
        // }
        // BinaryTree.printRoot2Leaf(root,new ArrayList<>());
        // BinaryTree.BSTdelete(root, 5);
        // BinaryTree.printInRange(root, 5, 12);
        // System.out.println();
        // BinaryTree.InOrder(root);
        // System.out.println();
        // if(BinaryTree.BSTSearch(root, 5)){
        //     System.out.println("Founded");
        // }
        // else{
        //     System.out.println("Not Founded");
        // }

    }
}

