package ru.boiko.se;

public class LinkIteratorApp {

    public static void main(String[] args) {
        Link link = new Link("Boris", 23);
        MyLinkedList list = new MyLinkedList();
        list.addFirst(link);

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertBefore("Nikita", 30);
        itr.insertAfter("Alex", 40);
        itr.deleteCurrent();


        System.out.println(itr.toString());
    }

}
