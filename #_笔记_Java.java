string.replaceAll("_", "")

new ArrayList<Integer>( Arrays.asList(1,2,3) )

奇判断
if((n & 1) != 0)

Integer是引用类型，在(-128,128]JVM使用常数缓冲，否则需.equals()来比较值
	
判断字母和数字
Character.isLetterOrDigit('a')

清栈
Deque.clear()

队列用LinkedList可以添加null，ArrayDeque不行

String比较还是用equals

String.valueOf(47291)
Integer.parseInt("47291")
Integer.valueOf("23")
Long.parseLong("123")

Arrays.equals(cnt1, cnt2)

//lamda排序，302周赛#3
Arrays.sort(t,(a,b)->{
            if(a[0].equals(b[0]))
                return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            return a[0].compareTo(b[0]);
        });

//字典序排序String
String.compareTo
//join
String.join(".", path)