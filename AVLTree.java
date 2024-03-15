package a_pe_csd_de1;

import java.util.List;

public class AVLTree {

    public int getHeight(AVLNode n) {
        if (n == null) return -1;
        int lh = getHeight(n.left);
        int rh = getHeight(n.right);
        return Math.max(lh, rh) + 1;
    }

    public int getBalanceFactor(AVLNode n) {
        if (n == null) return 0;
        return getHeight(n.left) - getHeight(n.right);
    }

    public AVLNode rightRotate(AVLNode a) {
        AVLNode b = a.left;
        AVLNode br = b.right;
        b.right = a;
        a.left = br;
        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;
        b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;
        return b;
    }

    public AVLNode leftRotate(AVLNode a) {
        AVLNode b = a.right;
        AVLNode bl = b.left;
        b.left = a;
        a.right = bl;
        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;
        b.height = Math.max(getHeight(b.left), getHeight(b.right)) + 1;
        return b;
    }

    public AVLNode insert(AVLNode root, Country value) {
        if (root == null)
            return new AVLNode(value);

        if (value.compareTo(root.data) < 0) {
            root.left = insert(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = insert(root.right, value);
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        int bf = getBalanceFactor(root);

        if (bf > 1 && value.compareTo(root.left.data) < 0) {
            return rightRotate(root);
        }

        if (bf < -1 && value.compareTo(root.right.data) > 0) {
            return leftRotate(root);
        }

        if (bf > 1 && value.compareTo(root.left.data) > 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (bf < -1 && value.compareTo(root.right.data) < 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public void display(AVLNode n) {
        if (n == null) return;
        String str = "";
        if (n.left == null) {
            str += ".";
        } else {
            str += n.left.data;
        }
        str += ">=" + n.data + "<=";
        if (n.right == null) {
            str += ".";
        } else {
            str += n.right.data;
        }
        System.out.println(str);
        display(n.left);
        display(n.right);
    }
    public AVLNode search(AVLNode root, Country value) {
        if (root == null || root.data.equals(value)) {
            return root;
        }

        if (value.compareTo(root.data) < 0) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    public AVLNode insertAt(AVLNode root, Country value) {
        if (root == null) {
            return new AVLNode(value);
        }

        if (value.compareTo(root.getData()) < 0) {
            root.left = insert(root.getLeft(), value);
        } else if (value.compareTo(root.getData()) > 0) {
            root.right = insert(root.getRight(), value);
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        int bf = getBalanceFactor(root);

        if (bf > 1 && value.compareTo(root.left.data) < 0) {
            return rightRotate(root);
        }

        if (bf < -1 && value.compareTo(root.right.data) > 0) {
            return leftRotate(root);
        }

        if (bf > 1 && value.compareTo(root.left.data) > 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (bf < -1 && value.compareTo(root.right.data) < 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    private int count = 0;
    public int countCountryNamesStartingWith(AVLNode root, char startChar) {
        inOrderTraversal(root, startChar);
        int res = count;
        count = 0;
        return res;
    }

    public void inOrderTraversal(AVLNode root, char startChar) {
        if (root != null) {
            inOrderTraversal(root.left, startChar);

            // Assuming the country name is a String property in the Country class
            String countryName = root.data.getName();

            // Check if the country name starts with the specified character
            if (countryName.startsWith(String.valueOf(startChar))) {
                count++;
            }

            inOrderTraversal(root.right, startChar);
        }
    }
    public AVLNode insertList(AVLNode root, List<Country> countryList) {
        for (Country country : countryList) {
            root = insertAt(root, country);
        }
        return root;
    }
}
