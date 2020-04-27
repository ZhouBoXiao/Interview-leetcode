package _公司笔试._腾讯笔试._3;

import java.util.*;

public class Main {

    static double  distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(1.0 * (x1 - x2) * (x1 - x2) +  (y1 - y2) * (y1 - y2)) ;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (m-- > 0 ) {
            int n = scanner.nextInt();
            int[][] a = new int[n][2];
            int[][] b = new int[n][2];
            for (int i = 0 ; i < n; i ++) {
                a[i][0] = scanner.nextInt();
                a[i][1] = scanner.nextInt();
            }
            for (int i = 0 ; i < n; i ++) {
                b[i][0] = scanner.nextInt();
                b[i][1] = scanner.nextInt();
            }
            Arrays.sort(a, (o1,o2)->{
                int sum1 = o1[0] + o1[1];
                int sum2 = o2[0] + o2[1];
                return sum1 - sum2;
            });

            double res = distance(a[0][0], a[0][0], b[0][0], b[0][1]);
            for (int i = 0; i < n; i ++) {
                int x1 = a[i][0], y1 = a[i][1];

                for (int j = 0 ; j < n; j++) {

                    double d = distance(x1,y1, b[j][0], b[j][1]);
                    if(d < res) {
                        res = d;
                    }
                }
            }
//            for (int i = 0; i < n; i ++) {
//                int x1 = a[i][0], y1 = a[i][1];
//                int left = 0, right = n - 1;
//                while (left <= right) {
//                    int mid = left + (right - left)/2;
//                    double d = distance(x1,y1, b[mid][0], b[mid][1]);
//                    if(d < res) {
//                        res = d;
//                        right = mid - 1;
//                    } else  {
//                        right = mid - 1;
//
//                    }
//                }
//                /*if (left >= n) {
//
//                }*/
//            }
            System.out.printf("%.3f\n", res);

        }
        scanner.close();
    }
}
/*
作者：qin_peng
链接：https://www.nowcoder.com/discuss/417957?type=post&order=time&pos=&page=1&channel=
来源：牛客网

const ll INF=1e11;
int n;
int flag[N];
int z[N];
struct Po{
    double x,y;
    int id;
}AB[N];
bool cmp(Po a,Po b){
    if(a.x==b.x)return a.y<b.y;
    return a.x<b.x;
}
bool cmps(const int &a,const int &b){
    return AB[a].y<AB[b].y;
}
double dis(int i,int j){
    double x=(AB[i].x-AB[j].x)*(AB[i].x-AB[j].x);
    double y=(AB[i].y-AB[j].y)*(AB[i].y-AB[j].y);
    return sqrt(x+y);
}
double merge(int l,int r){
    double d=INF;
    if(l==r)return d;
    if(l+1==r){
        if(AB[l].id==AB[r].id)return d;
        return dis(l,r);
    }
    int mid=l+r>>1;
    double d1=merge(l,mid);
    double d2=merge(mid+1,r);
    d=min(d1,d2);
    int i,j,k=0;
    for(i=l;i<=r;i++){
        if(fabs(AB[mid].x-AB[i].x)<=d){
            flag[i]=AB[i].id;
            z[k++]=i;
        }
    }
    sort(z,z+k,cmps);
    for(i=0;i<k;i++){
        for(j=i+1;j<k&&AB[z[j]].y-AB[z[i]].y<d;j++){
            if(flag[z[i]]!=flag[z[j]]){
                double d3=dis(z[i],z[j]);
                if(d>d3)d=d3;
            }
        }
    }
    return d;
}
void solve(){
    sc("%d",&n);
    for(int i=0;i<n;i++){
        sc("%lf%lf",&AB[i].x,&AB[i].y);
        AB[i].id=1;
    }
    for(int i=n;i<2*n;i++){
        sc("%lf%lf",&AB[i].x,&AB[i].y);
        AB[i].id=2;
    }
    n<<=1;
    sort(AB,AB+n,cmp);
    pr("%.3f\n",merge(0,n-1));
}


int main(){
    int t;I(t); while(t--)solve();
}
 */