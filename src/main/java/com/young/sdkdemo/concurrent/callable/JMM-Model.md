## JMM抽象结构模型
cpu的处理速度和主存的读写熟读不是一个量级的，每个CPU都会有缓存。因此，共享变量会先放主存中，每个线程都有自己的工作内存，
并且会把位于主存中的共享变量拷贝到自己的工作内存，之后读写操作均使用-工作内存中的变量副本-，并且某个时刻将工作内存的
变量副本写回主存  
```    
   Thread-A     <-->    本地内存A（共享变量副本）   <-->          
                                                 |
                                                JMM控制        |主内存（共享变量）|
                                                 |      
   Thread-B     <-->    本地内存B（共享变量副本）   <-->
```    
## 重排序
为了提高性能，编译器和处理器常常会对指令重排序

```
    源代码     -->     编译器优化重排序①       ->   指令级并行重排序②      -->     内存系统重排序③ --> 最终执行的指令排序
```
①编译器在不改变单线程语义的前提下，可以重新安排语句的执行顺序
②现代处理器采用指令级并行技术将多条指令重叠执行，如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序
③内存系统的重排序，由于处理器使用缓存和读写缓冲区，这使得加载和存储操作看上去可能是乱序执行  
数据依赖性？不能进行指令重排序  
`as-if-serial`  
[JMM参考](https://juejin.im/post/5ae6d309518825673123fd0e)