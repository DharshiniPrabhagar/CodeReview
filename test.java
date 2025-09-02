import java.util.*;

class f {
public static int X=0;
int y;
f(){y=5;}
public static void main(String[]args){
int n=;
System.out.println(n+" is "+(check(n)?"prime":"not prime"));
}
static boolean check(int num){
if(num<=1)return false;for(int i=2;i<num;i++){if(num%i==0)return false;}return true;}
}
