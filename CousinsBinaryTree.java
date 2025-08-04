public class CousinsBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);

        TreeNode target = root.left.right;
        System.out.print("Cousins of node " + target.data + " is :");
        printCousins(root, target);
    }

    private static void printCousins(TreeNode root, TreeNode target) {
        int level = getLevel(root, target, 1);
        printGivenLevelExceptSibling(root, target, level);
    }

    private static int getLevel(TreeNode root, TreeNode target, int level) {
        if (root == null) return 0;
        if (root == target) return level;

        int leftLevel = getLevel(root.left, target, level + 1);
        if (leftLevel != 0) return leftLevel;

        return getLevel(root.right, target, level + 1);
    }

    private static void printGivenLevelExceptSibling(TreeNode root, TreeNode target, int level) {
        if (root == null || level < 2) return;
        // Check if target is child of this node
        if (level == 2) {
            if ((root.left == target) || (root.right == target)) {
                // This is parent of target, so skip
                return;
            }
            if (root.left != null) System.out.print(root.left.data + " ");
            if (root.right != null) System.out.print(root.right.data + " ");
        } else {
            // Recurse for next level
            printGivenLevelExceptSibling(root.left, target, level - 1);
            printGivenLevelExceptSibling(root.right, target, level - 1);
        }
    }
}
