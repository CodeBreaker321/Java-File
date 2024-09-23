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
        static class Info{
            int ht;
            int dia;

            public Info(int ht,int dia){
                this.ht = ht;
                this.dia = dia;
            }
        }
        public static Info diameter (Node root){
            if(root == null){
                return new Info(0,0);
            }
            Info rightInfo = diameter(root.left);
            Info leftInfo = diameter(root.right);

            int diam =Math.max(Math.max(leftInfo.dia, rightInfo.dia),leftInfo.ht+rightInfo.ht+1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

            return new Info(ht,diam);
        }
    }
    

    public static void main(String[] args) {
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.LevelOrder(root);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Height Of Tree: " + BinaryTree.height(root));
        System.out.println("Number Of Node: " + BinaryTree.numOfNodes(root));
        System.out.println("Sum Of Nodes: " + BinaryTree.sumOfNodes(root));
        BinaryTree.Info treeInfo = BinaryTree.diameter(root);
        System.out.println("Diameter of tree: " + treeInfo.dia);

    }
}

