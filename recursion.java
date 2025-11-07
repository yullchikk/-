class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeTraversal {
    // Preorder: корень → левое → правое
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");  // Обрабатываем корень
        preorder(root.left);                // Рекурсия влево
        preorder(root.right);               // Рекурсия вправо
    }

    // Inorder: левое → корень → правое
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);                 // Рекурсия влево
        System.out.print(root.val + " ");  // Обрабатываем корень
        inorder(root.right);               // Рекурсия вправо
    }

    // Postorder: левое → правое → корень
    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);               // Рекурсия влево
        postorder(root.right);            // Рекурсия вправо
        System.out.print(root.val + " "); // Обрабатываем корень
    }

    public static void main(String[] args) {
        // Создаём дерево (аналогично C++)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Preorder: ");  preorder(root);  System.out.println();
        System.out.print("Inorder: ");   inorder(root);   System.out.println();
        System.out.print("Postorder: "); postorder(root); System.out.println();
    }
}
