package com.company;

public class LinkList {
    Object data;
    public LinkList next;
    public LinkList(int data){

        this.data = data;
    }
}

class List {

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((head == null) ? 0 : head.hashCode());
        result = prime * result + ((tail == null) ? 0 : tail.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        List other = (List) obj;
        if (head == null) {
            if (other.head != null)
                return false;
        } else if (!head.equals(other.head))
            return false;
        if (tail == null) {
            if (other.tail != null)
                return false;
        } else if (!tail.equals(other.tail))
            return false;
        return true;
    }

    private LinkList head;
    private LinkList tail;

    public List() {
        this.head = head;
        this.tail = tail;
    }

    public List(List list) {

        this.tail = null;
        this.head = reverseList(list.head);
    }

    public LinkList reverseList(LinkList head){
        LinkList prev = null;
        while (head != null){
            LinkList next_note = head.next;
            head.next = prev;
            prev = head;
            head = next_note;
        }
        return prev;
    }



    private boolean isEmpty(){

        return head == null;
    }
    public void kolvo (){
        LinkList temp = head;
        int c = 0;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        System.out.println("Количество элементов: " + c);
    }

    public void add(int data){
        LinkList temp = new LinkList(data);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else{
            temp.next = head;
            head = temp;
        }
    }
    public void bdd(int data) {
        LinkList temp = new LinkList(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }


    public void removeData(int key){
        LinkList cur = head;
        LinkList prev = null;
        while (true) {
            if (cur.data.equals(key) ){
                if (cur == head)
                    head = cur.next;
                else{
                    prev.next = cur.next;
                }
            }
            if ( cur.data.equals(key))
                break;
            prev = cur;
            cur = cur.next;
        }
    }
    public void removeAll(){
        while (head != null)
            head = head.next;
    }




    public void remove(){
        head = head.next;
    }

    public void print(){
        LinkList temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}