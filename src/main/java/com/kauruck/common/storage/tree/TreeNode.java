package com.kauruck.common.storage.tree;

public class TreeNode<T> {
    private T content;

    private TreeNode<T> left;

    private TreeNode<T> right;

    public TreeNode(T content){
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public TreeNode<T> setContent(T content) {
        this.content = content;
        return this;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> setLeft(TreeNode<T> left) {
        this.left = left;
        return this;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public TreeNode<T> setRight(TreeNode<T> right) {
        this.right = right;
        return this;
    }
}
