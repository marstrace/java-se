package top.top7.collection.list;

/******
 *       Created by LEARNING on 2020/10/29 21:47.
 *
 **********************************************************************
 *                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
 *            __.'              ~.   .~              `.__
 *          .'//                  \./                  \\`.
 *        .'//                     |                     \\`.
 *      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
 *    .'//.-"                 `-.  |  .-'                 "-.\\`.
 *  .'//______.============-..   \ | /   ..-============.______\\`.
 *.'______________________________\|/______________________________`.
 *
 *
 *                     Don't forget to be awesome!                      
 **********************************************************************
 */

/**
 * 自定义类实现双向链表,模仿LinkedList
 *
 * LinkedList的特点:
 * 1. 底层是通过双向链表来实现的,有下标,可循环遍历
 * 2. 链表元素内存地址不连续
 * 3. 链表增删效率高,查询效率低,增删不涉及大量元素的位移,查询需从头结点开始遍历,无法向数组那样通过内存地址偏移量来快速定位
 */
public class PList3LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;


    public static void main(String[] args) {
        PList3LinkedList<String> linkedList = new PList3LinkedList<>();
        System.out.println(linkedList.size());
        boolean b = linkedList.add("第一次添加数据");
        b = linkedList.add("第二次添加数据");
        b = linkedList.add("第三次添加数据");
        System.out.println(linkedList.size());
        System.out.println(linkedList.get(2));

        System.out.println(linkedList.remove(2));
        System.out.println(linkedList.size);
        linkedList.add("第四次");
        linkedList.add("第五次");
        linkedList.add("第六次");
        linkedList.add("第七次");
        System.out.println(linkedList.size);
        System.out.println(linkedList.get(5));
        System.out.println(linkedList.toString());
    }

    public boolean add(E e) {
        Node<E> eNode = new Node<>(last, e, null);
        if (last != null) last.next = eNode;
        else first = eNode;

        last = eNode;
        size++;

        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<E> n = first;
        String s = "[  ";
        for (int i = 0; i < size; i++) {
            s = s + n.data.toString() + "--+--";
            n = n.next;
        }
        return s + "  ]";
    }

    private Node<E> findNode(int index) {
        if (index < 0 || index > size - 1) throw new RuntimeException("下标越界异常: size=" + size + " index=" + index);
        Node<E> n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    public E get(int index) {
        return findNode(index).data;
    }


    public E remove(int index) {
        Node<E> n = findNode(index);
        size--;
        if (n == last) {
            last = n.prev;
            last.next = null;
            return n.data;
        }
        n.prev.next = n.next;
        n.next.prev = n.prev;
        return n.data;
    }


    /**
     * 链表结点类
     */
    private class Node<E> {
        Node<E> next;
        E data;
        Node<E> prev;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.next = next;
            this.data = data;
            this.prev = prev;
        }
    }
}
