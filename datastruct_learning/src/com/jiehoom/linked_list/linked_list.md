链表:是一种物理存储单元上非连续,非顺序的存储结构,数据元素的逻辑顺序是通过链表中的指针链接次序实现的,
链表由一系列结点组成,结点可以在运行时动态生成.每个结点包括两个部分:一个是存储数据元素的数据域,
一个是存储下一个结点的指针域

链表有很多,根据需求和实际情况使用,例如单链表,双链表,循环链表等等.
(以下面试题年份比较早,时效性不行)
单链表新浪面试题:求单链表中的倒数第k个结点

    解题思路:由于是单链表,并且链表是头插法,存入的顺序和读取的顺序是相反的
    解决办法就是先遍历链表统计一共多少个结点,然后用一个变量记录长度减去k的值就是从头遍历的次数,就能得到该数
    该解决方案的遍历链表中元素的次数为(2n-k)次,时间复杂度为O(n),空间复杂度为O(1);
    
单链表腾讯面试题:单链表的反转

    想到的一个能够解决方法的思路,但是时间复杂度达到了O(n^2)
    就是相当于冒泡排序的做法,每次把前面的往后交换:设定当前结点为current,当前结点的下一个结点为
    p结点,每次循环可以表示为current.next=p.next; p.next=current;直到p.next=null;
    
    另外一种方法就是通过另外一个链表,因为是单链表,使用头插法后遍历到的链表就是反序的,时间复杂度为O(n)
    
单链表百度面试题:从尾到头打印单链表(要求方式1:反向遍历,方式2:stack)
可以使用jdk中提供的stack类对结点进行一个压栈出栈的操作从而达到反向遍历的目的
