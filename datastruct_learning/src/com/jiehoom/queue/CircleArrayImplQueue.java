package com.jiehoom.queue;

/**
 * 循环数组实现队列
 */
public class CircleArrayImplQueue {
    public static void main(String[] args) {
        //实际长度为3
        CircleArray circleArray=new CircleArray(4);
        circleArray.addElement(10);
        circleArray.addElement(11);
        circleArray.addElement(12);
        circleArray.addElement(13);
        circleArray.getElement();
        circleArray.addElement(14);
        circleArray.showQueue();
    }

}

class CircleArray{
    private int maxSize;

    private int front;
    private int rear;
    private int[] array;


    //初始化队列
    public CircleArray(int maxSize){
        this.maxSize=maxSize;
        front=0;
        rear=0;
        array=new int[maxSize];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        if (rear==front){
            return true;
        }
        return false;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){
        if ((rear+1)%maxSize==front){
            return true;
        }
        return false;
    }

    /**
     * 给队列中添加元素
     * @param value
     */
    public void addElement(int value){
        if (isFull()){
            throw new RuntimeException("该队列已满,不能添加");
        }
        array[rear]=value;
        rear=(rear+1)%maxSize;
    }


    /**
     * 获取队列的元素
     * @return
     */
    public int getElement(){
        if (isEmpty()){
            throw new RuntimeException("该队列为空,请先添加数据");
        }
        int value = array[front];
        front=(front+1)%maxSize;
        return value;
    }

    /**
     * 读队首元素
     * @return
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("该队列为空,请先添加数据");
        }
        return array[front];
    }

    /**
     * 查找队列中的元素
     */
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("该队列为空,请先添加数据");
        }
        for (int i=front;i<front+size();i++){
            System.out.println(array[i%maxSize]+"\t");
        }
    }

    /**
     * 获取当前队列的有效元素个数
     * @return
     */
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

}
