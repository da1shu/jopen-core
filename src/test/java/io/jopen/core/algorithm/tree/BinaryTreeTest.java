package io.jopen.core.algorithm.tree;

import org.junit.Test;

import java.util.List;


/**
 * @author maxuefeng
 */
public class BinaryTreeTest {

    /**
     * 测试获取树的高度
     */
    @Test
    public void testGetHeight() {

        BinaryTree<Object> tree = new BinaryTree<>();

        tree.createBinaryTree();
        System.err.println(tree.height());
    }

    /**
     * 测试获取树的大小
     */
    @Test
    public void testGetSize() {

        BinaryTree<Object> tree = new BinaryTree<Object>();

        tree.createBinaryTree();
        System.err.println(tree.size());
    }

    /**
     * 测试先序遍历
     */
    @Test
    public void testLeftOrder() {

        BinaryTree<Object> tree = new BinaryTree<Object>();

        tree.createBinaryTree();
        List<AbstractBinaryTree.BinaryTreeNode> binaryTreeNodes = tree.leftOrder();

        binaryTreeNodes.forEach(System.err::println);
    }

    /**
     * 测试中序遍历
     */
    @Test
    public void testMidOrder() {

        BinaryTree<Object> tree = new BinaryTree<Object>();

        tree.createBinaryTree();
        List<AbstractBinaryTree.BinaryTreeNode> binaryTreeNodes = tree.midOrder();

        binaryTreeNodes.forEach(System.err::println);
    }

    /**
     * 测试后序遍历
     */
    @Test
    public void testRightOrder() {

        BinaryTree<Object> tree = new BinaryTree<Object>();

        tree.createBinaryTree();
        List<AbstractBinaryTree.BinaryTreeNode> binaryTreeNodes = tree.rightOrder();

        binaryTreeNodes.forEach(System.err::println);
    }
}
