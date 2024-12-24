package sourcefile;
//先来先服务
public class fcfs {
    int a[]={};
    int n,start,SumCount=0;
    //初始化磁道
    public fcfs(int S[],int num,int start) {
      this.a=S;
      this.n=num;
      this.start=start;
    }
    //计算磁道数
    public void Count()
    {
        int Num1=start;
        for(int i=0;i<n;i++)
        {
            if(a[i]<=Num1)
            {
                SumCount+=Num1-a[i];
            }
            else{
                SumCount+=a[i]-Num1;
            }
            Num1=a[i];
        }
    }
    //顺序输出即可
    public void print()
    {
        Count();
        System.out.print(start+"->");
        for(int i=0;i<n;i++)
        {
            if(i==n-1)
            {
                System.out.println(a[i]);
            }else{
                System.out.print(a[i]+"->");
            }
        }
        System.out.print("磁头移动的总磁道数:"+SumCount);
    }
 
}