# algorithms-learn

### 介绍

数据结构和算法学习

### 数据结构(data-structure)

- Heap (堆)

堆的应用:

1. Heap Sort 

2. Priority Queue

3. Graph Algorithms

4. problem

> K'th Largest Element in an array

> Sort an almost sorted array

> Merge K Sorted Arrays

堆(Binary Heap)是一种特殊的树形数据结构，并且是一个完全二叉树。堆分为`大根堆`和`小根堆`.

MaxHeap(大根堆) : 父节点的key值必须大于其任何子节点的key值。

MinHea(小根堆) : 父节点的key值必须小于其任何子节点的key值。

小根堆的操作:

1) getMini() 将返回小根堆的root节点。时间复杂度是$O(1)$

2) extractMin() 从小根堆里面移除最小节点，时间复杂度是$O(log n)$

3) decreaseKey() 减小某个节点的key的值。该操作的时间复杂度是$O(log n)$，如果减小的值比父节点的key值大不做任何操作，否则向上迭代修复二叉树.

4) insert() 插入一个新的key节点需要花费$O(log n)$时间复杂度。该方法会将该节点插入树的末尾，如果该节点大于父节点不需要做任何事，否则需要从该节点向上迭代修复被破坏的树的属性。

5) delete() 删除节点需要花费$O(log n)$ 的时间复杂度。删除节点时通过`decreaseKey`将节点的值减小为mini，那么mini就会被迭代到root，最后执行extactMin就完成了该节点的删除.

```
        小根堆                    大根堆

          10                      100 
        /    \                   /    \
      15     30                40      50
    /   \   /   \             /  \    /  \
  40    50 100  40          10    15 50  40
```

二叉堆的主要应用是优先队列。

二项堆(Binomial Heap) 是一种堆结构。与二叉堆相比，其优势是可以快速合并两个堆，因此它属于可合并堆(Mergeable Heap)数据结构的一种.


****

- List (链表)

链表和数组很相似都是线性的, 但是也有不同点.数组的元素是存储在连续的内存区域，而链表的元素存储的位置却不一定是连续的。链表是通过指针将一个一个元素连接起来的。
根据链表节点包含的指针可以将链表分为`单链表`和`双向链表`.

SingleLinkedList (单链表)

> 单链表是那些节点只包含一个指针的链表，该指针用于指向该节点的下一节点。

```
+----------+          +------------+          +-----------+
| val      |          | val        |          | val       |
|     next -------->  |       next -------->  |     next --------> ...
+----------+          +------------+          +-----------+
```

LinkedList (双向链表)

> 双向链表是指链表的节点包含两个分别指向前向元素和后向元素的链表.

```
  +---------------+      +---------------+      +--------------+
<-- prev          |<------prev           |<------prev          |
  |      val      |      |     val       |      |     val      |
  |           next ----> |          next ---->  |         next ---> ...
  +---------------+      +---------------+      +--------------+
```

> 单链表

Queue (队列)

- Tree (树)

Binary Search Tree(二叉搜索树)

AVL Tree (二叉平衡树)

Red Black Tree (红黑树)

Segment Tree (线段树)

****

- Graph (图)

图是一个非线性数据结构。图是一个由多个节点和多个边组成的结构。节点有时也称为顶点，边是线或弧用于连接两个节点。

> 定义:
> A Graph consists of a finite set of vertices(or nodes) and set of Edges which connect a pair of nodes.
> 图是有限的边（连接两个节点）将有限的节点连接起来的结构。

*两种常用的图的表示法*:

1. 邻接矩阵

假设图的边的大小是$V$, 邻接矩阵是一个2维的$V x V$的数组.假设邻接矩阵是`adj[]`, 那么`adj[i][j] = 1`表示存在一个边从点`i`到`j`.

```
      1 2 3 4 5 6 7 
    +---------------+
  1 | 0 1 0 1 0 0 0 |
  2 | 0 0 0 1 0 1 0 |
  3 | 1 1 1 0 0 0 0 |
  4 | 1 0 1 0 0 1 0 |
  5 | 0 1 1 0 0 0 0 |
  6 | 0 1 1 0 1 0 0 |
  7 | 1 1 1 0 0 0 0 |
    +---------------+

```

2. 邻接列表

邻接列表是用一个数组表示，数组大小是边的大小. 如果该数组是`arr[]`, 那么`arr[i]`代表第`i`个节点的临近节点.

```
    +--+   +------+    +-------+
0   | ---> | 1  | ---> | 4  | ---> ...
    +--+   +------+    +-------+

    +--+   +------+    +-------+   +-------+   +-------+   
1   | ---> | 0  | ---> | 4  | ---> | 2  | ---> | 3  | --->  ..
    +--+   +------+    +-------+   +-------+   +-------+     

    +--+   +------+    +-------+
2   | ---> | 1  | ---> | 3  | ---> ...
    +--+   +------+    +-------+

    +--+   +------+    +-------+
3   | ---> | 1  | ---> | 4  | ---> ...
    +--+   +------+    +-------+

    +--+   +------+    +-------+   +-------+
4   | ---> | 3  | ---> | 0  | ---> | 1  | --->...
    +--+   +------+    +-------+   +-------+  

```

*遍历节点*:

1. 广度优先遍历

广度优先搜索始终是将已发现节点和未发现节点之间的边界，沿其广度方向向外扩展，也就是说算法需要在发现所有距离源节点s为k的所有节点之后，才会发现距离源节点s为$k + 1$的其他节点.

为了跟踪算法的进展，广度优先搜索在概念上将每个节点图上白色、灰色或黑色，所有节点在一开始的时候均涂上白色，在算法退进过程中，这些节点可能会变成灰色或黑色，在搜索过程中，第一次遇到一个节点就称该节点被`发现`,此时该节点的颜色将发生改变。因此，凡是`灰色`和`黑色`的节点都是已发现的结点。但广度优先搜索对灰色和黑色结点加以区别,以确保搜索按照广度优先模式进行推进,如果边$(u,v) \in E$且结点u是黑色，则结点v既可能是灰色也可能是黑色，也就是说，所有与黑色结点邻接的结点都已发现。对于灰色结点来说，其邻接结点中可能存在未被发现的白色结点，灰色结点所代表的就是已知和未知两个集合之间的边界。

*实现: src/main/java/com/learn/ds/graph/Graph*

****

2. 深度优先遍历

from [Bill Thies](http://people.csail.mit.edu/thies/6.046-web/recitation9.txt)

Edge Classification

1. Tree edge:  encounter new (white) vertex
   - gray to white
2. Back edge: from descendent to ancestor
   - gray to gray
3. Forward edge:  nontree edge from ancestor to descendent
   - gray to black
4. cross edge:  remainder - betweeen trees or sub-trees
   - gray to black


```
DFS(G)
  for each vertex u in V[G]
    do color[u] <- WHITE
       pi[u] <- NIL
  time <- 0
  for each vertex u \in V[G]
    do if color[u] = WHITE
       then DFS-VISIT(u)

DFS-VISIT(u)
  color[u] <- GRAY
  time <- time + 1
  d[u] <- time
  for each v \in Adj[u]
    do if color[v] = WHITE
      then pi[v] <- u
           DFS-VISIT(v)
 color[u] <- BLACK
 f[u] <- time + 1
 time <- time + 1
```


from [求有向图边的分类分别是什么意思？](https://www.zhihu.com/question/20003218)

我们在做dfs的时候，当访问到一个节点时，会出现四种情况：

1.此节点未被访问过，则此次的访问关系边（发起点——>接受点）称为树边（tree edge）；

2.此节点被访问过但此节点的子孙还没访问完，换句话说，此次的发起点的源头可以追溯到接收点，则此次访问关系边称为后向边（back edge）；

3.此节点被访问过且此节点的子孙已经访问完，而且发起点是搜索初始边，则称为前向边（down edge）；

4.此节点被访问过且此节点的子孙已经访问完，而且发起点不是搜索初始边，则称为横叉边（cross edge）

深度优先搜索应用: 

1. Topological Sort (拓扑排序)

2. Detecting cycle in graph (查找环)

3. Path Find (路径查找)

> 过程: 进行深度优先搜索( a -> z ) ，通过栈保存`a`到当前节点的路径，当遇到`z`时返回保存的路径。

*实现*: 

1. src/main/java/com/learn/algorithms/zuo/Graphs

2. src/main/java/com/learn/ds/graph/Graph

****

- Hashing Data Structure (hash结构数据)

Hashing 是一种通过hash函数将键值对的映射存储在hash表的技术。这样的技术是用于更快的访问容器的元素，映射的速度取决于使用的hash函数。

基本操作:

1. HashTable : 创建hash表

2. Delete : 从hash表中删除特定的key-value(键值对)

3. Put : 获取hash表中特定的key对应的值

4. DeleteHashTable : 删除hash表

Hashing重要的组件:

HashTable : 用于存储键值对

Hash function : 将key转化成实际的int值

### 算法(algorithms)

- basic sort

排序算法的稳定性:  假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，即在原序列中，ri=rj，且ri在rj之前，而在排序后的序列中，ri仍在rj之前，则称这种排序算法是稳定的；否则称为不稳定的。

1. bubble sort (冒泡排序)

```java

public static <T extends Comparable<T>> void bubble(List<T> list){
  for(int i = 0; i < list.size() - 1; i++){
    for(int j=0; j < list.size() - i - 1; j++){
      if(list.get(j).compareTo(list.get(j + 1)) > 0){
        swap(list, j, j + 1);
      }
    }
  }
}
```

2. quick sort (快排)

```java

  public static <T extends Comparable<T>> void quick(List<T> list){
    partition(list, 0, list.size());
  }

  public static <T extends Comparable<T>> void partition(List<T> list, int start, int end){
    /**
     * a swap example:
     * start <------------------------> end
     * 
     * lower       pivot
     * |            ||
     * |            \/
     * ? 7 9 4 5 2 1 6
     *     |
     *    walk
     * 
     * lower       pivot
     * |            ||
     * |            \/
     * ? 7 9 4 5 2 1 6
     *       |
     *      walk -> less than pivot && do swap
     *  
     *  lower      pivot
     *   |          ||
     *   |          \/
     * ? 4 9 7 5 2 1 6
     *       |
     *      walk -> swapped && continue
     * 
     *  lower      pivot
     *   |          ||
     *   |          \/
     * ? 4 9 7 5 2 1 6
     *         |
     *        walk -> less than pivot && do swap
     *
     *   lower    pivot
     *     |        ||
     *     |        \/
     * ? 4 5 7 9 2 1 6
     *         |
     *        walk -> swapped && continue
     * 
     * ? 4 5 2 9 7 1 6
     * 
     *       lower pivot
     *         |    ||
     *         |    \/
     * ? 4 5 2 1 7 9 6
     *             |
     *            walk -> swapped && continue
     * 
     * swap pivot to the partition "lower + 1"
     * ? 4 5 2 1 6 9 7
     * 
     */
    if(end - start <= 1) return;
    int lower = start - 1;
    final T pivot = list.get(end - 1);
    for(int i=start; i < end - 1; i++){
      // if(greater(pivot, list.get(i))){ 
      if(less(list.get(i), pivot)){ 
        // found smaller one
        swap(list, i, ++lower);
      }
    }
    swap(list, ++lower, end - 1);
    // do more partition
    partition(list, start,lower);
    partition(list, lower + 1, end);
  }

```
3. heap sort (堆排序)

```java

  public static <T extends Comparable<T>> void heap(List<T> list){
    // build the heap
    for(int i= list.size()/2 - 1; i >= 0; i--){
      heapfyDown(list, i, list.size());
    }

    // iterate list select swap index of 0 and end, do {@code heapfyDown} from 0 to end
    for(int i=0; i < list.size(); i++){
      final int end = list.size()  - i;
      swap(list, 0, end - 1);
      heapfyDown(list, 0, end - 1);
    }
  }


  private static <T extends Comparable<T>> void heapfyDown(List<T> list, int start, int end){
    int walk = start;
    int leftChild = Heaps.leftChild(walk), rightChild = Heaps.rightChild(walk);
    while(
      walk < end && 
      ( 
        (leftChild < end && greater(list.get(leftChild), list.get(walk))) || 
        (rightChild < end && greater(list.get(rightChild), list.get(walk)))
      )
    ){
      // swap with child 
      final int betterChild = 
        leftChild < end && 
        (rightChild >= end || greater(list.get(leftChild), list.get(rightChild))) 
        ? leftChild : 
          rightChild ;
      swap(list, walk, betterChild);
      walk = betterChild;
      leftChild = Heaps.leftChild(walk);
      rightChild = Heaps.rightChild(walk);
    }
  }

```

4. selection sort (选择排序)

```java

  public static <T extends Comparable<T>> void selection(List<T> list){
    for(int i=0; i < list.size() - 1; i++){
      // find min element between i and list.size
      int min = i;
      for(int j=i + 1; j < list.size(); j++){
        if(list.get(j).compareTo(list.get(min)) < 0){
          min = j;
        }
      }
      if(min != i) swap(list, min, i);
    }
  }

```

5. insert sort (插入排序)

```java

  public static <T extends Comparable<T>>  void insertion(List<T> list){
    for(int i=1; i < list.size(); i++){
      int walk = i;
      while(walk > 0 && list.get(walk).compareTo(list.get(walk - 1)) < 0 && walk < list.size()){
        swap(list, walk, walk - 1);
        walk--;
      }
    }
  }

```

6. merge sort (归并排序)

```java

  public static <T extends Comparable<T>> void merge(List<T> list){
    doMergeSort(list, 0, list.size());
  }

  private static <T extends Comparable<T>> void doMergeSort(List<T> list, int start, int end){
    // 
    if(end - start <= 1) return;
    final int mid = (start + end) / 2;
    doMergeSort(list, start, mid);
    doMergeSort(list, mid, end);

    // do sort
    for(int i=0; i<end; i++){
      // use insertion sort 
      insertionSort(list, start, end);
    }
  } 

```
7. counting sort (计数排序)

```java

  public static void counting2(List<Integer> list){
    if(list.isEmpty()) return;
    final int[] maxAndMin = maxAndmin(list);
    final int max = list.get(maxAndMin[0]);
    final int min = list.get(maxAndMin[1]);
    final int range = max - min + 1;
    final int[] counts = new int[range];
    for(int el : list){
      counts[el - min] += 1;
    }

    for(int i=1; i < counts.length; i++){
      counts[i] += counts[i - 1];
    }

    final Integer[] origin = list.toArray(new Integer[0]);
    for(int el : origin){
      list.set(--counts[el - min], el);
    }
  }

```

8. bucket sort (桶排序)

```java

  public static void bucket(double[] ls, int n){
    final List<List<Double>> buckets = Stream.generate(() -> new ArrayList<Double>()).limit(n).collect(Collectors.toList());
    for(double el : ls){
      final int location = (int)(el * n);
      List<Double> bucket = buckets.get(location);
      if(Objects.isNull(bucket)) buckets.set(location, (bucket = new ArrayList<>()));
      insertInOrder(bucket, el, (a , b) -> a > b);
    }

    final List<Double> sorted = buckets.stream().flatMap(bucket -> bucket.stream()).collect(Collectors.toList());
    for(int i=0; i < sorted.size(); i++){
      ls[i] = sorted.get(i);
    }
  }

```

9. radix sort (基数排序)

```java

  public static void radix(int[] arr){
    final int[] maxAndMin = maxAndMin(arr);
    final int max = arr[maxAndMin[0]];
    for(int exp=1; max/exp > 0; exp *= 10){
      counting(arr, exp, max, maxAndMin[1]);
    }
  }

  static void counting(int[] arr, int n, int max, int min){
    final int[] counts = new int[10]; 
    for(int el : arr){
      int indexInCounts = (el / n) % 10;
      counts[indexInCounts]++;
    }
    for(int i=1; i<10; i++) counts[i] += counts[i - 1];
    final int[] copy = Arrays.copyOf(arr, arr.length);
    for(int i=arr.length - 1; i >= 0; i--){
      int indexInCounts = (copy[i] / n) % 10;
      arr[--counts[indexInCounts]] = copy[i];
    } 
  }

```

10. shell-sort (希尔排序)

```java

  public static <T extends Comparable<T>> void shell(List<T> array){
    final int length = array.size();
    int gap = 1;
    while(gap < length / 3){
      gap = 3 * gap + 1;
    }

    for(; gap > 0; gap /= 3){
      for(int i = gap; i < length; i++){
        int j;
        T temp = array.get(i);
        for(j = i; j >= gap && less(temp, array.get(j -gap)); j -= gap){
          array.set(j, array.get(j - gap));
        }
        array.set(j, temp);
      }
    }
  }

```

按照时间复杂度大致分为3类：

  时间复杂度 O(n^2) ：选泡插：选择排序、冒泡排序、插入排序

  时间复杂度 O(nlogn) ：快归希堆：快速排序、归并排序、希尔排序、堆排序

  时间复杂度 O(n) ：桶计基：桶排序、计数排序、基数排序

| algorithm | avg | best | worst | space |  sort-way | is stable? |
| -- | -- | -- | -- | -- | -- | -- |
| bubble  | $O(n ^ 2)$| $O(n)$ | $O(n ^ 2)$ | $O(1)$ | In-place | true |
| select  | $O(n ^ 2)$| $O(n ^ 2)$ | $O(n ^ 2)$ | $O(1)$ | In-place | false |
| insert  | $O(n ^ 2)$| $O(n)$ | $O(n ^ 2)$ | $O(1)$ | In-place | true |
| shell   | $O(n \log n)$| $O(n \log^2n)$ | $O(n \log ^ 2n)$ | $O(1)$ | In-place | false |
| merge   | $O(n \log n)$| $O(n \log n)$ | $O(n \log n)$ | $O(n)$ | Out-place | true |
| quick   | $O(n \log n)$| $O(n \log n)$ | $O(n ^ 2)$ | $O(\log n)$ | In-place | false |
| heap    | $O(n \log n)$| $O(n \log n)$ | $O(n \log n)$ | $O(1)$ | In-place | false |
| counting| $O(n + k)$| $O(n + k)$ | $O(n + k)$ | $O(k)$ | Out-place | true |
| bucket  | $O(n + k)$| $O(n + k)$ | $O(n ^ 2)$ | $O(n + k)$ | Out-place | true |
| radix   | $O(n  k)$| $O(n  k)$ | $O(n k)$ | $O(n + k)$ | Out-place | true |


*实现： src/main/java/com/learn/algorithms/basic/BasicSort*

- Bits (位运算)

1. multiply

通过位操作实现两数之和

*方法: `if b & 1 == 1 , a * b = a * 2 * (b - 1) / 2 + a else a * b = a * 2 * b / 2`*

### leetcode

- easy

1. CombinationSum

2. DeleteText

3. GetIntersectioNode

4. GetRow

5. HasAlternatingBits

6. IsBoomerang

7. MaxDepth

8. MaximumWealth

9. MergeTwoLists

10. MinBitFlips

11. MinStack

12. MostCommonWord

13. NextGreatestLetter

14. NumberOfLines

15. NumWays

16. PalindromeNumber

17. RemoveElement

18. RotateString

19. ShorttestToChar

20. StrStr

21. ToGoatLatin

22. TwoSum

23. minDiffInBST

给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

差值是一个正数，其数值等于两值之差的绝对值。

*思路: 二叉树中序遍历*

```java
int min = Integer.MAX_VALUE;
public int minDiffInBST(TreeNode root) {
  interthemTrav(root, new ArrayList<>());
  return min;
}

void interthemTrav(TreeNode root, List<Integer> arr){
  if(Objects.isNull(root)) return;
  interthemTrav(root.left, arr);
  //
  if(!arr.isEmpty()){
    int temp ;
    if((temp = Math.abs( arr.get(arr.size() - 1)  - root.val)) < min)min = temp; 
  }
  arr.add(root.val);
  interthemTrav(root.right, arr);
}
```

24. MovingAverage

给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。

实现 MovingAverage 类：

MovingAverage(int size) 用窗口大小 size 初始化对象。
double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/qIsx9U
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

25. isBalanced(二叉树平衡)

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

26. hasPathSum 二叉树路径总和

给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

27. majorityElement(多数元素)

给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

28. titleToNumber (Excel 表列序号)

给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。

例如：

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

示例 1:

输入: columnTitle = "A"
输出: 1
示例 2:

输入: columnTitle = "AB"
输出: 28
示例 3:

输入: columnTitle = "ZY"
输出: 701

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/excel-sheet-column-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

29. isIsomorphic (同构字符串)

给定两个字符串 s 和 t ，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

 

示例 1:

输入：s = "egg", t = "add"
输出：true
示例 2：

输入：s = "foo", t = "bar"
输出：false
示例 3：

输入：s = "paper", t = "title"
输出：true

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/isomorphic-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

30. shiftGrid

给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

每次「迁移」操作将会引发下述活动：

位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
请你返回 k 次迁移操作后最终得到的 二维网格。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/shift-2d-grid
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

31. reverseString (反转字符串)

*swap(i, len - i - 1)*

32. reverseList (反转链表)

给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

```java

  public ListNode reverseList(ListNode head) {
    ListNode walk = head;
    ListNode temp = new ListNode();
    while(Objects.nonNull(walk)){
      ListNode next = temp.next;
      temp.next = walk;
      walk = walk.next;
      temp.next.next = next;
    }
    return temp.next;
  }

```

33. moveZeroes ( 移动零 )

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。

34. isPowerOfThree 3的幂

给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/power-of-three
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


*int 能表示的3的幂的最大值为1162261467*

35. removeElements (移除链表元素)

给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

*链表迭代*

36. isSubsequence 判断子序列

给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/is-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*双指针*

37. reverseVowels (反转字符串中的元音字母)

给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。

38. toHex (数字转换为十六进制数)

给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

注意:

十六进制中所有字母(a-f)都必须是小写。
十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
给定的数确保在32位有符号整数范围内。
不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/convert-a-number-to-hexadecimal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

39. distanceBetweenBusStops ( 公交站间的距离)

环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。

环线上的公交车都可以按顺时针和逆时针的方向行驶。

返回乘客从出发点 start 到目的地 destination 之间的最短距离。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/distance-between-bus-stops
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



*解法: 排序+计数*

- medium

1. AddTwoNumbers

2. CanIWin

3. CombinationSum

4. ConvertTime

5. CountNumbersWithUniqueDigits

6. Deserialize

7. Divide

8. FindDuplicates

9. GenerateParenthesis

10. GrayCode

11. Insert

12. IsValidBST

13. IsValidSudoku

14. Jump

15. LetterCombinations

16. LevelOrder

17. LexicalOrder

18. LongestPalindromicSubstring

19. LongestSubstringWithoutRepestingCharacters

20. LongestValidParentheses

21. MaxArea

22. MaxConsecutiveAnswers

23. MinDeletion

24. MinEatingSpeed

25. MinPathSum

26. NextPermutation

27. NumArray

28. NumSubarrayProductLessThanK

29. Permute

30. PermuteUnique

31. RandomIndex

32. RemoveDuplicates

33. ReorderList

34. ReverseInteger

35. Rotate

36. Search

37. SimplifyPath

38. SortColors

39. StringtoInteger

40. Subsets

41. ZigzgConversion

42. asteroidCollision

>给定一个整数数组 asteroids，表示在同一行的行星。

>对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。

>找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

43. fourSum (四数之和)

> 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

>0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

>示例 1：

>输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

>输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]

*解法: 1. 回溯(遍历) 2. 排序 + 双指针(官方解法)*

44. groupAnagrams (字母异位词分组)

> 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

> 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*解题方法: 统计字母出现的次数作为key*

45. intersect(四叉树交集)

46. arrayNesting(数组嵌套)

索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。

 

示例 1:

输入: A = [5,4,0,3,1,6,2]
输出: 4
解释: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

其中一种最长的 S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 

提示：

N是[1, 20,000]之间的整数。
A中不含有重复的元素。
A中的元素大小在[0, N-1]之间。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/array-nesting
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

47. multiply 字符串相乘

给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。

 

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/multiply-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

48. findAnagrams(找到字符串中所有字母异位词)

给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

 

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

49. MyCalendar

记录一个有意思的答案(差分数组+TreeMap)

```java
class MyCalendarTwo {
    TreeMap<Integer, Integer> cnt;

    public MyCalendarTwo() {
        cnt = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
            if (maxBook > 2) {
                cnt.put(start, cnt.getOrDefault(start, 0) - 1);
                cnt.put(end, cnt.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/my-calendar-ii/solution/wo-de-ri-cheng-an-pai-biao-ii-by-leetcod-wo6n/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

50. pruneTree (二叉树剪枝)

给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。

返回移除了所有不包含 1 的子树的原二叉树。

节点 node 的子树为 node 本身加上所有 node 的后代。

 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/binary-tree-pruning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

51. MyCalendar 

(实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。

当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。

日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。

实现 MyCalendar 类：

MyCalendar() 初始化日历对象。
boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/my-calendar-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。)

52. sequenceReconstruction (重建序列)

给定一个长度为 n 的整数数组 nums ，其中 nums 是范围为 [1，n] 的整数的排列。还提供了一个 2D 整数数组 sequences ，其中 sequences[i] 是 nums 的子序列。
检查 nums 是否是唯一的最短 超序列 。最短 超序列 是 长度最短 的序列，并且所有序列 sequences[i] 都是它的子序列。对于给定的数组 sequences ，可能存在多个有效的 超序列 。

例如，对于 sequences = [[1,2],[1,3]] ，有两个最短的 超序列 ，[1,2,3] 和 [1,3,2] 。
而对于 sequences = [[1,2],[1,3],[1,2,3]] ，唯一可能的最短 超序列 是 [1,2,3] 。[1,2,3,4] 是可能的超序列，但不是最短的。
如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false 。
子序列 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/ur2n8P
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*拓扑排序*

53. combinationSum2 (组合总和 II)

给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用 一次 。

注意：解集不能包含重复的组合。 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*回溯*

54. cloneGraph (拷贝图)

给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。

图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。

class Node {
    public int val;
    public List<Node> neighbors;
}

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/clone-graph
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

55. partition (分隔链表)

给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

56. setZeroes (矩阵置零)

给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。


- hard

1. BusiestServers

2. FindSubstring

3. FirstMissingPositive

4. MedianofTwoSortedArrays

5. RangeModule

区间 的范围并查询它们。

半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。

实现 RangeModule 类:

RangeModule() 初始化数据结构的对象。
void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true ，否则返回 false 。
void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。
 

示例 1：

输入
["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
输出
[null, null, null, true, false, true]

解释
RangeModule rangeModule = new RangeModule();
rangeModule.addRange(10, 20);
rangeModule.removeRange(14, 16);
rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/range-module
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



6. ReachingPoint

7. Trap

8. UniqueMorseRepresentations

9. UniquePaths

10. WordFilter

> 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
>
> 实现 WordFilter 类：
>
> WordFilter(string[] words) 使用词典中的单词 words 初始化对象。 
> f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/prefix-and-suffix-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*解题方法: Trie 字典树*

****

- zuo (左程云)

1. 判断一个二叉树是否是搜索二叉树

- 判断是否满足 `left-key < node-key < right-key`

- 中序遍历放入数组，数组是按照节点升序排列，比较数组是否符合该条件(构建该数组时可以递归也可以使用循环) 

> 代码位置 

> src/main/java/com/learn/algorithms/zuo/BST#isBST

> src/main/java/com/learn/algorithms/zuo/BST#isBST2

2. 判断一个二叉树是否是完全二叉树

- 进行广度优先搜索，判断是否存在前序节点是不存在两个子节点和当前节点是否是不存在left但存在right的情况

3. 判断一个二叉树是否平衡

- 后续遍历子树是否是平衡树

4. 找到两个节点的最低公共祖先