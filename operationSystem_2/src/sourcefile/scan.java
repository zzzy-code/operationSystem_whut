package sourcefile;
 
//电梯算法
public class scan {
    int a[]={};
    int num,start,Sumcount=0;
    int direction;
    public scan(int a[],int num,int start,int str) {
        this.a=a;
        this.num=num;
        this.start=start;
        this.direction=str;
    }
    //将数组由小到大排列
   public int []sortArray(int a[])
   {
       if (a == null || a.length < 2) {
           return null;
       }
 
       /*规定每次两两比较的末尾元素的位置，最多为数组的最后一个位置*/
       for (int end = a.length - 1; end > 0; end--) {
			/*从第一个元素开始，两两进行比较，如果前面的元素大于后面的
			  元素，就交换，最终的结果就是最大的数在最后面
			*/
           for (int i = 0; i < end; i++) {
               if (a[i] > a[i + 1]) {
                   int tmp = a[i];
                   a[i] = a[i+1];
                   a[i+1] = tmp;
               }
           }
       }
       return a;
   }
 
   // 打印函数
    public void print()
    {
        int newA[] = {};
        newA = sortArray(a);
        
        
        if(direction==1)
        {
            right(newA, start);
        } else {
            left(newA, start);
        }
    }
   //向左情况
   public void left(int array[],int S)
   {
      int mid=location(array,S);
      int num1;
      num1=start;
      System.out.print(num1+"->");
      for(int i=mid-1;i>=0;i--)
      {
          Sumcount+=Math.abs(num1-a[i]);
          num1=a[i];
          System.out.print(num1+"->");
      }
      for(int i=mid;i<array.length;i++)
      {
          Sumcount+=Math.abs(num1-a[i]);
          num1=a[i];
          if(i!=array.length-1)
          {
              System.out.print(num1+"->");
          }else{
              System.out.println(num1);
          }
      }
       System.out.print("磁头移动的总磁道数:"+Sumcount);
   }
   //向右情况
   public void right(int array[],int S)
   {
       int mid=location(array,S);
       int num1;
       num1=start;
       System.out.print(num1+"->");
       for(int i=mid;i<array.length;i++)
       {
           Sumcount+=Math.abs(num1-a[i]);
           num1=a[i];
           System.out.print(a[i]+"->");
       }
       for(int i=mid-1;i>=0;i--)
       {
           Sumcount+=Math.abs(num1-a[i]);
           num1=a[i];
           if(i!=0)
           {
               System.out.print(a[i]+"->");
           }else{
               System.out.println(a[i]);
           }
       }
       System.out.print("磁头移动的总磁道数:"+Sumcount);
   }
   //找出start在排完序的数组中的位置
   public int location(int array[],int S)
   {
       int flag=0;
       for(int i=0;i<array.length;i++)
       {
           if(array[i]>=S)
           {
               flag=i;
               break;
           }
       }
       return flag;
   }
}