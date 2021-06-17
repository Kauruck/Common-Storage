package com.kauruck.common.storage.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {

    private TreeNode<T> root;

    private TreeNode<T> adRecursive(TreeNode<T> current, T content){
        if(current == null)
            return new TreeNode<T>(content);

        if(content.compareTo(current.getContent()) < 0){
            current.setLeft(adRecursive(current.getLeft(), content));
        }
        else if(content.compareTo(current.getContent()) > 0){
            current.setRight(adRecursive(current.getRight(), content));
        }
        else{
            return  current;
        }

        return current;
    }

    public void add(T content){
        root = adRecursive(root, content);
    }

    public void addRange(Collection<T> contents){
        for(T current : contents){
            add(current);
        }
    }

    private boolean containsNodeRecursive(TreeNode<T> current, T content) {
        if (current == null) {
            return false;
        }
        if (content.equals(current.getContent())) {
            return true;
        }
        return content.compareTo(current.getContent()) < 0
                ? containsNodeRecursive(current.getLeft(), content)
                : containsNodeRecursive(current.getRight(), content);
    }

    public boolean contains(T content) {
        return containsNodeRecursive(root, content);
    }

    private TreeNode<T> deleteRecursive(TreeNode<T> current, T content) {
        if (current == null) {
            return null;
        }

        if (content.equals(current.getContent())) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            T smallestValue = findSmallestValue(current.getLeft());
            current.setContent(smallestValue);
            current.setLeft(deleteRecursive(current.getLeft(), smallestValue));
            return current;

        }
        if (content.compareTo(current.getContent()) < 0) {
            current.setLeft(deleteRecursive(current.getLeft(), content));
            return current;
        }
        current.setRight(deleteRecursive(current.getRight(), content));
        return current;
    }

    public void remove(T content) {
        root = deleteRecursive(root, content);
    }

    private T findSmallestValue(TreeNode<T> root) {
        return root.getLeft() == null ? root.getContent() : findSmallestValue(root.getLeft());
    }

    public String traverseInOrder(){
        return traverseInOrder(root).trim();
    }

    private String traverseInOrder(TreeNode<T> node) {
        String out = "";
        if (node != null) {
            out += traverseInOrder(node.getLeft());
            out += " " + node.getContent();
            out += traverseInOrder(node.getRight());
        }

        return out;
    }

    public String traverseInPreorder(){
        return traverseInPreorder(root).trim();
    }

    private String traverseInPreorder(TreeNode<T> node) {
        String out = "";
        if (node != null) {
            out += " " + node.getContent();
            out += traverseInPreorder(node.getLeft());
            out += traverseInPreorder(node.getRight());
        }

        return out;
    }

    public String traverseInPostorder(){
        return traverseInPostorder(root).trim();
    }

    private String traverseInPostorder(TreeNode<T> node) {
        String out = "";
        if (node != null) {
            out += traverseInPostorder(node.getLeft());
            out += traverseInPostorder(node.getRight());
            out += " " + node.getContent();
        }

        return out;
    }

    public List<T> traverseInOrderForList(){
        return traverseInOrderForList(root);
    }

    private List<T> traverseInOrderForList(TreeNode<T> node) {
        ArrayList<T> out = new ArrayList<>();
        if (node != null) {
            out.addAll(traverseInOrderForList(node.getLeft()));
            out.add(node.getContent());
            out.addAll(traverseInOrderForList(node.getRight()));
        }

        return out;
    }

    public List<T> traverseInPreorderForList(){
        return traverseInPreorderForList(root);
    }

    private List<T> traverseInPreorderForList(TreeNode<T> node) {
        ArrayList<T> out = new ArrayList<>();
        if (node != null) {
            out.add(node.getContent());
            out.addAll(traverseInPreorderForList(node.getLeft()));
            out.addAll(traverseInPreorderForList(node.getRight()));
        }

        return out;
    }

    public List<T> traverseInPostorderForList(){
        return traverseInPostorderForList(root);
    }

    private List<T> traverseInPostorderForList(TreeNode<T> node) {
        ArrayList<T> out = new ArrayList<>();
        if (node != null) {
            out.addAll(traverseInPostorderForList(node.getLeft()));
            out.addAll(traverseInPostorderForList(node.getRight()));
            out.add(node.getContent());
        }

        return out;
    }

    @Override
    public String toString() {
        return switch(Constants.TO_STRING_TRAVERSE_ORDER) {
            case InOrder -> traverseInOrder(root);
            case PreOrder -> traverseInPreorder(root);
            case PostOrder -> traverseInPostorder(root);
        };
    }

    public Stream<T> stream(){
        return toList().stream();
    }

    public List<T> toList(){
        return switch(Constants.List_TRAVERSE_ORDER) {
            case InOrder -> traverseInOrderForList(root);
            case PreOrder -> traverseInPreorderForList(root);
            case PostOrder -> traverseInPostorderForList(root);
        };
    }

    @Override
    public Iterator<T> iterator() {
        return toList().iterator();
    }
}


