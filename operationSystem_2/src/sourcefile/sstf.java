package sourcefile;
//最短寻道时间优先
public class sstf {
    int a[]={};
    int num,start,Sumcount=0;
    //String direction;
    public sstf(int a[],int num,int start) {
        this.a=a;
        this.num=num;
        this.start=start;
        //this.direction=str;
    }
    public void print()
    {
        int num1=start,num2=-1;
        int min;
        System.out.print(num1+"->");
        for(int j=0;j<num;j++)
        {
            min=100000;
            for(int i=0;i<a.length;i++)
            {
                if((Math.abs(num1-a[i])<min))
                {
                    min=Math.abs(num1-a[i]);
                    num2=a[i];
                }
            }
            Sumcount+=min;
            num1=num2;
            a=removeElement(a,num2);
            if(j!=num-1)
            {
                System.out.print(num1+"->");
            }
            else{
                System.out.println(num1);
            }
        }
        System.out.print("磁头移动的总磁道数:"+Sumcount);
    }
    //删除数组中元素的方法
    public int []removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        int newArray[]=new int[i];
        for(int k=0;k<i;k++)
        {
            newArray[k]=nums[k];
        }
        return newArray;
    }
}