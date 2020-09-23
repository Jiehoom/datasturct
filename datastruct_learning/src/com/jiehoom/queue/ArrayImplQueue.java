package com.jiehoom.queue;

/**
 * 数组实现队列
 */
public class ArrayImplQueue {
    public static void main(String[] args) {
        //一个较为完成的验证
        ArrayQueue queue=new ArrayQueue(4);
        queue.addElement(10);
        queue.addElement(10);
        queue.addElement(10);
        queue.addElement(10);
        queue.getElement();
        queue.getElement();
        queue.getElement();
        queue.getElement();
        //因为每次取出front++,会碰到情况就是front=rear=maxSize-1;在getElemnt方法中进行了处理,这里检测一下
        System.out.println(queue.isFull());
        queue.addElement(15);
        queue.showAll();
    }

}


class ArrayQueue{
    //队列的最大容量
    private int maxSize;
    //定义数组
    private final int[] array;
    //前索引位置
    private int front;
    //后索引位置
    private int rear;

    //创建队列
    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        array=new int[maxSize];
        front=-1;
        rear=-1;
    }

    //判断队列是否满
    public boolean isFull(){
        if (rear==maxSize-1){
            return true;
        }
        return false;
    }

    //判断是否为空
    public boolean isEmpty(){
        if (front==rear){
            return true;
        }
        return false;
    }

    //添加元素
    public void addElement(int value){
        if (isFull()){
            throw new RuntimeException("该队列已满,不能完成添加操作");
        }
        rear++;
        array[rear]=value;
    }

    //取出队列元素
    public int getElement(){
        if (isEmpty()){
            throw new RuntimeException("该队列为空,请先添加数据");
        }
        front++;
        int temp=array[front];
        if (front==rear&&rear==(maxSize-1)){
            front=-1;
            rear=-1;
        }
        return temp;
    }

    //查看队列的队首元素
    public int cheakFront(){
        if (isEmpty()){
            throw new RuntimeException("该队列为空,请先添加数据");
        }
        return array[front+1];
    }

    //查看队列的所有元素
    public void showAll(){
        if (isEmpty()){
            throw new RuntimeException("该队列为空,请先添加数据");
        }
        for (int i = front+1; i <= rear; i++) {
            System.out.print(array[i]+"\t");
        }
    }
}
