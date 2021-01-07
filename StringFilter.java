
// package lab5;
import java.util.Scanner;
interface Filter
{
    boolean Accept(String x);
}


public class StringFilter 
{
    public static String[] filtering(String[] a, Filter f)
    {
        int len = a.length, k=0;
        boolean ans;
        String[] filt=new String[len];
        for(int i=0;i<len;i++)
        {
            System.out.println("Checking: "+a[i]);
            ans = f.Accept(a[i]);
            if(ans==true)
            {
                filt[k++]=a[i];
            }
        }
        return filt;
    }
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter length of String array: ");
        int n = s1.nextInt();
        String[] ex = new String[n];
        System.out.println("Enter Strings:");
        for(int i=0;i<n;i++)
        {
            if(s1.hasNext())
            {
                ex[i] = s1.nextLine();
            }
                
            else
            {
                System.out.println("You didn't provide enough strings!");
                break;
            }
        }
        String[] A = filtering(ex, new Filter()
        {        
            public boolean Accept(String x)
            {
                System.out.println("A: ");
                int len = x.length();
                if(len<=3)
                    return true;
                else
                    return false;
            }
        }
        );
        String[] B = filtering(ex, new Filter()
        {
            public boolean Accept(String x)
            {
                System.out.println("B: ");
                int last_index=x.length()-1;
                char[] new_x = x.toCharArray();
                if(new_x[last_index]=='s')
                    return true;
                else
                    return false;
            }        
        }
        );
        String[] C = filtering(ex, new Filter()
        {
            public boolean Accept(String x)
            {
                System.out.println("C: ");
                int i, last=x.length(), flag=0;
                char[] new_x = x.toCharArray();
                for(i=0;i<last/2;i++)
                {
                    if(new_x[i]!=new_x[last-i-1])
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                    return true;
                else
                    return false;
            }
        }
        );
        for(int i=0;i<n;i++)
        {
            System.out.println(A[i]);
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(B[i]);
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(C[i]);
        }
    }
}
