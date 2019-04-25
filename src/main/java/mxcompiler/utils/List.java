package mxcompiler.utils;

import mxcompiler.error.CompileError;


public class List<T> {
    private Node head;
    private Node tail;

    public List(T init) {
        head = new Node(this, init);
        tail = head;
    }

    // tail
    // tail -> inst
    public void addLast(Node inst) {
        tail.next = inst;
        inst.prev = tail;
        tail = inst;
    }

    // prev -> tail
    // prev(tail)
    public void removeLast() {
        if (head == tail)
            throw new CompileError("delete empty list");
        tail = tail.prev;
    }

    public class Node {
        List<T> parent;
        T data;
        Node prev = null;
        Node next = null;

        public Node(List<T> parent, T data) {
            this.data = data;
            this.parent = parent;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        // prev -> this -> next
        // prev -> inst -> this -> next
        public void prepend(Node inst) {
            inst.prev = prev;
            inst.next = this;
            prev.next = inst;
            this.prev = inst;
        }

        // prev -> this -> next
        // prev -> this -> inst -> next
        public void appendInst(Node inst) {
            inst.prev = this;
            inst.next = next;
            next.prev = inst;
            this.next = inst;
        }

        // prev -> this -> next
        // prev -> next
        public void remove() {
            // if (removed) {
            // throw new CompilerError("cannot remove an instruction already removed");
            // }
            // removed = true;
            prev.next = next;
            next.prev = prev;
            // if (this instanceof IRJumpInstruction) {
            // parent.removeJumpInst();
            // }
        }

        public void replace(Node inst) {
            // if (removed) {
            // throw new CompilerError("cannot remove an instruction already removed");
            // }
            // removed = true;
            this.data = inst.data;
        }
    }
}